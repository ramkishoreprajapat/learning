package com.rk.junittesting.mock

class UserRepository {
    private val users = listOf(
        User(1, "John", "john@gmail.com", "password123"),
        User(1, "Smith", "smith@gmail.com", "smith1111"),
        User(1, "rock", "rock@gmail.com", "rock5464"),
    )

    fun loginUser(email: String, password: String): LoginStatus {

        val user = users.filter {
            it.email == email
        }

        return if (user.size == 1) {
            if (user[0].password == password) {
                LoginStatus.SUCCESS
            } else {
                LoginStatus.INVALID_PASSWORD
            }
        } else {
            LoginStatus.INVALID_USER
        }

    }
}