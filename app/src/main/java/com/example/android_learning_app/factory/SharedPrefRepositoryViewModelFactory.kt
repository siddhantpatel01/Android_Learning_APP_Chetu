package com.example.android_learning_app.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_learning_app.repository.SharedPrefRepository
import com.example.android_learning_app.viewModels.SharedPrefRepositoryViewModel
import com.example.androidconcept_tp_5.viewModels.AssignmentsActivityViewModel

class SharedPrefRepositoryViewModelFactory(private val sharedPrefRepo: SharedPrefRepository, private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SharedPrefRepositoryViewModel::class.java)){
            return SharedPrefRepositoryViewModel(sharedPrefRepo, context) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}