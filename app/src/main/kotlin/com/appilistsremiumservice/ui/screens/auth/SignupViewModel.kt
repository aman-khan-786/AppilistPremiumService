package com.appilistpremiumservice.ui.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appilistpremiumservice.AppilistApp
import com.appilistpremiumservice.domain.usecase.auth.SignupUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignupViewModel : ViewModel() {
    
    private val signupUseCase = SignupUseCase(AppilistApp.database)
    
    private val _signupState = MutableStateFlow<SignupState>(SignupState.Idle)
    val signupState: StateFlow<SignupState> = _signupState
    
    fun signup(name: String, email: String, password: String) {
        viewModelScope.launch {
            _signupState.value = SignupState.Loading
            
            val result = signupUseCase(name, email, password)
            
            _signupState.value = if (result.isSuccess) {
                SignupState.Success
            } else {
                SignupState.Error(result.exceptionOrNull()?.message ?: "Signup failed")
            }
        }
    }
}

sealed class SignupState {
    object Idle : SignupState()
    object Loading : SignupState()
    object Success : SignupState()
    data class Error(val message: String) : SignupState()
}