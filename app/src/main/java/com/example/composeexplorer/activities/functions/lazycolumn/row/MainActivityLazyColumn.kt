package com.example.composeexplorer.activities.functions.lazycolumn.row

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeexplorer.activities.functions.lazycolumn.row.repository.PersonRepository
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

class MainActivityLazyColumn : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExplorerTheme {
                LazyColumn(rememberNavController())
                //StickyHeader()
            }
        }
    }
}

//LazyColumn:
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumn(navController: NavHostController) {

    var items by remember { mutableStateOf(PersonRepository().getAllData()) }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(all = 12.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = items) { person ->
                CustomItem(person = person)
            }

            //Additionally, ItemsIndexed can also be utilized:
            /*itemsIndexed(
                items = getAllData,
                key = { index, person -> person.id }
            ) { index, person ->
                Log.d("MainActivityLazyColumn", index.toString())
                CustomItem(person = person)
            }*/
        }
        Button(
            modifier = Modifier
                .padding(all = 30.dp),
            onClick = { items = items.shuffled() }
        ) {
            Text(text = "Shuffle")
        }
    }
}

//LazyColumn (StickyHeader):
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeader() {

    val sections = listOf("A", "B", "C", "D", "E", "F", "G")

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        sections.forEach { section ->
            stickyHeader {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(12.dp),
                    text = "Section $section"
                )
            }
            items(10) {
                Text(
                    modifier = Modifier.padding(12.dp),
                    text = "Item $it from the section $section"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnPreview() {
    ComposeExplorerTheme {
        LazyColumn(rememberNavController())
        //StickyHeader()
    }
}
