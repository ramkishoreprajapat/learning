package com.rk.loginjetpackwithmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.rk.loginjetpackwithmvvm.navigation.AppRoute
import com.rk.loginjetpackwithmvvm.ui.theme.LoginJetpackWithMVVMTheme
import com.rk.loginjetpackwithmvvm.viewModel.SnakeBarViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val snackBarViewModel : SnakeBarViewModel = hiltViewModel()

            SnackBarScreen(snackBarViewModel)
        }
    }


    //Stateful
    @Composable
    fun SnackBarScreen(viewModel: SnakeBarViewModel) {
        val messageIds by viewModel.messageIds.collectAsState()
        val snackBarHostState = remember { SnackbarHostState() }

        SnackBarScreen(
            messageIds = messageIds,
            showSnackBar = { messageId ->
                viewModel.showUserMessage(messageId)
            },
            setSnackBarShown = { messageId ->
                viewModel.setMessageShown(messageId)
            },
            snackBarHostState = snackBarHostState,
        )
    }

    //Stateless
    @Composable
    fun SnackBarScreen(
        messageIds: List<Int>,
        showSnackBar: (Int) -> Unit,
        setSnackBarShown: (Int) -> Unit,
        snackBarHostState: SnackbarHostState,
        modifier: Modifier = Modifier,
    ) {

        if (messageIds.isNotEmpty()) {
            val messageId = messageIds.first()
            val message = stringResource(id = messageId)

            LaunchedEffect(key1 = messageId) {
                snackBarHostState.showSnackbar(message = message, withDismissAction = true)
                setSnackBarShown(messageId)
            }
        }
        LoginJetpackWithMVVMTheme {
            Scaffold(modifier = Modifier.fillMaxSize(),
                snackbarHost = { SnackbarHost(hostState = snackBarHostState) },)
            { innerPadding ->
                Box(
                    modifier = Modifier.padding(innerPadding)
                ) {
                   /* Button(onClick = { showSnackBar(R.string.already_have_an_account) }) {
                        Text(text = "Show Snackbar")
                    }*/
                    AppRoute()
                }
            }
        }
    }
}

