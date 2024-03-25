package com.example.task.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.R

@Composable
fun NormalTextComponent(value:String){
    Text(text =value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style= TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
        ),
        color= colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center

    )

}
@Composable
fun HeadingTextComponent(value:String){
    Text(text =value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style= TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
        ),
        color= colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    labelValue: String,
    iconId: Int,
    text: String,
    onTextChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            unfocusedBorderColor = colorResource(id = R.color.colorGrey),

            ),
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = onTextChanged,
        leadingIcon = {
            Box(
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    labelValue: String,
    iconId: Int,
    password: String,
    onPasswordChanged: (String) -> Unit
) {
    val passwordVisible= remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            unfocusedBorderColor = colorResource(id = R.color.colorGrey)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = onPasswordChanged,
        trailingIcon = {
            val iconImage=if(passwordVisible.value){
                Icons.Filled.Favorite

            }else{
                Icons.Filled.FavoriteBorder

            }
            IconButton(onClick = { passwordVisible.value=!passwordVisible.value}) {
                Icon(imageVector =iconImage , contentDescription =null )

            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        leadingIcon = {
            Box(
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = iconId),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }


    )
}



@Composable
fun LoginButton(
    onClick: () -> Unit,
    username: String,
    password: String){
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),

        ) {
        Box( modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Color.Blue, Color.White)),
                shape = RoundedCornerShape(50.dp),
            ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Login",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp ,
            )

        }


    }
}



//            val username = "example_username" //            val password = "example_password" // //            val credentials = Credentials(username, password) // //            viewModelScope.launch { //                try { //                    val response = authService.authenticateUser(credentials) //                    // Handle the response as per your application logic //                    if (response.isSuccessful) { //                        // Authentication successful //                        Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show() //                    } else { //                        // Authentication failed //                        Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show() //                    } //                } catch (e: Exception) { //                    // Handle exceptions //                    Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show() //                } //            }