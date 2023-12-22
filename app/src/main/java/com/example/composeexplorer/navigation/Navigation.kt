package com.example.composeexplorer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeexplorer.activities.DefaultTest
import com.example.composeexplorer.activities.functions.animation.LoadingAnimation
import com.example.composeexplorer.activities.functions.lazycolumn.LazyColumn
import com.example.composeexplorer.activities.functions.text.DefaultTest2
import com.example.composeexplorer.activities.functions.text.DefaultTest3

@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.FirstScreen.route) {
        composable(Screen.FirstScreen.route) {
            DefaultTest(navController = navController)
        }
        composable(Screen.SecondScreen.route) {
            DefaultTest2(navController = navController)
        }
        composable(Screen.ThirdScreen.route) {
            DefaultTest3(navController = navController)
        }
        composable(Screen.LazyColumnScreen.route) {
            LazyColumn(navController = navController)
        }
        composable(Screen.LoadingScreen.route) {
            LoadingAnimation(navController = navController)
        }

    }

}