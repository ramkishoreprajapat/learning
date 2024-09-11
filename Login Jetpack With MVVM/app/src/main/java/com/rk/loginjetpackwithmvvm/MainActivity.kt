package com.rk.loginjetpackwithmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.rk.loginjetpackwithmvvm.screens.unauthenticated.LoginScreen
import com.rk.loginjetpackwithmvvm.screens.unauthenticated.OnBoardingScreen
import com.rk.loginjetpackwithmvvm.screens.unauthenticated.SignUpScreen
import com.rk.loginjetpackwithmvvm.ui.theme.LoginJetpackWithMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginJetpackWithMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        OnBoardingScreen()
                    }
                }
            }
        }
    }
}
