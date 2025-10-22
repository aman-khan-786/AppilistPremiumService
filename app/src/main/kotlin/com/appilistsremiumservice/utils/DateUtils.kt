package com.appilistpremiumservice.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Date & Time Utility Functions
 * Format conversion, validation, comparison
 */
object DateUtils {
    
    /**
     * Get current date in dd/MM/yyyy format
     */
    fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())
        return dateFormat.format(Date())
    }
    
    /**
     * Get current date and time in dd/MM/yyyy HH:mm:ss format
     */
    fun getCurrentDateTime(): String {
        val dateFormat = SimpleDateFormat(Constants.DATE_TIME_FORMAT, Locale.getDefault())
        return dateFormat.format(Date())
    }
    
    /**
     * Get current time in HH:mm format
     */
    fun getCurrentTime(): String {
        val timeFormat = SimpleDateFormat(Constants.TIME_FORMAT, Locale.getDefault())
        return timeFormat.format(Date())
    }
    
    /**
     * Get current timestamp in milliseconds
     */
    fun getCurrentTimestamp(): Long {
        return System.currentTimeMillis()
    }
    
    /**
     * Format timestamp to readable date string
     * @param timestamp Long timestamp in milliseconds
     * @param format String format pattern (default: dd/MM/yyyy)
     * @return Formatted date string
     */
    fun formatTimestamp(timestamp: Long, format: String = Constants.DATE_FORMAT): String {
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(Date(timestamp))
    }
    
    /**
     * Convert date string to timestamp
     * @param dateString String in dd/MM/yyyy format
     * @return Timestamp in milliseconds
     */
    fun dateStringToTimestamp(dateString: String): Long {
        return try {
            val dateFormat = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())
            dateFormat.parse(dateString)?.time ?: 0L
        } catch (e: Exception) {
            0L
        }
    }
    
    /**
     * Check if date1 is same as date2
     */
    fun isSameDate(date1: String, date2: String): Boolean {
        return date1 == date2
    }
    
    /**
     * Check if given date is today
     */
    fun isToday(dateString: String): Boolean {
        return dateString == getCurrentDate()
    }
    
    /**
     * Get date of specific days ago
     * @param daysAgo Number of days to subtract
     * @return Date string in dd/MM/yyyy format
     */
    fun getDateDaysAgo(daysAgo: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -daysAgo)
        val dateFormat = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())
        return dateFormat.format(calendar.time)
    }
    
    /**
     * Get start of current month date
     */
    fun getMonthStartDate(): String {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        val dateFormat = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())
        return dateFormat.format(calendar.time)
    }
    
    /**
     * Get end of current month date
     */
    fun getMonthEndDate(): String {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
        val dateFormat = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())
        return dateFormat.format(calendar.time)
    }
    
    /**
     * Get day name from date (Monday, Tuesday, etc)
     */
    fun getDayName(dateString: String): String {
        return try {
            val dateFormat = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())
            val date = dateFormat.parse(dateString)
            val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
            dayFormat.format(date ?: Date())
        } catch (e: Exception) {
            ""
        }
    }
    
    /**
     * Compare two dates
     * @return -1 if date1 < date2, 0 if equal, 1 if date1 > date2
     */
    fun compareDates(date1: String, date2: String): Int {
        val timestamp1 = dateStringToTimestamp(date1)
        val timestamp2 = dateStringToTimestamp(date2)
        return when {
            timestamp1 < timestamp2 -> -1
            timestamp1 > timestamp2 -> 1
            else -> 0
        }
    }
}