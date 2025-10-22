package com.appilistpremiumservice.ui.screens.sales

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appilistpremiumservice.AppilistApp
import com.appilistpremiumservice.domain.model.Sales
import com.appilistpremiumservice.domain.usecase.sales.AddSalesUseCase
import com.appilistpremiumservice.utils.DateUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SalesEntryViewModel : ViewModel() {
    
    private val addSalesUseCase = AddSalesUseCase(AppilistApp.database)
    
    private val _saveState = MutableStateFlow<SaveState>(SaveState.Idle)
    val saveState: StateFlow<SaveState> = _saveState
    
    fun saveSales(
        totalSales: Double,
        cashAmount: Double,
        onlineAmount: Double,
        customersServed: Int,
        notes: String
    ) {
        viewModelScope.launch {
            _saveState.value = SaveState.Loading
            
            val sales = Sales(
                date = DateUtils.getCurrentDate(),
                shopId = "default_shop",
                staffId = "current_user",
                totalSales = totalSales,
                cashAmount = cashAmount,
                onlineAmount = onlineAmount,
                customersServed = customersServed,
                notes = notes
            )
            
            val result = addSalesUseCase(sales)
            
            _saveState.value = if (result.isSuccess) {
                SaveState.Success
            } else {
                SaveState.Error(result.exceptionOrNull()?.message ?: "Failed to save")
            }
        }
    }
}

sealed class SaveState {
    object Idle : SaveState()
    object Loading : SaveState()
    object Success : SaveState()
    data class Error(val message: String) : SaveState()
}