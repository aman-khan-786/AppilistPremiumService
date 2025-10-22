package com.appilistpremiumservice.domain.usecase.attendance

import com.appilistpremiumservice.data.local.AppDatabase
import com.appilistpremiumservice.data.local.entity.toEntity
import com.appilistpremiumservice.domain.model.Attendance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

/**
 * Mark Attendance Use Case
 */
class MarkAttendanceUseCase(private val database: AppDatabase) {
    
    suspend operator fun invoke(attendance: Attendance): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                val attendanceWithId = if (attendance.id.isEmpty()) {
                    attendance.copy(id = UUID.randomUUID().toString())
                } else attendance
                
                database.attendanceDao().insertAttendance(attendanceWithId.toEntity())
                Result.success(Unit)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}