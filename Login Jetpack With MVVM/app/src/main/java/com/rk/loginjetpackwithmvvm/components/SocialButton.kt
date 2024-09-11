package com.rk.loginjetpackwithmvvm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rk.loginjetpackwithmvvm.R

@Composable
fun SocialButton(painter: Int = R.drawable.ic_google) {
    Box(
        modifier = Modifier.clip(MaterialTheme.shapes.small)
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        Image(
            painter = painterResource(painter),
            contentDescription = "",
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SocialButtonPreview() {
    SocialButton()
}