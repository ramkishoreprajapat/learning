package com.rk.junittesting.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesUtil(private val dispatcher: CoroutineDispatcher) {
    suspend fun getUserName(): String {
        delay(10000)
        return "John"
    }

    suspend fun getLastName(): String {
        //Dispatcher.Main // We are passing dispatcher dynamically because we requiring StandardTestDispatcher for test cases for all dispatchers
        CoroutineScope(dispatcher).launch {
            delay(2000)
        }
        return "Doe"
    }

    suspend fun getAddress(): String {
        //Dispatcher.IO // We are passing dispatcher dynamically because we requiring StandardTestDispatcher for test cases for all dispatchers
        withContext(dispatcher) {
            delay(5000)
        }
       return "Address"
    }

}