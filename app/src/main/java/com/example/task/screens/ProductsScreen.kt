package com.example.task.screens
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.task.Models.Product
import com.example.task.components.ProductItem

@Composable
fun ProductListScreen(navController: NavController, products: List<Product>) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Welcome!", color = Color.Blue, fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        ProductList(products = products) { productId ->

            navController.navigate("product/$productId")
        }
    }
}

@Composable
fun ProductList(products: List<Product>, onItemClick: (Int) -> Unit) {
    LazyColumn {
        items(products) { product ->
            ProductItem(product = product, onItemClick = onItemClick)
        }
    }
}