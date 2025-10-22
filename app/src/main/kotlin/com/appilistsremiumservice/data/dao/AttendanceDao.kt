package com.appilistpremiumservice.data.local.dao

import androidx.room.*
import com.appilistpremiumservice.data.local.entity.AttendanceEntity
import kotlinx.coroutines.flow.Flow

/**
 * Attendance Data Access Object
 * Database operations for Attendance table
 */
@Dao
interface AttendanceDao {
    
    /**
     * Insert new attendance record
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttendance(attendance: AttendanceEntity)
    
    /**
     * Insert multiple attendance records
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttendanceList(attendanceList: List<AttendanceEntity>)
    
    /**
     * Update existing attendance record
     */
    @Update
    suspend fun updateAttendance(attendance: AttendanceEntity)
    
    /**
     * Delete attendance record
     */
    @Delete
    suspend fun deleteAttendance(attendance: AttendanceEntity)
    
    /**
     * Get attendance by ID
     */
    @Query("SELECT * FROM attendance WHERE id = :attendanceId")
    suspend fun getAttendanceById(attendanceId: String): AttendanceEntity?
    
    /**
     * Get all attendance records
     */
    @Query("SELECT * FROM attendance ORDER BY date DESC, createdAt DESC")
    fun getAllAttendance(): Flow<List<AttendanceEntity>>
    
    /**
     * Get attendance by staff ID
     */
    @Query("SELECT * FROM attendance WHERE staffId = :staffId ORDER BY date DESC")
    fun getAttendanceByStaff(staffId: String): Flow<List<AttendanceEntity>>
    
    /**
     * Get attendance by date
     */
    @Query("SELECT * FROM attendance WHERE date = :date ORDER BY staffName ASC")
    fun getAttendanceByDate(date: String): Flow<List<AttendanceEntity>>
    
    /**
     * Get attendance by staff and date
     */
    @Query("SELECT * FROM attendance WHERE staffId = :staffId AND date = :date")
    suspend fun getAttendanceByStaffAndDate(staffId: String, date: String): AttendanceEntity?
    
    /**
     * Get attendance by shop ID
     */
    @Query("SELECT * FROM attendance WHERE shopId = :shopId ORDER BY date DESC")
    fun getAttendanceByShop(shopId: String): Flow<List<AttendanceEntity>>
    
    /**
     * Get attendance by date range
     */
    @Query("SELECT * FROM attendance WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    fun getAttendanceByDateRange(startDate: String, endDate: String): Flow<List<AttendanceEntity>>
    
    /**
     * Get present staff for a date
     */
    @Query("SELECT * FROM attendance WHERE date = :date AND isPresent = 1 ORDER BY staffName ASC")
    fun getPresentStaffByDate(date: String): Flow<List<AttendanceEntity>>
    
    /**
     * Get absent staff for a date
     */
    @Query("SELECT * FROM attendance WHERE date = :date AND isPresent = 0 AND isOnLeave = 0 ORDER BY staffName ASC")
    fun getAbsentStaffByDate(date: String): Flow<List<AttendanceEntity>>
    
    /**
     * Get staff on leave for a date
     */
    @Query("SELECT * FROM attendance WHERE date = :date AND isOnLeave = 1 ORDER BY staffName ASC")
    fun getStaffOnLeaveByDate(date: String): Flow<List<AttendanceEntity>>
    
    /**
     * Count present staff for a date
     */
    @Query("SELECT COUNT(*) FROM attendance WHERE date = :date AND isPresent = 1")
    suspend fun countPresentStaff(date: String): Int
    
    /**
     * Count total working days for staff in date range
     */
    @Query("SELECT COUNT(*) FROM attendance WHERE staffId = :staffId AND date BETWEEN :startDate AND :endDate AND isPresent = 1")
    suspend fun countWorkingDays(staffId: String, startDate: String, endDate: String): Int
    
    /**
     * Delete all attendance records
     */
    @Query("DELETE FROM attendance")
    suspend fun deleteAllAttendance()
}