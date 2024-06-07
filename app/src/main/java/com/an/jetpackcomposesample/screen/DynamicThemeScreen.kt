package com.an.jetpackcomposesample.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.an.jetpackcomposesample.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DynamicThemeScreen(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TouristCard(
            painterResource(id = R.drawable.persepolis),
            "Persepolis",
            "Persepolis was the ceremonial capital of the Achaemenid Empire. It is situated in the plains of Marvdasht, encircled by southern Zagros mountains, Fars province of Iran. It is one of the key Iranian Cultural heritages. The city of Shiraz is situated 60 km southwest of Persepolis. UNESCO declared the ruins of Persepolis a World Heritage Site in 1979."
        )
        TouristCard(
            painterResource(id = R.drawable.taj_mahal),
            "Taj Mahal",
            "The Taj Mahal is an ivory-white marble mausoleum on the right bank of the river Yamuna in Agra, Uttar Pradesh, India. It was commissioned in 1631 by the fifth Mughal emperor, Shah Jahan to house the tomb of his beloved wife, Mumtaz Mahal; it also houses the tomb of Shah Jahan himself."
        )
    }
}

@Composable
fun TouristCard(image: Painter, title: String, desc: String) {
    Box(
        modifier = Modifier
            .padding(14.dp)
            .wrapContentSize()
    ) {
        Card (
            modifier = Modifier
                .wrapContentHeight(),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Column (
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = image,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        blendMode = BlendMode.ColorBurn
                    )
                )
                Column (
                    modifier = Modifier
                        .padding(bottom = 12.dp, start = 10.dp, end = 10.dp, top = 12.dp)
                        .fillMaxWidth()
                ) {
                   Row(
                       modifier = Modifier.fillMaxWidth()
                           .padding(6.dp),
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Text(
                           text = title,
                           fontWeight = FontWeight.Bold,
                           fontSize = 18.sp,
                           color = MaterialTheme.colorScheme.onSecondaryContainer,
                           modifier = Modifier.weight(1f, true)
                       )
                       Button(
                           onClick = { /*TODO*/ },
                           shape = RoundedCornerShape(6.dp),
                           colors = ButtonDefaults.buttonColors(
                               containerColor = MaterialTheme.colorScheme.primary
                           )
                       ) {
                           Image(
                               imageVector = Icons.Filled.Favorite,
                               contentDescription ="",
                               modifier = Modifier.size(15.dp),
                               colorFilter = ColorFilter.tint(
                                   color = MaterialTheme.colorScheme.surface
                               )
                           )
                           Text(
                               text = "Liked",
                               modifier = Modifier.padding(start = 8.dp)
                           )
                       }
                   }
                    Text(
                        text = desc,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(6.dp),
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DynamicThemeScreenPreview() {
    DynamicThemeScreen()
}