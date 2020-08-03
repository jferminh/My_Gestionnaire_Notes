package com.example.mygestionnairenotes.data.local

import com.example.mygestionnairenotes.AppDatabase
import com.example.mygestionnairenotes.data.model.TeacherEntity
import com.example.mygestionnairenotes.domain.ITeacherDataSource
import com.example.mygestionnairenotes.vo.Resource

class TeacherDataSourceImpl(
    private val appDatabase: AppDatabase
) : ITeacherDataSource {
    override suspend fun getAllTeachers(): Resource<List<TeacherEntity>> {
        return Resource.Success(appDatabase.teacherDao().getAllTeachers())
    }

    override suspend fun insertTeacher(teacherEntity: TeacherEntity) {
        appDatabase.teacherDao().insertTeacher(teacherEntity)
    }
}