package com.example.composeexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExplorerTheme {
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(23.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    ExpandableCard(
                        textTitle = "My Title",
                        description = "Lorem ipsum dolor sit amet consectetur adipiscing elit, urna consequat" +
                                " felis vehicula class ultricies mollis dictumst, aenean non a in donec" +
                                " nulla. Phasellus ante pellentesque erat cum risus consequat imperdiet" +
                                " aliquam, integer placerat et turpis mi eros nec lobortis taciti," +
                                " vehicula nisl litora tellus ligula porttitor metus."
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestThreePreview() {
    ComposeExplorerTheme {
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(23.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            ExpandableCard(
                textTitle = "My Title",
                description = "Lorem ipsum dolor sit amet consectetur adipiscing elit, urna consequat" +
                        " felis vehicula class ultricies mollis dictumst, aenean non a in donec" +
                        " nulla. Phasellus ante pellentesque erat cum risus consequat imperdiet" +
                        " aliquam, integer placerat et turpis mi eros nec lobortis taciti," +
                        " vehicula nisl litora tellus ligula porttitor metus."
            )
        }
    }
}