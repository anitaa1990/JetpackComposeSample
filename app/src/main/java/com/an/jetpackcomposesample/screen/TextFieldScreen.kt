package com.an.jetpackcomposesample.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth().fillMaxHeight()
            .padding(top = 12.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TextHeading("Simple TextField")
        SimpleFilledTextFieldSample()

        TextHeading("Simple Outlined TextField")
        SimpleOutlinedTextFieldSample()

        TextHeading("Styled TextField")
        StyledTextFieldExample()

        TextHeading("TextField with Input Options")
        TextFieldWithInputTypeExample()

        TextHeading("TextField with Icon")
        TextFieldWithIconsExample()

        TextHeading("TextField with Visual transformation")
        TextFieldWithVisualTransformationExample()
    }
}

@Composable
fun SimpleFilledTextFieldSample() {
    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp, top = 10.dp).fillMaxWidth()
    ) {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            }
        )
    }
}

@Composable
fun SimpleOutlinedTextFieldSample() {
    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp, top = 10.dp).fillMaxWidth()
    ) {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Email") },
            placeholder = { Text(text = "Eg: John") }
        )
    }
}

@Composable
fun StyledTextFieldExample() {
    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp, top = 10.dp).fillMaxWidth()
    ) {
        var value by remember { mutableStateOf("") }

        TextField(
            value = value,
            onValueChange = { value = it },
            label = { Text("Enter text") },
            maxLines = 2,
            textStyle = TextStyle(color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp),
            shape = MaterialTheme.shapes.extraLarge,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun TextFieldWithInputTypeExample() {
    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp, top = 10.dp).fillMaxWidth()
    ) {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text,
            label = { Text(text = "Number") },
            // Other input types include:
            // KeyboardType.Text
            // KeyboardType.Ascii
            // KeyboardType.Phone
            // KeyboardType.Uri
            // KeyboardType.Email
            // KeyboardType.Password
            // KeyboardType.NumberPassword
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { text = it }
        )
    }
}

@Composable
fun TextFieldWithIconsExample() {
    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp, top = 10.dp).fillMaxWidth()
    ) {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        return OutlinedTextField(
            value = text,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "emailIcon"
                ) },
            onValueChange = { text = it },
            label = { Text(text = "Email address") },
            placeholder = { Text(text = "Enter your email") },
            singleLine = true
        )
    }
}

@Composable
fun TextFieldWithVisualTransformationExample() {
    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp, top = 10.dp).fillMaxWidth()
    ) {
        var password by remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )
    }
}
