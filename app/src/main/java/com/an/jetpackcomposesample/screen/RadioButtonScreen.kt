package com.an.jetpackcomposesample.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.an.jetpackcomposesample.ui.theme.Purple40
import com.an.jetpackcomposesample.ui.theme.Purple80

@Composable
fun RadioButtonScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        TextHeading("Simple Radio button")
        BasicRadioButton()

        TextHeading("Styled Radio button")
        StyledRadioButton()
    }
}

private val radioOptions = listOf("USA","UK","Canada","India")

@Composable
fun BasicRadioButton() {
    var selectedOption by remember { mutableStateOf(radioOptions[0]) }

    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp, top = 10.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        radioOptions.forEach { country ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (country == selectedOption),
                    onClick = { selectedOption = country }
                )
                Text(
                    text = country,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun StyledRadioButton() {
    var selectedOption by remember { mutableStateOf(radioOptions[0]) }

    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp, top = 10.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        radioOptions.forEach { country ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (country == selectedOption),
                    onClick = { selectedOption = country },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Purple40,
                        unselectedColor = Purple80
                    )
                )
                Text(
                    text = country,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}