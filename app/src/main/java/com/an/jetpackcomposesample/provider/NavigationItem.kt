package com.an.jetpackcomposesample.provider

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_CALLS
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_CHATS
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_HOME
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_NOTIFICATION
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_SETTINGS
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_UPDATES

sealed class NavigationItem(
    var route: String,
    val icon: ImageVector?
) {
    object Updates : NavigationItem(NAV_ROUTE_UPDATES, Icons.Default.Refresh)
    object Calls : NavigationItem(NAV_ROUTE_CALLS, Icons.Default.Call)
    object Home : NavigationItem(NAV_ROUTE_HOME, Icons.Default.Home)
    object Chats : NavigationItem(NAV_ROUTE_CHATS, Icons.Default.Person)
    object Settings : NavigationItem(NAV_ROUTE_SETTINGS, Icons.Default.Settings)
    object Notification : NavigationItem(NAV_ROUTE_NOTIFICATION, Icons.Default.Notifications)
}