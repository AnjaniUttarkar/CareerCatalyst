package com.example.jobapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.jobapp.ui.theme.JobAppTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberAsyncImagePainter


class Thanks : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    generateLastImage(this)
                }
            }
        }
    }
}


@Composable
fun generateLastImage(activity: ComponentActivity) {
    //val imageUrl = "https://cdn1.vectorstock.com/i/1000x1000/50/00/round-check-mark-symbol-or-tick-vector-45245000.jpg"
    val imageUrl = "https://i.pinimg.com/564x/fc/a8/cc/fca8ccfc8f4af4188f554b0b0a6e1e3d.jpg"
    val painter = rememberAsyncImagePainter(imageUrl)
    Column(
        modifier = Modifier
            //.fillMaxSize(),
            .border(10.dp, Color.Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = "Image",
            modifier = Modifier

                .padding(bottom = 25.dp)
                .height(150.dp)
                .width(150.dp),

            contentScale = ContentScale.FillBounds,
            alignment = Alignment.Center

        )
        Text(
            modifier = Modifier.padding(bottom = 5.dp),
            text = "Thank You for Applying",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "We will reach out soon",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 8.dp)
        )


    }

}
