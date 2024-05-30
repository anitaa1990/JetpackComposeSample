package com.an.jetpackcomposesample.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.an.jetpackcomposesample.ui.theme.Purple40
import com.an.jetpackcomposesample.ui.theme.Purple60
import com.an.jetpackcomposesample.ui.theme.Purple80

@Composable
fun DialogScreen(modifier: Modifier = Modifier) {
    val showAlertDialog = remember { mutableStateOf(false) }
    val showCustomDialog = remember { mutableStateOf(false) }
    val datePickerDialog = remember { mutableStateOf(false) }
    val bottomSheetDialog = remember { mutableStateOf(false) }

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
        Button(onClick = { showCustomDialog.value = true }) {
            Text("Custom Dialog")
        }
        Button(onClick = { datePickerDialog.value = true }) {
            Text("DatePicker Dialog")
        }
        Button(onClick = { bottomSheetDialog.value = true }) {
            Text("Bottom Sheet Dialog")
        }
    }

    if(showAlertDialog.value) {
        AlertDialogExample(showAlertDialog)
    }
    if(showCustomDialog.value) {
        CustomDialogExample(showCustomDialog)
    }
    if(datePickerDialog.value) {
        DatePickerDialogExample(datePickerDialog)
    }
    if(bottomSheetDialog.value) {
        BottomSheetExample(bottomSheetDialog)
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

@Composable
fun CustomDialogExample(showCustomDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { showCustomDialog.value = false }) {
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp, top = 20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Purple60)
                    .padding(16.dp)
            ) {
                Icon(Icons.Filled.Info, contentDescription = "Info Icon", tint = Purple80)
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Dialog with info icon",
                        style = TextStyle(fontWeight = FontWeight.Bold, color = Purple40, fontSize = 18.sp)
                    )
                    Text(
                        modifier = Modifier.padding(top = 10.dp),
                        textAlign = TextAlign.Center,
                        text = "This Dialog is an example of a custom dialog with the Dialog Composable"
                    )
                }
                TextButton(
                    onClick = { showCustomDialog.value = false }
                ) {
                    Text("Confirm", color = Purple40)
                }
                TextButton(
                    onClick = { showCustomDialog.value = false }
                ) {
                    Text("Dismiss", color = Purple40)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialogExample(showDatePickerDialog: MutableState<Boolean>) {
    val dateState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = { showDatePickerDialog.value = false },
        confirmButton = {
            TextButton(
                onClick = { showDatePickerDialog.value = false }
            ) {
                Text("Confirm", color = Purple40)
            }
        },
        dismissButton = {
            TextButton(
                onClick = { showDatePickerDialog.value = false }
            ) {
                Text(text = "Cancel", color = Purple40)
            }
        }) {
        DatePicker(
            state = dateState,
            showModeToggle = true
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetExample(showBottomSheet: MutableState<Boolean>) {
    val context = LocalContext.current
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { showBottomSheet.value = false },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        val countries = listOf(
            Pair("United States", "US".toFlagEmoji()),
            Pair("Canada", "CA".toFlagEmoji()),
            Pair("India", "IN".toFlagEmoji()),
            Pair("Germany", "DE".toFlagEmoji()),
            Pair("France", "FR".toFlagEmoji()),
            Pair("Japan", "JP".toFlagEmoji()),
            Pair("China", "CN".toFlagEmoji()),
            Pair("Brazil", "BR".toFlagEmoji()),
            Pair("Australia", "AU".toFlagEmoji()),
            Pair("Russia", "RU".toFlagEmoji()),
            Pair("United Kingdom", "UK".toFlagEmoji()),
            Pair("Belgium", "BE".toFlagEmoji()),
            Pair("Pakistan", "PK".toFlagEmoji()),
        )

        LazyColumn {
            items(countries.size) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp, horizontal = 20.dp)
                        .clickable {
                            Toast.makeText(context, countries[it].first+ " Clicked", Toast.LENGTH_SHORT).show()
                            showBottomSheet.value = false
                        }
                ) {
                    Text(
                        text = countries[it].second,
                        modifier = Modifier.padding(end = 20.dp, top = 5.dp, bottom = 5.dp)
                    )
                    Text(text = countries[it].first)
                }
            }
        }
    }
}

private fun String.toFlagEmoji(): String {
    // 1. It first checks if the string consists of only 2 characters: ISO 3166-1 alpha-2 two-letter country codes (https://en.wikipedia.org/wiki/Regional_Indicator_Symbol).
    if (this.length != 2) {
        return this
    }

    val countryCodeCaps =
        this.uppercase() // upper case is important because we are calculating offset
    val firstLetter = Character.codePointAt(countryCodeCaps, 0) - 0x41 + 0x1F1E6
    val secondLetter = Character.codePointAt(countryCodeCaps, 1) - 0x41 + 0x1F1E6

    // 2. It then checks if both characters are alphabet
    if (!countryCodeCaps[0].isLetter() || !countryCodeCaps[1].isLetter()) {
        return this
    }

    return String(Character.toChars(firstLetter)) + String(Character.toChars(secondLetter))
}
