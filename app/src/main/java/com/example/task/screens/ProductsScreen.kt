package com.example.task.screens


import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.task.Models.Product
import com.example.task.components.ProductItem
import com.example.task.helper.RetrofitProducts
import retrofit2.HttpException

@Composable
fun ProductScreen() {
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            products = fetchProducts()
            isLoading = false
        } catch (e: HttpException) {
            error = "Failed to fetch products: ${e.message()}"
            isLoading = false
            println("Error fetching products: ${e.message()}")
        } catch (e: Exception) {
            error = "An error occurred: ${e.message}"
            isLoading = false
            println("An error occurred: ${e.message}")
        }
    }

    if (isLoading) {
        CircularProgressIndicator(
            color = Color.Blue,
            modifier = Modifier.size(50.dp)
        )
    } else if (error != null) {

        println("Error: $error")
    } else {

        LazyColumn {
            items(products) { product ->
                ProductItem(product = product) {

                }
            }
        }
    }
}

suspend fun fetchProducts(): List<Product> {
    return RetrofitProducts.productService.getProducts()
}