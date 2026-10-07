package com.codecx.tpackages.data.utils

import android.content.Context
import android.util.Log
import com.codecx.tpackages.BuildConfig
import com.codecx.tpackages.data.model.AdItem
import com.codecx.tpackages.data.model.RemoteAdsConfig
import com.google.firebase.FirebaseApp
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeout
import kotlin.time.Duration.Companion.seconds

object RemoteConfigHelper {
    const val NATIVE_AD_TYPE = "native"
    const val INTER_AD_TYPE = "inter"
    const val OPEN_AD_TYPE = "open"
    const val BANNER_AD_TYPE = "banner"
    const val COLLAPSIBLE_AD_TYPE = "collapsible"


    val mFirebaseRemoteConfig: FirebaseRemoteConfig by lazy {
        FirebaseRemoteConfig.getInstance()
    }

    val TAG = "RemoteConfigHelper"

    private lateinit var application: Context
    var adIds: RemoteAdsConfig = RemoteAdsConfig()

    fun init(application: Context) {
        this@RemoteConfigHelper.application = application
        adIds = getDefaultAdIds()
        Log.i("RemoteConfigHelper", "init: Ad IDs initialized\n\n${Gson().toJson(adIds)}")
        CoroutineScope(Dispatchers.IO).launch {
            try {
                FirebaseApp.initializeApp(application)
            } catch (e: Exception) {
                Log.e(TAG, "Firebase initialization failed: ${e.message}")
            }
        }
    }

    suspend fun checkRemoteConfig(onConfigLoaded: () -> Unit) {
        runCatching {
            val configSettings: FirebaseRemoteConfigSettings =
                FirebaseRemoteConfigSettings.Builder()
                    .setMinimumFetchIntervalInSeconds(if (BuildConfig.DEBUG) 0 else 2600)
                    .build()

            mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings)
            withTimeout(20.seconds) {
                mFirebaseRemoteConfig.fetchAndActivate().await()
            }
        }.onSuccess {
            val key = if (isInTestMode) "aps_config_test" else "ads_config"
            val json = mFirebaseRemoteConfig.getString(key)

            Log.d(TAG, "checkRemoteConfig: Fetched JSON: $json")
            if (json.isNotEmpty()) {
                try {
                    adIds = Gson().fromJson(json, RemoteAdsConfig::class.java)
                    Log.d(TAG, "checkRemoteConfig: Ad IDs updated successfully")
                } catch (e: Exception) {
                    Log.e(TAG, "checkRemoteConfig: JSON Parsing Error: ${e.message}")
                }
            } else {
                Log.w(TAG, "checkRemoteConfig: 'ads_config' is empty in Remote Config")
            }
            onConfigLoaded()
        }.onFailure {
            Log.e(TAG, "checkRemoteConfig: Fetch Failure: ${it.message}")
            onConfigLoaded()
        }
    }

    val isInTestMode get() = BuildConfig.DEBUG || BuildConfig.FLAVOR.startsWith("dev", true)

    fun getDefaultAdIds(): RemoteAdsConfig {
        return RemoteAdsConfig(

            resumeAppOpen = AdItem(BuildConfig.app_open_id, true, OPEN_AD_TYPE),
            splashInterAd = AdItem(BuildConfig.inter_id, true, INTER_AD_TYPE),

            homeFirstClick = true, adFrequency = 3,
            homeTopNative = AdItem(BuildConfig.advance_native_id, true, NATIVE_AD_TYPE),
            homeBottomBanner = AdItem(BuildConfig.banner_id, true, COLLAPSIBLE_AD_TYPE),
            homeInter = AdItem(BuildConfig.inter_id, true, INTER_AD_TYPE),

            offerNative = AdItem(BuildConfig.advance_native_id, true, NATIVE_AD_TYPE),
            deviceNative = AdItem(BuildConfig.advance_native_id, true, NATIVE_AD_TYPE),
            quickToolNative = AdItem(BuildConfig.advance_native_id, true, NATIVE_AD_TYPE),

            fourGNative = AdItem(BuildConfig.advance_native_id, true, NATIVE_AD_TYPE,7),
            fourGInter = AdItem(BuildConfig.inter_id, true, INTER_AD_TYPE),

            simSignalNative = AdItem(BuildConfig.advance_native_id, true, NATIVE_AD_TYPE),
            simInfoNative = AdItem(BuildConfig.advance_native_id, true, NATIVE_AD_TYPE),
            dataUsageNative = AdItem(BuildConfig.advance_native_id, true, NATIVE_AD_TYPE),
            lteNative = AdItem(BuildConfig.advance_native_id, true, NATIVE_AD_TYPE),

            speedTestNative = AdItem(BuildConfig.advance_native_id, true, NATIVE_AD_TYPE)
            )
    }
}