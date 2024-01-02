package com.example.composeexplorer.activities.functions.animation

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeexplorer.navigation.Screen

// In this example function, I implemented both the old and new ways to animate the top app bar:

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AnimatedTopBar(navController: NavHostController) {
    val lazyListState = rememberLazyListState()

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){

        // Using the new way with animation:
        val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
//        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
//        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//        val scrollBehavior = TopAppBarDefaults.centerAlignedTopAppBarColors()
//        val scrollBehavior = TopAppBarDefaults.largeTopAppBarColors()
//        val scrollBehavior = TopAppBarDefaults.mediumTopAppBarColors()
//        val scrollBehavior = TopAppBarDefaults.topAppBarColors()
//        val scrollBehavior = TopAppBarDefaults.smallTopAppBarColors()

        Scaffold (
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopBar(
                    lazyListState = lazyListState,
                    scrollBehavior = scrollBehavior,
                    navController = navController
                    )
            }
        ){
            Column (modifier = Modifier.padding(start = 10.dp)){
                MainContent(lazyListState = lazyListState)
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    lazyListState: LazyListState,
    scrollBehavior: TopAppBarScrollBehavior,
    navController: NavHostController) {

    TopAppBar(
        modifier = Modifier
            .padding(5.dp),
        // Using the old way with animation:
//            .animateContentSize(animationSpec = tween(durationMillis = 300))
//            .height(height = if (lazyListState.isScrolled) 0.dp else TOP_BAR_HEIGHT),
        title = {
            Text(text = "My Notes")
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigate(Screen.AnimationScreen.route) }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Go back"
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Mark as favorite"
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit notes"
                )
            }
        },
        scrollBehavior = scrollBehavior
    )

}

@Composable
fun MainContent(lazyListState: LazyListState) {
    val numbers = remember { List(size = 32) { it } }
    val padding by animateDpAsState(
        targetValue = if (lazyListState.isScrolled) 0.dp else TOP_BAR_HEIGHT,
        animationSpec = tween(durationMillis = 300), label = ""
    )
    LazyColumn(
        modifier = Modifier.padding(top = padding),
        state = lazyListState
    ) {
        items(
            items = numbers,
            key = { it }
        ) {
            NumberHolder(number = it)
        }
    }
}

@Composable
fun NumberHolder(number: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = number.toString(),
            style = TextStyle(
                fontSize = MaterialTheme.typography.displayLarge.fontSize,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

val TOP_BAR_HEIGHT = 56.dp
val LazyListState.isScrolled: Boolean
    get() = firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0


@Preview(showBackground = true)
@Composable
fun AnimatedTopBarPreview() {
    AnimatedTopBar(rememberNavController())
}