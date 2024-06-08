# Jetpack Compose Samples
<img src="https://github.com/anitaa1990/JetpackComposeSample/blob/master/media/img_jetpack_compose.png">

## Contents
- [What is Jetpack Compose?](#what-is-jetpack-compose)
- [Advantages of Jetpack Compose](#advantages-of-jetpack-compose)
- [Composable function](#composable-function)
- [State management in Compose](#state-management-in-compose)
- [Jetpack Compose Preview](#jetpack-compose-preview)
- [Rows](#rows)
- [Columns](#columns)
- [Box](#box)
- [Compose Modifiers](#compose-modifiers)
- [Text](#text)
- [Button](#button)
- [Image](#image)
- [TextField](#textfield)
- [Lazy Grids](#lazy-grids)
- [Lazy Lists](#lazy-lists)
- [Scaffold](#scaffold) (topAppBar, floatingActionButton, bottomBar)
- [Card](#card)
- [Progress Indicators](#progress-indicators)
- [Alert Dialog](#alert-dialog)
- [Custom Dialog](#custom-dialog)
- [DatePicker Dialog](#datepicker-dialog)
- [BottomSheet](#bottomsheet)
- [RadioButton](#radiobutton)
- [CheckBox](#checkbox)
- [Slider](#slider)
- [Switch](#switch)
- [Chips](#chips)
- [Tabs](#tabs)
- [BottomBar](#bottombar)
- [Dynamic themes](#dynamic-themes)
- [Switching between dark and light mode](#switching-between-dark-mode-and-light-mode)
- [Navigation in Compose](#nacigation-in-compose)

### What is Jetpack Compose?
Jetpack Compose is Android’s **recommended** modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Jetpack Compose is _declarative programming_, which means you can describe your user interface by invoking a set of composables, which is vastly different from the traditional way of imperative UI design.

### Advantages of Jetpack Compose
- Compose uses a declarative API, which means that all you need to do is describe your UI - Compose takes care of the rest. The APIs are intuitive - easy to discover and use.
- Compose is compatible with all your existing code: you can call Compose code from Views and Views from Compose.
- Compose allows you to do more with less code, compared to using the Android View system.
- With Composable functions, state can be handled reactively. When the state changes, only the parts of the UI that depend on this state are automatically and efficiently re-rendered. This is achieved through the use of state holders and observable state variables, which triggers the recomposition of the Composable functions they are used in.

### Composable function
A composable function is a modern way of developing UI in Android. It is a Kotlin function that is annotated with `@Composable`. This annotation tells the Compose compiler that the functions is meant for UI construction. Unlike tradition XML layouts in Android, Composable functions allow us to build UI with Kotlin code which is more intuitive and flexible. Composable functions can only be called from within the scope of other composable functions. We should think of composable functions to be similar to lego blocks - each composable function is in turn built up of smaller composable functions.
```
@Composable
fun HelloWorld(name: String) {
    Text(text = "Hello, $name!")
}
```

### State management in Compose
With Composable functions, state can be handled reactively. When the state changes, only the parts of the UI that depend on this state are automatically and efficiently re-rendered. This is achieved through the use of state holders and observable state variables, which triggers the recomposition of the Composable functions they are used in. Compose provides `State` (read-only) and `MutableState` (read-write).

There are two main ways to manage state in Jetpack Compose.
1. Stateful composables** are composables that manage their own state. This state is typically stored within the composable function itself, using tools provided by Jetpack Compose, such as `remember` or `mutableStateOf`. When the state changes, the composable recomposes itself, updating the UI with the new state.

```
var darkTheme by remember { mutableStateOf(false) }
```
2. **Stateless composables** are those that do not manage their own state internally. Instead, they receive their state through parameters and emit events to notify the parent composable of any changes. In the below example, the `SimpleButton` composable is stateless. It receives the text and onClick event through its parameters and does not manage any state.

```
@Composable
fun StatelessScreen() {
    val text = "Click me!"
    SimpleButton(text = text) { /* Handle click event */ }
}
```

### Jetpack Compose Preview
Compose comes with this nifty feature that lets you preview each component in the IntelliJ IDE itself, instead of needing to download the app to an Android device or emulator. To do so, we need to define `@Preview` to any of the `@Composable` methods and click on the preview button in the top right corner. The main restriction is, the composable function must not take any parameters. If your composable function requires a parameter, you can simply wrap your component inside another composable function that doesn't take any parameters and call your composable function with the appropriate params.

<img src="https://github.com/anitaa1990/JetpackComposeSample/blob/master/media/img_compose_preview.png">

### Rows
A row is a horizontal layout component in Jetpack Compose. It is used to position UI elements horizontally. You can add any number of children to a row, and they will be laid out horizontally in the order they were added. By default, the row will take up as much horizontal space as possible, and the children will be sized to fit within the row’s boundaries.

<img src="https://github.com/anitaa1990/JetpackComposeSample/blob/master/media/row/img_row_1.png" width="500"> <img src="https://github.com/anitaa1990/JetpackComposeSample/blob/master/media/row/img_row_2.png" width="500">

```
@Composable
private fun RowStyle(arrangement: Arrangement.Horizontal) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(MaterialTheme.colorScheme.inverseOnSurface, shape = RoundedCornerShape(10.dp)),
        horizontalArrangement  =  arrangement) {
        Text(
            text = "A"
        )
        Text(
            text = "B"
        )
        Text(
            text = "C"
        )
    }
}
```
Credits
-----------------
Author: Anitaa Murthy (murthyanitaa@gmail.com)

<a href="https://medium.com/@anitaa_1990">
  <img alt="Follow me on Medium"
       src="https://github.com/anitaa1990/JetpackComposeSample/blob/master/media/medium.png" width="40" />
</a>
<a href="https://www.linkedin.com/in/anitaa1990">
  <img alt="Follow me on LinkedIn"
       src="https://github.com/anitaa1990/JetpackComposeSample/blob/master/media/linkedin.png" width="40" />
</a>


License
-----------------

    Copyright 2024 Anitaa Murthy

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
