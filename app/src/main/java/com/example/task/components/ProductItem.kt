package com.example.task.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.task.Models.Product


@Composable
fun ProductItem(product: Product, onItemClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClick)
            .padding(16.dp)
    ) {
        // Load product image
        val painter: Painter = rememberImagePainter(product.imageUrl)
        Image(
            painter = painter,
            contentDescription = "Product Image",
            modifier = Modifier.size(100.dp)
        )

        // Display product details
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = product.title)
            Text(text = product.description)
            // Add more product details as needed
        }
    }
}