package com.codecx.tpackages.data.ads.googleads

import android.app.Activity
import android.os.SystemClock
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.webkit.WebViewCompat
import com.codecx.tpackages.R
import com.codecx.tpackages.data.ads.CodecxAd
import com.codecx.tpackages.data.ads.GDPR.UMPConsent
import com.codecx.tpackages.data.ads.interfaces.AdCallBack
import com.codecx.tpackages.data.ads.openAd.OpenAdConfig
import com.codecx.tpackages.data.ads.utils.LoadingUtils
import com.codecx.tpackages.data.ads.utils.isNetworkConnected
import com.codecx.tpackages.data.ads.utils.runOnUiThread
import com.google.android.libraries.ads.mobile.sdk.common.AdLoadCallback
import com.google.android.libraries.ads.mobile.sdk.common.AdRequest
import com.google.android.libraries.ads.mobile.sdk.common.FullScreenContentError
import com.google.android.libraries.ads.mobile.sdk.common.LoadAdError
import com.google.android.libraries.ads.mobile.sdk.interstitial.InterstitialAd
import com.google.android.libraries.ads.mobile.sdk.interstitial.InterstitialAdEventCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.coroutines.resume
import kotlin.time.Duration.Companion.milliseconds


object InterstitialAdHelper {
    var isInterstitialShowing: Boolean = false
    var isInterstitialLoading: Boolean = false

    fun checkIfTimePassed(lastAdTimer: Long, timerMilliSec: Long): Boolean {
        if (lastAdTimer == 0L) {
            Log.d("Ad Timer", "Timer has not been started yet.")
            return true
        }

        val currentTime = SystemClock.elapsedRealtime()
        val timeElapsed = currentTime - lastAdTimer
        if (timeElapsed >= timerMilliSec) {
            Log.d("Ad Timer", "Time passed: $timeElapsed ms (Timer complete)")
            return true
        } else {
            Log.d("Ad Timer", "Time remaining: ${timerMilliSec - timeElapsed} ms")
            return false
        }
    }

    class InterstitialHelper {
        var isTimerComplete = false
        var lastAdTimer: Long = 0L
        private var interstitialAd: InterstitialAd? = null



        fun loadShowInterstitial(
            adId: String?,
            adAllowed: Boolean,
            showLoadingLayout: Boolean = true,
            timerAllowed: Boolean = false,
            timerMilliSec: Long = 0L,
            @LayoutRes
            loadingLayout: Int = R.layout.dialog_ad_loading,
            adCallBack: AdCallBack, activity: Activity
        ) = CoroutineScope(Dispatchers.Main).launch {
            isTimerComplete = if (!timerAllowed) {
                true
            } else {
                checkIfTimePassed(lastAdTimer, timerMilliSec)
            }

            if (WebViewCompat.getCurrentWebViewPackage(activity) != null && CodecxAd.isSDKInit) {
                if (adAllowed && UMPConsent.isUMPAllowed && CodecxAd.getAdConfig()?.isGoogleAdsAllowed == true) {
                    if (isTimerComplete) {
                        if (activity.isNetworkConnected()) {
                            if (showLoadingLayout) {
                                LoadingUtils.showAdLoadingScreen(
                                    activity,
                                    layoutId = loadingLayout
                                )
                            }
                            isInterstitialLoading = true
                            fun requestToShowAd(p0: InterstitialAd) {
                                isInterstitialLoading = false
                                adCallBack.onAdLoaded()
                                p0.adEventCallback =
                                    object : InterstitialAdEventCallback {
                                        override fun onAdDismissedFullScreenContent() {
                                            super.onAdDismissedFullScreenContent()
                                            isInterstitialShowing = false
                                            if (timerAllowed) {
                                                lastAdTimer = SystemClock.elapsedRealtime()
                                            }
                                            runOnUiThread {
                                                adCallBack.onAdDismiss()
                                               // LoadingUtils.dismissScreen()
                                            }


                                        }



                                        override fun onAdFailedToShowFullScreenContent(
                                            fullScreenContentError: FullScreenContentError
                                        ) {
                                            super.onAdFailedToShowFullScreenContent(
                                                fullScreenContentError
                                            )
                                            isInterstitialShowing = false
                                            runOnUiThread {

                                                LoadingUtils.dismissScreen()
                                                adCallBack.onAdFailToShow(
                                                    Exception(
                                                        fullScreenContentError.message
                                                    )
                                                )
                                            }
                                        }

                                        override fun onAdClicked() {
                                            super.onAdClicked()
                                            if (CodecxAd.getAdConfig()?.isDisableResumeAdOnClick == true) {
                                                OpenAdConfig.isOpenAdStop = true
                                            }
                                            runOnUiThread {
                                                adCallBack.onAdClick()
                                            }
                                        }

                                        override fun onAdShowedFullScreenContent() {
                                            super.onAdShowedFullScreenContent()
                                            isInterstitialShowing = true
                                            runOnUiThread {
                                                LoadingUtils.dismissScreen()
                                                adCallBack.onAdShown()
                                            }

                                        }




                                    }
                                p0.show(activity)
                            }

                            fun failToLoadAd() {
                                LoadingUtils.dismissScreen()
                                isInterstitialLoading = false
                                adCallBack.onAdFailToLoad(Exception("Fail to load"))
                            }

                            withTimeoutOrNull(
                                (CodecxAd.getAdConfig()?.adsTimeOut ?: 10000L).milliseconds
                            ) {
                                getInterAd(
                                    activity,
                                    adId ?: "ca-app-pub-3940256099942544/1033173712"
                                )
                            }?.let { ad ->
                                requestToShowAd(ad)
                            } ?: run {
                                failToLoadAd()
                            }

                        } else {
                            adCallBack.onAdFailToLoad(Exception("No internet found"))
                        }
                    } else {
                        adCallBack.onAdFailToLoad(TimeDelayException())
                    }
                } else {
                    adCallBack.onAdFailToLoad(Exception("Ad not allowed"))
                }
            } else {
                adCallBack.onAdFailToLoad(Exception("Ad not allowed"))
            }

        }

        private suspend fun getInterAd(activity: Activity, adId: String): InterstitialAd? {
            return suspendCancellableCoroutine {
                val interAdCallBack = object : AdLoadCallback<InterstitialAd> {
                    override fun onAdLoaded(ad: InterstitialAd) {
                        super.onAdLoaded(ad)
                        runOnUiThread {
                            it.resume(ad)
                        }
                    }

                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        super.onAdFailedToLoad(adError)
                        runOnUiThread {
                            it.resume(null)
                        }
                    }
                }
                InterstitialAd.load(
                    AdRequest.Builder(adId).build(), interAdCallBack
                )
            }
        }

    }

    class TimeDelayException : Exception() {
        private fun readResolve(): Any = TimeDelayException()
    }


}