package com.rk.jetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview


//State hoisting process event -> Bottom to Top
//State hoisting process data sharing -> Top to Bottom
//Stateful  Composable
@Composable
fun StateHoistingScreen() {
    val count: MutableState<Int> = rememberSaveable { mutableIntStateOf(0) }
    Column {
        NotificationCounter(count.value) { count.value++ }
        MessageBar(count.value)
    }
}

//Stateless Composable
@Composable
fun MessageBar(count: Int) {
    Text(text = "Message sent so far - $count")
}

//Stateless Composable
@Composable
fun NotificationCounter(count: Int, increment: () -> Unit) {
    Column {
        Text(text = "You have sent $count notifications")
        Button(onClick = {
            increment()
        }) {
            Text(text = "Send Notification")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StateHoistingScreenPreview() {
    StateHoistingScreen()
}