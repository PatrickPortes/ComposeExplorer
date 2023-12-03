package com.example.composeexplorer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeexplorer.activities.MainActivity
import com.example.composeexplorer.activities.MainActivity2
import com.example.composeexplorer.activities.MainActivity3

//Setup NavGraph:
@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "first"
    ) {
        composable(
            Screen.FirstScreen.route
        ){
            MainActivity()
        }
        composable(
            Screen.SecondScreen.route
        ){
            MainActivity2()
        }
        composable(
            Screen.ThirdScreen.route
        ){
            MainActivity3()
        }
    }
}