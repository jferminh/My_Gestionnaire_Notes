package com.example.mygestionnairenotes.domain

import com.example.mygestionnairenotes.data.model.StudentEntity
import com.example.mygestionnairenotes.vo.Resource

interface IStudentDataSource {
    suspend fun getAllStudents(): Resource<List<StudentEntity>>
    suspend fun insertStudent(studentEntity: StudentEntity)
}