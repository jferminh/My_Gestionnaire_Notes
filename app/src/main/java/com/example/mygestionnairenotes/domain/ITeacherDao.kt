package com.example.mygestionnairenotes.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mygestionnairenotes.data.model.TeacherEntity

@Dao
interface ITeacherDao {
    @Query("SELECT * FROM teachers")
    suspend fun getAllTeachers(): List<TeacherEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeacher(teacherEntity: TeacherEntity)
}