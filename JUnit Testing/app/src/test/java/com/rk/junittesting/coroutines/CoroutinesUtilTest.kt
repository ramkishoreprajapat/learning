package com.rk.junittesting.coroutines

import com.rk.junittesting.MainCoroutinesRule
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class CoroutinesUtilTest {

    @get:Rule
    val mainCoroutinesRule = MainCoroutinesRule()

    private val coroutinesUtil = CoroutinesUtil(mainCoroutinesRule.testDispatcher)

    //Run blocking is not a good candidate. Try to avoid it. If coroutines take times if we added delay the run blocking also taking time
    @Test
    fun getUserNameUsingRunBlocking() = runBlocking {
        val result = coroutinesUtil.getUserName()
        assertEquals("John", result)
    }

    //Run Test is a good candidate. Try to use it. If coroutines take times if we added delay the run test not taking time
    @Test
    fun getUserNameUsingRunTest() {
        runTest {
            val result = coroutinesUtil.getUserName()
            assertEquals("John", result)
        }
    }

    @Test
    fun getLastNameUsingRunTest() {
        runTest {
            val result = coroutinesUtil.getLastName()
            assertEquals("Doe", result)
        }
    }

    @Test
    fun getAddress() {

    }
}