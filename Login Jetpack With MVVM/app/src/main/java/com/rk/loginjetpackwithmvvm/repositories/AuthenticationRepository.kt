package com.rk.loginjetpackwithmvvm.repositories

import com.rk.loginjetpackwithmvvm.api.AuthenticationApi
import com.rk.loginjetpackwithmvvm.data.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(private val authenticationApi: AuthenticationApi) {
    private val _user = MutableStateFlow(User("","",""))
    val user get() = _user.asStateFlow()

    suspend fun register() {
        val response = authenticationApi.register()
        if (response.isSuccessful && response.body() != null) {
            _user.emit(response.body()!!)
        }
    }

}