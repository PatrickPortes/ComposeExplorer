package com.example.composeexplorer.activities.functions.previews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

// Using a single preview composable to display multiple different previews:

@Composable
@DevicePreviews
@FontScalePreviews
fun ExamplePreview() {
    ComposeExplorerTheme {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Example Preview")
            }
        }
    }
}
