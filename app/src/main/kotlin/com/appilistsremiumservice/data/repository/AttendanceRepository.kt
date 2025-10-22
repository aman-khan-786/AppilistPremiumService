package com.appilistpremiumservice.data.repository

import com.appilistpremiumservice.data.local.dao.AttendanceDao
import com.appilistpremiumservice.data.local.entity.AttendanceEntity
import com.appilistpremiumservice.data.local.entity.toDomain
import com.appilistpremiumservice.domain.model.Attendance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AttendanceRepository(private val attendanceDao: AttendanceDao) {
    
    suspend fun insertAttendance(attendance: AttendanceEntity) = 
        attendanceDao.insertAttendance(attendance)
    
    fun getAttendanceByDate(date: String): Flow<List<Attendance>> {
        return attendanceDao.getAttendanceByDate(date).map { list -> 
            list.map { it.toDomain() } 
        }
    }
}