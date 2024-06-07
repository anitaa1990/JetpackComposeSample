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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.an.jetpackcomposesample.R
import com.an.jetpackcomposesample.provider.NavigationItem
import com.an.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

@Composable
fun IntroScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(12.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.intro_screen_text),
            style = MaterialTheme.typography.bodyLarge
        )
        DemoButtonWithText(
            buttonTextRes = R.string.row_screen_text,
            infoTextRes = R.string.intro_screen_row,
            onClick = { navController.navigate(NavigationItem.RowScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.column_screen_text,
            infoTextRes = R.string.intro_screen_column,
            onClick = { navController.navigate(NavigationItem.ColumnScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_text_title,
            infoTextRes = R.string.intro_screen_text_desc,
            onClick = { navController.navigate(NavigationItem.TextScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_button_title,
            infoTextRes = R.string.intro_screen_button_desc,
            onClick = { navController.navigate(NavigationItem.ButtonScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_image_title,
            infoTextRes = R.string.intro_screen_image_desc,
            onClick = { navController.navigate(NavigationItem.ImageScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_textfield_title,
            infoTextRes = R.string.intro_screen_textfield_desc,
            onClick = { navController.navigate(NavigationItem.TextFieldScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_grid_title,
            infoTextRes = R.string.intro_screen_grid_desc,
            onClick = { navController.navigate(NavigationItem.GridScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_list_title,
            infoTextRes = R.string.intro_screen_list_desc,
            onClick = { navController.navigate(NavigationItem.ListScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_scaffold_title,
            infoTextRes = R.string.intro_screen_scaffold_desc,
            onClick = { navController.navigate(NavigationItem.ScaffoldScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_card_title,
            infoTextRes = R.string.intro_screen_card_desc,
            onClick = { navController.navigate(NavigationItem.CardScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_progress_title,
            infoTextRes = R.string.intro_screen_progress_desc,
            onClick = { navController.navigate(NavigationItem.ProgressScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_dialog_title,
            infoTextRes = R.string.intro_screen_dialog_desc,
            onClick = { navController.navigate(NavigationItem.DialogScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_radio_title,
            infoTextRes = R.string.intro_screen_radio_desc,
            onClick = { navController.navigate(NavigationItem.RadioScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_checkbox_title,
            infoTextRes = R.string.intro_screen_checkbox_desc,
            onClick = { navController.navigate(NavigationItem.CheckboxScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_others_title,
            infoTextRes = R.string.intro_screen_others_desc,
            onClick = { navController.navigate(NavigationItem.OthersScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_tab_title,
            infoTextRes = R.string.intro_screen_tab_desc,
            onClick = { navController.navigate(NavigationItem.TabsScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_bottombar_title,
            infoTextRes = R.string.intro_screen_bottombar_desc,
            onClick = { navController.navigate(NavigationItem.BottomBarScreen.route) }
        )
        DemoButtonWithText(
            buttonTextRes = R.string.intro_screen_theme_title,
            infoTextRes = R.string.intro_screen_theme_desc,
            onClick = { navController.navigate(NavigationItem.ThemesScreen.route) }
        )
    }
}

@Composable
fun DemoButtonWithText(
    buttonTextRes: Int,
    infoTextRes: Int,
    onClick: () -> Unit
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
            onClick = { onClick() },
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
        val navController = rememberNavController()
        IntroScreen(navController)
    }
}