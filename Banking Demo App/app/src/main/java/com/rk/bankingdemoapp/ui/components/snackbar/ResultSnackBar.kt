package com.rk.bankingdemoapp.ui.components.snackbar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

suspend fun SnackbarHostState.showResultSnackBar(
    message: String,
    snackBarMode: SnackBarMode = SnackBarMode.Neutral
) {
    showSnackbar(
        ResultSnackBarVisuals(
            message = message,
            snackBarMode = snackBarMode
        )
    )
}

@Composable
fun ResultSnackBar(
    snackbarData: SnackbarData,
    cornerRadius: Dp = 16.dp,
    fontSize: TextUnit = 18.sp
) {
    val customVisuals = snackbarData.visuals as? ResultSnackBarVisuals
    if (customVisuals != null) {
        ResultSnackBarUI(
            cornerRadius = cornerRadius,
            snackBarMode = customVisuals.snackBarMode,
            fontSize = fontSize,
            message = snackbarData.visuals.message
        )
    } else {
        throw IllegalArgumentException("Unexpected visuals in ResultSnackBar")
    }
}

@Composable
private fun ResultSnackBarUI(
    cornerRadius: Dp = 16.dp,
    snackBarMode: SnackBarMode,
    fontSize: TextUnit = 14.sp,
    message: String
){
    Surface(
        shape = RoundedCornerShape(cornerRadius),
        shadowElevation = 8.dp,
        color = snackBarMode.getSurfaceColor(),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
        border = BorderStroke(2.dp, Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = message, fontSize = fontSize, color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultSnackBarUIPreview() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        ResultSnackBarUI(
            message = "Test message", snackBarMode = SnackBarMode.Neutral
        )

        ResultSnackBarUI(
            message = "Test message", snackBarMode = SnackBarMode.Positive
        )

        ResultSnackBarUI(
            message = "Test message", snackBarMode = SnackBarMode.Negative
        )
    }
}