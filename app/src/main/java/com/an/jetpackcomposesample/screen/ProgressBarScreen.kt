package com.an.jetpackcomposesample.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.an.jetpackcomposesample.R
import com.an.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme
import com.an.jetpackcomposesample.ui.theme.Purple40
import com.an.jetpackcomposesample.ui.theme.Purple80

@Composable
fun ProgressBarScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(start = 12.dp, top = 12.dp, end = 12.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = stringResource(R.string.progress_screen_text),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        
        LinearProgressBar()
        CustomLinearProgressBar()

        CircularProgressIndicator(modifier = Modifier.padding(10.dp))
        CustomCircularProgressBar()
    }
}

private val progressBarModifier = Modifier.fillMaxWidth().padding(10.dp)

@Composable
private fun LinearProgressBar() {
    Column(modifier = progressBarModifier) {
        LinearProgressIndicator()
    }
}

@Composable
private fun CustomLinearProgressBar() {
    Column(modifier = progressBarModifier) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            trackColor = Purple80,
            color = Purple40, //progress color
        )
    }
}

@Composable
private fun CustomCircularProgressBar() {
    Column(modifier = Modifier.fillMaxWidth()) {
        CircularProgressIndicator(
            trackColor = Purple40,
            color = Purple80 //progress color
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressBarScreenPreview() {
    JetpackComposeSampleTheme {
        ProgressBarScreen()
    }
}