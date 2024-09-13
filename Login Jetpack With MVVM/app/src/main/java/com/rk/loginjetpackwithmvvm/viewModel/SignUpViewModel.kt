package com.rk.loginjetpackwithmvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rk.jetpackwithmvvm.repositories.AuthenticationRepository
import com.rk.loginjetpackwithmvvm.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val authenticationRepository: AuthenticationRepository) : ViewModel() {
    val user: StateFlow<User> get() = authenticationRepository.user

    fun register() {
        viewModelScope.launch {
            authenticationRepository.register()
        }
    }

    fun registrationValidationCheck() {

    }
}