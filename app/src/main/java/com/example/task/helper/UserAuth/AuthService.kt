package com.example.task.helper.UserAuth
import com.example.task.Models.LoginResponse
import com.example.task.Models.UserModel
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
    suspend fun login(@Body loginRequest: UserModel): LoginResponse
}