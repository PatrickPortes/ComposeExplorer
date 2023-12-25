package com.example.composeexplorer.activities.functions.parcelable.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.composeexplorer.activities.functions.parcelable.model.Person

//Used in the Second Approach to Pass a Parcelable Object with Navigation Compose:
class SharedViewModel : ViewModel() {

    var person by mutableStateOf<Person?>(null)
        private set

    fun addPerson(newPerson: Person) {
        person = newPerson
    }

}