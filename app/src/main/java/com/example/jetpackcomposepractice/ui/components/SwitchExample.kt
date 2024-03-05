package com.example.jetpackcomposepractice.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun MySwitch() {
    // State for the switch - true if the switch is on, false if it's off
   // var isSwitchedOn by remember { mutableStateOf(false) }
    var isSwitchedOn by rememberSaveable { mutableStateOf(false) } // we are doing deligation means making kotlin update this valriable it self for new state we are not taking any other variable

    // A row with the Switch and a Text label
    Row(verticalAlignment = Alignment.CenterVertically) {
        // Switch composable with checked state and onCheckedChange lambda
        Switch(
            checked = isSwitchedOn,
            onCheckedChange = { isSwitchedOn = it }
        )
        Text(if (isSwitchedOn) "Switch is ON" else "Switch is OFF")
    }
}

