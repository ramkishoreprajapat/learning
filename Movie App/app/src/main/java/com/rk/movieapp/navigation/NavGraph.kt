package com.rk.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rk.movieapp.data.model.Genre
import com.rk.movieapp.ui.screens.movies.nowplaying.popular.NowPlayingMovie

@Composable
fun Navigation(navController: NavHostController, page: Int, genres: ArrayList<Genre>? = null) {
    NavHost(
        navController = navController,
        startDestination = initialScreen(page)

    ) {
        composable(Screen.NowPlaying.route) {
            NowPlayingMovie(
                navController = navController,
                genres
            )
        }
        composable(Screen.Popular.route) {
            NowPlayingMovie(
                navController = navController,
                genres
            )
        }
        composable(Screen.TopRated.route) {
            NowPlayingMovie(
                navController = navController,
                genres
            )
        }
        composable(Screen.Upcoming.route) {
            NowPlayingMovie(
                navController = navController,
                genres
            )
        }
        composable(Screen.AiringTodayTvSeries.route) {
            NowPlayingMovie(
                navController = navController,
                genres
            )
        }
        composable(Screen.OnTheAirTvSeries.route) {
            NowPlayingMovie(
                navController = navController,
                genres
            )
        }
        composable(Screen.PopularTvSeries.route) {
            NowPlayingMovie(
                navController = navController,
                genres
            )
        }
        composable(Screen.TopRatedTvSeries.route) {
            NowPlayingMovie(
                navController = navController,
                genres
            )
        }
    }
}

fun initialScreen(page: Int): String {
    return if (page == 0) {
        Screen.NowPlaying.route
    } else {
        Screen.AiringTodayTvSeries.route
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route?.substringBeforeLast("/")
}
