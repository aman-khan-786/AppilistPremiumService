package com.appilistpremiumservice.di

object NetworkModule {
    // Future: Add Retrofit, OkHttp, Firebase initialization here
    
    fun provideBaseUrl(): String {
        return "https://api.example.com/"
    }
}