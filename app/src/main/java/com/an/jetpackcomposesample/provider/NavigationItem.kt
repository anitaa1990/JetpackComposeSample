package com.an.jetpackcomposesample.provider

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_BOTTOM_BAR
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_BUTTON
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_CALLS
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_CARD
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_CHATS
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_CHECKBOX
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_COLUMN
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_DIALOG
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_GRID
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_HOME
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_IMAGE
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_INTRO
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_LIST
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_NOTIFICATION
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_OTHERS
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_PROGRESS
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_RADIO
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_ROW
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_SCAFFOLD
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_SEARCH
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_SETTINGS
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_TAB
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_TEXT
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_TEXTFIELD
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_THEMES
import com.an.jetpackcomposesample.Constants.NAV_ROUTE_UPDATES

sealed class NavigationItem(
    var route: String,
    val icon: ImageVector? = null
) {
    data object Updates : NavigationItem(NAV_ROUTE_UPDATES, Icons.Default.Refresh)
    data object Calls : NavigationItem(NAV_ROUTE_CALLS, Icons.Default.Call)
    data object Home : NavigationItem(NAV_ROUTE_HOME, Icons.Default.Home)
    data object Chats : NavigationItem(NAV_ROUTE_CHATS, Icons.Default.Person)
    data object Settings : NavigationItem(NAV_ROUTE_SETTINGS, Icons.Default.Settings)
    data object Notification : NavigationItem(NAV_ROUTE_NOTIFICATION, Icons.Default.Notifications)

    data object IntroScreen: NavigationItem(NAV_ROUTE_INTRO)
    data object RowScreen: NavigationItem(NAV_ROUTE_ROW)
    data object ColumnScreen: NavigationItem(NAV_ROUTE_COLUMN)
    data object TextScreen: NavigationItem(NAV_ROUTE_TEXT)
    data object ButtonScreen: NavigationItem(NAV_ROUTE_BUTTON)
    data object ImageScreen: NavigationItem(NAV_ROUTE_IMAGE)
    data object TextFieldScreen: NavigationItem(NAV_ROUTE_TEXTFIELD)
    data object GridScreen: NavigationItem(NAV_ROUTE_GRID)
    data object ListScreen: NavigationItem(NAV_ROUTE_LIST)
    data object ScaffoldScreen: NavigationItem(NAV_ROUTE_SCAFFOLD)
    data object CardScreen: NavigationItem(NAV_ROUTE_CARD)
    data object ProgressScreen: NavigationItem(NAV_ROUTE_PROGRESS)
    data object DialogScreen: NavigationItem(NAV_ROUTE_DIALOG)
    data object RadioScreen: NavigationItem(NAV_ROUTE_RADIO)
    data object CheckboxScreen: NavigationItem(NAV_ROUTE_CHECKBOX)
    data object OthersScreen: NavigationItem(NAV_ROUTE_OTHERS)
    data object TabsScreen: NavigationItem(NAV_ROUTE_TAB)
    data object BottomBarScreen: NavigationItem(NAV_ROUTE_BOTTOM_BAR)
    data object ThemesScreen: NavigationItem(NAV_ROUTE_THEMES)
    data object SearchScreen: NavigationItem(NAV_ROUTE_SEARCH)
}