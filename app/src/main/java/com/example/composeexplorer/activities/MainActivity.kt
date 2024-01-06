package com.example.composeexplorer.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeexplorer.navigation.Navigation
import com.example.composeexplorer.navigation.Screen
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme
import com.example.composeexplorer.ui.theme.CustomColor1
import com.example.composeexplorer.ui.theme.CustomColor2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExplorerTheme {
                Navigation()
            }
        }
    }
}

//Columns and Rows:
@Composable
fun ColumnTest() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .width(200.dp)
                .weight(1f),
            color = Color.Black
        ) {}
        Surface(
            modifier = Modifier
                .width(200.dp)
                .weight(1f),
            color = CustomColor1
        ) {}
        Surface(
            modifier = Modifier
                .width(200.dp)
                .weight(1f),
            color = CustomColor2
        ) {}
        CustomItem(weight = 1f, color = Color.DarkGray)
        CustomItem(weight = 1f)
    }
}

@Composable
fun ColumnScope.CustomItem(weight: Float, color: Color = Color.LightGray) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .weight(weight),
        color = color
    ) {}
}

@Composable
fun RowTest() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
                .weight(1f),
            color = Color.Black
        ) {}
        CustomItem(1f, color = CustomColor1, 50.dp)
        CustomItem(1f, color = CustomColor2, 50.dp)

    }
}

@Composable
fun RowScope.CustomItem(weight: Float, color: Color = Color.LightGray, height: Dp) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .weight(weight)
            .height(height),
        color = color
    ) {}
}

//Box:
@Composable
fun BoxTest() {

    //Each Box composable will stack on top of each other
    Box(
        //modifier = Modifier.fillMaxSize(),
        //contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .padding(4.dp),
//                .height(100.dp)
//                .width(100.dp)
//                .verticalScroll(rememberScrollState())
            Alignment.Center
        ) {
//            Box (modifier = Modifier.height(50.dp).width(50.dp).background(Color.Green)){}
            Text(
                text = "I Love Android!",
                fontSize = 40.sp,
                textAlign = TextAlign.Justify,
                lineHeight = 45.sp
            )
        }
    }
}

@Composable
fun TextButton(text: String, onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(12.dp)
            .size(100.dp, 50.dp), // Adjust the size as needed
    ) {
        Text(
            text = text,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}

@Composable
fun MainLayout(navController: NavController) {

    val buttonTexts = listOf(
        "Second Screen", "Third Screen",
        "LazyColumn Screen", "Animation Screen",
        "Swipeable Screen", "Parcelable Object Screen",
        "mutableStateListOf", "Box With Constraints",
        "Permissions Screen", "Hyperlink Screen",
        "Moving Text Screen", "Color Picker Screen",
        "Scrolled List Screen", "Example Screen",
        "Blur Effect Screen", "Date Time Picker Screen",
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Choose Your Next Screen:",
            modifier = Modifier.padding(30.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                color = if (isSystemInDarkTheme()) Color.White else Color.Black
            )
        )
        Spacer(modifier = Modifier.height(25.dp))

        LazyColumn {
            items(items = buttonTexts.chunked(2)) { rowItems ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    rowItems.forEach { text ->
                        // Define different click actions for each button
                        when (text) {
                            "Second Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.SecondScreen.route)
                            }

                            "Third Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.ThirdScreen.route)
                            }

                            "LazyColumn Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.LazyColumnScreen.route)
                            }

                            "Animation Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.AnimationScreen.route)
                            }

                            "Swipeable Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.SwipeableScreen.route)
                            }

                            "Parcelable Object Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.HomeScreen.route)
                            }

                            "mutableStateListOf" -> TextButton(text = text) {
                                navController.navigate(Screen.MutableListScreen.route)
                            }

                            "Box With Constraints" -> TextButton(text = text) {
                                navController.navigate(Screen.BoxWithConstraintsScreen.route)
                            }

                            "Permissions Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.PermissionsScreen.route)
                            }

                            "Hyperlink Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.HyperlinkScreen.route)
                            }

                            "Moving Text Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.MovingTextScreen.route)
                            }

                            "Color Picker Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.ColorPickerScreen.route)
                            }

                            "Scrolled List Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.ScrolledListScreen.route)
                            }

                            "Example Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.ExampleScreen.route)
                            }

                            "Blur Effect Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.BlurEffectScreen.route)
                            }

                            "Date Time Picker Screen" -> TextButton(text = text) {
                                navController.navigate(Screen.DateTimeScreen.route)
                            }
                        }
                    }
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun MainLayoutPreview() {
    ComposeExplorerTheme {
        Navigation()
    }
}