package com.example.task.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.task.Models.Product
import com.example.task.R
import com.example.task.components.ProductInfoRow




@Composable
fun ProductDetailsScreen(navController: NavController, product: Product) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberImagePainter(product.images[0]),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape)
                .border(4.dp, colorResource(id = R.color.colorPrimary), CircleShape),

            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            ProductInfoRow(text ="Title: ", value = product.title )
            ProductInfoRow(text ="Description: ", value = product.description )
            ProductInfoRow(text ="Price: ", value = product.price.toString() )
            ProductInfoRow(text ="Brand: ", value = product.brand )
            ProductInfoRow(text ="Rating: ", value = product.rating.toString() )
            ProductInfoRow(text ="Category: ", value = product.category )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = { navController.navigate("productList") },
            modifier = Modifier.fillMaxWidth(),
            content = {
                Text(
                    text = "Back to Product List",
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            },
            colors = ButtonDefaults.buttonColors( colorResource(id = R.color.colorPrimary))
        )
    }
}