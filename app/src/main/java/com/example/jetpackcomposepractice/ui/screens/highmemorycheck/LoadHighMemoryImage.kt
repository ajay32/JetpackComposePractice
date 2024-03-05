package com.example.jetpackcomposepractice.ui.screens.highmemorycheck

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.jetpackcomposepractice.R

@Composable
fun HighMemoryUsageComposable() {
    // Simulating a large image loading
    val largeImage = painterResource(id = R.drawable.highmbimage) // Assuming large_image is a very large image
    Image(
        painter = largeImage,
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
}