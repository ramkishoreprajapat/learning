package com.rk.flowsandchannel

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rk.flowsandchannel.ui.theme.FlowsAndChannelTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : ComponentActivity() {
    //Channel - Channel is basically hot. that means it providing continuously data. if consumer consume or not.
    //Flow -  Flow is basically cold. that means it providing data only when consumer consume. It will provide all of the data one by one even flow started already
    var channel = Channel<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*channelProducer()
          channelConsumer()*/

        //simpleFlowUse()
        //flowFunctions()
        //flowMapAndFilterBeforeCollect()
        //flowBuffer()
        flowOnForThreadManage()

        enableEdgeToEdge()
        setContent {
            FlowsAndChannelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {

                    }
                }
            }
        }
    }

    private fun channelProducer() {
        CoroutineScope(Dispatchers.Main).launch {
            channel.send(1)
            channel.send(2)
        }
    }

    private fun channelConsumer() {
        CoroutineScope(Dispatchers.Main).launch {

            Log.d("TAG", "channelConsumer: " + channel.receive().toString())
            Log.d("TAG", "channelConsumer: " + channel.receive().toString())
        }
    }

    private fun producerFlow(): Flow<Int> {
        return flow {
            val list = listOf(1, 2, 3, 4, 5)
            list.forEach {
                delay(1000)
                Log.d("TAG", "Emitter Thread - ${Thread.currentThread().name}")
                emit(it)
                //throw Exception("Error in emit") //it will call when flow Exception and we can emit our value. Uncomment and test it.
            }
        }.catch {
            //it will call when flow Exception and we can emit our value
            Log.d("TAG", "producerFlow Exception: ${it.message}")
            emit(-1)
        }
    }

    private fun simpleFlowUse() {
        val job = GlobalScope.launch(Dispatchers.Main) {
            val data: Flow<Int> = producerFlow()
            data.collect {
                Log.d("TAG", "onCreate: $it")
            }
        }

        //Flow canceling through coroutine
        GlobalScope.launch(Dispatchers.Main) {
            delay(2500)
            job.cancel()
        }
    }

    private fun flowFunctions() {
        GlobalScope.launch(Dispatchers.Main) {
            producerFlow()
                .onStart {
                    // it will call when flow started
                    Log.d("TAG", "flowFunctions: onStart")
                }.map {
                    // it will call before each time when flow consume and we can modify before collect.
                    it * 2
                }.filter {
                    // it will call before each time when flow consume and we can filter data.
                    it < 6
                }
                .onCompletion {
                    // it will call when flow completed
                    Log.d("TAG", "flowFunctions: onCompletion")
                }
                .onEach {
                    // it will call before each time when flow consume
                    Log.d("TAG", "flowFunctions: onEach - $it")
                }.collect {
                    // it will call when flow consume
                    Log.d("TAG", "flowFunctions: collect ${it.toString()}")
                }
        }
    }

    private fun flowMapAndFilterBeforeCollect() {
        GlobalScope.launch(Dispatchers.Main) {
            getNotes().map {
                Notes(it.id, it.isActivate, it.title.uppercase(), it.description)
            }.filter {
                it.isActivate
            }.collect {
                Log.d("TAG", "flowFilterBeforeCollect: $it")
            }
        }
    }

    private fun flowBuffer() {

        GlobalScope.launch(Dispatchers.Main) {
            val time = measureTimeMillis {
                val data = producerFlow()
                data
                    .buffer(3)// Comment this line and check time difference
                    .collect {
                        delay(1500)
                        Log.d("TAG", "flowBuffer: $it")
                    }

            }
            Log.d("TAG", "flowBuffer Time: $time")
        }

    }

    private fun flowOnForThreadManage() {
        //Collect will be called in Main thread
        GlobalScope.launch(Dispatchers.Main) {
            try {
                producerFlow().map {
                    delay(1000)
                    Log.d(
                        "TAG",
                        "flowOnForThreadManage: Map Thread - ${Thread.currentThread().name}"
                    )
                }.filter {
                    delay(500)
                    Log.d(
                        "TAG",
                        "flowOnForThreadManage: Filter Thread - ${Thread.currentThread().name}"
                    )
                    it < 3
                }
                    .flowOn(Dispatchers.IO) //Above map and filter will be called on IO thread - It work like up steam / bottom to top
                    .collect {
                        Log.d(
                            "TAG",
                            "flowOnForThreadManage: Collect Thread - ${Thread.currentThread().name}"
                        )
                    }
            } catch (e: Exception){
                Log.d(
                    "TAG",
                    "flowOnForThreadManage: Exception - ${e.message}"
                )
            }
        }
    }

}
