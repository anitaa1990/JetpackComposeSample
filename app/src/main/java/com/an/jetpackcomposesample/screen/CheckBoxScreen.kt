package com.an.jetpackcomposesample.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        TextHeading("Simple Checkbox")
        BasicCheckBoxExample()

        TextHeading("TriStateCheckBox Example")
        TriStateCheckboxExample()
    }
}

private val checkedOptions = listOf("USA","UK","Canada","India")

@Composable
fun BasicCheckBoxExample() {
    var checkedOption by remember { mutableStateOf(checkedOptions[0]) }
    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp, top = 10.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        checkedOptions.forEach { country ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = (country == checkedOption ),
                    onCheckedChange = { checkedOption = country },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colorScheme.secondaryContainer,
                        uncheckedColor = MaterialTheme.colorScheme.primary
                    )
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
fun TriStateCheckboxExample() {
    // Initialize states for the child checkboxes
    val childCheckedStates = remember { mutableStateListOf(false, false, false, false) }

    // Compute the parent state based on children's states
    val parentState = when {
        childCheckedStates.all { it } -> ToggleableState.On
        childCheckedStates.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp, top = 10.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Parent TriStateCheckbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            val text = if (childCheckedStates.all { it })  "Deselect All" else "Select All"
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    // Determine new state based on current state
                    val newState = parentState != ToggleableState.On
                    checkedOptions.forEachIndexed { index, _ ->
                        childCheckedStates[index] = newState
                } },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.secondaryContainer,
                    uncheckedColor = MaterialTheme.colorScheme.primary
                )
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        checkedOptions.forEachIndexed { index, value ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Checkbox(
                    checked = childCheckedStates[index],
                    onCheckedChange = {
                        // Update the individual child state
                        childCheckedStates[index] = it
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colorScheme.secondaryContainer,
                        uncheckedColor = MaterialTheme.colorScheme.primary
                    )
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
