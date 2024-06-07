package com.an.jetpackcomposesample.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.an.jetpackcomposesample.R
import com.an.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

@Composable
fun ButtonScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(start = 12.dp, top = 12.dp, end = 12.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = stringResource(R.string.button_screen_text),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        FilledButtonExample { }
        FilledTonalButtonExample { }
        OutlinedButtonExample { }
        ElevatedButtonExample { }
        TextButtonExample { }
        CustomFilledButtonExample { }
        IconButtonExample { }
        ButtonWithIconExample { }
        RoundedCornerButtonExample { }
        CutCornerShapeButtonExample { }
    }
}

@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("Filled Button")
    }
}

@Composable
fun FilledTonalButtonExample(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Text("Tonal Button")
    }
}

@Composable
fun OutlinedButtonExample(onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick() }) {
        Text("Outlined Button")
    }
}

@Composable
fun ElevatedButtonExample(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Elevated Button")
    }
}

@Composable
fun TextButtonExample(onClick: () -> Unit) {
    TextButton(
        onClick = { onClick() }
    ) {
        Text("Text Button")
    }
}

@Composable
fun CustomFilledButtonExample(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Text("Button with custom background")
    }
}

@Composable
fun IconButtonExample(onClick: () -> Unit) {
    IconButton(onClick) {
        Icon(Icons.Filled.Favorite, contentDescription = "Favorite",
        tint = Color.Red,
        modifier = Modifier.size(48.dp)
        )
    }
}

@Composable
fun ButtonWithIconExample(onClick: () -> Unit) {
    Button(onClick) {
        Image(
            painterResource(id = R.drawable.ic_cart),
            contentDescription ="Cart button icon",
            modifier = Modifier.size(20.dp))

        Text(text = "Button with icon",Modifier.padding(start = 10.dp))
    }
}
@Composable
fun RoundedCornerButtonExample(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(20.dp)
    ) {
        Text("Round corner shape button")
    }
}

@Composable
fun CutCornerShapeButtonExample(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        shape = CutCornerShape(10)
    ) {
        Text("Cut corner shape button")
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonScreenPreview() {
    JetpackComposeSampleTheme {
        ButtonScreen()
    }
}