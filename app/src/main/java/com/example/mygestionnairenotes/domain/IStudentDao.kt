package com.example.mygestionnairenotes.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mygestionnairenotes.data.model.StudentEntity

@Dao
interface IStudentDao {
    @Query("SELECT * FROM students")
    suspend fun getAllStudents(): List<StudentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(studentEntity: StudentEntity)
}