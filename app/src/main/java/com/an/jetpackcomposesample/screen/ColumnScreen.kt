package com.an.jetpackcomposesample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.an.jetpackcomposesample.R
import com.an.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

@Composable
fun ColumnScreen(modifier: Modifier = Modifier) {
    val displayedTextList = listOf(
        stringResource(id = R.string.column_screen_txt_1),
        stringResource(id = R.string.column_screen_txt_2),
        stringResource(id = R.string.column_screen_txt_3),
        stringResource(id = R.string.column_screen_txt_4),
        stringResource(id = R.string.column_screen_txt_5),
        stringResource(id = R.string.column_screen_txt_6)
    )

    val customPairList = listOf(
        Pair(0, Arrangement.Top),
        Pair(1, Arrangement.Bottom),
        Pair(2, Arrangement.Center),
        Pair(3, Arrangement.SpaceBetween),
        Pair(4, Arrangement.SpaceEvenly),
        Pair(5, Arrangement.SpaceAround)
    )

    var displayedText by rememberSaveable { mutableStateOf(displayedTextList[0]) }
    var displayedArrangement by rememberSaveable { mutableIntStateOf(customPairList[0].first) }

    Column(
        modifier = modifier.fillMaxHeight()
    ) {
        Text(
            text = stringResource(R.string.column_screen_text),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp)
        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            TonalButtonStyle(stringResource(id = R.string.column_screen_btn_1)) {
                displayedText = displayedTextList[0]
                displayedArrangement = customPairList[0].first
            }
            TonalButtonStyle(stringResource(id = R.string.column_screen_btn_2)) {
                displayedText = displayedTextList[1]
                displayedArrangement = customPairList[1].first
            }
            TonalButtonStyle(stringResource(id = R.string.column_screen_btn_3)) {
                displayedText = displayedTextList[2]
                displayedArrangement = customPairList[2].first
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            TonalButtonStyle(stringResource(id = R.string.column_screen_btn_4)) {
                displayedText = displayedTextList[3]
                displayedArrangement = customPairList[3].first
            }
            TonalButtonStyle(stringResource(id = R.string.column_screen_btn_5)) {
                displayedText = displayedTextList[4]
                displayedArrangement = customPairList[4].first
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            TonalButtonStyle(stringResource(id = R.string.column_screen_btn_5)) {
                displayedText = displayedTextList[5]
                displayedArrangement = customPairList[5].first
            }
        }

        BodyText(displayedText)
        ColumnStyle(customPairList[displayedArrangement].second)
    }
}

@Composable
fun TonalButtonStyle(buttonText: String, onClick: ()-> Unit) {
    FilledTonalButton(
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = Color.Black
        ),
        onClick = { onClick() }
    ) {
        Text(buttonText)
    }

}

@Composable
private fun BodyText(string: String) {
    Text(
        text = string,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp)
    )
}

@Composable
private fun ColumnStyle(arrangement: Arrangement.Vertical) {
    Column(modifier = Modifier
        .fillMaxHeight(0.5f)
        .fillMaxWidth()
        .padding(12.dp)
        .alpha(1f)
        .background(MaterialTheme.colorScheme.inverseOnSurface, shape = RoundedCornerShape(10.dp)),
        verticalArrangement = arrangement
    ) {
        Text(text = "A",
            Modifier
                .background(MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(8.dp))
                .padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp))
        Text(text = "B",
            Modifier
                .background(MaterialTheme.colorScheme.secondaryContainer, shape = RoundedCornerShape(8.dp))
                .padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp))
        Text(text = "C",
            Modifier
                .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(8.dp))
                .padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnScreenPreview() {
    JetpackComposeSampleTheme {
        ColumnScreen()
    }
}