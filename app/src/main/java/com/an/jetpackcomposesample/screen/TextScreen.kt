package com.an.jetpackcomposesample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.an.jetpackcomposesample.R
import com.an.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

/**
 * The Text composable is pre-defined by the Compose UI library; you can use this composable to
 * render text on the screen
 */
@Composable
fun TextScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        TextHeading("Basic Text Styles")
        BasicTextStyles()

        TextHeading("Text Decoration Styles")
        TextDecorationStyle()

        TextHeading("Text Heading Styles")
        TextHeadingStyle()

        TextHeading("Text Align Styles")
        TextAlignStyles()

        TextHeading("Other Text styles")
        OtherTextStyles()
    }
}
@Composable
fun TextHeading(heading: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .padding(6.dp)
    ) {
        Text(
            text = heading,
            style = TextStyle(color = MaterialTheme.colorScheme.primary, fontSize = 18.sp),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
        )
    }
}
@Composable
fun BasicTextStyles() {
    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp, top = 10.dp)
    ) {
        Text(
            text = "Default Text"
        )
        Text(
            text = "Bold Text",
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
        Text(
            text = "Italic Text",
            style = TextStyle(fontStyle = FontStyle.Italic)
        )
        Text(
            text = "Text with Color",
            style = TextStyle(color = MaterialTheme.colorScheme.secondaryContainer)
        )
        Text(
            text = "Text with Background Color",
            style = TextStyle(background = MaterialTheme.colorScheme.primaryContainer)
        )
        Text(
            text = "Text with Shadow",
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(5f, 5f),
                    blurRadius = 5f
                )
            )
        )
        Text(
            text = "Text with custom font",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily.Cursive
            )
        )
        Text(
            text = "Text with big font size",
            style = TextStyle(fontSize = 30.sp)
        )
    }
}

@Composable
fun TextDecorationStyle() {
    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp, top = 10.dp)
    ) {
        Text(
            text = "Text with Underline",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Text with Strike",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
    }
}

@Composable
fun TextHeadingStyle() {
    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp)
    ) {
        Text(
            text = "Display Large",
            style = MaterialTheme.typography.displayLarge
        )
        Text(
            text = "Display Medium",
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = "Display Small",
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = "Heading Large",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Heading Medium",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Heading Small",
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "Title Large",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Title Medium",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Title Small",
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = "Label Large",
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = "Label Medium",
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = "Label Small",
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = "Body Large",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Body Medium",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Body Small",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun TextAlignStyles() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(start = 10.dp, bottom = 12.dp)
    ) {
        Text(
            text = stringResource(id = R.string.text_screen_sample_txt_1),
            modifier = Modifier.padding(bottom = 8.dp),
            textAlign = TextAlign.Justify,
            style = TextStyle(color = Color.Magenta)
        )
        Text(
            text = stringResource(id = R.string.text_screen_sample_txt_2),
            modifier = Modifier.padding(bottom = 8.dp),
            textAlign = TextAlign.Start,
            style = TextStyle(color = Color.Blue)
        )
        Text(
            text = stringResource(id = R.string.text_screen_sample_txt_3),
            modifier = Modifier.padding(bottom = 8.dp),
            textAlign = TextAlign.Center,
            style = TextStyle(color = MaterialTheme.colorScheme.primary)
        )
        Text(
            text = stringResource(id = R.string.text_screen_sample_txt_4),
            modifier = Modifier.padding(bottom = 8.dp),
            textAlign = TextAlign.End,
            style = TextStyle(color = Color.Green)
        )
    }
}

@Composable
fun OtherTextStyles() {
    Column(
        modifier = Modifier.padding(start = 10.dp, bottom = 12.dp)
    ) {
        Text(
            text = "Text with exactly 2 max lines defined. ".repeat(50), maxLines = 2,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Text(
            text = "Text with overflow ellipsis. ".repeat(50), maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        SelectionContainer {
            Text("Long press text to select & copy",
                style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    color = Color.Blue,
                    fontSize = 20.sp
                ))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextScreenPreview() {
    JetpackComposeSampleTheme {
        TextScreen()
    }
}