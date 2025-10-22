package com.appilistpremiumservice.ui.screens.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appilistpremiumservice.AppilistApp
import com.appilistpremiumservice.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AdminViewModel : ViewModel() {
    
    private val database = AppilistApp.database
    
    private val _pendingUsers = MutableStateFlow<List<User>>(emptyList())
    val pendingUsers: StateFlow<List<User>> = _pendingUsers
    
    init {
        loadPendingUsers()
    }
    
    private fun loadPendingUsers() {
        viewModelScope.launch {
            database.userDao().getPendingUsers().collect { entities ->
                _pendingUsers.value = entities.map { it.toDomain() }
            }
        }
    }
    
    fun approveUser(userId: String) {
        viewModelScope.launch {
            database.userDao().approveUser(userId, System.currentTimeMillis())
        }
    }
}

private fun com.appilistpremiumservice.data.local.entity.UserEntity.toDomain() = 
    com.appilistpremiumservice.domain.model.User(
        id = id,
        name = name,
        email = email,
        password = password,
        role = com.appilistpremiumservice.domain.model.UserRole.fromString(role),
        shopId = shopId,
        isApproved = isApproved,
        createdAt = createdAt,
        updatedAt = updatedAt
    )