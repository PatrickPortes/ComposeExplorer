package com.example.composeexplorer.activities.functions.animation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeexplorer.activities.TextButton
import com.example.composeexplorer.activities.functions.animation.AnimatedSelectableItem
import com.example.composeexplorer.activities.functions.animation.LoadingAnimation
import com.example.composeexplorer.navigation.Screen
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

@Composable
fun AnimationMainScreen(navController: NavHostController) {
    ComposeExplorerTheme {

        val buttonTexts = listOf(
            "Loading Animation", "Selectable Item Animation",
            "TopBar Animation", "Shimmer Animation",
            "Moving Animation", "Moving Text Animation",
            "Lottie Animation"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Choose Your Next Animation Screen:",
                modifier = Modifier.padding(10.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
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
                                "Loading Animation" -> TextButton(text = text) {
                                    navController.navigate(Screen.LoadingAnimationScreen.route)
                                }

                                "Selectable Item Animation" -> TextButton(text = text) {
                                    navController.navigate(Screen.SelectableItemAnimationScreen.route)
                                }

                                "TopBar Animation" -> TextButton(text = text) {
                                    navController.navigate(Screen.AnimatedTopBarScreen.route)
                                }

                                "Shimmer Animation" -> TextButton(text = text) {
                                    navController.navigate(Screen.ShimmerAnimationScreen.route)
                                }

                                "Moving Text Animation" -> TextButton(text = text) {
                                    navController.navigate(Screen.MovingTextScreen.route)
                                }

                                "Moving Animation" -> TextButton(text = text) {
                                    navController.navigate(Screen.MovingAnimationScreen.route)
                                }

                                "Lottie Animation" -> TextButton(text = text) {
                                    navController.navigate(Screen.LottieAnimationScreen.route)
                                }
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
fun AnimationMainScreenPreview() {
    AnimationMainScreen(rememberNavController())
}
