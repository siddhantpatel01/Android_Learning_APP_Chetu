package com.example.android_learning_app.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.android_learning_app.R
import com.example.android_learning_app.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity()/*, AdapterView.OnItemSelectedListener*/ {
    lateinit var binding: ActivityDetailsBinding
//    val data = arrayOf("AA", "BB", "CC", "DD", "EE")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)

//        val dataAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
//        binding.spinner.adapter = dataAdapter
//
//        binding.spinner.onItemSelectedListener = this
    }

//    override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, row: Long) {
//        val data = adapter?.getItemAtPosition(position)
//        Toast.makeText(this, "You are selected $data", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onNothingSelected(p0: AdapterView<*>?) {
//
//    }
}