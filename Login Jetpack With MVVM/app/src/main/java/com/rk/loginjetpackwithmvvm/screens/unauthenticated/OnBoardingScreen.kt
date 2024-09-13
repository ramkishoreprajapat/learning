package com.rk.loginjetpackwithmvvm.screens.unauthenticated

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rk.loginjetpackwithmvvm.R
import com.rk.loginjetpackwithmvvm.components.CustomElevatedButton
import com.rk.loginjetpackwithmvvm.navigation.loginScreen
import com.rk.loginjetpackwithmvvm.navigation.signUpScreen

@Composable
fun OnBoardingScreen(navController: NavHostController) {
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
                    .width(300.dp)
                    .height(270.dp)
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
            Text(
                text = stringResource(R.string.explore_all_the_existing_job),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall.copy(
                ), modifier = Modifier
                    .padding(vertical = 10.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().height(56.dp)) {
                Box(Modifier.fillMaxWidth(0.5f)) {
                    CustomElevatedButton(stringResource(R.string.login), onClick = {
                        navController.navigate(loginScreen)
                    })
                }
                Box(Modifier.fillMaxSize().clickable(
                    onClick = {
                        navController.navigate("$signUpScreen/true")
                    },

                ),) {
                    Text(
                        text = stringResource(R.string.register),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.SemiBold
                        ), modifier = Modifier.height(56.dp).fillMaxWidth()
                            .wrapContentSize (align = Alignment.Center),
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

    }
}


@Preview(showBackground = true)
@Composable
fun OnBoardingPreview() {
    OnBoardingScreen(NavHostController(LocalContext.current))
}