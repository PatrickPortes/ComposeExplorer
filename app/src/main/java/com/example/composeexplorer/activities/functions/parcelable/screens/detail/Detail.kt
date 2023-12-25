package com.example.composeexplorer.activities.functions.parcelable.screens.detail

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

//Screens used as examples for passing Parcelable objects with navigation:

@Composable
fun DetailScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    ComposeExplorerTheme {

        val person = sharedViewModel.person
        //Using LaunchedEffect the value will print only the first time:
        LaunchedEffect(key1 = person) {

            if (person != null){
                Log.d("DetailScreen", person.firstName)
                Log.d("DetailScreen", person.lastName)
            }

        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Detail Screen",
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
fun DetailScreenPreview() {
    DetailScreen(rememberNavController(), viewModel())
}