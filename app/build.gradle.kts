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
        multiDexEnabled = true // Corrected syntax
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
        // Yeh line Compose ke liye zaroori nahi hai jab tak aapko specific interface default methods na chahiye hon
        // freeCompilerArgs += "-Xjvm-default=all" 
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core AndroidX
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-compose:1.8.2")

    // Compose BOM
    implementation(platform("androidx.compose:compose-bom:2024.04.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // WorkManager
    implementation("androidx.work:work-runtime-ktx:2.9.0")
    // Note: work-runtime-ktx already includes work-runtime, so you might not need the second line
    // implementation("androidx.work:work-runtime:2.9.0") 
    implementation("androidx.work:work-multiprocess:2.9.0")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    // MultiDex
    implementation("androidx.multidex:multidex:2.0.1")

    // Networking (if needed)
    implementation("com.google.android.gms:play-services-base:18.2.0") // For GCM/Network

    // Testing (optional)
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.04.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
}

// === YEH BLOCK ZAROOR HATA DEIN AGAR AAPKI FILE MEIN HAI ===
// Agar aapki file mein is tarah ka koi block neeche hai, to use DELETE kar dein.
/*
tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile).configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}
*/
