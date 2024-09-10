package com.rk.junittesting.mock

class UserService(private val userRepository: UserRepository) {
    fun loginUser(email: String, password: String): String {
        val status = userRepository.loginUser(email, password)

        return when (status) {
            LoginStatus.INVALID_USER -> "User does not exist"
            LoginStatus.INVALID_PASSWORD -> "Password is invalid"
            LoginStatus.SUCCESS -> "Logged in successfully"
            LoginStatus.UNKNOWN_ERROR -> "Unknown error occurred"
        }
    }

}