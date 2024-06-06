package com.an.jetpackcomposesample.screen.tabs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.an.jetpackcomposesample.ui.theme.Pink40
import com.an.jetpackcomposesample.ui.theme.Purple40
import com.an.jetpackcomposesample.ui.theme.PurpleGrey80
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainTabScreen(modifier: Modifier = Modifier) {
    val tabData = getTabList()

    // on below line we are creating variable for pager state.
    val pagerState = rememberPagerState { tabData.size }

    Column(modifier = modifier.fillMaxSize()) {
        TabLayout(tabData, pagerState)
        TabContent(pagerState)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout(
    tabData: List<Pair<String, ImageVector>>,
    pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 0.dp, // removes padding between the first pager item
        divider = {
            Spacer(modifier = Modifier.height(5.dp))
        },
        containerColor = PurpleGrey80,
        indicator = { tabPositions ->
            // we are specifying the styling for tab indicator by specifying color for the selected tab indicator
            if (pagerState.currentPage < tabPositions.size) {
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    color = Purple40
                )
            }
        },
        tabs = {
            tabData.forEachIndexed { index, data ->
                Tab(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    selected = pagerState.currentPage == index,
                    icon = {
                        Icon(
                            imageVector = data.second,
                            contentDescription = "Tab layout icon"
                        )
                    },
                    unselectedContentColor = Pink40,
                    selectedContentColor = Purple40,

                    // Uncomment if you don't want Text to the tab
                    text = {
                        Text(text = data.first, fontSize = 12.sp)
                    }
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabContent(pagerState: PagerState) {
    HorizontalPager(state = pagerState) { index ->
        when (index) {
            0 -> UpdatesScreen()
            1 -> CallsScreen()
            2 -> HomeScreen()
            3 -> ChatScreen()
            4 -> SettingsScreen()
            5 -> NotificationsScreen()
        }
    }
}

private fun getTabList(): List<Pair<String, ImageVector>> {
    return listOf(
        "Updates" to Icons.Default.Refresh,
        "Calls" to Icons.Default.Call,
        "Home" to Icons.Default.Home,
        "Chats" to Icons.Default.Person,
        "Settings" to Icons.Default.Settings,
        "Notifications" to Icons.Default.Notifications
    )
}