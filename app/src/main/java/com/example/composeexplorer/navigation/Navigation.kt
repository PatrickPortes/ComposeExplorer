package com.example.composeexplorer.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeexplorer.activities.DefaultTest
import com.example.composeexplorer.activities.functions.animation.main.AnimationMainScreen
import com.example.composeexplorer.activities.functions.lazycolumn.LazyColumn
import com.example.composeexplorer.activities.functions.list.home.HomeMutableListScreen
import com.example.composeexplorer.activities.functions.parcelable.model.Person
import com.example.composeexplorer.activities.functions.parcelable.screens.SharedViewModel
import com.example.composeexplorer.activities.functions.parcelable.screens.detail.DetailScreen
import com.example.composeexplorer.activities.functions.parcelable.screens.home.HomeScreen
import com.example.composeexplorer.activities.functions.text.DefaultTest2
import com.example.composeexplorer.activities.functions.text.DefaultTest3
import com.example.composeexplorer.activities.functions.uicustom.swipe.SwipeItems

@Composable
fun Navigation() {

    //Used in the Second Approach to Pass a Parcelable Object with Navigation Compose:
    val sharedViewModel: SharedViewModel = viewModel()

    //NavGraph:
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
        composable(Screen.AnimationScreen.route) {
            AnimationMainScreen(navController = navController)
        }
        composable(Screen.SwipeableScreen.route) {
            SwipeItems(navController = navController)
        }


        //Screens used as examples for passing Parcelable objects with navigation:
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController, sharedViewModel = sharedViewModel)
        }
        composable(Screen.DetailScreen.route) {

            //First Approach to Pass a Parcelable Object with Navigation Compose: (there's a flaw)
//            LaunchedEffect(key1 = it){
//                val result =
//                    navController.previousBackStackEntry?.savedStateHandle?.get<Person>("person")
//                //Using LaunchedEffect the value will print only the first time:
//                Log.d("DetailScreen", "${result?.firstName}")
//                Log.d("DetailScreen", "${result?.lastName}")
//            }
//            DetailScreen(navController = navController)

            //The second approach is implemented within the DetailScreen composable function.
            DetailScreen(navController = navController, sharedViewModel = sharedViewModel)
        }


        // mutableStateListOf Example:
        composable(Screen.MutableListScreen.route) {
            HomeMutableListScreen(navController = navController)
        }

    }

}