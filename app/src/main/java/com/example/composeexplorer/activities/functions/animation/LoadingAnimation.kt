package com.example.composeexplorer.activities.functions.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme
import kotlinx.coroutines.delay

@Composable
fun LoadingAnimation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    circleSize: Dp = 25.dp,
    circleColor: Color = MaterialTheme.colorScheme.primary,
    spaceBetween: Dp = 10.dp,
    travelDistance: Dp = 20.dp
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(all = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val circles = listOf(
            remember { Animatable(initialValue = 0f) },
            remember { Animatable(initialValue = 0f) },
            remember { Animatable(initialValue = 0f) }
        )

        //Animate Circles:
        circles.forEachIndexed { index, animatable ->
            LaunchedEffect(key1 = animatable) {
                delay(index * 250L)
                animatable.animateTo(
                    targetValue = 1f,
                    animationSpec = infiniteRepeatable(
                        animation = keyframes {
                            durationMillis = 1200
                            0.0f at 0 with LinearOutSlowInEasing
                            1.0f at 300 with LinearOutSlowInEasing
                            0.0f at 600 with LinearOutSlowInEasing
                            0.0f at 1200 with LinearOutSlowInEasing
                        },
                        repeatMode = RepeatMode.Restart
                    )
                )
            }
        }

        //Developing Circles:
        val circlesValues = circles.map { it.value }
        val distance = with(LocalDensity.current) { travelDistance.toPx() }
        val lastCircle = circlesValues.size - 1

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(spaceBetween)
        ) {
            circlesValues.forEachIndexed { index, value ->
                Box(
                    modifier = Modifier
                        .size(circleSize)
                        .graphicsLayer {
                            translationY = -value * distance
                        }
                        .background(
                            color = circleColor,
                            shape = CircleShape
                        )
                )

                //We can use this (Row: horizontalArrangement) to have the same behavior:
//                    if (index != lastCircle) {
//                        Spacer(modifier = Modifier.width(spaceBetween))
//                    }

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun LoadingAnimationPreview() {
    LoadingAnimation(rememberNavController())
}