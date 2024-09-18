package com.rk.bankingdemoapp.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rk.bankingdemoapp.ui.navigation.model.ConditionalNavigation
import com.rk.bankingdemoapp.ui.navigation.model.NavDestinations
import com.rk.bankingdemoapp.ui.onboarding.OnboardingScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    conditionalNavigation: ConditionalNavigation,
    paddingValues: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = NavDestinations.RootGraph.route,
        modifier = Modifier.padding(paddingValues)
    ) {

        composable(NavDestinations.Onboarding.route) {
            OnboardingScreen(
               /* onGoToLogin = {

                },
                onGoToSignUp = {

                }*/
            )
        }
    }
}