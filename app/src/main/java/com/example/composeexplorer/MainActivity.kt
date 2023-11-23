package com.example.composeexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme
import com.example.composeexplorer.ui.theme.CustomColor1
import com.example.composeexplorer.ui.theme.CustomColor2
import com.example.composeexplorer.ui.theme.Typography
import com.example.composeexplorer.ui.theme.seed
import java.lang.reflect.Type

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExplorerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(
            text = "Hello!!!",
            modifier = modifier
        )
    }
}

//First Composable Fun:
@Composable
fun CustomText(text: String) {
    Text(
        text = text,
        style = Typography.headlineMedium
    )
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
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Box (
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


@Preview(showBackground = true)
@Composable
fun TestOnePreview() {
    ComposeExplorerTheme {
        //CustomText()
        //ColumnTest()
        //RowTest()
        BoxTest()
    }
}