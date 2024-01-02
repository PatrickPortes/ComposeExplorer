package com.example.composeexplorer.activities.functions.lazycolumn.scroll

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Scrolled() {

    val lazyListState = rememberLazyListState()

    Scaffold (
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                List(lazyListState = lazyListState)
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = if (lazyListState.isScrolled) "Scrolling..." else "Idle",
                    style = TextStyle(fontSize = MaterialTheme.typography.titleLarge.fontSize)
                )
            }
        }
    )
}

@Composable
fun List(lazyListState: LazyListState) {

    val items = remember {
        List(size = 25) { it }
    }

    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        items(
            items = items,
            key = { it }
        ) {
            ItemHolder()
        }

    }
}

@Composable
fun ItemHolder() {

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.LightGray.copy(alpha = 0.3f))
    )

}

val LazyListState.isScrolled: Boolean
    get() = firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0


@Preview(showBackground = true)
@Composable
fun ScrolledPreview() {
    Scrolled()
}