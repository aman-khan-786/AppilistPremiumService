package com.appilistpremiumservice

import android.app.Application
import com.appilistpremiumservice.data.local.AppDatabase
import com.appilistpremiumservice.utils.NotificationUtils

/**
 * Main Application Class
 * App launch hone pe sabse pehle run hota hai
 */
class AppilistApp : Application() {
    
    companion object {
        lateinit var instance: AppilistApp
            private set
        
        // Database instance accessible throughout app
        lateinit var database: AppDatabase
            private set
    }
    
    override fun onCreate() {
        super.onCreate()
        instance = this
        
        // Initialize database
        database = AppDatabase.getDatabase(this)
        
        // Create notification channels
        NotificationUtils.createNotificationChannels(this)
    }
}