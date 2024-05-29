package com.an.jetpackcomposesample.screen.grid

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp

data class GridModel(
    val id: Int,
    val color: Color,
    val size: Dp,
    val icon: ImageVector
)