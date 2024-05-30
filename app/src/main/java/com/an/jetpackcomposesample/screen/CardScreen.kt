package com.an.jetpackcomposesample.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.an.jetpackcomposesample.R
import com.an.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme
import com.an.jetpackcomposesample.ui.theme.Pink40
import com.an.jetpackcomposesample.ui.theme.Purple60
import com.an.jetpackcomposesample.ui.theme.PurpleGrey40

@Composable
fun CardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 12.dp, top = 12.dp, end = 12.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = stringResource(R.string.card_screen_text),
            style = MaterialTheme.typography.titleLarge
        )

        CustomCardExample()
        SimpleCardExample()
        RectangleShapeCardExample()
        CircleShapeCardExample()
        CutCornerShapeCardExample()
        RoundedCornerShapeCardExample()
    }
}

@Composable
fun SimpleCardExample() {
    val paddingModifier  = Modifier.padding(8.dp)
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = paddingModifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Text(text = "Simple Card ",
            modifier = paddingModifier)
    }
}

@Composable
fun RectangleShapeCardExample() {
    val paddingModifier  = Modifier.padding(10.dp)
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = paddingModifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Text(text = "Rectangle Shape Card ",
            modifier = paddingModifier)
    }
}

@Composable
fun CircleShapeCardExample() {
    val paddingModifier  = Modifier.padding(10.dp)
    Card(
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = paddingModifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Text(text = "Circle Shape Card ",
            modifier = paddingModifier.padding(10.dp))
    }
}

@Composable
fun CutCornerShapeCardExample() {
    val paddingModifier  = Modifier.padding(10.dp)
    Card(
        shape = CutCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp, topStart = 8.dp, topEnd = 8.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = paddingModifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Text(text = "Cut corner shape Card ",
            modifier = paddingModifier)
    }
}

@Composable
fun RoundedCornerShapeCardExample() {
    val paddingModifier  = Modifier.padding(10.dp)
    Card(
        shape = RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp, topStart = 8.dp, topEnd = 8.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = paddingModifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Text(text = "Rounded Corner Card ",
            modifier = paddingModifier)
    }
}

@Composable
fun CustomCardExample() {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth().wrapContentHeight()
            .padding(bottom = 20.dp, top = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Purple60)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_image),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(10.dp)
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Column {
                Text(text = "Anitaa Murthy", color = PurpleGrey40)
                Text(text = "Android developer", color = Pink40)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardScreenPreview() {
    JetpackComposeSampleTheme {
        CardScreen()
    }
}