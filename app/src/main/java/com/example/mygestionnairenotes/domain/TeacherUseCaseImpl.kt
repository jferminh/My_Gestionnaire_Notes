package com.example.mygestionnairenotes.domain

import android.app.ApplicationErrorReport
import com.example.mygestionnairenotes.data.model.TeacherEntity
import com.example.mygestionnairenotes.vo.Resource

class TeacherUseCaseImpl(
    private val repo: ITeacherDataSource
) : ITeacherUseCase {
    override suspend fun getTeachersList(): Resource<List<TeacherEntity>> = repo.getAllTeachers()

    override suspend fun insertTeacher(teacherEntity: TeacherEntity) = repo.insertTeacher(teacherEntity)
}