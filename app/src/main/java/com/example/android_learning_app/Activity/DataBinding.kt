package com.example.android_learning_app.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.android_learning_app.R
import com.example.android_learning_app.databinding.ActivityMainBinding

class DataBinding : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_data_binding)
    }
}