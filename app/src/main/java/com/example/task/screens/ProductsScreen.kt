package com.example.task.screens
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberImagePainter
import com.example.task.Models.Product
import com.example.task.helper.RetrofitClient

@Composable
fun ProductListScreen() {
    val context = LocalContext.current
    val productsState = remember { mutableStateOf<List<Product>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            val products = RetrofitClient.productService.getProducts()
            productsState.value = products
        } catch (e: Exception) {
            Toast.makeText(context, "Error fetching products", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    LazyColumn {
        items(productsState.value) { product ->
            ProductListItem(product = product)
        }
    }
}

@Composable
fun ProductListItem(product: Product) {
    Row(
        modifier = Modifier
            .clickable {  }
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(product.images),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = product.title)
    }
}
