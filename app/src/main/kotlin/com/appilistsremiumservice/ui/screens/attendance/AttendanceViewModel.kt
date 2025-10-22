package com.appilistpremiumservice.ui.screens.attendance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appilistpremiumservice.AppilistApp
import com.appilistpremiumservice.domain.model.Attendance
import com.appilistpremiumservice.domain.usecase.attendance.MarkAttendanceUseCase
import com.appilistpremiumservice.utils.DateUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AttendanceViewModel : ViewModel() {
    
    private val markAttendanceUseCase = MarkAttendanceUseCase(AppilistApp.database)
    
    private val _markState = MutableStateFlow<MarkState>(MarkState.Idle)
    val markState: StateFlow<MarkState> = _markState
    
    fun markAttendance(staffId: String, staffName: String) {
        viewModelScope.launch {
            _markState.value = MarkState.Loading
            
            val attendance = Attendance(
                staffId = staffId,
                staffName = staffName,
                shopId = "default_shop",
                date = DateUtils.getCurrentDate(),
                isPresent = true,
                checkInTime = DateUtils.getCurrentTime()
            )
            
            val result = markAttendanceUseCase(attendance)
            
            _markState.value = if (result.isSuccess) {
                MarkState.Success
            } else {
                MarkState.Error(result.exceptionOrNull()?.message ?: "Failed")
            }
        }
    }
}

sealed class MarkState {
    object Idle : MarkState()
    object Loading : MarkState()
    object Success : MarkState()
    data class Error(val message: String) : MarkState()
}