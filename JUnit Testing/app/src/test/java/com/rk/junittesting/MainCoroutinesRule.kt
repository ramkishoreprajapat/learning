package com.rk.junittesting

import com.rk.junittesting.coroutines.CoroutinesUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class MainCoroutinesRule: TestWatcher() {
    private lateinit var coroutinesUtil: CoroutinesUtil
    val testDispatcher  = StandardTestDispatcher()

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
        coroutinesUtil = CoroutinesUtil(testDispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}