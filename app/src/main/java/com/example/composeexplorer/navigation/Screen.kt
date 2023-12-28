package com.example.composeexplorer.navigation

sealed class Screen (val route: String) {

    object FirstScreen: Screen(route = "firstScreen")
    object SecondScreen: Screen(route = "secondScreen")
    object ThirdScreen: Screen(route = "thirdScreen")
    object LazyColumnScreen: Screen(route = "lazyColumnScreen")
    object AnimationScreen: Screen(route = "animationScreen")
    object SwipeableScreen: Screen(route = "swipeableScreen")


    //Screens used as examples for passing Parcelable objects with navigation:
    object HomeScreen: Screen(route = "home_screen")
    object DetailScreen: Screen(route = "detail_screen")


    // mutableStateListOf Example:
    object MutableListScreen: Screen(route = "mutableListScreen")


    // Adaptive Layout with BoxWithConstraints Example:
    object BoxWithConstraintsScreen: Screen(route = "boxWithConstraintsScreen")


    // Single/Multiple Permission Example:
    object PermissionsScreen: Screen(route = "permissionsScreen")

}
