package com.example.android_learning_app.viewModels

import androidx.lifecycle.ViewModel
import com.example.android_learning_app.repository.SqliteDBRepository
import com.example.androidconcept_tp_5.model.Student

class DetailsActivtyViewModel(private val repository: SqliteDBRepository):ViewModel() {


    fun createData(fName: String, lName: String, phone: String){
        repository.createData(fName, lName, phone)
    }

    fun getAllData(): ArrayList<Student>{
        return repository.getAllData()
    }

    fun deleteSingleRecord(rowId: Int){
        repository.deleteSingleRecord(rowId)
    }

}