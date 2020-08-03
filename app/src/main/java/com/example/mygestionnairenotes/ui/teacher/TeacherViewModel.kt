package com.example.mygestionnairenotes.ui.teacher

import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import com.example.mygestionnairenotes.data.model.TeacherEntity
import com.example.mygestionnairenotes.domain.ITeacherUseCase
import com.example.mygestionnairenotes.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TeacherViewModel(
    private val repo : ITeacherUseCase
) : ViewModel() {

    val fetchTeacherList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getTeachersList())
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
    fun insertTeacher(teacherEntity: TeacherEntity){
        viewModelScope.launch {
            repo.insertTeacher(teacherEntity)
        }
    }
}