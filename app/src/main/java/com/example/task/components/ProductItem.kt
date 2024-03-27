package com.example.task.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.task.Models.Product


@Composable
fun ProductItem(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
//        val painter: Painter = rememberImagePainter(product.thumbnail)
//        Image(
//            painter = painter,
//            contentDescription = "Product Thumbnail",
//            modifier = Modifier.size(100.dp)
//        )

        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text="Welcome!")
            Text(text = product.title)
            Text(text = "Price: $${product.price}")
            Text(text = "Brand: ${product.brand}")
        }
    }
}