package com.an.jetpackcomposesample.screen.bottombar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.an.jetpackcomposesample.provider.NavigationItem
import com.an.jetpackcomposesample.ui.theme.Pink40
import com.an.jetpackcomposesample.ui.theme.Purple40
import com.an.jetpackcomposesample.ui.theme.PurpleGrey40
import com.an.jetpackcomposesample.ui.theme.PurpleGrey80

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val bottomBarList = listOf(
        NavigationItem.Updates,
        NavigationItem.Calls,
        NavigationItem.Home,
        NavigationItem.Chats,
        NavigationItem.Settings
    )
    var selectedItem by remember { mutableIntStateOf(0) }
    var currentRoute by remember { mutableStateOf(NavigationItem.Home.route) }

    bottomBarList.forEachIndexed { index, navigationItem ->
        if (navigationItem.route == currentRoute) {
            selectedItem = index
        }
    }

    NavigationBar(
        containerColor = PurpleGrey80,
        contentColor = Purple40,
    ) {
        bottomBarList.forEachIndexed { index, item ->
            NavigationBarItem(
                alwaysShowLabel = true,
                icon = {
                        Icon(
                            item.icon!!,
                            contentDescription = item.route
                        )
                },
                // uncomment this line if you want to add text to the bottom bar
//                label = {
//                    Text(
//                        item.route,
//                        overflow = TextOverflow.Ellipsis,
//                        maxLines = 1)
//                },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    currentRoute = item.route
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults
                    .colors(
                        selectedIconColor = Purple40,
                        unselectedIconColor = PurpleGrey40,
                        selectedTextColor = Purple40,
                        unselectedTextColor = Pink40,
                        indicatorColor = PurpleGrey80
                    )



            )

        }
    }
}