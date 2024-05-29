package com.an.jetpackcomposesample.screen.grid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun GridItem(
    modifier: Modifier = Modifier,
    item: GridModel
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(item.size)
            .background(item.color)
    ) {

        Icon(
            imageVector = item.icon,
            contentDescription = "",
            modifier = modifier.align(Alignment.Center),
            tint = Color.White
        )
    }
}