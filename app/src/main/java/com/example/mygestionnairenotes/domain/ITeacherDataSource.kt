package com.example.mygestionnairenotes.domain

import com.example.mygestionnairenotes.data.model.TeacherEntity
import com.example.mygestionnairenotes.vo.Resource

interface ITeacherDataSource {
    suspend fun getAllTeachers(): Resource<List<TeacherEntity>>
    suspend fun insertTeacher(teacherEntity: TeacherEntity)
}