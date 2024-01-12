package com.example.composeexplorer.activities.functions.animation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovingAnimation() {
    ComposeExplorerTheme {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                modifier = Modifier
                    .background(Color.Red)
                    .padding(vertical = 10.dp)
                    .basicMarquee(
                        iterations = Int.MAX_VALUE,
                        delayMillis = 0,
                        initialDelayMillis = 0,
                        velocity = 100.dp
                    ),
                color = Color.White,
                text = "BREAKING NEWS! BREAKING NEWS! BREAKING NEWS! Etiam eleifend ipsum eget arcu aliquam pulvinar. Aenean sollicitudin iaculis tempor. Nunc tincidunt metus magna, quis commodo arcu suscipit ut."
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovingAnimationPreview() {
    MovingAnimation()
}
