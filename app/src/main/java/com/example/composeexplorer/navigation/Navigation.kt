package com.example.composeexplorer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeexplorer.activities.DefaultTest
import com.example.composeexplorer.activities.DefaultTest2
import com.example.composeexplorer.activities.DefaultTest3
import com.example.composeexplorer.lazycolumn.LazyColumn
import com.example.composeexplorer.lazycolumn.MainActivityLazyColumn

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

    }

}