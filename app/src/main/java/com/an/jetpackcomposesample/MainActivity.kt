package com.an.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.an.jetpackcomposesample.screen.MainApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * You can make your app display edge-to-edge—using the entire width and height of the
         * display—by drawing behind the system bars. The system bars are the status bar and the
         * navigation bar. By default, enableEdgeToEdge makes the system bars transparent, except
         * on 3-button navigation mode where the status bar gets a translucent scrim. The colors of
         * the system icons and the scrim are adjusted based on the system light or dark theme. The
         * enableEdgeToEdge method automatically declares that the app should be laid out
         * edge-to-edge and adjusts the colors of the system bars.
         */
        enableEdgeToEdge()

        /**
         * setContent is an extension function of Activity that sets the @Composable function that
         * is passed to it as the root view of the activity. This is meant to replace the .xml file
         * that we would typically set using the setContent(R.id.xml_file) method. The setContent
         * block defines the activity's layout.
         */
        setContent {
            /**
             * The NavController is the central API for the Navigation component. It is stateful
             * and keeps track of the back stack of composables that make up the screens in your app
             * and the state of each screen. You can create a NavController by using the
             * rememberNavController() method in your composable.
             */
            val navController = rememberNavController()
            MainApp(navController)
        }
    }
}

/**
 * Android Studio lets you preview your composable functions within the IDE itself, instead of
 * needing to download the app to an Android device or emulator. This is a fantastic feature as you
 * can preview all your custom components(read composable functions) from the comforts of the IDE.
 * The main restriction is, the composable function must not take any parameters. If your composable
 * function requires a parameter, you can simply wrap your component inside another composable
 * function that doesn't take any parameters and call your composable function with the appropriate
 * params. Also, don't forget to annotate it with @Preview & @Composable annotations.
 */
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainApp(navController)
}

