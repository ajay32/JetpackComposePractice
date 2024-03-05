package com.example.jetpackcomposepractice.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Arranging UI components

@Composable
fun ArrangingUIComponents() {
    Column {
        Text("Hello AJay")
        Text("Hello Raaje")

        Row {
            Text("Hello aaju")
            Text("Hello baaju")
        }
        Box { // seems like example of FrameLayout
            Text("Background")
            Text("Foreground")
        }



        //======== Modifier example

        Text( // modifier follows the builder pattern
            text = "Hello Ji",
            modifier = Modifier
                .border(2.dp, Color.Black)
                .background(Color.Red)
                .fillMaxWidth()
        )

        // .size(18.dp) it sets height and width
        Text(
            text = "New text",
            modifier = Modifier
                .background(Color.Blue)
                .size(80.dp)
        )

        Text(
            style = TextStyle(fontSize = 12.sp, fontFamily = FontFamily.Monospace),
            text="HappyHappy",
            modifier = Modifier
                .width(100.dp)
                .height(70.dp)
                .background(Color.LightGray)
        )
    }
}
