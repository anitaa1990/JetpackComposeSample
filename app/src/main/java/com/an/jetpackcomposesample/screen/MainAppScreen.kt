package com.an.jetpackcomposesample.screen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.an.jetpackcomposesample.R
import com.an.jetpackcomposesample.component.ThemeSwitch
import com.an.jetpackcomposesample.provider.Navigation
import com.an.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

@Composable
fun MainApp(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = MainAppScreen.valueOf(
        backStackEntry?.destination?.route ?: MainAppScreen.Intro.name
    )
    // get the current theme set by the app
    var darkTheme by remember { mutableStateOf(false) }
    JetpackComposeSampleTheme(darkTheme = darkTheme) {
        Scaffold(
            topBar = {
                MainAppBar(
                    currentScreen = currentScreen,
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() },
                    darkTheme = darkTheme,
                    onThemeUpdated = { darkTheme = !darkTheme } // update light mode/dark mode
                )
            }
        ) { innerPadding ->
            Navigation(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    currentScreen: MainAppScreen,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit,
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                text = stringResource(id = currentScreen.title)
            )
        },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState()),
        actions = {
            ThemeSwitch(
                darkTheme = darkTheme,
                size = 35.dp,
                padding = 5.dp,
                onClick = onThemeUpdated
            )
        }
    )
}

enum class MainAppScreen(@StringRes val title: Int) {
    Main(title = R.string.app_name),
    Intro(title = R.string.app_name),
    Row(title = R.string.row_screen_text),
    Column(title = R.string.column_screen_text),
    Text(title = R.string.intro_screen_text_title),
    Button(title = R.string.intro_screen_button_title),
    Image(title = R.string.intro_screen_image_title),
    TextField(title = R.string.intro_screen_textfield_title),
    Grid(title = R.string.intro_screen_grid_title),
    List(title = R.string.intro_screen_list_title),
    Scaffold(title = R.string.intro_screen_scaffold_title),
    Card(title = R.string.intro_screen_card_title),
    Progress(title = R.string.intro_screen_progress_title),
    Dialog(title = R.string.intro_screen_dialog_title),
    Radio(title = R.string.intro_screen_radio_title),
    Checkbox(title = R.string.intro_screen_checkbox_title),
    Others(title = R.string.intro_screen_others_title),
    Tab(title = R.string.intro_screen_tab_title),
    BottomBar(title = R.string.intro_screen_bottombar_title),
    Themes(title = R.string.intro_screen_theme_title)
}

@Preview
@Composable
fun MainAppPreview() {
    MainApp()
}