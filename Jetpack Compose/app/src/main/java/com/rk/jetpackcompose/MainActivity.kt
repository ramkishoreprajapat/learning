package com.rk.jetpackcompose

import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
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
                        LaunchEffectComposable()
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
fun ListItems(imageId: Int, name: String, status: String, tintColor: Color, modifier: Modifier = Modifier) {
    Card(elevation = CardDefaults.cardElevation(8.dp), modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        Row(modifier = modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(imageId),
                contentDescription = "User Profile $name",
                tint = tintColor,
                modifier = Modifier.size(42.dp)
            )
            Column {
                Text(
                    name,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.ExtraBold)
                )
                Text(status, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Thin)
            }
        }
    }
}

@Composable
fun ClickableView(modifier: Modifier = Modifier) {
    Text(
        color = MaterialTheme.colorScheme.primary,
        text = "Click Me",
        modifier = modifier
            .background(Color.Yellow)
            .size(100.dp)
            .border(4.dp, Color.Red)
            .clip(CircleShape)
            .background(Color.Green)
            .clickable {
                Log.d(
                    "TAG",
                    "ClickableView: Clicked"
                ) //Only circle clickable if I move clickable on top then it work on enter Text
            }
    )
}

@Composable
fun CircularImage(modifier: Modifier = Modifier) {
    Image(painter = painterResource(id = R.drawable.ps),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(100.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Gray, CircleShape))
}

//@Preview(showBackground = true)
@Composable
fun CircularImagePreview() {
    CircularImage()
}

//@Preview(showBackground = true)
@Composable
fun ClickableViewPreview() {
    ClickableView()
}


//@Preview(showBackground = true)
@Composable
fun TextInputPreview() {
    TextInput()
}

//@Preview(showBackground = true, widthDp = 180, heightDp = 300)
@Composable
fun ListItemsPreview() {
    Column {
        ListItems(imageId = R.drawable.ic_user_profile, name = "John Doe", status = "Online", MaterialTheme.colorScheme.primary)
        ListItems(imageId = R.drawable.ic_user_profile, name = "Alex", status = "Offline", MaterialTheme.colorScheme.error)
        ListItems(imageId = R.drawable.ic_user_profile, name = "Rock", status = "Online", MaterialTheme.colorScheme.primary)
        ListItems(imageId = R.drawable.ic_user_profile, name = "James", status = "Online", MaterialTheme.colorScheme.error)
    }
}