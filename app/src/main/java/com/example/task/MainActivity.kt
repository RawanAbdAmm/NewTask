package com.example.task

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.task.Models.Product
import com.example.task.helper.GetProducts.RetrofitProducts
import com.example.task.screens.LoginScreen
import com.example.task.screens.ProductDetailsScreen
import com.example.task.screens.ProductListScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val (productsState, setProductsState) = remember { mutableStateOf<List<Product>>(emptyList()) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        try {
            val productResponse = RetrofitProducts.productService.getProducts()
            setProductsState(productResponse.products)
        } catch (e: Exception) {
            Toast.makeText(context, "Error fetching products: ${e.message}", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("productList") {
            ProductListScreen(
                navController = navController,
                products = productsState
            )
        }
        composable("product/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
            productId?.let { id ->
                val product = productsState.find { it.id == id }
                product?.let {
                    ProductDetailsScreen(navController = navController, product = it)
                }
            }
        }
    }
}