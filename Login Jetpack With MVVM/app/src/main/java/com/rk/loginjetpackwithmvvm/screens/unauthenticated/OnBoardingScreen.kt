package com.rk.loginjetpackwithmvvm.screens.unauthenticated

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rk.loginjetpackwithmvvm.R
import com.rk.loginjetpackwithmvvm.components.CustomElevatedButton

@Composable
fun OnBoardingScreen() {
    //Full Screen Content
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.ic_bg),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(90.dp))
            Image(
                painter = painterResource(R.drawable.ic_onboarding),
                contentDescription = "",
                Modifier
                    .width(333.dp)
                    .height(300.dp)
            )
            Spacer(modifier = Modifier.height(90.dp))
            Text(
                text = stringResource(R.string.discover_your_dream_job_here),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                ), modifier = Modifier
                    .padding(vertical = 10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            //Create an account
            Text(
                text = stringResource(R.string.explore_all_the_existing_job),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall.copy(
                ), modifier = Modifier
                    .padding(vertical = 10.dp)
            )
            Spacer(modifier = Modifier.height(60.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()) {
                Box(Modifier.fillMaxWidth(0.5f)) {
                    CustomElevatedButton(stringResource(R.string.login)) { }
                }
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = stringResource(R.string.register),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                    )
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun OnBoardingPreview() {
    OnBoardingScreen()
}