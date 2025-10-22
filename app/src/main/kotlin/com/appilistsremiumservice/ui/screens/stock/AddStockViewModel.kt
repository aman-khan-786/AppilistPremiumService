package com.appilistpremiumservice.ui.screens.stock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appilistpremiumservice.AppilistApp
import com.appilistpremiumservice.domain.model.Stock
import com.appilistpremiumservice.domain.model.StockCategory
import com.appilistpremiumservice.domain.usecase.stock.AddStockUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddStockViewModel : ViewModel() {
    
    private val addStockUseCase = AddStockUseCase(AppilistApp.database)
    
    private val _saveState = MutableStateFlow<SaveStockState>(SaveStockState.Idle)
    val saveState: StateFlow<SaveStockState> = _saveState
    
    fun addStock(
        productName: String,
        category: String,
        quantity: Int,
        purchasePrice: Double,
        sellingPrice: Double
    ) {
        viewModelScope.launch {
            _saveState.value = SaveStockState.Loading
            
            val stock = Stock(
                productName = productName,
                category = StockCategory.fromString(category),
                quantity = quantity,
                purchasePrice = purchasePrice,
                sellingPrice = sellingPrice,
                shopId = "default_shop",
                lastUpdatedBy = "current_user"
            )
            
            val result = addStockUseCase(stock)
            
            _saveState.value = if (result.isSuccess) {
                SaveStockState.Success
            } else {
                SaveStockState.Error(result.exceptionOrNull()?.message ?: "Failed")
            }
        }
    }
}

sealed class SaveStockState {
    object Idle : SaveStockState()
    object Loading : SaveStockState()
    object Success : SaveStockState()
    data class Error(val message: String) : SaveStockState()
}