package com.example.jetpackcomposepractice.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun TextExample() {

    Column {
        Text("Hello Beta") // default stype

        Text(
            text = "Hello GUGU",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(10.dp),
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Right,
            letterSpacing = 0.2.em,
            lineHeight = 28.sp
        )
    }
}
