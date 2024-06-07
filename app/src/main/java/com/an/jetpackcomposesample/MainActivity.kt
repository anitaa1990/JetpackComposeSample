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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.an.jetpackcomposesample.screen.DynamicThemeScreen
import com.an.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            JetpackComposeSampleTheme {
                MainScreen(navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
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
//        DialogScreen(Modifier.padding(innerPadding))
//        RadioButtonScreen(Modifier.padding(innerPadding))
//        CheckBoxScreen(Modifier.padding(innerPadding))
//        SmallerComponentScreen(Modifier.padding(innerPadding))
//        MainTabScreen(Modifier.padding(innerPadding))
//        MainBottomBarScreen(navController, Modifier.padding(innerPadding))
        DynamicThemeScreen(Modifier.padding(innerPadding))
//         SamplePaymentScreen(Modifier.padding(innerPadding))
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController)
}

