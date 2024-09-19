package com.rk.weatherappwithjetpackmvvm.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rk.weatherappwithjetpackmvvm.R
import com.rk.weatherappwithjetpackmvvm.components.WeatherLoadingAnimation
import com.rk.weatherappwithjetpackmvvm.ui.screens.WeatherLoadedScreen
import com.rk.weatherappwithjetpackmvvm.ui.theme.WeatherAppWithJetpackMVVMTheme
import com.rk.weatherappwithjetpackmvvm.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppWithJetpackMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        CurrentWeatherHeader()
                    }
                }
            }
        }
    }
}

@Composable
fun CurrentWeatherHeader(mainViewModel: MainViewModel = viewModel()){
    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        when(val state = mainViewModel.uiState.collectAsState().value){
            is MainViewModel.WeatherUiState.Empty -> Text(
                text = stringResource(R.string.no_data_available)
            )
            is MainViewModel.WeatherUiState.Loading -> Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherLoadingAnimation()
            }
            is MainViewModel.WeatherUiState.Success -> WeatherLoadedScreen(state.weatherUiModel)
            is MainViewModel.WeatherUiState.Error -> Text(
                text = state.message
            )
        }
    }
}
