package com.example.task.helper.GetProducts
import com.example.task.Models.Product
import com.example.task.Models.ProductResponse
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getProducts(): ProductResponse
}