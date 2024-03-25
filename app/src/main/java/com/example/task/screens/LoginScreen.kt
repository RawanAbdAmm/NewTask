package com.example.task.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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

@Composable
fun LoginScreen() {
    Surface (

        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column( modifier = Modifier.fillMaxSize()
        ){
            NormalTextComponent(value = stringResource(id = R.string.hello ) )
            HeadingTextComponent(value = stringResource(id = R.string.welcome))
            Spacer(modifier = Modifier.height(50.dp))
            MyTextField(labelValue = stringResource(id = R.string.username), iconId =R.drawable.user)
            PasswordTextField(labelValue = stringResource(id = R.string.password),iconId=R.drawable.password)
            Spacer(modifier = Modifier.height(50.dp))
            LoginButton()




        }

    }
}

@Preview
@Composable
fun DefaultPreviewLogin(){
    LoginScreen()
}