package com.example.android_learning_app.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android_learning_app.R
import com.example.android_learning_app.databinding.ActivitySharedPrefsBinding
import com.example.android_learning_app.factory.SharedPrefRepositoryViewModelFactory
import com.example.android_learning_app.repository.SharedPrefRepository
import com.example.android_learning_app.viewModels.SharedPrefRepositoryViewModel

class SharedPrefsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySharedPrefsBinding
    lateinit var factory: SharedPrefRepositoryViewModelFactory
    lateinit var viewModel: SharedPrefRepositoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shared_prefs)
        factory = SharedPrefRepositoryViewModelFactory(SharedPrefRepository, this)
        viewModel = ViewModelProvider(this, factory)[SharedPrefRepositoryViewModel::class.java]

        binding.lifecycleOwner = this
        viewModel.getData()
        viewModel.firstName.observe(this, Observer {
            binding.tvName.text = it
        })
        binding.btnSave.setOnClickListener {
            viewModel.saveData(binding.etFname.text.toString(), binding.etLname.text.toString())
        }

    }
}