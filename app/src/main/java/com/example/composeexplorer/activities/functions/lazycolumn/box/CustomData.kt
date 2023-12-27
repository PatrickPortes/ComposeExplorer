package com.example.composeexplorer.activities.functions.lazycolumn.box

import androidx.compose.ui.graphics.vector.ImageVector

data class CustomData(
    val id: Int,
    val image: String,
    val title: String,
    val description: String,
    val badges: List<ImageVector>
)
