package com.example.task.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import com.example.task.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetailsScreen(
    productName: String,
    productImageRes: Int,
    productDescription: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Display Image in a Circle
        Image(
            painter = painterResource(id = productImageRes),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )

        // Product Details
        Text(
            text = productName,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = productDescription,
            color = Color.Gray
        )
    }
}



@Preview
@Composable
fun PreviewProductDetailsScreen() {
    ProductDetailsScreen(
        productName = "Sample Product",
        productImageRes = R.drawable.user,
        productDescription = "This is a sample product description."
    )
}
