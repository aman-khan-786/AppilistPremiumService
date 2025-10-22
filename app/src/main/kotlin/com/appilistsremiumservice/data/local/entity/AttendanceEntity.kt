package com.appilistpremiumservice.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.appilistpremiumservice.domain.model.Attendance

/**
 * Attendance Table Entity
 * Room database table for attendance records
 */
@Entity(tableName = "attendance")
data class AttendanceEntity(
    @PrimaryKey
    val id: String,
    val staffId: String,
    val staffName: String,
    val shopId: String,
    val date: String,
    val isPresent: Boolean,
    val isOnLeave: Boolean,
    val checkInTime: String,
    val checkOutTime: String,
    val notes: String,
    val createdAt: Long
)

/**
 * Convert Entity to Domain Model
 */
fun AttendanceEntity.toDomain(): Attendance {
    return Attendance(
        id = id,
        staffId = staffId,
        staffName = staffName,
        shopId = shopId,
        date = date,
        isPresent = isPresent,
        isOnLeave = isOnLeave,
        checkInTime = checkInTime,
        checkOutTime = checkOutTime,
        notes = notes,
        createdAt = createdAt
    )
}

/**
 * Convert Domain Model to Entity
 */
fun Attendance.toEntity(): AttendanceEntity {
    return AttendanceEntity(
        id = id,
        staffId = staffId,
        staffName = staffName,
        shopId = shopId,
        date = date,
        isPresent = isPresent,
        isOnLeave = isOnLeave,
        checkInTime = checkInTime,
        checkOutTime = checkOutTime,
        notes = notes,
        createdAt = createdAt
    )
}