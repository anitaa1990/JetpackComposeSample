package com.an.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.an.jetpackcomposesample.screen.ButtonScreen
import com.an.jetpackcomposesample.screen.CardScreen
import com.an.jetpackcomposesample.screen.ColumnScreen
import com.an.jetpackcomposesample.screen.DialogScreen
import com.an.jetpackcomposesample.screen.ImageScreen
import com.an.jetpackcomposesample.screen.IntroScreen
import com.an.jetpackcomposesample.screen.ProgressBarScreen
import com.an.jetpackcomposesample.screen.RowScreen
import com.an.jetpackcomposesample.screen.ScaffoldScreen
import com.an.jetpackcomposesample.screen.TextFieldScreen
import com.an.jetpackcomposesample.screen.TextScreen
import com.an.jetpackcomposesample.screen.grid.GridScreen
import com.an.jetpackcomposesample.screen.list.ListScreen
import com.an.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme
import com.an.jetpackcomposesample.ui.theme.Purple40
import com.an.jetpackcomposesample.ui.theme.PurpleGrey80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PurpleGrey80,
                    titleContentColor = Purple40,
                ),
                title = {
                    Text(stringResource(id = R.string.app_name))
                },
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
            )
        },
    ) { innerPadding ->
//        IntroScreen(Modifier.padding(innerPadding))
//        RowScreen(Modifier.padding(innerPadding))
//        ColumnScreen(Modifier.padding(innerPadding))
//        TextScreen(Modifier.padding(innerPadding))
//        ButtonScreen(Modifier.padding(innerPadding))
//        ImageScreen(Modifier.padding(innerPadding))
//        TextFieldScreen(Modifier.padding(innerPadding))
//        GridScreen(Modifier.padding(innerPadding))
//        ListScreen(Modifier.padding(innerPadding))
//        ScaffoldScreen(Modifier.padding(innerPadding))
//        CardScreen(Modifier.padding(innerPadding))
//        ProgressBarScreen(Modifier.padding(innerPadding))
          DialogScreen(Modifier.padding(innerPadding))
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
