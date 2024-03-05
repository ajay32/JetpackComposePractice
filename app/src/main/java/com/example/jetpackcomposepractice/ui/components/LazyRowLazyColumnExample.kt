package com.example.jetpackcomposepractice.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LazyRowAndColumnExample() {
    myCustomList()
    myHorizontalList()
}

@Composable
fun myCustomList() {

    val data = listOf("Item1", "Item2", "Item3", "Item4", "Item5")

    LazyColumn() {
        items(data) { item ->
            Text(item)
        }
    }
}

// Horizontal List

@Composable
fun myHorizontalList() {
    val data = listOf("HOR1", "HOR22", "HOR3", "HOR4", "HOR5")

    LazyRow {
        items(data) { item ->
            Text(text= item, modifier = Modifier.padding(horizontal = 20.dp))
        }
    }
}
