package com.example.mygestionnairenotes.data.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "students")
data class StudentEntity(
    @PrimaryKey
    val number: String = "",
    @Embedded val person: Person?
): Parcelable