package com.example.mygestionnairenotes.ui.student

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mygestionnairenotes.domain.IStudentUseCase

class StudentVMFactory(private val repo: IStudentUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IStudentUseCase::class.java).newInstance(repo)
    }
}