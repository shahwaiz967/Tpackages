package com.codecx.tpackages.data.ads

import android.content.Context
import com.codecx.tpackages.BuildConfig
import com.google.android.gms.ads.MobileAds
import com.google.android.libraries.ads.mobile.sdk.initialization.InitializationConfig
import com.codecx.tpackages.R
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


object CodecxAd {

    private var adConfig: CodecxAdsConfig? = null
    val isSDKInit get() =  com.google.android.libraries.ads.mobile.sdk.MobileAds.isInitialized
    fun getAdConfig(): CodecxAdsConfig? {
        return adConfig
    }

    suspend fun initAds(adsConfig: CodecxAdsConfig, context: Context) =
        suspendCancellableCoroutine { continuation ->
            adConfig = adsConfig
            if (adsConfig.isGoogleAdsAllowed) {
                try {
                    com.google.android.libraries.ads.mobile.sdk.MobileAds.initialize(
                        context,
                        InitializationConfig.Builder(BuildConfig.app_id).build()
                    ) {
                        if (continuation.isActive)
                            continuation.resume(Unit)
                    }
                } catch (ex: Exception) {
                    if (continuation.isActive)
                        continuation.resume(Unit)
                }
            } else {
                if (continuation.isActive)
                    continuation.resume(Unit)
            }
        }
}