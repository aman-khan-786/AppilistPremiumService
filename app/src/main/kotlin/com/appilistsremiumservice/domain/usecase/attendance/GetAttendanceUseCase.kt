package com.appilistpremiumservice.domain.usecase.attendance

import com.appilistpremiumservice.data.local.AppDatabase
import com.appilistpremiumservice.data.local.entity.toDomain
import com.appilistpremiumservice.domain.model.Attendance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAttendanceUseCase(private val database: AppDatabase) {
    
    operator fun invoke(date: String): Flow<List<Attendance>> {
        return database.attendanceDao().getAttendanceByDate(date).map { list ->
            list.map { it.toDomain() }
        }
    }
}