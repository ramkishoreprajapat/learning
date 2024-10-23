package com.rk.movieapp.ui.screens.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rk.movieapp.R
import com.rk.movieapp.data.model.Genre
import com.rk.movieapp.navigation.Navigation
import com.rk.movieapp.navigation.Screen
import com.rk.movieapp.navigation.currentRoute
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val pagerState = rememberPagerState {
        2
    }
    val genreList = remember { mutableListOf<Genre>() }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text(
                    text = "Title",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
            },
        )
    },
        bottomBar = {
           when(currentRoute(navController)) {
               Screen.NowPlaying.route, Screen.Popular.route, Screen.TopRated.route, Screen.Upcoming.route,
               Screen.AiringTodayTvSeries.route, Screen.OnTheAirTvSeries.route, Screen.PopularTvSeries.route,
               Screen.TopRatedTvSeries.route-> {
                   BottomNavigationUI(navController = navController, pagerState = pagerState)
               }
           }
        }) {
        Box(Modifier.padding(it)) {
            TabScreen(
                navigator = navController,
                pagerState = pagerState,
                genres = genreList as ArrayList<Genre>?
            )
        }
    }
}

@Composable
fun BottomNavigationUI(navController: NavController, pagerState: PagerState) {
    NavigationBar {
        val items = if (pagerState.currentPage == 0) {
            listOf(
                Screen.NowPlayingNav,
                Screen.PopularNav,
                Screen.TopRatedNav,
                Screen.UpcomingNav
            )
        } else {
            listOf(
                Screen.AiringTodayTvSeriesNav,
                Screen.OnTheAirTvSeriesNav,
                Screen.PopularTvSeriesNav,
                Screen.TopRatedTvSeriesNav
            )
        }

        items.forEachIndexed { index, item ->

            NavigationBarItem(
                icon = item.navIcon,
                label = { Text(text = stringResource(item.title)) },
                selected = currentRoute(navController) == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }

                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun TabScreen(
    navigator: NavHostController,
    pagerState: PagerState,
    genres: ArrayList<Genre>? = null
) {
    val coroutineScope = rememberCoroutineScope()
    val tabs = listOf(stringResource(R.string.movie), stringResource(R.string.tv_series))

    Column {
        TabRow(
            modifier = Modifier.background(Color.White),
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.PrimaryIndicator(
                    Modifier.tabIndicatorOffset(
                        tabPositions[pagerState.currentPage],
                    ),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            color = if (index == 0) MaterialTheme.colorScheme.primary else Color.Gray
                        )
                    })
            }
        }

        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
            Navigation(navigator, page = page, genres = genres)
        }
    }
}