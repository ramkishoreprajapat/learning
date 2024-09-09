package com.rk.junittesting.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {
    lateinit var helper: Helper
    @Before
    fun setUp() {
        //Arrange
        helper = Helper()
        //You can't use Log.d() in unit test
        println("setUp: Before every test case")
    }

    @After
    fun tearDown() {
        //You can't use Log.d() in unit test
        println("tearDown: After every test case")
    }

    @Test
    fun isPalindrome_inputString_hello_expectedFalse() {
        //Arrange
        //val helper = Helper()
        //Act
        val result = helper.isPalindrome("hello")
        //Assert
        assertEquals(false, result)
    }

    @Test
    fun isPalindrome_inputString_level_expectedTrue() {
        //Arrange
        //val helper = Helper()
        //Act
        val result = helper.isPalindrome("level")
        //Assert
        assertEquals(true, result)
    }

    @Test
    fun isPalindrome_inputString_empty_expectedTrue() {
        //Arrange
        //val helper = Helper()
        //Act
        val result = helper.isPalindrome("")
        //Assert
        assertEquals(true, result)
    }

    @Test
    fun isPalindrome_inputString_a_expectedTrue() {
        //Arrange
        //val helper = Helper()
        //Act
        val result = helper.isPalindrome("level")
        //Assert
        assertEquals(true, result)
    }
}