package com.example.task.Models

data class UserModel(

val username: String,
val password: String
)
data class LoginResponse(
    val token: String
)
