package com.rk.weatherappwithjetpackmvvm.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.rk.weatherappwithjetpackmvvm.ui.theme.WeatherAppWithJetpackMVVMTheme

@Composable
fun ErrorDialog(title: String, message: String) {
    val openDialog = remember { mutableStateOf(false) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = title) },
            text = { Text(text = message) },
            confirmButton = {
                Button(onClick = { openDialog.value = false }) {
                    Text(text = "OK")
                }
            }

        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorDialogPreview() {
    WeatherAppWithJetpackMVVMTheme {
        ErrorDialog(title = "Error", message = "Something went wrong")
    }
}