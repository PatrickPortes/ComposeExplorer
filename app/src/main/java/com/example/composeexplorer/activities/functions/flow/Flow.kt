package com.example.composeexplorer.activities.functions.flow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

//Kotlin Flows With Jetpack Compose:
@Composable
fun Flow(){

    val viewModel = viewModel<FlowViewModel>()

    ComposeExplorerTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            val currentValue = viewModel.myFlow.collectAsState(initial = 1).value

            Text(text = "Current Index is: $currentValue", fontSize = 32.sp)

        }
    }
}



@Preview(showBackground = true)
@Composable
fun FlowPreview(){
    Flow()
}