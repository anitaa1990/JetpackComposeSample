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
- [Button](#buttons)
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
- [Bottom Navigation Bar](#bottom-navigation-bar)
- [Dynamic themes](#dynamic-themes)
- [Switching between dark and light mode](#switching-between-dark-mode-and-light-mode)
- [Navigation in Compose](#navigation-in-compose)

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
A `Row` is a horizontal layout component in Jetpack Compose. It is used to position UI elements horizontally. You can add any number of children to a row, and they will be laid out horizontally in the order they were added. By default, the row will take up as much horizontal space as possible, and the children will be sized to fit within the row’s boundaries.

| Example                                                                        | Preview                                                                                       |
|--------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| [RowScreen](app/src/main/java/com/an/jetpackcomposesample/screen/RowScreen.kt) | <img src ="media/row/img_row_1.png" width=300><img src ="/media/row/img_row_2.png" width=300> |

```
@Composable
private fun RowStyle() {
    Row(
        modifier = Modifier
            // will set the min and max width of the composble to the maximum allowed by the container
            .fillMaxWidth()
            .padding(12.dp)
            .background(MaterialTheme.colorScheme.inverseOnSurface, shape = RoundedCornerShape(10.dp)),
        // The horizontalArrangement parameter controls the way free space is distributed between items.
        horizontalArrangement = Arrangement.Start)
{
        Text(text = "A")
        Text(text = "B")
        Text(text = "C")
    }
}
```

### Columns
A column is a vertical layout component in Jetpack Compose. It is used to position UI elements vertically. You can add any number of children to a column, and they will be laid out vertically in the order they were added. By default, the column will take up as much vertical space as possible, and the children will be sized to fit within the column’s boundaries.

| Example                                                                              | Preview                                                                                                   |
|--------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| [ColumnScreen](app/src/main/java/com/an/jetpackcomposesample/screen/ColumnScreen.kt) | <img src ="media/column/img_column_1.gif" width=300><img src ="/media/column/img_column_2.gif" width=300> |

```
@Composable
private fun ColumnStyle() {
    Column(modifier = Modifier
        .fillMaxHeight(0.5f)
        .fillMaxWidth()
        .padding(12.dp)
        .alpha(1f)
        .background(MaterialTheme.colorScheme.inverseOnSurface, shape = RoundedCornerShape(10.dp)),
        verticalArrangement = arrangement
    ) {
        Text(text = "A")
        Text(text = "B")
        Text(text = "C")
    }
}
```

### Box
A box is a layout component that allows you to position a single UI element anywhere within its boundaries. You can add any UI element to a box and position it by specifying its alignment within the box.
```
Box(
   modifier = Modifier.size(size),
   contentAlignment = Alignment.Center
) {
    Text("Center", Modifier.align(Alignment.Center))
    Text("Top Start", Modifier.align(Alignment.TopStart))
    Text("Top End", Modifier.align(Alignment.TopEnd))
    Text("Bottom Start", Modifier.align(Alignment.BottomStart))
    Text("Bottom End", Modifier.align(Alignment.BottomEnd))
 }
```

### Compose Modifiers
Modifier elements decorate or add behavior to Compose UI elements. For example, backgrounds, padding and click event listeners decorate or add behavior to rows, text or buttons. Modifiers are standard Kotlin objects. We can create a modifier by calling one of the `Modifier` class functions.
```
Text("Text with green background color",
    modifier = Modifier
                .background(color = Color.Green)) // background color
                .padding(16.dp) // inner padding
                .width(200.dp) // define width & height separately
                .height(300.dp)
                .size(width = 250.dp, height = 100.dp) // OR add size
                .alpha(0.5f) // 50% opacity
                .rotate(45f) // Sets the degrees the view is rotated around the center of the composable.
                .scale(scaleX = 2f, scaleY = 3f) // Scale the contents of the composable by the following scale factors along the horizontal and vertical axis respectively.
                .weight(1f) // you can specify a size ratio between multiple views
                .border(2.dp,Color.Red) // adds border to the text
                .clip(RoundedCornerShape(25.dp)) // allows you to clip the existing shape
```

### Text
`Text` is a central piece of any UI, and Jetpack Compose makes it easier to display or write text. Attributes of the `Text` composable include:
```
@Composable
fun Text(
    text: String,                                        // the text to be displayed
    modifier: Modifier = Modifier,                       // the Modifier to be applied to this layout node
    color: Color = Color.Unspecified,                    // Color to apply to the text
    fontSize: TextUnit = TextUnit.Unspecified,           // the size of glyphs to use when painting the text
    fontStyle: FontStyle? = null,                        // the typeface variant to use when drawing the letters (e.g., italic)
    fontWeight: FontWeight? = null,                      // the typeface thickness to use when painting the text
    fontFamily: FontFamily? = null,                      // the font family to be used when rendering the text
    letterSpacing: TextUnit = TextUnit.Unspecified,      // the amount of space to add between each letter
    textDecoration: TextDecoration? = null,              // the decorations to paint on the text (e.g., an underline)  
    textAlign: TextAlign? = null,                        // the alignment of the text within the lines of the paragraph
    lineHeight: TextUnit = TextUnit.Unspecified,         // line height for the Paragraph in TextUnit unit
    overflow: TextOverflow = TextOverflow.Clip,          // defines how visual overflow should be handled.  
    softWrap: Boolean = true,                            // whether the text should break at soft line breaks.
    maxLines: Int = Int.MAX_VALUE,                       // An optional maximum number of lines for the text to span, wrapping if necessary 
    minLines: Int = 1,                                   // The minimum height in terms of minimum number of visible lines.  
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,  // callback that is executed when a new text layout is calculated.   
    style: TextStyle = LocalTextStyle.current            // style configuration for the text such as color, font, line height etc.
)
```
| Example                                                                              | Preview                                                                                                   |
|--------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| [TextScreen](app/src/main/java/com/an/jetpackcomposesample/screen/TextScreen.kt) | <img src ="media/text/img_text_1.gif" width=300><img src ="/media/text/img_text_2.gif" width=300> |

### Buttons
Buttons are fundamental components that allow the user to trigger a defined action. In Jetpack Compose, you need to give two arguments for buttons. The first argument as `onClick` callback and another one is your button `text` element. You can add a `Text`-Composable or any other Composable as child elements of the Button. There are five types of buttons.

![](media/img_button_types.png)
*[Reference](https://developer.android.com/develop/ui/compose/components/button)*

```
@Composable
fun Button(
    onClick: () -> Unit,                                              // called when this button is clicked
    modifier: Modifier = Modifier,                                    // the [Modifier] to be applied to this button  
    enabled: Boolean = true,                                          // controls the enabled state of this button.
    shape: Shape = ButtonDefaults.shape,                              // defines the shape of this button's container, border (when [border] is not null), and shadow (when using [elevation])
    colors: ButtonColors = ButtonDefaults.buttonColors(),             // used to resolve the colors for this button in different states
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),   // used to resolve the elevation for this button in different states. This controls the size of the shadow below the button.
    border: BorderStroke? = null,                                    // the border to draw around the container of this button
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,   // the spacing values to apply internally between the container and the content
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }, 
    content: @Composable RowScope.() -> Unit
) {
    // Content of the Button
    Text(text = "Clicked me!")
}
```
| Example                                                                              | Preview                                                                                                   |
|--------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| [ButtonScreen](app/src/main/java/com/an/jetpackcomposesample/screen/ButtonScreen.kt) | <img src ="media/button/img_button_1.png" width=300><img src ="/media/button/img_button_2.png" width=300> |

### Image
We can use the `Image` composable to display a graphic on screen. The different attributes of `Image` are:
```
@Composable
fun Image(
    painter: Painter,     // loads a drawable from resources. Use painterResource and pass a resource id
    contentDescription: String?, // to give description about the image
    modifier: Modifier = Modifier, // defines the modifier for the image
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
)

// Example
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
```

| Example                                                                            | Preview                                                                                               |
|------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------|
| [ImageScreen](app/src/main/java/com/an/jetpackcomposesample/screen/ImageScreen.kt) | <img src ="media/image/img_image_1.gif" width=300><img src ="/media/image/img_image_2.gif" width=300> |

### TextField
`TextField` allows users to enter and modify text. The different attributes of `TextField` are:
```
@Composable
fun TextField(
    value: TextFieldValue,                      // the input value to be shown in the text field
    onValueChange: (TextFieldValue) -> Unit,    // the callback that is triggered when user enters any value
    modifier: Modifier = Modifier,              // defines the modifier for the TextField
    enabled: Boolean = true,                    // controls the enabled state of this text field
    readOnly: Boolean = false,                  // controls the editable state of the text field
    textStyle: TextStyle = LocalTextStyle.current,      // the style to be applied to the input text.
    label: @Composable (() -> Unit)? = null,            // the optional label to be displayed inside the text field container.
    placeholder: @Composable (() -> Unit)? = null,      // the optional placeholder to be displayed when the text field is empty
    leadingIcon: @Composable (() -> Unit)? = null,      // the optional leading icon to be displayed at the beginning of the text field container
    trailingIcon: @Composable (() -> Unit)? = null,     // the optional trailing icon to be displayed at the end of the text field container
    prefix: @Composable (() -> Unit)? = null,           // the optional prefix to be displayed before the input text in the text field
    suffix: @Composable (() -> Unit)? = null,           // the optional suffix to be displayed after the input text in the text field
    supportingText: @Composable (() -> Unit)? = null,   // the optional supporting text to be displayed below the text field
    isError: Boolean = false,                                       // indicates if the text field's current value is in error state.
    visualTransformation: VisualTransformation = VisualTransformation.None,             // transforms the visual representation of the input value
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,                         // software keyboard options that contains configuration such as KeyboardType and ImeAction
    keyboardActions: KeyboardActions = KeyboardActions.Default,                         // when the input service emits an IME action, the corresponding callback is called.
    singleLine: Boolean = false,                                    // this text field becomes a single horizontally scrolling text field instead of wrapping onto multiple lines.
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,           // the maximum height in terms of maximum number of visible lines
    minLines: Int = 1,                                              // the minimum height in terms of minimum number of visible lines
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },     
    shape: Shape = TextFieldDefaults.shape,                         // defines the shape of this text field's container
    colors: TextFieldColors = TextFieldDefaults.colors()            // [TextFieldColors] that will be used to resolve the colors used for this text field in different states.
)

// Example
TextField(
    value = password,
    onValueChange = { password = it },
    label = { Text("Enter password") },
    visualTransformation = PasswordVisualTransformation(),
    keyboardOptions = KeyboardOptions(
    keyboardType = KeyboardType.Password,
    imeAction = ImeAction.Done
    )
) 
```

| Example                                                                                    | Preview                                                                                                               |
|--------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| [TextFieldScreen](app/src/main/java/com/an/jetpackcomposesample/screen/TextFieldScreen.kt) | <img src ="media/textfield/img_textfield_1.png" width=300><img src ="/media/textfield/img_textfield_2.png" width=300> |

### Lazy Grids
Vertical staggered grid layout that composes and lays out only items currently visible on screen. Attributes of `Grid` include:
```
@Composable
fun LazyVerticalStaggeredGrid(
    columns: StaggeredGridCells,                                        // description of the size and number of staggered grid columns.
    modifier: Modifier = Modifier,                                      // modifier to apply to the layout.
    state: LazyStaggeredGridState = rememberLazyStaggeredGridState(),   // state object that can be used to control and observe staggered grid state.
    contentPadding: PaddingValues = PaddingValues(0.dp),                // padding around the content.
    reverseLayout: Boolean = false,                                     // reverse the direction of scrolling and layout. When `true`, items are laid out in the reverse order
    verticalItemSpacing: Dp = 0.dp,                                     // vertical spacing between items    
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(0.dp),         // arrangement specifying horizontal spacing between items.
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),                  // logic responsible for handling fling.
    userScrollEnabled: Boolean = true,                                  // whether scroll with gestures or accessibility actions are allowed.
    content: LazyStaggeredGridScope.() -> Unit                          // a lambda describing the staggered grid content. Inside this block you can use [LazyStaggeredGridScope.items] to present list of items
)

// Example
LazyVerticalStaggeredGrid(
    columns = StaggeredGridCells.Adaptive(minSize = 180.dp),
    // applied to outside edges of our content – creating some visual space between the edges of the content and the container
    // contentPadding = PaddingValues(16.dp),
    // horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val gridList = (1..20).map {
            GridModel(it, getRandomColor(), getRandomHeight(), getRandomIcon())
        }
        items(gridList.size) {
            GridItem(modifier, gridList[it])
        }
 }
```

| Example                                                                               | Preview                                                                                           |
|---------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| [GridScreen](app/src/main/java/com/an/jetpackcomposesample/screen/grid/GridScreen.kt) | <img src ="media/grid/img_grid_1.gif" width=300> |

### Lazy Lists
Compose provides a set of components which only compose and lay out items which are visible in the component’s viewport. These components include `LazyColumn` (Vertical `RecyclerView`) and `LazyRow` (Horizontal `RecyclerView`). In LazyColumn you can add an `item()` or `items()`.
```
@Composable
fun LazyColumn(
    modifier: Modifier = Modifier,                                          // the modifier to apply to this layout.
    state: LazyListState = rememberLazyListState(),                         // the state object to be used to control or observe the list's state.
    contentPadding: PaddingValues = PaddingValues(0.dp),                    // a padding around the whole content.
    reverseLayout: Boolean = false,                                         // reverse the direction of scrolling and layout.
    verticalArrangement: Arrangement.Vertical =
        if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,        // The vertical arrangement of the layout's children. This allows to add a spacing between items and specify the arrangement of the items when we have not enough of them to fill the whole minimum size.
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,            // the horizontal alignment applied to the items.
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),      // logic describing fling behavior.
    userScrollEnabled: Boolean = true,                                      // whether the scrolling via the user gestures or accessibility actions is allowed. 
    content: LazyListScope.() -> Unit                                       // a block which describes the content 
)

// Example
LazyColumn(
     contentPadding = PaddingValues(16.dp),
     verticalArrangement = Arrangement.spacedBy(6.dp),
     modifier = modifier.fillMaxSize().wrapContentHeight()
) {
        // items is a DSL available in the LazyColumn scope. This allows you to render a composable
        // for a single element in the list.
        items(list.size) {
            ListItem(item = list[it], onClick = { listModel ->
                Toast.makeText(context, listModel.name +  " clicked!", Toast.LENGTH_SHORT).show()
            })
        }
}
```

| Example                                                                               | Preview                                                                                           |
|---------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| [ListScreen](app/src/main/java/com/an/jetpackcomposesample/screen/list/ListScreen.kt) | <img src ="media/list/img_list_1.png" width=300><img src ="/media/list/img_list_2.png" width=300> |

### Scaffold
The `Scaffold` composable provides a straightforward API you can use to quickly assemble your app's structure according to Material Design guidelines. `Scaffold` accepts several composables as parameters.
```
@Composable
fun Scaffold(
    modifier: Modifier = Modifier,                              // the modifier to apply to this layout. 
    topBar: @Composable () -> Unit = {},                        // top app bar of the screen
    bottomBar: @Composable () -> Unit = {},                     // bottom bar of the screen
    snackbarHost: @Composable () -> Unit = {},                  // component to host Snackbars that are pushed to be shown via SnackbarHostState.showSnackbar
    floatingActionButton: @Composable () -> Unit = {},              // Main action button of the screen
    floatingActionButtonPosition: FabPosition = FabPosition.End,        // position of the FAB on the screen
    containerColor: Color = MaterialTheme.colorScheme.background,       // the color used for the background of this scaffold.
    contentColor: Color = contentColorFor(containerColor),              // the preferred color for content inside this scaffold.
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,       // window insets to be passed to content slot via PaddingValues params.
    content: @Composable (PaddingValues) -> Unit                // content of the screen
)
    
// Example
Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
                onClick = { Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show() }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
)    
```

| Example                                                                                  | Preview                                                                                                           |
|------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| [ScaffoldScreen](app/src/main/java/com/an/jetpackcomposesample/screen/ScaffoldScreen.kt) | <img src ="media/scaffold/img_scaffold_1.png" width=300><img src ="/media/scaffold/img_scaffold_2.png" width=300> |


### Card
`Card` composable is a predefined composable that is meant to represent the card surface as specified by the Material Design specification. We also configure it to have rounded corners and apply a modifier. Attributes of `Card` composable includes:
```
@Composable
fun Card(
    modifier: Modifier = Modifier,                    // the Modifier to be applied to this card
    shape: Shape = CardDefaults.shape,                // defines the shape of this card's container, border (when border is not null), and shadow (when using elevation)
    colors: CardColors = CardDefaults.cardColors(),    //  CardColors that will be used to resolve the colors used for this card in different states.
    elevation: CardElevation = CardDefaults.cardElevation(),        // This controls the size of the shadow below the card.
    border: BorderStroke? = null,                      // the border to draw around the container of this card  
    content: @Composable ColumnScope.() -> Unit        // define content of the card
)

// Example
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
```

| Example                                                                          | Preview                                                                                           |
|----------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| [CardScreen](app/src/main/java/com/an/jetpackcomposesample/screen/CardScreen.kt) | <img src ="media/card/img_card_1.png" width=300><img src ="/media/card/img_card_2.png" width=300> |

### Progress Indicators
Progress indicators visually surface the status of an operation. They use motion to bring to the user's attention how near completion the process is, such as loading or processing data. There are 2 types of Progress indicators: `LinearProgressIndicator` & `CircularProgressIndicator`. Attributes of `LinearProgressIndicator` includes:
```
@Composable
fun LinearProgressIndicator(
    modifier: Modifier = Modifier,                                         // the Modifier to be applied to this progress indicator
    color: Color = ProgressIndicatorDefaults.linearColor,                 // color of this progress indicator 
    trackColor: Color = ProgressIndicatorDefaults.linearTrackColor,        // color of the track behind the indicator, visible when the progress has not reached the area of the overall indicator yet
    strokeCap: StrokeCap = ProgressIndicatorDefaults.LinearStrokeCap,      // stroke cap to use for the ends of this progress indicator
)

// Example of LinearProgressIndicator
LinearProgressIndicator(
        modifier = Modifier.fillMaxWidth().height(8.dp),
        trackColor = MaterialTheme.colorScheme.secondaryContainer,
        color = MaterialTheme.colorScheme.primary, //progress color
    )
}

// Example of CircularProgressIndicator
CircularProgressIndicator(
        trackColor = MaterialTheme.colorScheme.primary,
        color = MaterialTheme.colorScheme.secondaryContainer //progress color
)
```

| Example                                                                                        | Preview                                                                                                           |
|------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| [ProgressBarScreen](app/src/main/java/com/an/jetpackcomposesample/screen/ProgressBarScreen.kt) | <img src ="media/progress/img_progress_1.png" width=300><img src ="/media/progress/img_progress_2.png" width=300> |

### Alert Dialog
The `AlertDialog` composable provides a convenient API for creating a Material Design themed dialog. `AlertDialog` has specific parameters for handling particular elements of the dialog.
```
@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit,               // called when the user tries to dismiss the Dialog by clicking outside or pressing the back button. This is not called when the dismiss button is clicked.
    confirmButton: @Composable () -> Unit,      // button which is meant to confirm a proposed action
    modifier: Modifier = Modifier,              // the Modifier to be applied to this dialog
    dismissButton: @Composable (() -> Unit)? = null,        // button which is meant to dismiss the dialog
    icon: @Composable (() -> Unit)? = null,     // optional icon that will appear above the title or above the text.
    title: @Composable (() -> Unit)? = null,    // title which should specify the purpose of the dialog.
    text: @Composable (() -> Unit)? = null,     // text which presents the details regarding the dialog's purpose.
    shape: Shape = AlertDialogDefaults.shape,   // defines the shape of this dialog's container
    containerColor: Color = AlertDialogDefaults.containerColor,         // the color used for the background of this dialog.
    iconContentColor: Color = AlertDialogDefaults.iconContentColor,     // the content color used for the icon.
    titleContentColor: Color = AlertDialogDefaults.titleContentColor,   // the content color used for the title.
    textContentColor: Color = AlertDialogDefaults.textContentColor,     // the content color used for the text.
    tonalElevation: Dp = AlertDialogDefaults.TonalElevation,            // when containerColor is ColorScheme.surface, a translucent primary color overlay is applied on top of the container.
    properties: DialogProperties = DialogProperties()               // typically platform specific properties to further configure the dialog.
)


// Example of AlertDialog
AlertDialog(
        icon = {
            Icon(Icons.Filled.Info, contentDescription = "Info Icon", tint = MaterialTheme.colorScheme.secondaryContainer)
        },
        title = {
            Text(text = "Dialog with info icon")
        },
        text = {
            Text(text = "The Dialog component displays pop up messages or requests user input on a layer above the main app content. It creates an interruptive UI experience to capture user attention.")
        },
        onDismissRequest = { },
        confirmButton = {
            TextButton(
                onClick = { showAlertDialog.value = false }
            ) {
                Text("Confirm", color = MaterialTheme.colorScheme.primary)
            }
        },
        dismissButton = {
            TextButton(
                onClick = { showAlertDialog.value = false }
            ) {
                Text("Dismiss", color = MaterialTheme.colorScheme.primary)
            }
        }
)
```

| Example                                                                              | Preview                                                                                                                         |
|--------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| [DialogScreen](app/src/main/java/com/an/jetpackcomposesample/screen/DialogScreen.kt) | <img src ="media/alertdialog/img_alert_dialog_1.png" width=300><img src ="/media/alertdialog/img_alert_dialog_2.png" width=300> |

### Custom Dialog
`Dialog` is a basic composable that doesn't provide any styling or predefined slots for content. It is a relatively straightforward container that you should populate with a container such as `Card`.
```
@Composable
fun Dialog(
    onDismissRequest: () -> Unit,                       // Executes when the user tries to dismiss the dialog.
    properties: DialogProperties = DialogProperties(),  // for further customization of this dialog's behavior.
    content: @Composable () -> Unit                     // The content to be displayed inside the dialog.
)

// Example of Dialog
Dialog(onDismissRequest = { showCustomDialog.value = false }) {
    Card(
          elevation = CardDefaults.cardElevation(8.dp),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp, top = 20.dp)
    ) {
         Column(
             horizontalAlignment = Alignment.CenterHorizontally,
             modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
                    .padding(16.dp)
            ) {
                Icon(Icons.Filled.Info, contentDescription = "Info Icon", tint = MaterialTheme.colorScheme.secondaryContainer)
                    Column(modifier = Modifier.padding(16.dp).fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                 Text(
                        text = "Dialog with info icon",
                        style = TextStyle(fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, fontSize = 18.sp)
                    )
                 Text(
                        modifier = Modifier.padding(top = 10.dp),
                        textAlign = TextAlign.Center,
                        text = "This Dialog is an example of a custom dialog with the Dialog Composable"
                    )
                }
                TextButton(
                    onClick = { showCustomDialog.value = false }
                ) {
                    Text("Confirm", color = MaterialTheme.colorScheme.primary)
                }
                TextButton(
                    onClick = { showCustomDialog.value = false }
                ) {
                    Text("Dismiss", color = MaterialTheme.colorScheme.primary)
                }
            }
     }
 }
```

| Example                                                                              | Preview                                                                                                                             |
|--------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------|
| [DialogScreen](app/src/main/java/com/an/jetpackcomposesample/screen/DialogScreen.kt) | <img src ="media/customdialog/img_custom_dialog_1.png" width=300><img src ="/media/customdialog/img_custom_dialog_2.png" width=300> |

## DatePicker Dialog
The `DatePicker` composable is designed to display a full-screen view of the `DatePicker`. It offers a range of features, including date validation, which allows you to disable future dates or implement custom logic based on your requirements. To enable date validation, you’ll need to provide your own implementation of the SelectableDates interface. We can use the `DatePickerDialog` composable to create a wrapper around `DatePicker` where you can pass your own **Ok** button, **Cancel** button composables.

```
@Composable
fun DatePickerDialog(
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    dismissButton: @Composable (() -> Unit)? = null,
    shape: Shape = DatePickerDefaults.shape,
    tonalElevation: Dp = DatePickerDefaults.TonalElevation,
    colors: DatePickerColors = DatePickerDefaults.colors(),
    properties: DialogProperties = DialogProperties(usePlatformDefaultWidth = false),
    content: @Composable ColumnScope.() -> Unit
)

// Example of DatePickerDialog
DatePickerDialog(
    onDismissRequest = { showDatePickerDialog.value = false },
    confirmButton = {
          TextButton(
                onClick = { showDatePickerDialog.value = false }
            ) {
                Text("Confirm", color = MaterialTheme.colorScheme.primary)
            }
    },
    dismissButton = {
          TextButton(
                onClick = { showDatePickerDialog.value = false }
          ) {
                Text(text = "Cancel", color = MaterialTheme.colorScheme.primary)
          }
    }) {
    DatePicker(
          state = dateState,
          showModeToggle = true
    )
}
```

| Example                                                                              | Preview                                                                                                                   |
|--------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| [DialogScreen](app/src/main/java/com/an/jetpackcomposesample/screen/DialogScreen.kt) | <img src ="media/datepicker/img_datepicker_1.png" width=300><img src ="/media/datepicker/img_datepicker_2.png" width=300> |

### BottomSheet
Modal bottom sheets are used as an alternative to inline menus or simple dialogs on mobile, especially when offering a long list of action items, or when items require longer descriptions and icons. Like dialogs, modal bottom sheets appear in front of app content, disabling all other app functionality when they appear, and remaining on screen until confirmed, dismissed, or a required action has been taken.
```
@Composable
@ExperimentalMaterial3Api
fun ModalBottomSheet(
    onDismissRequest: () -> Unit,                                       // Executes when the user clicks outside of the bottom sheet   
    modifier: Modifier = Modifier,                                      // Optional Modifier for the bottom sheet
    sheetState: SheetState = rememberModalBottomSheetState(),               // The state of the bottom sheet.
    sheetMaxWidth: Dp = BottomSheetDefaults.SheetMaxWidth,                  // defines what the maximum width the sheet will take.
    shape: Shape = BottomSheetDefaults.ExpandedShape,                       // The shape of the bottom sheet
    containerColor: Color = BottomSheetDefaults.ContainerColor,             // The color used for the background of this bottom sheet
    contentColor: Color = contentColorFor(containerColor),                  // The preferred color for content inside this bottom sheet
    tonalElevation: Dp = BottomSheetDefaults.Elevation,                     // The tonal elevation of this bottom sheet.
    scrimColor: Color = BottomSheetDefaults.ScrimColor,                             // Color of the scrim that obscures content when the bottom sheet is open.
    dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },       // Optional visual marker to swipe the bottom sheet
    windowInsets: WindowInsets = BottomSheetDefaults.windowInsets,                      // window insets to be passed to the bottom sheet window
    properties: ModalBottomSheetProperties = ModalBottomSheetDefaults.properties(),     // for further customization of this modal bottom sheet's behavior.    
    content: @Composable ColumnScope.() -> Unit,                                        // The content to be displayed inside the bottom sheet.
)

// Example of BottomSheet
val modalBottomSheetState = rememberModalBottomSheetState()

ModalBottomSheet(
        onDismissRequest = { showBottomSheet.value = false },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
) {
    LazyColumn {
        items(countries.size) {
            Row(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 20.dp)
                clickable {
                      Toast.makeText(context, countries[it].first+ " Clicked", Toast.LENGTH_SHORT).show()
                      showBottomSheet.value = false
                  }
                ) {
                Text(
                    text = countries[it].second,
                    modifier = Modifier.padding(end = 20.dp, top = 5.dp, bottom = 5.dp)
                )
               Text(text = countries[it].first)
            }
        }
    }
}
```

| Example                                                                              | Preview                                                                                                                       |
|--------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------|
| [DialogScreen](app/src/main/java/com/an/jetpackcomposesample/screen/DialogScreen.kt) | <img src ="media/bottomsheet/img_bottomsheet_1.png" width=300><img src ="/media/bottomsheet/img_bottomsheet_2.png" width=300> |

### RadioButton
Radio buttons allow users to select one option from a set. RadioButton can be combined together with `Text` in the desired layout to achieve radio group-like behaviour, where the entire layout is selectable. Attributes of `RadioButton` composable include:
```
@Composable
fun RadioButton(
    selected: Boolean,                                      // whether this radio button is selected or not
    onClick: (() -> Unit)?,                                 // called when this radio button is clicked.
    modifier: Modifier = Modifier,                          // modifier of the radio button
    enabled: Boolean = true,                                // controls the enabled state of this radio button.
    colors: RadioButtonColors = RadioButtonDefaults.colors(),           // RadioButtonColors that will be used to resolve the color used for this radio button in different states
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
)

// Example
RadioButton(
      selected = (country == selectedOption),
      onClick = { selectedOption = country },
      colors = RadioButtonDefaults.colors(
                  selectedColor = MaterialTheme.colorScheme.primary,
                  unselectedColor = MaterialTheme.colorScheme.secondaryContainer
          )
      )
      Text(
           text = country,
           style = MaterialTheme.typography.bodyLarge
      )
)
```

| Example                                                                                        | Preview                                                                                               |
|------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------|
| [RadioButtonScreen](app/src/main/java/com/an/jetpackcomposesample/screen/RadioButtonScreen.kt) | <img src ="media/radio/img_radio_1.png" width=300><img src ="/media/radio/img_radio_2.png" width=300> |


### CheckBox
Checkboxes allow users to select one or more items from a set. Checkboxes can turn an option on or off. Attributes of `CheckBox` include:
```
@Composable
fun Checkbox(
    checked: Boolean,                                   // whether this checkbox is checked or unchecked
    onCheckedChange: ((Boolean) -> Unit)?,              // called when this checkbox is clicked.        
    modifier: Modifier = Modifier,                      // modifier of the checkbox    
    enabled: Boolean = true,                            // controls the enabled state of this checkbox.
    colors: CheckboxColors = CheckboxDefaults.colors(),         // CheckboxColors that will be used to resolve the colors used for this checkbox in different states
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
)

// Example
Checkbox(
    checked = (country == checkedOption ),
    onCheckedChange = { checkedOption = country },
    colors = CheckboxDefaults.colors(
              checkedColor = MaterialTheme.colorScheme.secondaryContainer,
              uncheckedColor = MaterialTheme.colorScheme.primary
    )
)
```

| Example                                                                                  | Preview                                                                                                           |
|------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| [CheckBoxScreen](app/src/main/java/com/an/jetpackcomposesample/screen/CheckBoxScreen.kt) | <img src ="media/checkbox/img_checkbox_1.png" width=300><img src ="/media/checkbox/img_checkbox_2.png" width=300> |

### Slider
Sliders allow users to make selections from a range of values. Sliders reflect a range of values along a bar, from which users may select a single value. They are ideal for adjusting settings such as volume, brightness, or applying image filters. Attributes of `Slider` includes:
```
@Composable
fun Slider(
    value: Float,                                           // current value of the slider.
    onValueChange: (Float) -> Unit,                         // callback in which value should be updated    
    modifier: Modifier = Modifier,                          // the Modifier to be applied to this slider
    enabled: Boolean = true,                                // controls the enabled state of this slider
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,       // range of values that this slider can take.
    @IntRange(from = 0)                                         // range of values that this slider can take. 
    steps: Int = 0,                                         // if greater than 0, specifies the amount of discrete allowable values, evenly distributed across the whole value range. 
    onValueChangeFinished: (() -> Unit)? = null,            // called when value change has ended
    colors: SliderColors = SliderDefaults.colors(),         // SliderColors that will be used to resolve the colors used for this slider in different states
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
)

// Example
Slider(
     value = sliderPosition,
     onValueChange = { sliderPosition = it },
     colors = SliderDefaults.colors(
           thumbColor = MaterialTheme.colorScheme.primary,
           activeTrackColor = MaterialTheme.colorScheme.primary,
           inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
      ),
      steps = 5,
      valueRange = 0f..100f
)
```
| Example                                                                                                  | Preview                                                                                                   |
|----------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| [SmallerComponentScreen](app/src/main/java/com/an/jetpackcomposesample/screen/SmallerComponentScreen.kt) | <img src ="media/slider/img_slider_1.png" width=300><img src ="/media/slider/img_slider_2.png" width=300> |

### Switch
A pre-defined composable that's capable of rendering a switch.
```
@Composable
fun Switch(
    checked: Boolean,                                   // whether or not this switch is checked
    onCheckedChange: ((Boolean) -> Unit)?,              // called when this switch is clicked
    modifier: Modifier = Modifier,                      // the Modifier to be applied to this switch
    thumbContent: (@Composable () -> Unit)? = null,        // content that will be drawn inside the thumb 
    enabled: Boolean = true,                            // controls the enabled state of this switch
    colors: SwitchColors = SwitchDefaults.colors(),         // SwitchColors that will be used to resolve the colors used for this switch in different states
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)

// Example
var checked by remember { mutableStateOf(true) }
Switch(
       checked = checked,
       onCheckedChange = { checked = it },
       thumbContent = if (checked) {
      {
             Icon(
                  imageVector = Icons.Filled.Check,
                  contentDescription = null,
                  modifier = Modifier.size(SwitchDefaults.IconSize),
             )
       }
    } else {
             null
    }
)
```

| Example                                                                                                  | Preview                                                                                                   |
|----------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| [SmallerComponentScreen](app/src/main/java/com/an/jetpackcomposesample/screen/SmallerComponentScreen.kt) | <img src ="media/slider/img_slider_1.png" width=300><img src ="/media/slider/img_slider_2.png" width=300> |

### Chips
Chips help people enter information, make selections, filter content, or trigger actions. Chips can show multiple interactive elements together in the same area, such as a list of selectable movie times, or a series of email contacts. The four types of chips and where you might use them are as follows:
- Assist: Guides the user during a task. Often appears as a temporary UI element in response to user input.
- Filter: Allows users to refine content from a set of options. They can be selected or deselected, and may include a checkmark icon when selected.
- Input: Represents user-provided information, such as selections in a menu. They can contain an icon and text, and provide an 'X' for removal.
- Suggestion: Provides recommendations to the user based on their recent activity or input. Typically appear beneath an input field to prompt user actions.
  These components share the following attributes:

```
@Composable
private fun Chip(
    modifier: Modifier,
    onClick: () -> Unit,
    enabled: Boolean,
    label: @Composable () -> Unit,
    labelTextStyle: TextStyle,
    labelColor: Color,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    shape: Shape,
    colors: ChipColors,
    elevation: ChipElevation?,
    border: BorderStroke?,
    minHeight: Dp,
    paddingValues: PaddingValues,
    interactionSource: MutableInteractionSource,
)

// AssisChip example
AssistChip(
   onClick = {  },
   label = {
      Text(text = "Assist chip", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
   },
   border = BorderStroke(width = 3.dp, color = MaterialTheme.colorScheme.primary),
   leadingIcon = {
            Icon(Icons.Filled.Settings, contentDescription = "Settings", Modifier.size(AssistChipDefaults.IconSize), tint = MaterialTheme.colorScheme.primary)
   }
)

// FilterChip example
FilterChip(
    onClick = { selectedFilter = !selectedFilter },
    border = FilterChipDefaults.filterChipBorder(
       enabled = true,
       selected = false,
       borderColor = MaterialTheme.colorScheme.primary,
       selectedBorderColor = MaterialTheme.colorScheme.secondaryContainer
    ),
    colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer),
    label = {
            Text(text = "Filter chip", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
    },
    selected = selectedFilter,
    leadingIcon = {
            Icon(imageVector = filterLeadingIcon, contentDescription = "Leading icon", modifier = Modifier.size(FilterChipDefaults.IconSize), tint = MaterialTheme.colorScheme.primary)
    },
)

// InputChip example
InputChip(
   onClick = {  },
   label = {
            Text(text = "Input chip", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
   },
    border = FilterChipDefaults.filterChipBorder(
         enabled = true,
         selected = false,
         borderColor = MaterialTheme.colorScheme.primary,
         selectedBorderColor = MaterialTheme.colorScheme.secondaryContainer
    ),
    colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer),
    selected = enabled,
    avatar = {
            Icon(Icons.Filled.Person, contentDescription = "Input Chip person icon", Modifier.size(InputChipDefaults.AvatarSize), tint = MaterialTheme.colorScheme.primary)
    },
    trailingIcon = {
            Icon(Icons.Default.Close, contentDescription = "Input Chip close icon", Modifier.size(InputChipDefaults.AvatarSize), tint = MaterialTheme.colorScheme.primary)
     },
)

// SuggestionChip example
SuggestionChip(
    onClick = { Toast.makeText(context, "Suggestion clicked!", Toast.LENGTH_SHORT).show() },
    border = BorderStroke(width = 3.dp, color = MaterialTheme.colorScheme.primary),
    label = {
          Text(text = "Suggestion chip", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
    }
)
```

| Example                                                                                                  | Preview                                                                                                   |
|----------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| [SmallerComponentScreen](app/src/main/java/com/an/jetpackcomposesample/screen/SmallerComponentScreen.kt) | <img src ="media/slider/img_slider_1.png" width=300><img src ="/media/slider/img_slider_2.png" width=300> |

### Tabs
Tab layouts are a common navigation component in mobile app development. We can use the `TabRow` composable to create Tabs and `ScrollableTabRow` for scrollable tabs. Attributes of `TabRow` include:
```
@Composable
fun ScrollableTabRow(
    selectedTabIndex: Int,                          // the index of the currently selected tab
    modifier: Modifier = Modifier,                  // the Modifier to be applied to this tab row
    containerColor: Color = TabRowDefaults.primaryContainerColor,       // the color used for the background of this tab row
    contentColor: Color = TabRowDefaults.primaryContentColor,           // the preferred color for content inside this tab row
    edgePadding: Dp = TabRowDefaults.ScrollableTabRowEdgeStartPadding,              // the padding between the starting and ending edge of the scrollable tab row, and the tabs inside the row
    indicator: @Composable (tabPositions: List<TabPosition>) -> Unit = @Composable { tabPositions ->            // the indicator that represents which tab is currently selected.
        TabRowDefaults.SecondaryIndicator(
            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
        )
    },
    divider: @Composable () -> Unit = @Composable {                 // the divider displayed at the bottom of the tab row
        HorizontalDivider()
    },
    tabs: @Composable () -> Unit                        // the tabs inside this tab row
)

// Example
ScrollableTabRow(
  selectedTabIndex = pagerState.currentPage,
  edgePadding = 0.dp, // removes padding between the first pager item
  divider = { Spacer(modifier = Modifier.height(5.dp)) },
  containerColor = MaterialTheme.colorScheme.primaryContainer,
  indicator = { tabPositions ->
            // we are specifying the styling for tab indicator by specifying color for the selected tab indicator
            if (pagerState.currentPage < tabPositions.size) {
                SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    color = MaterialTheme.colorScheme.primary
                )
            }
  },
  tabs = {
            tabData.forEachIndexed { index, data ->
                Tab(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    selected = pagerState.currentPage == index,
                    icon = {
                        Icon(
                            imageVector = data.second,
                            contentDescription = "Tab layout icon"
                        )
                    },
                    unselectedContentColor = MaterialTheme.colorScheme.outline,
                    selectedContentColor = MaterialTheme.colorScheme.primary,

                    // Uncomment if you don't want Text to the tab
                    text = {
                        Text(text = data.first, fontSize = 12.sp)
                    }
                )
            }
        },
        modifier = Modifier.fillMaxWidth().wrapContentHeight()
)
```

| Example                                                                                     | Preview                                                                                           |
|---------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| [MainTabScreen](app/src/main/java/com/an/jetpackcomposesample/screen/tabs/MainTabScreen.kt) | <img src ="media/tabs/img_tabs_1.gif" width=300><img src ="/media/tabs/img_tabs_2.gif" width=300> |

### Bottom Navigation Bar
Navigation bars offer a persistent and convenient way to switch between primary destinations in an app. The recommended configuration for a `NavigationBarItem` depends on how many items there are inside a `NavigationBar`:
```
@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,                  // the Modifier to be applied to this navigation bar 
    containerColor: Color = NavigationBarDefaults.containerColor,                           // the color used for the background of this navigation bar
    contentColor: Color = MaterialTheme.colorScheme.contentColorFor(containerColor),        // the preferred color for content inside this navigation bar
    tonalElevation: Dp = NavigationBarDefaults.Elevation,                                   // when containerColor is ColorScheme.surface, a translucent primary color overlay is applied on top of the container.
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,                    // a window insets of the navigation bar
    content: @Composable RowScope.() -> Unit                    // the content of this navigation bar, typically 3-5 NavigationBarItems
)

@Composable
fun RowScope.NavigationBarItem(
    selected: Boolean,                      // whether this item is selected
    onClick: () -> Unit,                    // called when this item is clicked
    icon: @Composable () -> Unit,           // icon for this item
    modifier: Modifier = Modifier,          // the Modifier to be applied to this item
    enabled: Boolean = true,                // controls the enabled state of this item
    label: @Composable (() -> Unit)? = null,        // optional text label for this item
    alwaysShowLabel: Boolean = true,                // whether to always show the label for this item
    colors: NavigationBarItemColors = NavigationBarItemDefaults.colors(),           // NavigationBarItemColors that will be used to resolve the colors used for this item in different states
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) 
```

| Example                                                                                                      | Preview                                                                                                               |
|--------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| [MainBottomBarScreen](app/src/main/java/com/an/jetpackcomposesample/screen/bottombar/MainBottomBarScreen.kt) | <img src ="media/bottombar/img_bottombar_1.gif" width=300><img src ="/media/bottombar/img_bottombar_2.gif" width=300> |

### Dynamic themes
Dynamic Color, which was added in Android 12, enables users to personalize their devices to align tonally with the color scheme of their personal wallpaper or through a selected color in the wallpaper picker.  We can leverage this feature by adding the `DynamicColors` API, which applies this theming to our app to make it more personalized to the user. More details can be found [here](https://developer.android.com/develop/ui/views/theming/dynamic-colors).

| Example                                                                                          | Preview                                                                                                                                                                                                                                                                                                         |
|--------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [DynamicThemeScreen](app/src/main/java/com/an/jetpackcomposesample/screen/DynamicThemeScreen.kt) | <img src ="media/theme/img_theme_1.png" width=300><img src ="/media/theme/img_theme_2.png" width=300><img src ="media/theme/img_theme_3.png" width=300><img src ="/media/theme/img_theme_4.png" width=300><img src ="media/theme/img_theme_5.png" width=300><img src ="/media/theme/img_theme_6.png" width=300> |

### Switching between dark mode and light mode
<img src ="media/img_dark_mode.gif" width=300>

### Navigation in Compose
[Navigation](https://developer.android.com/develop/ui/compose/navigation) helps you in understanding how your app moves across different components in your Application. The Navigation Component is made up of three major parts:
- Navigation Graph: This is a resource that collects all navigation-related data in one place.
- `NavHost`: This is a unique composable that you can include in your layout. It shows various destinations from your Navigation Graph. The NavHost links the NavController with a navigation graph that specifies the composable destinations that you should be able to navigate between.
- `NavController`: The NavController is the central API for the Navigation component. It is stateful and keeps track of the back stack of composables that make up the screens in your app and the state of each screen. You can create a `NavController` by using the `rememberNavController()` method in your composable.

##### Setup Navigation graph & NavHost
- Define screens name and routes for Navigation in one file. ie. [NavigationItem.kt](https://github.com/anitaa1990/JetpackComposeSample/blob/master/app/src/main/java/com/an/jetpackcomposesample/provider/NavigationItem.kt)
- Define NavHost with your screens. ie. [Navigation.kt](https://github.com/anitaa1990/JetpackComposeSample/blob/master/app/src/main/java/com/an/jetpackcomposesample/provider/Navigation.kt)
- Call `Navigation.kt` inside the `MainApp` file.
```
Navigation(
      navController = navController,
      modifier = Modifier.padding(innerPadding)
)
```

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
