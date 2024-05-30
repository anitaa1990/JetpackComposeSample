package com.an.jetpackcomposesample.screen.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.an.jetpackcomposesample.ui.theme.Pink40
import com.an.jetpackcomposesample.ui.theme.Purple60
import com.an.jetpackcomposesample.ui.theme.PurpleGrey40

@Composable
fun ListItem(
    item: ListModel,
    onClick: (item: ListModel)-> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Purple60)
            .clickable { onClick(item) }
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Column {
            Text(text = item.name, color = PurpleGrey40)
            Text(text = item.desc, color = Pink40)
        }
    }
}