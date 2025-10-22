package com.appilistpremiumservice.ui.screens.sales

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appilistpremiumservice.AppilistApp
import com.appilistpremiumservice.domain.model.Sales
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SalesHistoryViewModel : ViewModel() {
    
    private val database = AppilistApp.database
    
    private val _salesList = MutableStateFlow<List<Sales>>(emptyList())
    val salesList: StateFlow<List<Sales>> = _salesList
    
    init {
        loadSalesHistory()
    }
    
    private fun loadSalesHistory() {
        viewModelScope.launch {
            database.salesDao().getAllSales().collect { entities ->
                _salesList.value = entities.map { it.toDomain() }
            }
        }
    }
}

private fun com.appilistpremiumservice.data.local.entity.SalesEntity.toDomain() = 
    com.appilistpremiumservice.domain.model.Sales(
        id = id,
        date = date,
        shopId = shopId,
        staffId = staffId,
        totalSales = totalSales,
        cashAmount = cashAmount,
        onlineAmount = onlineAmount,
        customersServed = customersServed,
        notes = notes,
        createdAt = createdAt,
        updatedAt = updatedAt
    )