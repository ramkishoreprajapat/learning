package com.rk.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rk.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {

                    }
                }
            }
        }
    }
}

@Composable
fun TextInput() {
    val state = remember { mutableStateOf("") }
    TextField(
        value = state.value,
        onValueChange = {state.value = it},
        label = { Text("Name") }
    )
}

@Composable
fun ListItems(imageId: Int, name: String, status: String, tintColor: Color) {
    Row(modifier = Modifier.padding(8.dp)) {
        Icon(
            painter = painterResource(imageId),
            contentDescription = "User Profile $name",
            tint = tintColor,
            modifier = Modifier.size(42.dp)
        )
        Column {
            Text(name, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold))
            Text(status, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun FunctionPreview() {
    Column {
        ListItems(imageId = R.drawable.ic_user_profile, name = "John Doe", status = "Online", MaterialTheme.colorScheme.primary)
        ListItems(imageId = R.drawable.ic_user_profile, name = "Alex", status = "Offline", MaterialTheme.colorScheme.error)
        ListItems(imageId = R.drawable.ic_user_profile, name = "Rock", status = "Online", MaterialTheme.colorScheme.primary)
        ListItems(imageId = R.drawable.ic_user_profile, name = "James", status = "Online", MaterialTheme.colorScheme.error)
    }
}