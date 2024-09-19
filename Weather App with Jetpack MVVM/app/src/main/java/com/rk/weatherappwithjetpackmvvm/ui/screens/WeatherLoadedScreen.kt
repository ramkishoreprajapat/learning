package com.rk.weatherappwithjetpackmvvm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.rk.weatherappwithjetpackmvvm.R
import com.rk.weatherappwithjetpackmvvm.components.DailyItem
import com.rk.weatherappwithjetpackmvvm.model.WeatherUiModel
import com.rk.weatherappwithjetpackmvvm.ui.theme.WeatherAppWithJetpackMVVMTheme
import com.rk.weatherappwithjetpackmvvm.utils.DummyData
import com.rk.weatherappwithjetpackmvvm.utils.capitalize
import com.rk.weatherappwithjetpackmvvm.utils.getWeatherIcon
import com.rk.weatherappwithjetpackmvvm.utils.todayDate

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun WeatherLoadedScreen(data: WeatherUiModel) {
    Column {
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = data.city,
            modifier = Modifier.padding(start = 20.dp),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        )

        Text(
            text = todayDate(),
            modifier = Modifier.padding(start = 20.dp),
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterVertically),
                colors = CardDefaults
                    .cardColors(containerColor = MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(40.dp),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                GlideImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    model = getWeatherIcon(data.todayWeatherIcon[0].description),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Image"
                )
            }

            Text(
                text = data.weather,
                modifier = Modifier.padding(start = 10.dp),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 70.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            )

            Text(
                text = "°C",
                modifier = Modifier.padding(top = 20.dp),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            )

            Text(
                text = capitalize(data.todayWeatherIcon[0].description),
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            )

        }

        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DailyItem(R.drawable.temprature, data.feelsLike, "Feels Like")
                DailyItem(R.drawable.visibility, data.visibility, "Visibility")
                DailyItem(R.drawable.uv_rays, data.uvRadiations, "UV Rays")
            }
            Spacer(modifier = Modifier.size(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DailyItem(R.drawable.humidity, data.humidity, "Humidity")
                DailyItem(R.drawable.wind_speed, data.windSpeed, "Wind Speed")
                DailyItem(R.drawable.pressure, data.pressure, "Air Pressure")
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp
                    )
            ) {
                items(data.forecastForWeek.size) {
                    Column {
                        Card(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.background)
                                .height(60.dp)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(CornerSize(16.dp)),
                            elevation = CardDefaults.cardElevation(0.dp),
                            colors = CardDefaults
                                .cardColors(containerColor = MaterialTheme.colorScheme.primary),
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = data.forecastForWeek[it].day,
                                    style = TextStyle(
                                        textAlign = TextAlign.Start,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 16.sp,
                                        color = MaterialTheme.colorScheme.onPrimary
                                    ),
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 15.dp) // Added some padding for separation
                                )

                                GlideImage(
                                    modifier = Modifier
                                        .weight(1f)
                                        .size(40.dp), // Using fixed size for the image
                                    model = getWeatherIcon(data.forecastForWeek[it].weeklyWeatherIcon[0].description),
                                    contentScale = ContentScale.Fit,
                                    contentDescription = "",
                                )

                                Row(
                                    modifier = Modifier
                                        .weight(1f),
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = data.forecastForWeek[it].dayTemp,
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.onPrimary
                                        ),
                                    )

                                    Text(
                                        text = data.forecastForWeek[it].nightTemp,
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.onPrimary
                                        ),
                                        modifier = Modifier.padding(start = 20.dp) // Added some padding for separation
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherLoadedScreenPreview() {
    WeatherAppWithJetpackMVVMTheme {
        WeatherLoadedScreen(DummyData().getDummyData())
    }
}