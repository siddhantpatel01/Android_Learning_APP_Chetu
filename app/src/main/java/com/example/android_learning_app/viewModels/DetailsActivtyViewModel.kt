package com.example.android_learning_app.viewModels

import androidx.lifecycle.ViewModel
import com.example.android_learning_app.repository.SqliteDBRepository

class DetailsActivtyViewModel(private val repository: SqliteDBRepository):ViewModel() {


    fun createData(fName: String, lName: String, phone: String){
        repository.createData(fName, lName, phone)
    }

}