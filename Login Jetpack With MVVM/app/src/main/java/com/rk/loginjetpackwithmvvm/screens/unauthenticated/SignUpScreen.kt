package com.rk.loginjetpackwithmvvm.screens.unauthenticated

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.rk.loginjetpackwithmvvm.R
import com.rk.loginjetpackwithmvvm.components.CustomElevatedButton
import com.rk.loginjetpackwithmvvm.components.CustomOutlinedTextField
import com.rk.loginjetpackwithmvvm.components.SocialTab
import com.rk.loginjetpackwithmvvm.data.User
import com.rk.loginjetpackwithmvvm.navigation.loginScreen
import com.rk.loginjetpackwithmvvm.viewModel.SignUpViewModel

@Composable
fun SignUpScreen(navController: NavHostController, isFromOnBoarding: Boolean) {
    val signUpViewModel : SignUpViewModel = hiltViewModel()
    val user: State<User> = signUpViewModel.user.collectAsState()

    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val confirmPassword = rememberSaveable { mutableStateOf("") }
    //Full Screen Content
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.ic_bg),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(96.dp))
            Text(
                text = stringResource(R.string.create_account),
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = stringResource(R.string.create_an_account_so_you_can_explore),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(74.dp))
            //Email
            CustomOutlinedTextField(
                placeholder = stringResource(R.string.email),
                state = email,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                visualTransformation = VisualTransformation.None,
                maxLength = 256
            )
            Spacer(modifier = Modifier.height(30.dp))
            //Password
            CustomOutlinedTextField(
                placeholder = stringResource(R.string.password),
                state = password,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                visualTransformation = PasswordVisualTransformation(),
                maxLength = 32
            )
            Spacer(modifier = Modifier.height(30.dp))
            //Confirm Password
            CustomOutlinedTextField(
                placeholder = stringResource(R.string.confirm_password),
                state = confirmPassword,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(),
                maxLength = 32
            )
            Spacer(modifier = Modifier.height(30.dp))
            //Sign Up Button
            CustomElevatedButton(text = stringResource(R.string.sign_up),
                onClick = { checkValidation() })
            Spacer(modifier = Modifier.height(10.dp))
            //Already an account
            Text(
                text = stringResource(R.string.already_have_an_account),
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.SemiBold
                ), modifier = Modifier
                    .padding(vertical = 10.dp).clickable {
                        if (isFromOnBoarding)
                            navController.navigate(loginScreen)
                        else
                            navController.popBackStack()
                    }
            )
            Spacer(modifier = Modifier.height(15.dp))
            //Or continue with
            Text(
                text = stringResource(R.string.or_continue_with),
                style = MaterialTheme.typography.titleSmall.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Light
                ), modifier = Modifier
                    .padding(vertical = 10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            SocialTab()
        }
    }
}

private fun checkValidation() {
    Log.d("TAG", "Validation checking...")
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        NavHostController(LocalContext.current),
        false
    )
}