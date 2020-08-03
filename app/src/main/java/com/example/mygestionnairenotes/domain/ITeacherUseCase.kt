package com.example.mygestionnairenotes.domain

import com.example.mygestionnairenotes.data.model.TeacherEntity
import com.example.mygestionnairenotes.vo.Resource

interface ITeacherUseCase {
    suspend fun getTeachersList(): Resource<List<TeacherEntity>>
    suspend fun insertTeacher(teacherEntity: TeacherEntity)
}