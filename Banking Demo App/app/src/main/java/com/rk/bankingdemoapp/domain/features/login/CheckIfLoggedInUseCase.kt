package com.rk.bankingdemoapp.domain.features.login

import javax.inject.Inject

class CheckIfLoggedInUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend fun execute(): Boolean {
        return loginRepository.checkIfLoggedIn()
    }
}