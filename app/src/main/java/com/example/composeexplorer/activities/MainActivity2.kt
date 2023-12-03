package com.example.composeexplorer.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composeexplorer.R
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

class MainActivity2() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExplorerTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CustomTest(text = stringResource(id = R.string.app_name))
                    }
                }
            }
        }
    }
}

/*  Text Modifier Order of Execution, String Resource,
    Light and Dark Mode Support (MaterialTheme),
    Text Parameters and Alignment:  */
@Composable
fun CustomTest(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(26.dp)
            .width(250.dp),
        color = Color.White,
        //fontSize = 32.sp,
        fontSize = MaterialTheme.typography.titleLarge.fontSize,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End
    )
}

// Annotated String:
@Composable
fun CustomTest2() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = ParagraphStyle(
                    textAlign = TextAlign.Center
                )
            ) {
                withStyle(
                    style = SpanStyle(
                        fontStyle = FontStyle.Italic,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("A")
                    append("B")
                    append("C")
                }
                append("D")
                append("E")
                append("F")
            }
        }, modifier = Modifier.width(200.dp)
    )
}

// String Repeat, maxLines and Overflow:
@Composable
fun CustomText3() {
    Text(
        //text = "Repeating my own Text 3 Times!!!".repeat(3),
        text = "Repeating my own Text Until 4 Lines!!!".repeat(10),
        maxLines = 4,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Justify
    )
}

// Text Selection:
@Composable
fun CustomText4() {

    SelectionContainer {
        Column(
            Modifier
                .padding(25.dp)
                .height(200.dp), verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Text Selectable!")
            DisableSelection {
                Text(text = "Text Selectable!")
            }
            Text(text = "Text Selectable!")
        }
    }
}

// Superscript/Subscript Text:
@Composable
fun CustomText5(
    normalText: String,
    superText: String,
    normalFontSize: TextUnit = MaterialTheme.typography.titleLarge.fontSize,
    superFontSize: TextUnit = MaterialTheme.typography.labelSmall.fontSize,
    fontWeight: FontWeight = FontWeight.Normal,
    fontColor: Color = Color.Blue
) {

    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = normalFontSize,
                    color = fontColor
                )
            ) {
                append(normalText)
            }

            withStyle(
                SpanStyle(
                    fontSize = superFontSize,
                    fontWeight = fontWeight,
                    baselineShift = BaselineShift.Superscript
                    //baselineShift = BaselineShift.Subscript
                )
            ) {
                append(superText)
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun TestTwoPreview() {
    ComposeExplorerTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            CustomTest(text = stringResource(id = R.string.app_name))
            CustomTest2()
            CustomText3()
            CustomText4()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomText5(
                    normalText = "ABC",
                    superText = "123",
                    fontWeight = FontWeight.Bold,
                    fontColor = Color.Black
                )
            }
        }
    }
}
