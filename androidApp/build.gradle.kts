plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.kotlin.plugin.compose")
}

// Load keystore properties
val keystorePropsFile = rootProject.file("androidApp/keystore.properties")
val keystoreProps = if (keystorePropsFile.exists()) {
    java.util.Properties().apply { load(keystorePropsFile.inputStream()) }
} else {
    null
}

android {
    namespace = "com.kmpapp.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.kmpapp.android"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
    }
    signingConfigs {
        create("release") {
            storeFile = file("keystore.jks")
            storePassword = keystoreProps?.getProperty("storePassword") ?: System.getenv("KEYSTORE_PASSWORD") ?: "KmpApp2024"
            keyAlias = keystoreProps?.getProperty("keyAlias") ?: System.getenv("KEY_ALIAS") ?: "kmpapp"
            keyPassword = keystoreProps?.getProperty("keyPassword") ?: System.getenv("KEY_PASSWORD") ?: "KmpApp2024"
        }
    }
    buildTypes {
        debug {
            isDebuggable = true
        }
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
    buildFeatures { compose = true }
}

dependencies {
    implementation(project(":shared"))
    val composeBom = platform("androidx.compose:compose-bom:2024.10.01")
    implementation(composeBom)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
    debugImplementation("androidx.compose.ui:ui-tooling")
}
