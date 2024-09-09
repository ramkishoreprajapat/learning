package com.rk.junittesting.utils

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class PasswordTest {
    lateinit var helper: Helper

    @Before
    fun setUp() {
        //Arrange
        helper = Helper()
    }

    @Test
    fun isPasswordValid_inputString_blank_expectedRequiredField() {
        //Arrange
        //Act
        val result = helper.isPasswordValid("")
        //Assert
        assertEquals("Password is required field", result)
    }

    @Test
    fun isPasswordValid_inputString_expectedValidationMsg() {
        //Arrange
        //Act
        val result = helper.isPasswordValid("abc")
        //Assert
        assertEquals("Length of password should be greater than 6", result)
    }

    @Test
    fun isPasswordValid_inputString_expectedValidationMsg2() {
        //Arrange
        //Act
        val result = helper.isPasswordValid("1234567891234567")
        //Assert
        assertEquals("Length of password should be less than 15", result)
    }

    @Test
    fun isPasswordValid_inputString_expectedValidPassword() {
        //Arrange
        //Act
        val result = helper.isPasswordValid("123456")
        //Assert
        assertEquals("Password is valid", result)
    }


    @Test
    fun reverseString_inputString_empty_expectedEmpty() {
        //Arrange
        //Act
        val result = helper.reverseString("")
        //Assert
        assertEquals("", result)

    }

    @Test
    fun reverseString_inputString_hello_expectedOlleh() {
        //Arrange
        //Act
        val result = helper.reverseString("hello")
        //Assert
        assertEquals("olleh", result)

    }

}