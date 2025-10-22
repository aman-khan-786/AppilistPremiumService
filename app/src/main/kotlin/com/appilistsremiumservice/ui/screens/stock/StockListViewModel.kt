package com.appilistpremiumservice.ui.screens.stock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appilistpremiumservice.AppilistApp
import com.appilistpremiumservice.data.local.entity.toDomain
import com.appilistpremiumservice.domain.model.Stock
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StockListViewModel : ViewModel() {
    
    private val database = AppilistApp.database
    
    private val _stockList = MutableStateFlow<List<Stock>>(emptyList())
    val stockList: StateFlow<List<Stock>> = _stockList
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading
    
    init {
        loadStock()
    }
    
    fun loadStock() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                database.stockDao().getAllStock().collect { entities ->
                    _stockList.value = entities.map { it.toDomain() }
                }
            } finally {
                _isLoading.value = false
            }
        }
    }
    
    fun searchStock(query: String) {
        if (query.isEmpty()) {
            loadStock()
        } else {
            viewModelScope.launch {
                database.stockDao().searchStock(query).collect { entities ->
                    _stockList.value = entities.map { it.toDomain() }
                }
            }
        }
    }
}