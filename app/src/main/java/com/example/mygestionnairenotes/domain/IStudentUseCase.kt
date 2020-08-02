package com.example.mygestionnairenotes.domain

import com.example.mygestionnairenotes.data.model.StudentEntity
import com.example.mygestionnairenotes.vo.Resource

interface IStudentUseCase {
    suspend fun getStudentsList(): Resource<List<StudentEntity>>
    suspend fun insertStudent(studentEntity: StudentEntity)
}