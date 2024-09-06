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
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    //Channel is basically hot. that means it providing continuously data. if consumer consume or not.
    var channel = Channel<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowsAndChannelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        channelProducer()
                        channelConsumer()
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

}
