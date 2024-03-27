package com.example.task.helper
import com.example.task.Models.Product
import retrofit2.http.GET
interface ProductService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}