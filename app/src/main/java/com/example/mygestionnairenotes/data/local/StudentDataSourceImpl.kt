package com.example.mygestionnairenotes.data.local

import com.example.mygestionnairenotes.AppDatabase
import com.example.mygestionnairenotes.data.model.StudentEntity
import com.example.mygestionnairenotes.domain.IStudentDataSource
import com.example.mygestionnairenotes.vo.Resource

class StudentDataSourceImpl(private val appDatabase: AppDatabase):
    IStudentDataSource {

    override suspend fun getAllStudents(): Resource<List<StudentEntity>> {
        return Resource.Success(appDatabase.studentDao().getAllStudents())
    }

    override suspend fun insertStudent(studentEntity: StudentEntity) {
        appDatabase.studentDao().insertStudent(studentEntity)
    }
}