package com.an.jetpackcomposesample.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.an.jetpackcomposesample.R
import com.an.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

@Composable
fun IntroScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(12.dp).verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.intro_screen_text),
            style = MaterialTheme.typography.bodyLarge
        )
        DemoButtonWithText(
            buttonTextRes = R.string.row_screen_text,
            infoTextRes = R.string.intro_screen_row
        )
        DemoButtonWithText(
            buttonTextRes = R.string.column_screen_text,
            infoTextRes = R.string.intro_screen_column
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_text_title,
            infoTextRes = R.string.intro_screen_text_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_button_title,
            infoTextRes = R.string.intro_screen_button_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_image_title,
            infoTextRes = R.string.intro_screen_image_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_textfield_title,
            infoTextRes = R.string.intro_screen_textfield_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_grid_title,
            infoTextRes = R.string.intro_screen_grid_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_list_title,
            infoTextRes = R.string.intro_screen_list_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_scaffold_title,
            infoTextRes = R.string.intro_screen_scaffold_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_card_title,
            infoTextRes = R.string.intro_screen_card_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_progress_title,
            infoTextRes = R.string.intro_screen_progress_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_dialog_title,
            infoTextRes = R.string.intro_screen_dialog_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_radio_title,
            infoTextRes = R.string.intro_screen_radio_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_checkbox_title,
            infoTextRes = R.string.intro_screen_checkbox_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_others_title,
            infoTextRes = R.string.intro_screen_others_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_tab_title,
            infoTextRes = R.string.intro_screen_tab_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_bottombar_title,
            infoTextRes = R.string.intro_screen_bottombar_desc
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_theme_title,
            infoTextRes = R.string.intro_screen_theme_desc
        )
    }
}

@Composable
fun DemoButtonWithText(
    buttonTextRes: Int,
    infoTextRes: Int
) {

    Row(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            modifier = Modifier
                .wrapContentWidth()
                .padding(end = 10.dp),
            onClick = {  },
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(stringResource(id = buttonTextRes))
        }
        Text(
            text = stringResource(infoTextRes),
            fontSize = 14.sp,
            modifier = Modifier.padding(6.dp),
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IntroScreenPreview() {
    JetpackComposeSampleTheme {
        IntroScreen()
    }
}