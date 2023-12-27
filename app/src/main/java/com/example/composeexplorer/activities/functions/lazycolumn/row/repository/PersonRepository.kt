package com.example.composeexplorer.activities.functions.lazycolumn.row.repository

import com.example.composeexplorer.activities.functions.lazycolumn.row.model.Person

class PersonRepository {
    fun getAllData(): List<Person> {

        return listOf(
            Person(1, "John", "Doe", 25),
            Person(2, "Jane", "Smith", 30),
            Person(3, "Bob", "Johnson", 22),
            Person(4, "Alice", "Williams", 28),
            Person(5, "Ethan", "Miller", 35),
            Person(6, "Sophia", "Anderson", 21),
            Person(7, "Michael", "Brown", 40),
            Person(8, "Olivia", "Davis", 27),
            Person(9, "William", "Jones", 32),
            Person(10, "Ava", "Wilson", 24),
            Person(11, "James", "Taylor", 29),
            Person(12, "Emily", "Moore", 26),
            Person(13, "Daniel", "Clark", 33),
            Person(14, "Grace", "Lewis", 31),
            Person(15, "Matthew", "White", 36),
            Person(16, "Chloe", "Harris", 23),
            Person(17, "Liam", "Martin", 38),
            Person(18, "Mia", "Thompson", 19),
            Person(19, "Jacob", "Hall", 34),
            Person(20, "Emma", "Garcia", 22)
        )
    }
}