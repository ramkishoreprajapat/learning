package com.rk.jetpackcompose

import android.media.MediaPlayer
import android.util.Log
import android.view.ViewTreeObserver
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Simple Example
@Composable
fun DisposableComposable() {
    val state = remember { mutableStateOf(false) }
    DisposableEffect(key1 = state.value) {
        Log.d("TAG", "Disposable Effect Started")
        onDispose {
            Log.d("TAG", "onDispose: Cleaning up side effect")
        }
    }

    Button(onClick = {
        state.value = !state.value
    }) {
        Text(text = "Change State")
    }
}

//Disposable effect example with MediaPlayer
@Composable
fun MediaComposable()  {
    val context = LocalContext.current
    val state = remember { mutableStateOf(false) }
    DisposableEffect(key1 = state.value) {
        val player = MediaPlayer.create(context, R.raw.music)
        player.start()
        onDispose {
            player.stop()
            player.release()
        }
    }

    Button(onClick = {
        state.value = !state.value
    }) {
        Text("Restart Music")
    }
}

@Composable
fun TestKeyboardComposable() {
    KeyboardComposable()
    TextField(onValueChange = {}, value = "")
}

@Composable
fun KeyboardComposable() {
    val view = LocalView.current
    DisposableEffect(key1 = Unit) {
        val listener  = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardOpen = insets?.isVisible(WindowInsetsCompat.Type.ime())
            Log.d("TAG", "Keyboard is visible ? : $isKeyboardOpen")

        }
        view.viewTreeObserver.addOnGlobalLayoutListener(listener)
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }
}