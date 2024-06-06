package com.an.jetpackcomposesample.provider

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.an.jetpackcomposesample.screen.tabs.CallsScreen
import com.an.jetpackcomposesample.screen.tabs.ChatScreen
import com.an.jetpackcomposesample.screen.tabs.HomeScreen
import com.an.jetpackcomposesample.screen.tabs.NotificationsScreen
import com.an.jetpackcomposesample.screen.tabs.SettingsScreen
import com.an.jetpackcomposesample.screen.tabs.UpdatesScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route
    ) {
        composable(NavigationItem.Updates.route) {
            UpdatesScreen()
        }
        composable(NavigationItem.Calls.route) {
            CallsScreen()
        }
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Chats.route) {
            ChatScreen()
        }
        composable(NavigationItem.Settings.route) {
            SettingsScreen()
        }
        composable(NavigationItem.Notification.route) {
            NotificationsScreen()
        }
    }
}