package com.example.composeexplorer.activities.functions.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class StateViewModel: ViewModel() {

    var count by mutableIntStateOf(0)

    fun sumCount(){
        count++
    }

    fun subCount(){
        count--
    }

}