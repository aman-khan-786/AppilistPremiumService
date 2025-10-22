package com.appilistpremiumservice.ui.screens.profile

import androidx.lifecycle.ViewModel
import com.appilistpremiumservice.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel : ViewModel() {
    
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser
    
    fun logout() {
        // TODO: Clear session
        _currentUser.value = null
    }
}