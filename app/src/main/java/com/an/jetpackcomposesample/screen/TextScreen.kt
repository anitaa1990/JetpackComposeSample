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
 * render text on the screen. Attributes of `Text` composable include:
 *  * @param text the text to be displayed
 *  * @param modifier the [Modifier] to be applied to this layout node
 *  * @param color [Color] to apply to the text. If [Color.Unspecified], and [style] has no color set,
 *  * this will be [LocalContentColor].
 *  * @param fontSize the size of glyphs to use when painting the text. See [TextStyle.fontSize].
 *  * @param fontStyle the typeface variant to use when drawing the letters (e.g., italic).
 *  * See [TextStyle.fontStyle].
 *  * @param fontWeight the typeface thickness to use when painting the text (e.g., [FontWeight.Bold]).
 *  * @param fontFamily the font family to be used when rendering the text. See [TextStyle.fontFamily].
 *  * @param letterSpacing the amount of space to add between each letter.
 *  * See [TextStyle.letterSpacing].
 *  * @param textDecoration the decorations to paint on the text (e.g., an underline).
 *  * See [TextStyle.textDecoration].
 *  * @param textAlign the alignment of the text within the lines of the paragraph.
 *  * See [TextStyle.textAlign].
 *  * @param lineHeight line height for the [Paragraph] in [TextUnit] unit, e.g. SP or EM.
 *  * See [TextStyle.lineHeight].
 *  * @param overflow how visual overflow should be handled.
 *  * @param softWrap whether the text should break at soft line breaks. If false, the glyphs in the
 *  * text will be positioned as if there was unlimited horizontal space. If [softWrap] is false,
 *  * [overflow] and TextAlign may have unexpected effects.
 *  * @param maxLines An optional maximum number of lines for the text to span, wrapping if
 *  * necessary. If the text exceeds the given number of lines, it will be truncated according to
 *  * [overflow] and [softWrap]. It is required that 1 <= [minLines] <= [maxLines].
 *  * @param minLines The minimum height in terms of minimum number of visible lines. It is required
 *  * that 1 <= [minLines] <= [maxLines].
 *  * @param onTextLayout callback that is executed when a new text layout is calculated. A
 *  * [TextLayoutResult] object that callback provides contains paragraph information, size of the
 *  * text, baselines and other details. The callback can be used to add additional decoration or
 *  * functionality to the text. For example, to draw selection around the text.
 *  * @param style style configuration for the text such as color, font, line height etc.
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