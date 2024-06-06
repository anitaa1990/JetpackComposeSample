package com.an.jetpackcomposesample.screen.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.an.jetpackcomposesample.ui.theme.Purple40

@Composable
fun UpdatesScreen() {
    Column { CenterText(text = "Updates") }
}

@Composable
fun CallsScreen() {
    Column { CenterText(text = "Calls") }
}

@Composable
fun HomeScreen() {
    Column { CenterText(text = "Home") }
}

@Composable
fun ChatScreen() {
    Column { CenterText(text = "Chats") }
}

@Composable
fun SettingsScreen() {
    Column { CenterText(text = "Settings") }
}

@Composable
fun NotificationsScreen() {
    Column { CenterText(text = "Notifications") }
}

@Composable
private fun CenterText(text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 32.sp,
            color = Purple40
        )
    }
}