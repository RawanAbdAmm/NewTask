package com.example.task.screens
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.example.task.Models.Product
import com.example.task.components.ProductItem
import com.example.task.helper.RetrofitClient

@Composable
fun ProductListScreen() {
    val context = LocalContext.current
    val productsState = remember { mutableStateOf<List<Product>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            val productResponse = RetrofitClient.productService.getProducts()
            productsState.value = productResponse.products
        } catch (e: Exception) {
            Toast.makeText(context, "Error fetching products: ${e.message}", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome!", color = Color.Blue, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        ProductList(productsState.value)
    }
}

@Composable
fun ProductList(products: List<Product>) {
    LazyColumn {
        items(products) { product ->
            ProductItem(product = product)
        }
    }
}

