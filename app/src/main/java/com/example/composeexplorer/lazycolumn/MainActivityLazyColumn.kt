package com.example.composeexplorer.lazycolumn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeexplorer.lazycolumn.repository.PersonRepository
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

class MainActivityLazyColumn : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExplorerTheme {
                LazyColumn()
                //StickyHeader()
            }
        }
    }
}

//LazyColumn:
@Composable
fun LazyColumn() {
    val personRepository = PersonRepository()
    val getAllData = personRepository.getAllData()

    LazyColumn(
        Modifier.padding(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = getAllData) { person ->
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
        LazyColumn()
        //StickyHeader()
    }
}
