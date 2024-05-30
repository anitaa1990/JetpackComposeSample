package com.an.jetpackcomposesample.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.an.jetpackcomposesample.ui.theme.Purple40
import com.an.jetpackcomposesample.ui.theme.Purple80

@Composable
fun DialogScreen(modifier: Modifier = Modifier) {
    val showAlertDialog = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(start = 12.dp, top = 12.dp, end = 12.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = { showAlertDialog.value = true }) {
            Text("Alert Dialog")
        }
    }

    if(showAlertDialog.value) {
        AlertDialogExample(showAlertDialog)
    }
}

@Composable
fun AlertDialogExample(showAlertDialog: MutableState<Boolean>) {
    AlertDialog(
        icon = {
            Icon(Icons.Filled.Info, contentDescription = "Info Icon", tint = Purple80)
        },
        title = {
            Text(text = "Dialog with info icon")
        },
        text = {
            Text(text = "The Dialog component displays pop up messages or requests user input on a layer above the main app content. It creates an interruptive UI experience to capture user attention.")
        },
        onDismissRequest = { },
        confirmButton = {
            TextButton(
                onClick = { showAlertDialog.value = false }
            ) {
                Text("Confirm", color = Purple40)
            }
        },
        dismissButton = {
            TextButton(
                onClick = { showAlertDialog.value = false }
            ) {
                Text("Dismiss", color = Purple40)
            }
        }
    )
}