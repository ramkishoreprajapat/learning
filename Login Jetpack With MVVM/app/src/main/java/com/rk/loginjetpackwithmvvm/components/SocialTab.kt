package com.rk.loginjetpackwithmvvm.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rk.loginjetpackwithmvvm.R

@Composable
fun SocialTab() {
    Row {
        SocialButton(painter = R.drawable.ic_google)
        Spacer(modifier = Modifier.width(10.dp))
        SocialButton(painter = R.drawable.ic_facebook)
        Spacer(modifier = Modifier.width(10.dp))
        SocialButton(painter = R.drawable.ic_apple)
    }
}

@Preview(showBackground = true)
@Composable
fun SocialTabPreview() {
    SocialTab()
}