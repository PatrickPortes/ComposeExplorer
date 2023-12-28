package com.example.composeexplorer.activities.functions.icons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Castle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.composeexplorer.R

@Composable
fun IconsTest() {

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        // How to get a complete list of Material Icons when using Icons object in a Jetpack Compose:

        // There's two different ways to increase the number of icons in the project:

        // Default Way:
        Icon(imageVector = Icons.Default.Check, contentDescription = null)

        // 1) Drawable Icons: (Adding a new vector asset in the drawable package)
        Icon(painter = painterResource(id = R.drawable.ic_google_logo), contentDescription = null)

        // 2) Extended Material Icons: (Adding new dependencies will unlock additional icons)
        Icon(imageVector = Icons.Default.Castle, contentDescription = null)

    }

}