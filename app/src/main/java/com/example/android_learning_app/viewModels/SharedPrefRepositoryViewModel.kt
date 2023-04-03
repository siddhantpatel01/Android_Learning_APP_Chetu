package com.example.android_learning_app.viewModels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_learning_app.repository.SharedPrefRepository
import com.example.androidconcept_tp_5.util.Keys

class SharedPrefRepositoryViewModel(private val sharedPrefRepo: SharedPrefRepository, private val context: Context):ViewModel() {
    var firstName: MutableLiveData<String> = MutableLiveData()
    fun saveData(fname: String, lname: String){
        sharedPrefRepo.getPreference(context).edit().putString(Keys.FNAME, fname).commit()
        sharedPrefRepo.getPreference(context).edit().putString(Keys.LNAME, lname).commit()
    }

    fun getData(): MutableLiveData<String>{
        val fname = sharedPrefRepo.getPreference(context).getString(Keys.FNAME, "")
//        val lname = sharedPrefRepo.getPreference(context).getString(Keys.LNAME, null)
        firstName.value = fname
        return firstName
    }
}