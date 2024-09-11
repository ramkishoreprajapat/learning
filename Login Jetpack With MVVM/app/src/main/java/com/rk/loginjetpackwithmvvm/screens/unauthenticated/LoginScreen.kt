package com.rk.loginjetpackwithmvvm.screens.unauthenticated

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
import com.rk.loginjetpackwithmvvm.R
import com.rk.loginjetpackwithmvvm.components.CustomElevatedButton
import com.rk.loginjetpackwithmvvm.components.CustomOutlinedTextField
import com.rk.loginjetpackwithmvvm.components.SocialTab

@Composable
fun LoginScreen() {
    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
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
                text = stringResource(R.string.login_here),
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = stringResource(R.string.welcome_back_you_ve_been_missed),
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
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(),
                maxLength = 32
            )
            //Forgot your password
            Text(
                text = stringResource(R.string.forgot_your_password),
                style = MaterialTheme.typography.titleSmall.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                ), modifier = Modifier
                    .padding(vertical = 30.dp)
                    .align(alignment = Alignment.End)
            )
            //Sign In Button
            CustomElevatedButton(text = stringResource(R.string.sign_in),
                onClick = { checkValidation() })
            Spacer(modifier = Modifier.height(10.dp))
            //Create an account
            Text(
                text = stringResource(R.string.create_new_account),
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.SemiBold
                ), modifier = Modifier
                    .padding(vertical = 10.dp)
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
fun LoginScreenPreview() {
    LoginScreen()
}