package com.example.composeexplorer.activities.functions.list.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeexplorer.activities.functions.list.viewmodel.HomeViewModel
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

// mutableStateListOf:

@Composable
fun HomeMutableListScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = viewModel()
){
    ComposeExplorerTheme {

        //PROBLEM: (Text doesn't display the added number)
//        val elements by homeViewModel.elements

        //SOLUTION: (using mutableStateListOf)
        val elements = homeViewModel.elements

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
                .verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Button(onClick = { homeViewModel.addElement() }) {
                Text(text = "Add the Number")
            }
            elements.forEach {
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp),
                    text = "Number $it",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                    )
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeMutableListScreenPreview(){
    HomeMutableListScreen(rememberNavController())
}