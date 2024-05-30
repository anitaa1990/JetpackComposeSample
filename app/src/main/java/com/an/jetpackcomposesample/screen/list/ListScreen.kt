package com.an.jetpackcomposesample.screen.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.an.jetpackcomposesample.R

@Composable
fun ListScreen(modifier: Modifier = Modifier) {
    val list = listOf(
        ListModel(id = 1, image = R.drawable.ic_image, name = "Anitaa Murthy", desc = "Android developer"),
        ListModel(id = 2, image = R.drawable.ic_image, name = "Aakash Choudary", desc = "Product Lead"),
        ListModel(id = 3, image = R.drawable.ic_image, name = "Timothy Parker", desc = "Lead engineer"),
        ListModel(id = 4, image = R.drawable.ic_image, name = "Sweety Pie", desc = "Operations Manager"),
        ListModel(id = 5, image = R.drawable.ic_image, name = "Preethi Raj", desc = "Comms Lead"),
        ListModel(id = 6, image = R.drawable.ic_image, name = "Trisha Rani", desc = "Queen Bee"),
        ListModel(id = 7, image = R.drawable.ic_image, name = "Tejas Sri", desc = "iOS developer"),
        ListModel(id = 8, image = R.drawable.ic_image, name = "Landry Brown", desc = "Chief architect"),
        ListModel(id = 9, image = R.drawable.ic_image, name = "Leonard Hurst", desc = "Digital overload"),
        ListModel(id = 10, image = R.drawable.ic_image, name = "Maya Roy", desc = "Evangelist"),
        ListModel(id = 11, image = R.drawable.ic_image, name = "Paul McKee", desc = "Assistant Manager"),
        ListModel(id = 12, image = R.drawable.ic_image, name = "Margaret Vo", desc = "Marketing Lead")
    )

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier
            .fillMaxSize()
            .wrapContentHeight()
    ) {
        items(list.size) {
            ListItem(item = list[it])
        }
    }
}
