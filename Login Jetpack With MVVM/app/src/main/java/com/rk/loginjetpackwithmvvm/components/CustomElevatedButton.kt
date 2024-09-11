package com.rk.loginjetpackwithmvvm.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomElevatedButton(text: String, onClick: () -> Unit) {
    ElevatedButton(onClick = onClick,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth().height(56.dp)) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun CustomElevatedButtonPreview() {
    CustomElevatedButton(text = "Sign In", onClick = {})
}