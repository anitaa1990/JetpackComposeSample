package com.an.jetpackcomposesample.screen.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.an.jetpackcomposesample.ui.theme.Pink40
import com.an.jetpackcomposesample.ui.theme.Pink80
import com.an.jetpackcomposesample.ui.theme.Purple40
import com.an.jetpackcomposesample.ui.theme.Purple60
import com.an.jetpackcomposesample.ui.theme.Purple80
import com.an.jetpackcomposesample.ui.theme.PurpleGrey40
import com.an.jetpackcomposesample.ui.theme.PurpleGrey80
import kotlin.random.Random

@Composable
fun GridScreen(modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(minSize = 180.dp),
        // applied to outside edges of our content – creating some visual space between the edges of the content and the container
        // contentPadding = PaddingValues(16.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        val gridList = (1..20).map {
            GridModel(it, getRandomColor(), getRandomHeight(), getRandomIcon())
        }
        items(gridList.size) {
            GridItem(modifier, gridList[it])
        }
    }
}

private val colorList = listOf(
    Purple40, Purple60, Purple80, PurpleGrey80, PurpleGrey40, Pink40, Pink80
)

private val iconList = listOf(
    Icons.Filled.Star,
    Icons.Filled.Home,
    Icons.Filled.Build,
    Icons.Filled.Favorite,
    Icons.Filled.Lock,
    Icons.Filled.LocationOn,
    Icons.Filled.Person,
    Icons.Filled.AccountBox,
    Icons.Filled.AccountCircle,
    Icons.Filled.Add,
    Icons.Filled.AddCircle,
    Icons.Filled.Call,
    Icons.Filled.Create,
    Icons.Filled.ShoppingCart,
    Icons.Filled.Delete
)

private fun getRandomColor() = (colorList[Random.nextInt(colorList.size)])
private fun getRandomIcon() = (iconList[Random.nextInt(iconList.size)])
private fun getRandomHeight() = (100 + Math.random() * (500 - 100)).dp

