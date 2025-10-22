package com.appilistpremiumservice.domain.model

/**
 * Attendance Domain Model
 * Daily attendance record
 */
data class Attendance(
    val id: String = "",
    val staffId: String = "",
    val staffName: String = "",
    val shopId: String = "",
    val date: String = "",
    val isPresent: Boolean = false,
    val isOnLeave: Boolean = false,
    val checkInTime: String = "",
    val checkOutTime: String = "",
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis()
) {
    /**
     * Get attendance status
     */
    fun getStatus(): AttendanceStatus {
        return when {
            isOnLeave -> AttendanceStatus.ON_LEAVE
            isPresent -> AttendanceStatus.PRESENT
            else -> AttendanceStatus.ABSENT
        }
    }
    
    /**
     * Get status display text
     */
    fun getStatusText(): String {
        return when (getStatus()) {
            AttendanceStatus.PRESENT -> "Present"
            AttendanceStatus.ABSENT -> "Absent"
            AttendanceStatus.ON_LEAVE -> "On Leave"
        }
    }
    
    /**
     * Calculate working hours
     */
    fun getWorkingHours(): String {
        if (checkInTime.isEmpty() || checkOutTime.isEmpty()) return "N/A"
        
        // Simple calculation (assuming format HH:mm)
        return try {
            val inParts = checkInTime.split(":")
            val outParts = checkOutTime.split(":")
            
            val inMinutes = inParts[0].toInt() * 60 + inParts[1].toInt()
            val outMinutes = outParts[0].toInt() * 60 + outParts[1].toInt()
            
            val diffMinutes = outMinutes - inMinutes
            val hours = diffMinutes / 60
            val minutes = diffMinutes % 60
            
            "${hours}h ${minutes}m"
        } catch (e: Exception) {
            "N/A"
        }
    }
}

/**
 * Attendance Status Enum
 */
enum class AttendanceStatus {
    PRESENT,
    ABSENT,
    ON_LEAVE
}