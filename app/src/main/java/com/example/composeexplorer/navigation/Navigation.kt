package com.example.composeexplorer.navigation

import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeexplorer.activities.MainLayout
import com.example.composeexplorer.activities.functions.animation.AnimatedSelectableItemScreen
import com.example.composeexplorer.activities.functions.animation.AnimatedTopBar
import com.example.composeexplorer.activities.functions.animation.LoadingAnimationScreen
import com.example.composeexplorer.activities.functions.animation.MovingAnimation
import com.example.composeexplorer.activities.functions.animation.ShimmerAnimationScreen
import com.example.composeexplorer.activities.functions.animation.lottie.LottieAnimationFun
import com.example.composeexplorer.activities.functions.animation.main.AnimationMainScreen
import com.example.composeexplorer.activities.functions.animation.text.MovingTextAnimation
import com.example.composeexplorer.activities.functions.color.picker.ColorPickerComponent
import com.example.composeexplorer.activities.functions.color.picker.ImageColorPicker
import com.example.composeexplorer.activities.functions.dialogs.picker.DateTimePicker
import com.example.composeexplorer.activities.functions.flow.Flow
import com.example.composeexplorer.activities.functions.images.imagecoil.PhotoPicker
import com.example.composeexplorer.activities.functions.launchedeffect.LaunchedEffect
import com.example.composeexplorer.activities.functions.lazycolumn.box.BoxWithConstraintsMain
import com.example.composeexplorer.activities.functions.lazycolumn.row.LazyColumn
import com.example.composeexplorer.activities.functions.lazycolumn.scroll.Scrolled
import com.example.composeexplorer.activities.functions.list.mutablestatelistof.home.HomeMutableListScreen
import com.example.composeexplorer.activities.functions.parcelable.screens.SharedViewModel
import com.example.composeexplorer.activities.functions.parcelable.screens.detail.DetailScreen
import com.example.composeexplorer.activities.functions.parcelable.screens.home.HomeScreen
import com.example.composeexplorer.activities.functions.permissions.RequestPermission
import com.example.composeexplorer.activities.functions.state.State
import com.example.composeexplorer.activities.functions.text.Hyperlink
import com.example.composeexplorer.activities.functions.text.TextFieldLayout
import com.example.composeexplorer.activities.functions.text.TextLayout
import com.example.composeexplorer.activities.functions.uicustom.effect.BlurEffect
import com.example.composeexplorer.activities.functions.uicustom.swipe.SwipeItems
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Navigation() {

    //Used in the Second Approach to Pass a Parcelable Object with Navigation Compose:
    val sharedViewModel: SharedViewModel = viewModel()

    //NavGraph:
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.FirstScreen.route) {
        composable(Screen.FirstScreen.route) {
            MainLayout(navController = navController)
        }
        composable(Screen.SecondScreen.route) {
            TextLayout(navController = navController)
        }
        composable(Screen.ThirdScreen.route) {
            TextFieldLayout(navController = navController)
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

        // Adaptive Layout with BoxWithConstraints Example:
        composable(Screen.BoxWithConstraintsScreen.route) {
            BoxWithConstraintsMain(navController = navController)
        }

        // Single/Multiple Permission Example:
        composable(Screen.PermissionsScreen.route) {

            //Single Permission:
            RequestPermission(permission = Manifest.permission.READ_CONTACTS)

            //Multiple Permission:
//            RequestMultiplePermissions(
//                permissions = listOf(
//                    Manifest.permission.READ_CONTACTS,
//                    Manifest.permission.CAMERA
//                )
//            )
        }

        // Hyperlink Within a Text Example:
        composable(Screen.HyperlinkScreen.route) {
            Hyperlink()
        }

        // Moving Text Animation:
        composable(Screen.MovingTextScreen.route) {
            MovingTextAnimation()
        }

        // Color Picker Component:
        composable(Screen.ColorPickerScreen.route) {
            ColorPickerComponent(navController = navController)
        }
        composable(Screen.ImageColorPickerScreen.route) {
            ImageColorPicker()
        }

        // isScrolled Extension Function:
        composable(Screen.ScrolledListScreen.route) {
            Scrolled()
        }

        // Collapsing Top Bar Animation:
        composable(Screen.AnimatedTopBarScreen.route) {
            AnimatedTopBar(navController = navController)
        }

        // Example Screen:
        composable(Screen.ExampleScreen.route) {
            PhotoPicker()
        }

        // Blur Effect:
        composable(Screen.BlurEffectScreen.route) {
            BlurEffect()
        }

        // Date Time Picker:
        composable(Screen.DateTimeScreen.route) {
            DateTimePicker()
        }

        // Lottie Animation:
        composable(Screen.LottieAnimationScreen.route) {
            LottieAnimationFun()
        }

        // Moving Animation:
        composable(Screen.MovingAnimationScreen.route) {
            MovingAnimation()
        }

        // Shimmer Animation:
        composable(Screen.ShimmerAnimationScreen.route) {
            ShimmerAnimationScreen()
        }

        // Loading Animation:
        composable(Screen.LoadingAnimationScreen.route) {
            LoadingAnimationScreen()
        }

        // Selectable Item Animation:
        composable(Screen.SelectableItemAnimationScreen.route) {
            AnimatedSelectableItemScreen()
        }

        // State in Jetpack Compose:
        composable(Screen.StateScreen.route) {
            State()
        }

        // Coroutines Flow in Jetpack Compose:
        composable(Screen.FlowScreen.route) {
            Flow()
        }

        //  Launched Effect:
        composable(Screen.LaunchedEffectScreen.route) {
            LaunchedEffect()
        }
    }

}