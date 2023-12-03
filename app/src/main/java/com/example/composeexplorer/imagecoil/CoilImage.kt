package com.example.composeexplorer.imagecoil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.composeexplorer.R
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

class CoilImage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExplorerTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    //LoadingImage(path = "https://source.android.com/static/docs/setup/images/Android_symbol_green_RGB.png")
                    //LoadingImage(path = "https://i.imgur.com/f6Dzd7O.png")
                }
            }
        }
    }
}

//@Composable
//fun LoadingImage(path: String){
//
//    AsyncImage(model = path, contentDescription = "Image")
//
//}

@Composable
fun CoilImageFun() {

    Box(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp),
        contentAlignment = Alignment.Center
    ) {

        val painter = rememberImagePainter(
            data = "https://developer.android.com/static/images/brand/Android_Robot_200.png",
            builder = {
                placeholder(R.drawable.ic_load)
                error(R.drawable.ic_error)
                crossfade(1000)

            }
        )

        val painterState = painter.state
        Image(painter = painter, contentDescription = "Test Image")
        if (painterState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoilPreview() {
    ComposeExplorerTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CoilImageFun()
        }
    }
}