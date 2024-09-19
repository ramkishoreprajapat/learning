package com.rk.weatherappwithjetpackmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.rk.weatherappwithjetpackmvvm.model.TodayWeatherIcon
import com.rk.weatherappwithjetpackmvvm.model.WeatherApiResponse
import com.rk.weatherappwithjetpackmvvm.model.WeatherForWeekItem
import com.rk.weatherappwithjetpackmvvm.model.WeatherUiModel
import com.rk.weatherappwithjetpackmvvm.model.WeeklyWeatherIcon
import com.rk.weatherappwithjetpackmvvm.repository.WeatherRepository
import com.rk.weatherappwithjetpackmvvm.utils.fahrenheitToCelsius
import com.rk.weatherappwithjetpackmvvm.utils.metersToKilometers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :
    ViewModel() {
    private var city: String = "Jodhpur, India"
    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Empty)
    val uiState = _uiState.asStateFlow()

    init {
        fetchWeather()
    }

    private fun fetchWeather() {
        _uiState.value = WeatherUiState.Loading

        viewModelScope.launch {
            try {
                /*val response = weatherRepository.fetchWeather(lon = "", lat = "")*/
                val str = "{\n" +
                        "  \"lat\":33.44,\n" +
                        "  \"lon\":-94.04,\n" +
                        "  \"timezone\":\"America/Chicago\",\n" +
                        "  \"timezone_offset\":-18000,\n" +
                        "  \"current\":{\n" +
                        "    \"dt\":1684929490,\n" +
                        "    \"sunrise\":1684926645,\n" +
                        "    \"sunset\":1684977332,\n" +
                        "    \"temp\":292.55,\n" +
                        "    \"feels_like\":292.87,\n" +
                        "    \"pressure\":1014,\n" +
                        "    \"humidity\":89,\n" +
                        "    \"dew_point\":290.69,\n" +
                        "    \"uvi\":0.16,\n" +
                        "    \"clouds\":53,\n" +
                        "    \"visibility\":10000,\n" +
                        "    \"wind_speed\":3.13,\n" +
                        "    \"wind_deg\":93,\n" +
                        "    \"wind_gust\":6.71,\n" +
                        "    \"weather\":[\n" +
                        "      {\n" +
                        "        \"id\":803,\n" +
                        "        \"main\":\"Clouds\",\n" +
                        "        \"description\":\"broken clouds\",\n" +
                        "        \"icon\":\"04d\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  },\n" +
                        "  \"minutely\":[\n" +
                        "    {\n" +
                        "      \"dt\":1684929540,\n" +
                        "      \"precipitation\":0\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"hourly\":[\n" +
                        "    {\n" +
                        "      \"dt\":1684926000,\n" +
                        "      \"temp\":292.01,\n" +
                        "      \"feels_like\":292.33,\n" +
                        "      \"pressure\":1014,\n" +
                        "      \"humidity\":91,\n" +
                        "      \"dew_point\":290.51,\n" +
                        "      \"uvi\":0,\n" +
                        "      \"clouds\":54,\n" +
                        "      \"visibility\":10000,\n" +
                        "      \"wind_speed\":2.58,\n" +
                        "      \"wind_deg\":86,\n" +
                        "      \"wind_gust\":5.88,\n" +
                        "      \"weather\":[\n" +
                        "        {\n" +
                        "          \"id\":803,\n" +
                        "          \"main\":\"Clouds\",\n" +
                        "          \"description\":\"broken clouds\",\n" +
                        "          \"icon\":\"04n\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"pop\":0.15\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"daily\":[\n" +
                        "    {\n" +
                        "      \"dt\":1684951200,\n" +
                        "      \"sunrise\":1684926645,\n" +
                        "      \"sunset\":1684977332,\n" +
                        "      \"moonrise\":1684941060,\n" +
                        "      \"moonset\":1684905480,\n" +
                        "      \"moon_phase\":0.16,\n" +
                        "      \"summary\":\"Expect a day of partly cloudy with rain\",\n" +
                        "      \"temp\":{\n" +
                        "        \"day\":299.03,\n" +
                        "        \"min\":290.69,\n" +
                        "        \"max\":300.35,\n" +
                        "        \"night\":291.45,\n" +
                        "        \"eve\":297.51,\n" +
                        "        \"morn\":292.55\n" +
                        "      },\n" +
                        "      \"feels_like\":{\n" +
                        "        \"day\":299.21,\n" +
                        "        \"night\":291.37,\n" +
                        "        \"eve\":297.86,\n" +
                        "        \"morn\":292.87\n" +
                        "      },\n" +
                        "      \"pressure\":1016,\n" +
                        "      \"humidity\":59,\n" +
                        "      \"dew_point\":290.48,\n" +
                        "      \"wind_speed\":3.98,\n" +
                        "      \"wind_deg\":76,\n" +
                        "      \"wind_gust\":8.92,\n" +
                        "      \"weather\":[\n" +
                        "        {\n" +
                        "          \"id\":500,\n" +
                        "          \"main\":\"Rain\",\n" +
                        "          \"description\":\"light rain\",\n" +
                        "          \"icon\":\"10d\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"clouds\":92,\n" +
                        "      \"pop\":0.47,\n" +
                        "      \"rain\":0.15,\n" +
                        "      \"uvi\":9.23\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"alerts\": [\n" +
                        "    {\n" +
                        "      \"sender_name\": \"NWS Philadelphia - Mount Holly (New Jersey, Delaware, Southeastern Pennsylvania)\",\n" +
                        "      \"event\": \"Small Craft Advisory\",\n" +
                        "      \"start\": 1684952747,\n" +
                        "      \"end\": 1684988747,\n" +
                        "      \"description\": \"...SMALL CRAFT ADVISORY REMAINS IN EFFECT FROM 5 PM THIS\\nAFTERNOON TO 3 AM EST FRIDAY...\\n* WHAT...North winds 15 to 20 kt with gusts up to 25 kt and seas\\n3 to 5 ft expected.\\n* WHERE...Coastal waters from Little Egg Inlet to Great Egg\\nInlet NJ out 20 nm, Coastal waters from Great Egg Inlet to\\nCape May NJ out 20 nm and Coastal waters from Manasquan Inlet\\nto Little Egg Inlet NJ out 20 nm.\\n* WHEN...From 5 PM this afternoon to 3 AM EST Friday.\\n* IMPACTS...Conditions will be hazardous to small craft.\",\n" +
                        "      \"tags\": [\n" +
                        "\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}"
                val response = Gson().fromJson(str, WeatherApiResponse::class.java)
                var dateCounter = -1
                _uiState.value = WeatherUiState.Success(WeatherUiModel(
                    city = city,
                    weather = "${fahrenheitToCelsius(response.current.temp)}",
                    feelsLike = "${fahrenheitToCelsius(response.current.feelsLike)}°C",
                    visibility = "${metersToKilometers(response.current.visibility)}km",
                    humidity = "${response.current.humidity}",
                    uvRadiations = "${response.current.uvi}%",
                    windSpeed = "${response.current.windSpeed} m/s",
                    pressure = "${response.current.pressure} mPa",
                    todayWeatherIcon = response.current.todayIcon.map {
                        TodayWeatherIcon(it.description)
                    },
                    forecastForWeek = response.weeklyWeather.drop(1).map { it ->
                        dateCounter++
                        WeatherForWeekItem(
                            day = Calendar.getInstance()
                                .also { cal -> cal.add(Calendar.DATE, dateCounter) }
                                .getDisplayName(
                                    Calendar.DAY_OF_WEEK,
                                    Calendar.LONG,
                                    Locale.getDefault()
                                ).orEmpty(),
                            dayTemp = "${fahrenheitToCelsius(it.temperature.day)}°C",
                            nightTemp = "${fahrenheitToCelsius(it.temperature.night)}°C",
                            weeklyWeatherIcon = it.weeklyIcon.map {
                                WeeklyWeatherIcon(
                                    description = it.description
                                )
                            },
                        )
                    }
                ))
            } catch (e: Exception) {
                if (e is HttpException && e.code() == 429) {
                    onQueryLimitReached()
                } else {
                    onErrorOccurred()
                }
            }

        }

    }

    private fun onQueryLimitReached() {
        _uiState.value = WeatherUiState.Error("Query limit reached")
    }

    private fun onErrorOccurred() {
        _uiState.value = WeatherUiState.Error("Something went wrong")
    }

    sealed class WeatherUiState {
        object Empty : WeatherUiState()
        object Loading : WeatherUiState()
        class Success(val weatherUiModel: WeatherUiModel) : WeatherUiState()
        class Error(val message: String) : WeatherUiState()
    }
}