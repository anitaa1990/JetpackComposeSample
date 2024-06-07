package com.an.jetpackcomposesample.provider

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.an.jetpackcomposesample.screen.ButtonScreen
import com.an.jetpackcomposesample.screen.CardScreen
import com.an.jetpackcomposesample.screen.CheckBoxScreen
import com.an.jetpackcomposesample.screen.ColumnScreen
import com.an.jetpackcomposesample.screen.DialogScreen
import com.an.jetpackcomposesample.screen.DynamicThemeScreen
import com.an.jetpackcomposesample.screen.ImageScreen
import com.an.jetpackcomposesample.screen.IntroScreen
import com.an.jetpackcomposesample.screen.ProgressBarScreen
import com.an.jetpackcomposesample.screen.RadioButtonScreen
import com.an.jetpackcomposesample.screen.RowScreen
import com.an.jetpackcomposesample.screen.ScaffoldScreen
import com.an.jetpackcomposesample.screen.SmallerComponentScreen
import com.an.jetpackcomposesample.screen.TextFieldScreen
import com.an.jetpackcomposesample.screen.TextScreen
import com.an.jetpackcomposesample.screen.bottombar.MainBottomBarScreen
import com.an.jetpackcomposesample.screen.grid.GridScreen
import com.an.jetpackcomposesample.screen.list.ListScreen
import com.an.jetpackcomposesample.screen.tabs.MainTabScreen

@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.IntroScreen.route,
        modifier = modifier
    ) {
        composable(NavigationItem.IntroScreen.route) {
            IntroScreen(navController)
        }
        composable(NavigationItem.RowScreen.route) {
            RowScreen()
        }
        composable(NavigationItem.ColumnScreen.route) {
            ColumnScreen()
        }
        composable(NavigationItem.TextScreen.route) {
            TextScreen()
        }
        composable(NavigationItem.ButtonScreen.route) {
            ButtonScreen()
        }
        composable(NavigationItem.ImageScreen.route) {
            ImageScreen()
        }
        composable(NavigationItem.TextFieldScreen.route) {
            TextFieldScreen()
        }
        composable(NavigationItem.GridScreen.route) {
            GridScreen()
        }
        composable(NavigationItem.ListScreen.route) {
            ListScreen()
        }
        composable(NavigationItem.ScaffoldScreen.route) {
            ScaffoldScreen()
        }
        composable(NavigationItem.CardScreen.route) {
            CardScreen()
        }
        composable(NavigationItem.ProgressScreen.route) {
            ProgressBarScreen()
        }
        composable(NavigationItem.DialogScreen.route) {
            DialogScreen()
        }
        composable(NavigationItem.RadioScreen.route) {
            RadioButtonScreen()
        }
        composable(NavigationItem.CheckboxScreen.route) {
            CheckBoxScreen()
        }
        composable(NavigationItem.OthersScreen.route) {
            SmallerComponentScreen()
        }
        composable(NavigationItem.TabsScreen.route) {
            MainTabScreen()
        }
        composable(NavigationItem.BottomBarScreen.route) {
            MainBottomBarScreen()
        }
        composable(NavigationItem.ThemesScreen.route) {
            DynamicThemeScreen()
        }
    }
}