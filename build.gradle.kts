buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.gradle.v800)
        classpath(libs.kotlin.gradle.plugin.v180)
        classpath(libs.gradle)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.realm.gradle.plugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
}
