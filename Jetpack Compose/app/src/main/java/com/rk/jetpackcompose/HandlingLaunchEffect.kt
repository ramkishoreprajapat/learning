package com.rk.jetpackcompose

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay

@Composable
fun LaunchEffectComposable() {
    val counter = remember { mutableIntStateOf(0) } // if you are using remember than it will cause issue after device rotate or configuration change. It only remembers the last value

    LaunchedEffect(key1 = Unit) {
        //it has coroutine scope
        Log.d("TAG", "LaunchEffectComposable: Launched")
        try {
            for (i in 1..10) {
                counter.intValue++
                delay(1000)
            }
        } catch (e: Exception) {
            Log.d("TAG", "LaunchEffectComposable: $e")
        }
    }

    var text = "Counter: ${counter.intValue}"

    if (counter.value == 10) {
        text = "Counter stopped"
    }

    Text(text = text)
}