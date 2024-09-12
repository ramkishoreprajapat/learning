package com.rk.loginjetpackwithmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rk.loginjetpackwithmvvm.screens.unauthenticated.ForgetPasswordScreen
import com.rk.loginjetpackwithmvvm.screens.unauthenticated.LoginScreen
import com.rk.loginjetpackwithmvvm.screens.unauthenticated.OnBoardingScreen
import com.rk.loginjetpackwithmvvm.screens.unauthenticated.SignUpScreen

//Screen name
const val onBoardingScreen: String = "onBoardingScreen"
const val loginScreen: String = "loginScreen"
const val signUpScreen: String = "signUpScreen"
const val forgetPasswordScreen: String = "forgetPasswordScreen"

//Params name
const val isFromOnBoarding: String = "isFromOnBoarding"

@Composable
fun AppRoute() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = onBoardingScreen) {
        composable(route = onBoardingScreen) {
            OnBoardingScreen(navController)
        }

        composable(route = loginScreen) {
            LoginScreen(navController)
        }

        composable(route = forgetPasswordScreen) {
            ForgetPasswordScreen(navController)
        }

        composable(route = "$signUpScreen/{$isFromOnBoarding}", arguments = listOf(
            navArgument(isFromOnBoarding) {
                type = NavType.BoolType
            }
        )) {
            SignUpScreen(navController, it.arguments?.getBoolean(isFromOnBoarding) ?: false)
        }

       /* composable(route = "$tweets/{category}", arguments = listOf(
            navArgument(category) {
                type = NavType.StringType
            }
        )) {
            TweetScreen()
        }*/
    }

}