package com.example.task.helper.UserAuth
import com.example.task.helper.GetProducts.ProductService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUser {
    private const val BASE_URL = "https://dummyjson.com/"
    private val okHttpClient = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val authService: AuthService = retrofit.create(AuthService::class.java)
    val productService: ProductService = retrofit.create(ProductService::class.java)
}


