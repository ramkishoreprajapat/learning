package com.rk.movieapp.ui.screens.movies.nowplaying.popular

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.rk.movieapp.data.model.Genre

@Composable
fun NowPlayingMovie(navController: NavController,
                    genres: ArrayList<Genre>? = null) {
    Text(text = "Now Playing Movie")
}