package com.rk.weatherappwithjetpackmvvm.components

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rk.weatherappwithjetpackmvvm.R
import com.rk.weatherappwithjetpackmvvm.ui.theme.WeatherAppWithJetpackMVVMTheme

@Composable
fun DailyItem(painter: Int, title: String, desc: String) {
    Card(modifier = Modifier.size(100.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults
            .cardColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()) {
            Icon(
                painter = painterResource(id = painter),
                contentDescription = "",
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 5.dp),

            )

            Text(
                text = desc,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 5.dp),

                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DailyItemPreview() {
    WeatherAppWithJetpackMVVMTheme {
        DailyItem(painter = R.drawable.snow, title = "Rain", desc = "20")
    }
}