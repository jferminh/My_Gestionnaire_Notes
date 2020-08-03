package com.example.mygestionnairenotes.ui.teacher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mygestionnairenotes.domain.IStudentUseCase
import com.example.mygestionnairenotes.domain.ITeacherUseCase

class TeacherVMFactory(
    private val repo: ITeacherUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ITeacherUseCase::class.java).newInstance(repo)
    }
}