package com.rk.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

//It managing state and launched effect both
@Composable
fun CounterWithoutProducer(){
    val state = remember { mutableIntStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        for (i in 1..10) {
            state.intValue += 1
            delay(1000)
        }
    }

    Text(text = state.intValue.toString())
}

@Composable
fun CounterWithProducer(){
    val state = produceState(initialValue = 0) {
        for (i in 1..10) {
            value += 1 //Value is producer part
            delay(1000)
        }
    }

    Text(text = state.value.toString())
}

@Composable
fun Loader() {
    val degree = produceState(initialValue = 0) {
        while (true) {
            delay(16)
            value = (value + 10) % 360
        }
    }

    Box(modifier = Modifier.fillMaxSize(1f), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(imageVector = Icons.Default.Refresh,
                contentDescription = "",
                modifier = Modifier.size(48.dp)
                    .rotate(degree.value.toFloat()))
            Text(text = "Loading...")
        }
    }
}

@Composable
fun LineLoader() {
    val progress = produceState(initialValue = 0) {
        while (true) {
            delay(100)
            value = (value + 10) % 110
        }
    }
    Box(Modifier.background(Color.Gray).fillMaxHeight(0.1f).fillMaxWidth(1f)) {

    }
    Box(Modifier.background(Color.Blue).fillMaxHeight(0.1f).fillMaxWidth(progress.value.toFloat() / 100)) {

    }
}

@Preview(showBackground = true)
@Composable
fun LineLoaderPreview() {
    LineLoader()

}