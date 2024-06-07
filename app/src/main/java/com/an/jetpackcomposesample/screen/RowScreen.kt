package com.an.jetpackcomposesample.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.an.jetpackcomposesample.R
import com.an.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

@Composable
fun RowScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Text(
            text = stringResource(R.string.row_screen_text),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp)
        )
        SimpleRow()
    }
}

@Composable
fun SimpleRow() {
    BodyText(stringResource(R.string.row_screen_txt_1))
    RowStyle(Arrangement.Start)

    BodyText(stringResource(R.string.row_screen_txt_2))
    RowStyle(Arrangement.End)

    BodyText(stringResource(R.string.row_screen_txt_3))
    RowStyle(Arrangement.Center)

    BodyText(stringResource(R.string.row_screen_txt_4))
    RowStyle(Arrangement.SpaceBetween)

    BodyText(stringResource(R.string.row_screen_txt_5))
    RowStyle(Arrangement.SpaceEvenly)

    BodyText(stringResource(R.string.row_screen_txt_6))
    RowStyle(Arrangement.SpaceAround)
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
private fun RowStyle(arrangement: Arrangement.Horizontal) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(MaterialTheme.colorScheme.inverseOnSurface, shape = RoundedCornerShape(10.dp)),
        horizontalArrangement  =  arrangement) {
        Text(
            text = "A",
            Modifier.background(MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(8.dp))
                .padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp)
        )
        Text(
            text = "B",
            Modifier.background(MaterialTheme.colorScheme.secondaryContainer, shape = RoundedCornerShape(8.dp))
                .padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp)
        )
        Text(
            text = "C",
            Modifier.background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(8.dp))
                .padding(start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RowScreenPreview() {
    JetpackComposeSampleTheme {
        RowScreen()
    }
}