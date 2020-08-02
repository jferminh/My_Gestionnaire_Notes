package com.example.mygestionnairenotes.ui.student

import androidx.lifecycle.*
import com.example.mygestionnairenotes.data.model.StudentEntity
import com.example.mygestionnairenotes.domain.IStudentUseCase
import com.example.mygestionnairenotes.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(private val repo : IStudentUseCase) : ViewModel() {

    val fetchStudentList = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(repo.getStudentsList())
        } catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }

    fun insertStudent(studentEntity: StudentEntity){
        viewModelScope.launch {
            repo.insertStudent(studentEntity)
        }
    }
}