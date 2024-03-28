package com.example.task.screens

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.task.Models.UserModel
import com.example.task.R
import com.example.task.components.HeadingTextComponent
import com.example.task.components.LoginButton
import com.example.task.components.MyTextField
import com.example.task.components.PasswordTextField
import com.example.task.helper.UserAuth.RetrofitUser
import kotlinx.coroutines.launch
import retrofit2.HttpException


@Composable
fun LoginScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            HeadingTextComponent(value = stringResource(id = R.string.login_screen))
            Spacer(modifier = Modifier.height(70.dp))

            MyTextField(
                labelValue = stringResource(id = R.string.username),
                iconId = R.drawable.user,
                text = username,
                onTextChanged = { newUsername -> username = newUsername }
            )
            Spacer(modifier = Modifier.height(20.dp))
            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                iconId = R.drawable.password,
                password = password,
                onPasswordChanged = { newPassword -> password = newPassword }
            )

            Spacer(modifier = Modifier.height(30.dp))

            LoginButton(
                onClick = {
                    coroutineScope.launch {
                        if (username.isNotBlank() && password.isNotBlank()) {
                            try {
                                val response = RetrofitUser.authService.login(UserModel(username, password))
                                if (response.token.isNotEmpty()) {
//                                    navController.graph.startDestinationRoute?.let {
//                                        navController.popBackStack(
//                                            it, inclusive = true)
//                                    }
                                    navController.navigate("productList")
                                } else {
                                    Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show()
                                }
                            } catch (e: HttpException) {
                                Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show()

                            } catch (e: Exception) {
                                Toast.makeText(context, "An error occurred: ${e.message}", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                },
                username = username,
                password = password
            )

        }
    }
}
