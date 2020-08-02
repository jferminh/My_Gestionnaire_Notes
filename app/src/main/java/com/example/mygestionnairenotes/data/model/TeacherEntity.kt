package com.example.mygestionnairenotes.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teachers")
data class TeacherEntity(
    @PrimaryKey
    val number: String = "",
    @Embedded val person: Person?
)