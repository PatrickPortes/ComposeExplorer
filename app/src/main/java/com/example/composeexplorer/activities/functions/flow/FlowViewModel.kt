package com.example.composeexplorer.activities.functions.flow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowViewModel: ViewModel() {

    val myFlow = flow<Int> {
        for (i in 1..100){
            emit(i)
            delay(1000L)
        }
    }

    init {
        backPressureDemo()
    }

    //Flow doesn't emit the next item until the previously emitted item get consumed

    private fun backPressureDemo(){
        val myFlow = flow<Int> {
            for (i in 1..10){
                Log.i("MyTag", "Produced $i")
                emit(i)
                delay(1000L)
            }
        }

        viewModelScope.launch {
            //Buffer call creates a second code that follows the flow and correct functions to execute concurrently
            myFlow.buffer().collect {
                delay(2000L)
                Log.i("MyTag", "Consumed $it")
            }

            //There's situations that we only need the most recent/updated value (needs to use collect latest in these flow situations)
            //myFlow.collectLatest { }
        }

    }

}