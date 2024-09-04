package com.rk.jetpackwithmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rk.jetpackwithmvvm.screens.CategoryScreen
import com.rk.jetpackwithmvvm.screens.TweetScreen

const val category: String = "category"
const val tweets: String = "tweets"

@Composable
fun AppRoute() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = category) {
        composable(route = category) {
            CategoryScreen() {
                navController.navigate("$tweets/${it}")
            }
        }

        composable(route = "$tweets/{category}", arguments = listOf(
            navArgument(category) {
                type = NavType.StringType
            }
        )) {
            TweetScreen()
        }
    }

}