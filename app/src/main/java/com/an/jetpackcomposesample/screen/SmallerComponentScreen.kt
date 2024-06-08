package com.an.jetpackcomposesample.screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SmallerComponentScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        TextHeading("Simple Slider")
        BasicSliderExample()

        TextHeading("Range Slider")
        RangeSliderExample()

        TextHeading("Switch")
        SwitchExample()

        TextHeading("Chips")
        ChipExample()

    }
}

@Composable
fun BasicSliderExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.primary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 5,
            valueRange = 0f..100f
        )
        Text(
            text = sliderPosition.toString(),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun RangeSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        RangeSlider(
            value = sliderPosition,
            steps = 5,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
            },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.primary,
                activeTrackColor = MaterialTheme.colorScheme.primary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            )
        )
        Text(
            text = sliderPosition.toString(),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

/**
 * A pre-defined composable that's capable of rendering a switch. It honors the Material
 * design specification.
 */
@Composable
fun SwitchExample() {
    var checked by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            thumbContent = if (checked) {
                {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                    )
                }
            } else {
                null
            }
        )

        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = {
                checked2 = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.inverseOnSurface,
                checkedTrackColor = MaterialTheme.colorScheme.primary,
                uncheckedThumbColor = MaterialTheme.colorScheme.inverseOnSurface,
                uncheckedTrackColor = MaterialTheme.colorScheme.primaryContainer,
            )
        )
    }
}

@Composable
fun ChipExample() {
    Row (
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        AssistChipExample()
        FilterChipExample()
        InputChipExample()
    }
    Row (
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SuggestionChipExample()
    }
}

@Composable
fun AssistChipExample() {
    val context = LocalContext.current

    AssistChip(
        onClick = { Toast.makeText(context, "Assist clicked!", Toast.LENGTH_SHORT).show()  },
        label = {
            Text(
                text = "Assist chip",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
        },
        border = BorderStroke(width = 3.dp, color = MaterialTheme.colorScheme.primary),
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Settings",
                Modifier.size(AssistChipDefaults.IconSize),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipExample() {
    // Filter Chip
    var selectedFilter by remember { mutableStateOf(false) }
    val filterLeadingIcon = if (selectedFilter) Icons.Filled.Clear else Icons.Filled.Check
    FilterChip(
        onClick = { selectedFilter = !selectedFilter },
        border = FilterChipDefaults.filterChipBorder(
            enabled = true,
            selected = false,
            borderColor = MaterialTheme.colorScheme.primary,
            selectedBorderColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        label = {
            Text(
                text = "Filter chip",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
        },
        selected = selectedFilter,
        leadingIcon = {
            Icon(
                imageVector = filterLeadingIcon,
                contentDescription = "Leading icon",
                modifier = Modifier.size(FilterChipDefaults.IconSize),
                tint = MaterialTheme.colorScheme.primary
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputChipExample() {
    // Input Chip – You can use the InputChip composable to create chips that result from user interaction. For example, in an email client, when the user is writing an email, an input chip might represent a person whose address the user has entered into the "to:" field.
    var enabled by remember { mutableStateOf(false) }
    InputChip(
        onClick = {
            enabled = !enabled
        },
        label = {
            Text(
                text = "Input chip",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
        },
        border = FilterChipDefaults.filterChipBorder(
            enabled = true,
            selected = false,
            borderColor = MaterialTheme.colorScheme.primary,
            selectedBorderColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        selected = enabled,
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Input Chip person icon",
                Modifier.size(InputChipDefaults.AvatarSize),
                tint = MaterialTheme.colorScheme.primary
            )
        },
        trailingIcon = {
            Icon(
                Icons.Default.Close,
                contentDescription = "Input Chip close icon",
                Modifier.size(InputChipDefaults.AvatarSize),
                tint = MaterialTheme.colorScheme.primary
            )
        },
    )
}

@Composable
fun SuggestionChipExample() {
    // Suggestion chips present dynamically generated hints.

    val context = LocalContext.current
    SuggestionChip(
        onClick = { Toast.makeText(context, "Suggestion clicked!", Toast.LENGTH_SHORT).show() },
        border = BorderStroke(width = 3.dp, color = MaterialTheme.colorScheme.primary),
        label = {
            Text(
                text = "Suggestion chip",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    )
}
