package com.rk.weatherappwithjetpackmvvm.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rk.weatherappwithjetpackmvvm.R
import com.rk.weatherappwithjetpackmvvm.ui.theme.WeatherAppWithJetpackMVVMTheme

@Composable
fun WeatherLoadingAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.5f at 500
            },
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Image(
        painter = painterResource(id = R.drawable.weather),
        contentDescription = null,
        modifier = Modifier
            .size(120.dp)
            .scale(scale))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppWithJetpackMVVMTheme {
        WeatherLoadingAnimation()
    }
}