package com.example.composeexplorer.navigation

sealed class Screen (val route: String) {

    object FirstScreen: Screen(route = "first")
    object SecondScreen: Screen(route = "second")
    object ThirdScreen: Screen(route = "third")

}
