package com.rk.jetpackcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

//Derived state basically use for convert multiple state into a state

@Composable
fun DerivedComposable(){
    val tableOf = remember { mutableIntStateOf(4) }
    val index = produceState(initialValue = 1) {
        repeat(9) {
            delay(1000)
            value = it + 1
        }
    }

    val message = remember { derivedStateOf {
        "${tableOf.intValue} * ${index.value} = ${index.value * tableOf.intValue}"
    }
        }

 Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
     Text(text = message.value, style = MaterialTheme.typography.displayLarge)
 }
}

@Preview(showBackground = true)
@Composable
fun DerivedComposablePreview(){
    DerivedComposable()
}