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
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    //Channel - Channel is basically hot. that means it providing continuously data. if consumer consume or not.
    //Flow -  Flow is basically cold. that means it providing data only when consumer consume. It will provide all of the data one by one even flow started already
    var channel = Channel<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*channelProducer()
          channelConsumer()*/
        val job = GlobalScope.launch {
            val data : Flow<Int> = producerFlow()
            data.collect {
                Log.d("TAG", "onCreate: $it")
            }
        }

        GlobalScope.launch {
            delay(2500)
            job.cancel()
        }

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

    private fun producerFlow()= flow {
        val list = listOf(1,2,3,4,5)
        list.forEach {
            delay(1000)
            emit(it)
        }
    }

}
