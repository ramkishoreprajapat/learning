package com.rk.loginjetpackwithmvvm.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.VisualTransformation
import com.rk.loginjetpackwithmvvm.ui.theme.ExtendedTheme

@Composable
fun CustomOutlinedTextField(
    placeholder: String,
    state: MutableState<String>,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    visualTransformation: VisualTransformation,
    maxLength: Int
) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = state.value,
        onValueChange = {
            if (it.length <= maxLength)
                state.value = it
        },
        singleLine = true,

        visualTransformation = visualTransformation,
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        keyboardOptions = keyboardOptions,
        placeholder = { Text(text = placeholder, style = MaterialTheme.typography.titleMedium) },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = ExtendedTheme.colors.transparent,
        ),
        modifier = Modifier
            .fillMaxWidth(),
    )
}