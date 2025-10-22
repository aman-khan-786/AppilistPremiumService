package com.appilistpremiumservice.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.appilistpremiumservice.R

/**
 * Notification Helper Utility
 * Create and show notifications
 */
object NotificationUtils {
    
    /**
     * Create notification channels (Android 8.0+)
     */
    fun createNotificationChannels(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            
            // General Notifications Channel
            val generalChannel = NotificationChannel(
                Constants.CHANNEL_ID_GENERAL,
                "General Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "General app notifications"
                enableLights(true)
                enableVibration(true)
            }
            
            // Stock Alerts Channel
            val stockChannel = NotificationChannel(
                Constants.CHANNEL_ID_STOCK_ALERTS,
                "Stock Alerts",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Low stock and stock update notifications"
                enableLights(true)
                enableVibration(true)
            }
            
            // Login Alerts Channel
            val loginChannel = NotificationChannel(
                Constants.CHANNEL_ID_LOGIN_ALERTS,
                "Login Alerts",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "User login and approval notifications"
                enableLights(true)
                enableVibration(true)
            }
            
            notificationManager.createNotificationChannel(generalChannel)
            notificationManager.createNotificationChannel(stockChannel)
            notificationManager.createNotificationChannel(loginChannel)
        }
    }
    
    /**
     * Show general notification
     */
    fun showNotification(
        context: Context,
        title: String,
        message: String,
        notificationId: Int = System.currentTimeMillis().toInt()
    ) {
        val builder = NotificationCompat.Builder(context, Constants.CHANNEL_ID_GENERAL)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
        
        with(NotificationManagerCompat.from(context)) {
            notify(notificationId, builder.build())
        }
    }
    
    /**
     * Show stock alert notification
     */
    fun showStockAlert(
        context: Context,
        productName: String,
        quantity: Int
    ) {
        val title = "Low Stock Alert"
        val message = "$productName is running low (${quantity} left)"
        
        val builder = NotificationCompat.Builder(context, Constants.CHANNEL_ID_STOCK_ALERTS)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
        
        with(NotificationManagerCompat.from(context)) {
            notify(System.currentTimeMillis().toInt(), builder.build())
        }
    }
    
    /**
     * Show login alert notification
     */
    fun showLoginAlert(
        context: Context,
        userName: String,
        userEmail: String
    ) {
        val title = "New Login Alert"
        val message = "$userName ($userEmail) has logged in"
        
        val builder = NotificationCompat.Builder(context, Constants.CHANNEL_ID_LOGIN_ALERTS)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
        
        with(NotificationManagerCompat.from(context)) {
            notify(System.currentTimeMillis().toInt(), builder.build())
        }
    }
    
    /**
     * Show user approval request notification
     */
    fun showApprovalRequest(
        context: Context,
        userName: String,
        userEmail: String
    ) {
        val title = "New Signup Request"
        val message = "$userName ($userEmail) is waiting for approval"
        
        val builder = NotificationCompat.Builder(context, Constants.CHANNEL_ID_LOGIN_ALERTS)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(false) // Don't auto-dismiss
        
        with(NotificationManagerCompat.from(context)) {
            notify(System.currentTimeMillis().toInt(), builder.build())
        }
    }
    
    /**
     * Cancel notification by ID
     */
    fun cancelNotification(context: Context, notificationId: Int) {
        NotificationManagerCompat.from(context).cancel(notificationId)
    }
    
    /**
     * Cancel all notifications
     */
    fun cancelAllNotifications(context: Context) {
        NotificationManagerCompat.from(context).cancelAll()
    }
}