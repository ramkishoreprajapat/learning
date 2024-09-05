package com.rk.jetpackcompose

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


//Coroutines on button click
@Composable
fun CoroutinesScopeComposable() {
    val counter = remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()

    var text = "Counter is running: ${counter.intValue}"
    if (counter.intValue == 10) {
        text = "Counter stopped"
    }

    Column {
        Text(text = text)
        Button(onClick = {
            Log.d("TAG", "CoroutinesScopeComposable: Started")
            scope.launch {
                try {
                    for (i in 1..10) {
                        counter.intValue++
                        delay(1000)
                    }
                } catch (e: Exception) {
                    Log.d("TAG", "CoroutinesScopeComposable: $e")
                }
            }
        }) {
            Text(text = "Click Me")
        }
    }

}