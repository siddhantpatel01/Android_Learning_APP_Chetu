package com.example.android_learning_app

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android_learning_app.databinding.ActivityAllDialogsBinding
import com.example.android_learning_app.databinding.ActivityMainBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    lateinit var selectedDateTV: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.btnWebView.setOnClickListener {
//            val intent = Intent(this , show_view::class.java)
//            startActivity(intent)
//        }
        binding.AllDialogs.setOnClickListener(this)
        binding.btnWebView.setOnClickListener(this)
        binding.ImplecitIntent.setOnClickListener(this)
        binding.ExplicitIntent.setOnClickListener(this)
        binding.DataBinding.setOnClickListener(this)
       // binding.datepicker.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_web_view -> {
                val intent = Intent(this, show_view::class.java)
                startActivity(intent)
            }
            R.id.All_dialogs ->{
                val intent = Intent(this,All_dialogs::class.java)
                startActivity(intent)
            }
            R.id.Implecit_Intent ->{
                val intent = Intent(this,Implicit_Intent::class.java)
                startActivity(intent)
            }
            R.id.Explicit_Intent ->{
                val intent = Intent(this,Explicit_Intent::class.java)
                startActivity(intent)
            }
            R.id.Data_Binding ->{
                val intent = Intent(this,DataBinding::class.java)
                startActivity(intent)
            }

//            R.id.datepicker -> {
//                MaterialDatePicker.Builder.datePicker().build()
//                    .show(supportFragmentManager, "DATE PICKER")
//                val datePickerBuilder = MaterialDatePicker.Builder.datePicker()
//                datePickerBuilder.setTitleText("SELECT UR DOB")
//                val datePicker = datePickerBuilder.build()
//
//
//                datePicker.show(supportFragmentManager, "DATE")
//                datePicker.addOnPositiveButtonClickListener {
//                    val calender = Calendar.getInstance()
//                    calender.time = Date(it)
//                    val DAY = calender.get(Calendar.DAY_OF_MONTH)
//                    val MONTH = calender.get(Calendar.MONTH) + 1
//                    val YEAR = calender.get(Calendar.YEAR)
//
//                    Toast.makeText(this@MainActivity, "$DAY / $MONTH / $YEAR", Toast.LENGTH_SHORT)
//                        .show()
//                    val simpelDateFormat = SimpleDateFormat("dd/MM/yyyy")
//                    val selectedDate = simpelDateFormat.format(Date(it))
//                    Toast.makeText(
//                        this@MainActivity,
//                        "You have selected: $selectedDate",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
        }



    }
}