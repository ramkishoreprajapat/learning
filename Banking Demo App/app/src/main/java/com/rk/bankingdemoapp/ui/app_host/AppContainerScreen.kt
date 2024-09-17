package com.rk.bankingdemoapp.ui.app_host

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rk.bankingdemoapp.R
import com.rk.bankingdemoapp.ui.components.DotsProgressIndicator
import com.rk.bankingdemoapp.ui.theme.primaryFontFamily

@Composable
fun AppContainerScreen(){
    val viewModel : AppViewModel = hiltViewModel()
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    //TODO
    /*val shouldShowBottomNave  = NavDestinations
        .primaryDestinationsRoutes()
        .contains(navBackStackEntry?.destination?.route)*/

    val snackBarHostState = remember { SnackbarHostState() }
    val hostCoroutineScope = rememberCoroutineScope()

    //TODO
//    val permissionHelper  = koinInject<PermissionHelper>()



}

@Composable
fun AppLoadingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_variant),
            contentDescription = "Logo",
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary),
            modifier = Modifier.size(160.dp)

        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.app_name).uppercase(),
            style = MaterialTheme.typography.displayMedium.copy(
                fontFamily = primaryFontFamily,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )
        )

        Spacer(Modifier.height(20.dp))

        DotsProgressIndicator(
            circleSize = 18.dp,
            travelDistance = 20.dp,
            circleColor = MaterialTheme.colorScheme.onPrimary
        )

    }
}

@Preview(showBackground = true)
@Composable
fun AppLoadingScreenPreview() {
    AppLoadingScreen()
}

@Preview(showBackground = true)
@Composable
fun AppContainerScreenPreview() {
    AppContainerScreen()
}