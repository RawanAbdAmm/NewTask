package com.example.task.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.task.R
import com.example.task.components.HeadingTextComponent
import com.example.task.components.LoginButton
import com.example.task.components.MyTextField
import com.example.task.components.NormalTextComponent
import com.example.task.components.PasswordTextField
import kotlinx.coroutines.launch
import retrofit2.HttpException


@Composable
fun LoginScreen() {
    val coroutineScope = rememberCoroutineScope()
    var loginError by remember { mutableStateOf("") }

    Surface(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.welcome))
            Spacer(modifier = Modifier.height(50.dp))
            val (username, setUsername) = remember { mutableStateOf("") }
            val (password, setPassword) = remember { mutableStateOf("") }

            MyTextField(
                labelValue = stringResource(id = R.string.username), iconId = R.drawable.user,
                text = username,
                onTextChanged = setUsername
            )
            PasswordTextField(
                labelValue = stringResource(id = R.string.password), iconId = R.drawable.password,
                password = password,
                onPasswordChanged = setPassword
            )
            Spacer(modifier = Modifier.height(50.dp))
            LoginButton(
                username = username,
                password = password,
                onClick = {
                    coroutineScope.launch {
                        handleLogin(username, password) { success: Boolean ->
                            if (success) {
                            } else {
                                loginError = "Invalid username or password"
                            }
                        }
                    }
                }
            )

            // Conditionally show login error
            if (loginError.isNotEmpty()) {
                NormalTextComponent(value = loginError)
            }}}}

suspend fun handleLogin(
    username: String,
    password: String,
    onResult: (Boolean) -> Unit
) {
    try {

        val success = true
        onResult(success)
    } catch (e: HttpException) {
        onResult(false)
    } catch (e: Exception) {
        onResult(false)
    }
}

@Preview
@Composable
fun DefaultPreviewLogin() {
    LoginScreen()
}