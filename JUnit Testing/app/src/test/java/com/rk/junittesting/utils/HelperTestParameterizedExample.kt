package com.rk.junittesting.utils

import org.junit.Test
import org.junit.runners.Parameterized
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith

@RunWith(Parameterized::class) // This must be used for parameterized test
class HelperTestParameterizedExample(val input: String, val expectedValue: Boolean) {
    @Test
    fun test() {
        val helper = Helper()
        val result = helper.isPalindrome(input)
        assertEquals(expectedValue, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is palindrome - {1}")//it will help to show the test case name
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true),
            )
        }
    }
}