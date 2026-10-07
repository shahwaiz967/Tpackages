plugins {
    alias(libs.plugins.android.application)
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.codecx.tpackages"
    compileSdk = 37
    signingConfigs {
        create("release") {
            val keystorePropertiesFile =
                rootProject.file("not_avalaible.jks")
            if (keystorePropertiesFile.exists()) {
                storeFile = keystorePropertiesFile
                storePassword = "not_avalaible"
                keyAlias = "key0"
                keyPassword = "not_avalaible"
            } else {
                println("Warning: keystore.properties not found. Release build may fail.")
            }
        }
    }

    defaultConfig {
        applicationId = "com.arsalhub.paktpackages"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    base.archivesName.set("TPackages${defaultConfig.versionName}")

    buildTypes {
        release {
            /*optimization {
                enable = false
            }*/
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
    flavorDimensions += "mainFlavorDimension"
    productFlavors {
        create("dev") {
            dimension = "mainFlavorDimension"

            buildConfigField("String", "app_id", "\"ca-app-pub-3940256099942544~3347511713\"")
            buildConfigField("String", "banner_id", "\"ca-app-pub-3940256099942544/9214589741\"")
            buildConfigField("String", "inter_id", "\"ca-app-pub-3940256099942544/1033173712\"")
            buildConfigField("String", "advance_native_id", "\"ca-app-pub-3940256099942544/2247696110\"")
            buildConfigField("String", "app_open_id", "\"ca-app-pub-3940256099942544/9257395921\"")

        }
        create("pro") {
            dimension = "mainFlavorDimension"

            buildConfigField("String", "app_id", "\"ca-app-pub-7619326555341870~4019703229\"")
            buildConfigField("String", "banner_id", "\"ca-app-pub-7619326555341870/8084080479\"")
            buildConfigField("String", "inter_id", "\"ca-app-pub-7619326555341870/5212616964\"")
            buildConfigField("String", "advance_native_id", "\"ca-app-pub-7619326555341870/4144835466\"")
            buildConfigField("String", "app_open_id", "\"ca-app-pub-7619326555341870/2751862745\"")

        }
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    //Gson
    implementation(libs.gson)

    //Koin
    api(libs.koin.androidx.compose)

    //sdp and ssp
    implementation(libs.ssp.android)
    implementation(libs.sdp.android)

    //Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //GoogleSdk
    implementation(libs.ads.mobile.sdk)
    implementation(libs.shimmer)

    //lottie animation
    implementation(libs.lottie)

    //FireBase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.perf)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.messaging)
    implementation(libs.firebase.config)

    implementation(libs.androidx.lifecycle.process)
}
androidComponents {
    beforeVariants(selector().all()) { variantBuilder ->
        val shouldEnableProGuard =
            variantBuilder.flavorName == "pro" && variantBuilder.buildType == "release"
        variantBuilder.isMinifyEnabled = shouldEnableProGuard
        variantBuilder.shrinkResources = shouldEnableProGuard
    }
}