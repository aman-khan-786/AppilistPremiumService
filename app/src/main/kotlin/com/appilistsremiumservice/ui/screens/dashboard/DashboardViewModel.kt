package com.appilistpremiumservice.ui.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appilistpremiumservice.AppilistApp
import com.appilistpremiumservice.utils.DateUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    
    private val database = AppilistApp.database
    
    private val _todaySales = MutableStateFlow(0.0)
    val todaySales: StateFlow<Double> = _todaySales
    
    private val _stockCount = MutableStateFlow(0)
    val stockCount: StateFlow<Int> = _stockCount
    
    init {
        loadDashboardData()
    }
    
    private fun loadDashboardData() {
        viewModelScope.launch {
            // Load today's sales
            val total = database.salesDao()
                .getTotalSalesByDateRange(DateUtils.getCurrentDate(), DateUtils.getCurrentDate())
            _todaySales.value = total ?: 0.0
        }
    }
}