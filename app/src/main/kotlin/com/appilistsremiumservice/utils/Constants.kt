package com.appilistpremiumservice.utils

/**
 * App-wide Constants
 * All static values stored here
 */
object Constants {
    
    // Database Constants
    const val DATABASE_NAME = "appilist_database"
    const val DATABASE_VERSION = 1
    
    // User Roles
    const val ROLE_ADMIN = "ADMIN"
    const val ROLE_STAFF = "STAFF"
    
    // Shared Preferences Keys
    const val PREF_NAME = "appilist_prefs"
    const val KEY_USER_ID = "user_id"
    const val KEY_USER_EMAIL = "user_email"
    const val KEY_USER_ROLE = "user_role"
    const val KEY_IS_LOGGED_IN = "is_logged_in"
    const val KEY_SELECTED_SHOP_ID = "selected_shop_id"
    
    // Date Format
    const val DATE_FORMAT = "dd/MM/yyyy"
    const val DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss"
    const val TIME_FORMAT = "HH:mm"
    
    // Validation Constants
    const val MIN_PASSWORD_LENGTH = 6
    const val MAX_PASSWORD_LENGTH = 20
    const val MIN_USERNAME_LENGTH = 3
    
    // Stock Alert Threshold
    const val LOW_STOCK_THRESHOLD = 10
    
    // WorkManager Constants
    const val SYNC_WORK_NAME = "data_sync_work"
    const val SYNC_INTERVAL_HOURS = 1L
    
    // Notification Channels
    const val CHANNEL_ID_GENERAL = "general_notifications"
    const val CHANNEL_ID_STOCK_ALERTS = "stock_alerts"
    const val CHANNEL_ID_LOGIN_ALERTS = "login_alerts"
    
    // Request Codes
    const val REQUEST_CODE_NOTIFICATION_PERMISSION = 1001
    
    // Error Messages
    const val ERROR_NETWORK = "No internet connection"
    const val ERROR_UNKNOWN = "Something went wrong"
    const val ERROR_EMPTY_FIELDS = "Please fill all fields"
    const val ERROR_INVALID_EMAIL = "Invalid email format"
    const val ERROR_WEAK_PASSWORD = "Password too weak"
    
    // Success Messages
    const val SUCCESS_LOGIN = "Login successful"
    const val SUCCESS_LOGOUT = "Logged out successfully"
    const val SUCCESS_SIGNUP = "Account created successfully"
    const val SUCCESS_SALES_ADDED = "Sales entry added"
    const val SUCCESS_STOCK_ADDED = "Stock added successfully"
    const val SUCCESS_ATTENDANCE_MARKED = "Attendance marked"
}