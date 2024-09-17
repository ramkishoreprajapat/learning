package com.rk.loginjetpackwithmvvm.viewModel

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rk.loginjetpackwithmvvm.R
import com.rk.loginjetpackwithmvvm.repositories.AuthenticationRepository
import com.rk.loginjetpackwithmvvm.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(private val authenticationRepository: AuthenticationRepository) : ViewModel() {
//    val user: StateFlow<User> get() = authenticationRepository.user
    private val _userRegister = mutableStateOf(User())
    val userRegister: State<User> = _userRegister

    var email by mutableStateOf("")
        private set


    fun register() {
        viewModelScope.launch {
            authenticationRepository.register()
        }
    }

    fun registrationValidationCheck(
        email: String,
        password: String,
        confirmPassword: String,
        snakeBarViewModel: SnakeBarViewModel
    ) {
        if (email.isNotEmpty()) {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                if (password.isNotEmpty()) {
                    if (password.length in 8..32) {
                            if (password == confirmPassword) {

                            } else {
                                Log.d("TAG", "registrationValidationCheck: Password and confirm password must be match")
                            }
                    } else {
                        Log.d("TAG", "registrationValidationCheck: Password must be 8-32 characters")
                    }
                } else {
                    Log.d("TAG", "registrationValidationCheck: Password is empty")
                }
            } else {
                Log.d("TAG", "registrationValidationCheck: Email is not valid")
            }
        } else {
            Log.d("TAG", "registrationValidationCheck: Email is empty")
            snakeBarViewModel.setMessageShown(R.string.email)
            //snakeBarViewModel.showUserMessage(R.string.email)
        }
    }
}