package com.rk.junittesting.utils

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ReverseStringTest{
    lateinit var helper: Helper

    @Before
    fun setUp() {
        //Arrange
        helper = Helper()
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