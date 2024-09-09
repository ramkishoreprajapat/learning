package com.rk.junittesting.utils

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class PasswordParameterizedTest(private val password: String, private val expectedValue: String) {
    private lateinit var helper: Helper

    @Before
    fun setUp() {
        //Arrange
        helper = Helper()
    }

    @Test
    fun isPasswordValid() {
        //Arrange
        //Act
        val result = helper.isPasswordValid(password)
        //Assert
        assertEquals(expectedValue, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is reversed to {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("     ", "Password is required field"),
                arrayOf("abc", "Length of password should be greater than 6"),
                arrayOf("1234567891234567", "Length of password should be less than 15"),
                arrayOf("123456", "Password is valid")
            )
        }
    }

}