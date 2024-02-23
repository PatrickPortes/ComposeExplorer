package com.example.composeexplorer.activities.functions.state

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

@Composable
fun State(){

    val viewModel = viewModel<StateViewModel>()

    ComposeExplorerTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //Without using ViewModel (rememberSaveable):
            //var count by rememberSaveable { mutableIntStateOf(0) }

            //Using ViewModel in Jetpack compose:
            val count = viewModel.count

            MyButton("Sum",count){ viewModel.sumCount() }
            Spacer(modifier = Modifier.height(20.dp))
            MyButton("Sub",count){ viewModel.subCount() }
        }
    }
}

@Composable
fun MyButton(textButton: String, currentCount: Int, updateCount:(Int)-> Unit) {

    Button(
        onClick = { updateCount(currentCount) },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )
        ) {

        Text(
            text = "$textButton : $currentCount",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(5.dp)
            )

    }

}

@Preview(showBackground = true)
@Composable
fun StatePreview(){
    State()
}