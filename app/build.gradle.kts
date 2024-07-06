plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 21
        targetSdk = 33
        namespace = applicationId
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    dependencies {
        implementation(libs.kotlin.stdlib)
        implementation(libs.recyclerview.v121)
        implementation(libs.material.v140)
        implementation(libs.appcompat.v131)
        testImplementation(libs.junit)
        androidTestImplementation(libs.junit.v113)
        androidTestImplementation(libs.espresso.core.v340)
    }
}
