import org.jetbrains.kotlin.config.JvmAnalysisFlags.useIR

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.dleibovych.domath.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
}
