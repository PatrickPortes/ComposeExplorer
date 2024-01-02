package com.example.composeexplorer.activities.functions.animation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeexplorer.activities.functions.animation.AnimatedSelectableItem
import com.example.composeexplorer.activities.functions.animation.LoadingAnimation
import com.example.composeexplorer.navigation.Screen
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

@Composable
fun AnimationMainScreen(navController: NavHostController) {
    ComposeExplorerTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(50.dp),
            verticalArrangement = Arrangement.spacedBy(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LoadingAnimation(navController = rememberNavController())

            var selected by remember { mutableStateOf(false) }
            var selected2 by remember { mutableStateOf(false) }

            Column {
                AnimatedSelectableItem(
                    selected = selected,
                    title = "Lorem Ipsum",
                    onClick = {
                        selected = !selected
                    }
                )

                Spacer(modifier = Modifier.height(12.dp))

                AnimatedSelectableItem(
                    selected = selected2,
                    title = "Lorem Ipsum",
                    subtitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus et enim eu neque dictum tincidunt id eu nisi. ",
                    onClick = {
                        selected2 = !selected2
                    }
                )
            }

            Button(
                onClick = { navController.navigate(Screen.AnimatedTopBarScreen.route) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                contentPadding = PaddingValues()
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 30.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Other Types of Animations",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
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
