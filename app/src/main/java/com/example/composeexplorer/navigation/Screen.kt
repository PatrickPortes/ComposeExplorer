package com.example.composeexplorer.navigation

sealed class Screen (val route: String) {

    object FirstScreen: Screen(route = "firstScreen")
    object SecondScreen: Screen(route = "secondScreen")
    object ThirdScreen: Screen(route = "thirdScreen")
    object LazyColumnScreen: Screen(route = "lazyColumnScreen")
    object LoadingScreen: Screen(route = "loadingScreen")

}
