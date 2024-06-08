package com.an.jetpackcomposesample.screen

import android.os.Build
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.an.jetpackcomposesample.R
import com.an.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

@Composable
fun ImageScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.image_screen_text),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 12.dp, bottom = 12.dp)
        )

        TextHeading("Simple Image")
        SimpleImageExample()

        TextHeading("Circle Image")
        CircleImageExample()

        TextHeading("Round Corner Image")
        RoundCornerImageExample()

        TextHeading("Image with border")
        ImageWithBorderExample()

        TextHeading("Custom aspect ratio Image")
        CustomAspectRatioImageExample()

        TextHeading("Tint Image")
        TintImageExample()

        TextHeading("Blurred Image")
        BlurImageExample()
    }
}
@Composable
fun SimpleImageExample() {
    // Image is a pre-defined composable that lays out and draws a given [ImageBitmap]
    Image(
        painter = painterResource(id = R.drawable.ic_image),
        contentDescription = stringResource(id = R.string.image_screen_content_desc),
        modifier = Modifier
            .padding(10.dp)
            .size(120.dp)
    )
}

@Composable
fun CircleImageExample() {
    // To make an image fit into a shape, use the built-in clip modifier.
    // To crop an image into a circle shape, use Modifier.clip(CircleShape)
    Image(
        painter = painterResource(id = R.drawable.ic_image),
        contentDescription = stringResource(id = R.string.image_screen_content_desc),
        modifier = Modifier
            .padding(10.dp)
            .size(120.dp)
            .clip(CircleShape)
    )
}

@Composable
fun RoundCornerImageExample() {
    // Use Modifier.clip(RoundedCornerShape(16.dp)) with the size of the corners you want to be rounded.
    // You can also create your own clipping shape by extending Shape and providing a Path for the shape to clip around
    Image(
        painter = painterResource(id = R.drawable.ic_image),
        contentDescription = stringResource(id = R.string.image_screen_content_desc),
        modifier = Modifier
            .padding(10.dp)
            .size(120.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Composable
fun ImageWithBorderExample() {
    // Combine the Modifier.border() with Modifier.clip() to create a border around an image.
    // You can create a gradient border also by using the Brush API
    val borderWidth = 4.dp
    Image(
        painter = painterResource(id = R.drawable.ic_image),
        contentDescription = stringResource(id = R.string.image_screen_content_desc),
        modifier = Modifier
            .size(150.dp)
            .padding(10.dp)
            .border(BorderStroke(borderWidth, MaterialTheme.colorScheme.primary), CircleShape)
            .padding(borderWidth)
            .clip(CircleShape)
    )
}
@Composable
fun CustomAspectRatioImageExample() {
    Image(
        painter = painterResource(id = R.drawable.ic_image),
        contentDescription = stringResource(id = R.string.image_screen_content_desc),
        modifier = Modifier
            .size(120.dp)
            .aspectRatio(16f / 9f) // sets a custom ratio
    )
}

@Composable
fun TintImageExample() {
    // The Image composable has a colorFilter parameter that can change the output of individual pixels of your image.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        Image(
            painter = painterResource(id = R.drawable.ic_image),
            contentDescription = stringResource(id = R.string.image_screen_content_desc),
            modifier = Modifier
                .padding(10.dp)
                .size(120.dp),
            colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.Darken)
        )
    }
}

@Composable
fun BlurImageExample() {
    Image(
        painter = painterResource(id = R.drawable.ic_image),
        contentDescription = stringResource(id = R.string.image_screen_content_desc),
        modifier = Modifier
            .padding(10.dp)
            .size(120.dp)
            .blur(
                radiusX = 5.dp,
                radiusY = 5.dp,
                edgeTreatment = BlurredEdgeTreatment(CircleShape)
            )
    )
}

@Preview(showBackground = true)
@Composable
fun ImageScreenPreview() {
    JetpackComposeSampleTheme {
        ImageScreen()
    }
}