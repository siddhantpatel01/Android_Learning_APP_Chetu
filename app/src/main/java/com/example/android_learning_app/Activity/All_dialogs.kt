package com.example.android_learning_app.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_learning_app.databinding.ActivityAllDialogsBinding
import com.example.android_learning_app.databinding.ActivityShowViewBinding

class All_dialogs : AppCompatActivity() {
    private lateinit var binding : ActivityAllDialogsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAllDialogsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
