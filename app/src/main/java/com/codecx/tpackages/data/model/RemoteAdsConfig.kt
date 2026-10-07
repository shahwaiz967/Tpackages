package com.codecx.tpackages.data.model

import com.google.gson.annotations.SerializedName

data class RemoteAdsConfig(
    // App Open
    @SerializedName("resume_app_open")
    val resumeAppOpen: AdItem = AdItem(),

    // Splash
    @SerializedName("splash_inter_ad")
    val splashInterAd: AdItem = AdItem(),

    //Home
    @SerializedName("home_top_native")
    val homeTopNative : AdItem = AdItem(),
    @SerializedName("home_bottom_banner")
    val homeBottomBanner : AdItem = AdItem(),
    @SerializedName("home_inter")
    val homeInter : AdItem = AdItem(),
    @SerializedName("home_inter_frequency")
    val adFrequency : Int = 3,
    @SerializedName("home_first_click")
    val homeFirstClick : Boolean = true,
    @SerializedName("home_middle_native")
    val homeMiddleNative : AdItem = AdItem(),

    //OfferFragment
    @SerializedName("offer_banner")
    val offerBanner : AdItem = AdItem(),
    @SerializedName("offer_inter")
    val offerInter : AdItem = AdItem(),
    @SerializedName("offer_native_frequency")
    val offerNativeFrequency : Int = 2,
    @SerializedName("offer_native")
    val offerNative : AdItem = AdItem(),



    //QuickToolFragment
    @SerializedName("quickTool_banner")
    val quickToolNative : AdItem = AdItem(),


    //DeviceFragment
    @SerializedName("device_banner")
    val deviceNative : AdItem = AdItem(),

    //FourGHome
    @SerializedName("fourG_banner")
    val fourGNative : AdItem = AdItem(),
    @SerializedName("fourG_inter")
    val fourGInter : AdItem = AdItem(),

    //SimSignalStrength
    @SerializedName("sim_signal_banner")
    val simSignalNative : AdItem = AdItem(),

    //SimInfo
    @SerializedName("sim_info_banner")
    val simInfoNative : AdItem = AdItem(),

    //DataUsage
    @SerializedName("data_usage_banner")
    val dataUsageNative : AdItem = AdItem(),

    //LTESetting
    @SerializedName("lte_banner")
    val lteNative : AdItem = AdItem(),

    //SpeedTest
    @SerializedName("speed_test_banner")
    val speedTestNative : AdItem = AdItem(),



)
