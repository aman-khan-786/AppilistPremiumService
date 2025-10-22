plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.appilistpremiumservice"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.appilistpremiumservice"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        // Optional: Enable multi-dex if needed
        multiDexEnabled true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11" // Updated to latest stable version
    }

    // Add packaging options if needed for Compose
    packaging {
        resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
        }
    }
}

dependencies {
    // Core AndroidX dependencies
    implementation("androidx.core:core-ktx:1.12.0") // Latest version
    implementation("androidx.activity:activity-compose:1.8.2") // Latest version

    // Compose BOM for version consistency
    implementation(platform("androidx.compose:compose-bom:2024.04.01")) // Latest BOM
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")

    debugImplementation("androidx.compose.ui:ui-tooling")

    // WorkManager for background tasks
    implementation("androidx.work:work-runtime-ktx:2.9.0") // Latest stable
    implementation("androidx.work:work-runtime:2.9.0")
    implementation("androidx.work:work-gcm:2.9.0") // For Google Cloud Messaging

    // Optional: Add lifecycle and viewmodel for better Compose integration
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    // MultiDex support (if needed)
    implementation("androidx.multidex:multidex:2.0.1")
}
