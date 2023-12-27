package com.example.composeexplorer.activities.functions.list.mutablestatelistof.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

// mutableStateListOf:

@SuppressLint("MutableCollectionMutableState")
class HomeViewModel: ViewModel(){

    //PROBLEM: (Text doesn't display the added number)
//    private val _elements: MutableState<MutableList<Int>> = mutableStateOf(mutableListOf())
//    val elements: State<List<Int>> = _elements
//
//    fun addElement(){
//        val randomNumber = Random.nextInt(from = 1, until = 100)
//        _elements.value.add(randomNumber)
//        Log.d("HomeViewModel", "Added Number: ${_elements.value.last()}")
//    }


    //SOLUTION: (using mutableStateListOf)
    private val _elements = mutableStateListOf<Int>()
    val elements: List<Int> = _elements

    fun addElement(){
        val randomNumber = Random.nextInt(from = 1, until = 100)
        _elements.add(randomNumber)
        Log.d("HomeViewModel", "Added Number: ${_elements.last()}")
    }

}