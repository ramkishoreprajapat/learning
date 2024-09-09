package com.rk.junittesting.utils

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ReverseStringParameterizedTest(private val input: String, private val expectedValue: String){
    private lateinit var helper: Helper

    @Before
    fun setUp() {
        //Arrange
        helper = Helper()
    }

    @Test
    fun reverseString() {
        //Arrange
        //Act
        val result = helper.reverseString(input)
        //Assert
        assertEquals(expectedValue, result)

    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is reversed to {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", "olleh"),
                arrayOf("madam", "madam"),
                arrayOf("12345", "54321"),
                arrayOf("", "")
            )
        }
    }

}