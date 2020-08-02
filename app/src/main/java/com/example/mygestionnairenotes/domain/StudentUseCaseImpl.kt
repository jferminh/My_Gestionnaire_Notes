package com.example.mygestionnairenotes.domain

import com.example.mygestionnairenotes.data.model.StudentEntity
import com.example.mygestionnairenotes.vo.Resource

class StudentUseCaseImpl(private val repo: IStudentDataSource): IStudentUseCase {
    override suspend fun getStudentsList(): Resource<List<StudentEntity>> = repo.getAllStudents()

    override suspend fun insertStudent(studentEntity: StudentEntity) = repo.insertStudent(studentEntity)
}