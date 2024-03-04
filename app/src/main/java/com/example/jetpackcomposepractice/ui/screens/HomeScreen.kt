package com.example.jetpackcomposepractice.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navHostController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(), // widht n Hight match parent
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Home Screen")

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navHostController.navigate("second" + "/www.url.com/44") }) {
            Text(text = "Go to Second Screen")
        }

    }


}

