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
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController


@Composable
fun SecondScreen(navHostController: NavHostController, backStackEntry: NavBackStackEntry) {

    val url = backStackEntry.arguments?.get("url")
    val counter = backStackEntry.arguments?.get("counter")


    Column(
        modifier = Modifier.fillMaxSize(), // widht n Hight match parent
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Second Screen $url$counter")

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navHostController.popBackStack() //it will store in backstack .. clicking from last scree..you willbe back to home screen
            navHostController.navigate("last")}) {
            Text(text = "Go to Last Screen")
        }

    }
}