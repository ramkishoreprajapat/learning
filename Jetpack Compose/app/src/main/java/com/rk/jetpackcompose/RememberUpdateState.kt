package com.rk.jetpackcompose

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedStateComposable(){
    val counter = remember { mutableIntStateOf(0) }
    LaunchedEffect(key1 = Unit){
        delay(2000)
        counter.intValue = 10
    }

    Counter(counter.intValue)
}

@Composable
fun Counter(state: Int) {
    val state = rememberUpdatedState(newValue = state) //test without it
    LaunchedEffect(key1 = state.value) {
        delay(5000)
        Log.d("TAG", "Counter: ${state.value}")
    }

    Text(text = "Counter: ${state.value}")
}
