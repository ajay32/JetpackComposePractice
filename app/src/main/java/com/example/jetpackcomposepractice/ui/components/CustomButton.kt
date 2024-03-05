package com.example.jetpackcomposepractice.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@Composable
fun CustomButton() {
    Column {
        CustomButtonWithoutDeligation()
        CustomButtonDeligation()
    }
}

@Composable
fun CustomButtonWithoutDeligation() {

    // destructing like JS  two variables text = Click me | setText = Clicked
    val (text, setText) = remember {
        mutableStateOf("Click me")
    }
    Button(
        onClick = { setText("Clicked") }
    ) {
        Text(text)
    }
}

@Composable
fun CustomButtonDeligation() {
    // Use property delegation for the state management
    var text by remember { mutableStateOf("Click me") }
    Button(
        onClick = { text = "Clicked" } // Directly update the state using delegated property
    ) {
        Text(text)
    }
}


