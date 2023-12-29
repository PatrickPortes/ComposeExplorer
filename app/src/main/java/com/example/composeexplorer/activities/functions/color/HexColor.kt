package com.example.composeexplorer.activities.functions.color

import android.graphics.Color.parseColor
import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ApplyHexColor() {

    //Apply Hex Color Code to your Jetpack Compose:

    Column (
        modifier = Modifier
            .background(color = "#1C2B8D".color)
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Applying Hex Color in The Background using Jetpack Compose!",
            style = TextStyle(
                fontSize = MaterialTheme.typography.displaySmall.fontSize,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        )
    }

}

val String.color
    get() = Color(parseColor(this))

@Preview(showBackground = true)
@Composable
fun ApplyHexColorPreview() {
    ApplyHexColor()
}