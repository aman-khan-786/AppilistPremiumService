// Top-level build file
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.4.0") // Latest stable as of Oct 2025
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.24") // Latest stable Kotlin
    }
}

plugins {
    id("com.android.application") version "8.4.0" apply false // Updated to match Gradle plugin
    id("com.android.library") version "8.4.0" apply false    // Updated to match Gradle plugin
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false // Updated to match Kotlin plugin
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}

// Optional: Add repositories for all projects
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
