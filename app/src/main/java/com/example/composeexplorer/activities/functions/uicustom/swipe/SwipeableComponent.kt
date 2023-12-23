package com.example.composeexplorer.activities.functions.uicustom.swipe

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeexplorer.R
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@Composable
fun SwipeableComponent() {

    val archive = SwipeAction(
        onSwipe = {
            Log.d("SwipeComponent", "Archive")
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                painter = painterResource(id = R.drawable.ic_archive_24),
                contentDescription = null,
                tint = Color.White
            )
        },
        background = Color.Blue
    )

    val email = SwipeAction(
        onSwipe = {
            Log.d("SwipeComponent", "Email")
        },
        icon = {
            Icon(
                modifier = Modifier.padding(16.dp),
                painter = painterResource(id = R.drawable.ic_email_24),
                contentDescription = null,
                tint = Color.White
            )
        },
        background = Color.Red
    )


    SwipeableActionsBox(
        swipeThreshold = 50.dp,
        startActions = listOf(archive),
        endActions = listOf(email)
    ) {

        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(horizontal = 16.dp)
                .padding(vertical = 20.dp)
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(size = 50.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(7f)) {
                Text(
                    text = "Title",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleLarge.fontSize
                    )
                )
                Text(text = "Some random text.")
            }

        }

    }

}

@Composable
fun CustomContactItem() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 12.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(10.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(10.dp)
                .size(80.dp)
                .clip(CircleShape)
                .border(
                    width = 3.dp,
                    color = Color.Black,
                    shape = CircleShape
                ),
            painter = painterResource(id = R.drawable.ic_profile_default),
            contentDescription = "Circular Image",
            contentScale = ContentScale.FillHeight
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Contact Name",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                modifier = Modifier
                    .padding(
                        start = 7.dp,
                        end = 7.dp,
                        bottom = 2.dp
                    ),
                text = "Contact Description: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus et enim eu neque dictum tincidunt id eu nisi.",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                ),
                textAlign = TextAlign.Justify,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

}

@Composable
fun SwipeItems(navController: NavHostController) {
    ComposeExplorerTheme {

        Column (
            Modifier.padding(5.dp)
        ){
            SwipeableComponent()

            Spacer(modifier = Modifier.height(50.dp))

            CustomContactItem()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SwipeItemsPreview(){
    SwipeItems(navController = rememberNavController())
}