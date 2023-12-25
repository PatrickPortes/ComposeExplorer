package com.example.composeexplorer.activities.functions.parcelable.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeexplorer.activities.functions.parcelable.model.Person
import com.example.composeexplorer.activities.functions.parcelable.screens.SharedViewModel
import com.example.composeexplorer.navigation.Screen
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

//Screens used as examples for passing Parcelable objects with navigation:

@Composable
fun HomeScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    ComposeExplorerTheme {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                modifier = Modifier.clickable {

                    //First Approach to Pass a Parcelable Object with Navigation Compose:
//                    val person = Person(firstName = "Patrick", lastName = "Portes")
//                    navController.currentBackStackEntry?.savedStateHandle?.set(
//                        key = "person",
//                        value = person
//                    )
                    /*Flaw with the first approach:
                    (using popBackStack() the value will return null in the navigation)*/
//                    navController.popBackStack()
//                    navController.navigate(route = Screen.DetailScreen.route)


                    //Second Approach to Pass a Parcelable Object with Navigation Compose:
                    /*(in this one will be used a Shared ViewModel and it
                     will be possible use popBackStack() without flaw)*/
                    val person = Person(firstName = "Patrick", lastName = "Portes")
                    sharedViewModel.addPerson(newPerson = person)
                    navController.popBackStack()
                    navController.navigate(route = Screen.DetailScreen.route)

                },

                text = "Home Screen",
                fontSize = MaterialTheme.typography.displayLarge.fontSize,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = MaterialTheme.typography.displayLarge.lineHeight
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController(), viewModel())
}