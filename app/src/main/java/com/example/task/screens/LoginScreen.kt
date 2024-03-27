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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.task.Models.UserModel
import com.example.task.R
import com.example.task.components.HeadingTextComponent
import com.example.task.components.LoginButton
import com.example.task.components.MyTextField
import com.example.task.components.NormalTextComponent
import com.example.task.components.PasswordTextField
import com.example.task.helper.RetrofitUser
import kotlinx.coroutines.launch
import retrofit2.HttpException


@Composable
fun LoginScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    var loginError by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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

            MyTextField(
                labelValue = stringResource(id = R.string.username),
                iconId = R.drawable.user,
                text = username,
                onTextChanged = { newUsername -> username = newUsername }
            )

            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                iconId = R.drawable.password,
                password = password,
                onPasswordChanged = { newPassword -> password = newPassword }
            )

            Spacer(modifier = Modifier.height(50.dp))

            LoginButton(
                onClick = {
                    coroutineScope.launch {
                        if (username.isNotBlank() && password.isNotBlank()) {
                            try {
                                val response = RetrofitUser.authService.login(UserModel(username, password))
                                if (response.token.isNotEmpty()) {
                                    navController.navigate("product")
                                } else {
                                    loginError = "Invalid username or password"
                                }
                            } catch (e: HttpException) {
                                loginError = "Failed to login: ${e.message()}"
                            } catch (e: Exception) {
                                loginError = "An error occurred: ${e.message}"
                            }
                        } else {
                            loginError = "Username or password cannot be empty"
                        }
                    }
                },
                username = username,
                password = password
            )

            if (loginError.isNotEmpty()) {
                NormalTextComponent(value = loginError)
            }
        }
    }
}
