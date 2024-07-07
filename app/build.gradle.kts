plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        namespace = applicationId
        minSdk = 21
        //noinspection OldTargetApi
        targetSdk = 33
        multiDexEnabled = true
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    dependencies {
        implementation(kotlin("stdlib"))
        implementation(libs.kotlin.stdlib.v180)
        implementation(libs.core.ktx)
        implementation(libs.kotlin.stdlib)
        implementation(libs.appcompat.v141)
        implementation(libs.kotlinx.collections.immutable.jvm)
        implementation(libs.realm.android.library)
        implementation(libs.mongodb.driver.sync)
        implementation(libs.material.v120)
        testImplementation(libs.junit)
        androidTestImplementation(libs.ext.junit)
        androidTestImplementation(libs.espresso.core)
    }
}


