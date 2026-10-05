package com.codecx.tpackages

import android.app.Application
import com.codecx.tpackages.data.ads.CodecxAd
import com.codecx.tpackages.data.ads.CodecxAdsConfig
import com.codecx.tpackages.data.ads.openAd.OpenAdConfig
import com.codecx.tpackages.data.ads.openAd.OpenApp
import com.codecx.tpackages.data.di.appModule
import com.codecx.tpackages.data.utils.RemoteConfigHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication() : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
            androidContext(this@MyApplication)
        }
        RemoteConfigHelper.init(this)
        OpenAdConfig.enableResumeAd()
        OpenApp(this)
        CoroutineScope(Dispatchers.Main).launch {
            CodecxAd.initAds(CodecxAdsConfig.Builder().build(), this@MyApplication)
        }
    }
}