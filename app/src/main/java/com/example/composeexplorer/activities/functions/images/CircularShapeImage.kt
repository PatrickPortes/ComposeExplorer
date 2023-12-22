package com.example.composeexplorer.activities.functions.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeexplorer.R
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

@Composable
fun CircularShapeImage() {
    ComposeExplorerTheme {

        Box(
            modifier = Modifier.fillMaxSize(),
            Alignment.Center
        ){
            Image(
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape)
                    .border(
                        width = 10.dp,
                        color = Color.Black,
                        shape = CircleShape
                    ),
                painter = painterResource(id = R.drawable.image_test_bg),
                contentDescription = "Circular Image"
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CircularShapeImagePreview() {
    CircularShapeImage()
}