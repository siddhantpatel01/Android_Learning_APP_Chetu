package com.example.android_learning_app.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_learning_app.repository.SqliteDBRepository
import com.example.android_learning_app.viewModels.DetailsActivtyViewModel
import com.example.androidconcept_tp_5.viewModels.AssignmentsActivityViewModel

class DetailsActivityViewModelFactory(private val repository: SqliteDBRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsActivtyViewModel::class.java)){
            return DetailsActivtyViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}