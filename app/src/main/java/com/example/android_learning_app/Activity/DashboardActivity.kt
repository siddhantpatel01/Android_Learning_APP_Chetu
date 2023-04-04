package com.example.android_learning_app.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_learning_app.R
import com.example.android_learning_app.databinding.ActivityMainBinding

class DashboardActivity : AppCompatActivity(), View.OnClickListener {
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
        binding.btnCoroutine.setOnClickListener(this)
        binding.btnSharedpreference.setOnClickListener(this)
        binding.btnDetails.setOnClickListener(this)
       // binding.datepicker.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_web_view -> {
                val intent = Intent(this, show_view::class.java)
                startActivity(intent)
            }
            R.id.All_dialogs ->{
                val intent = Intent(this, All_dialogs::class.java)
                startActivity(intent)
            }
            R.id.Implecit_Intent ->{
                val intent = Intent(this, Implicit_Intent::class.java)
                startActivity(intent)
            }
            R.id.Explicit_Intent ->{
                val intent = Intent(this, Explicit_Intent::class.java)
                startActivity(intent)
            }
            R.id.Data_Binding ->{
                val intent = Intent(this, DataBinding::class.java)
                startActivity(intent)
            }
            R.id.btn_coroutine ->{
                startActivity(Intent(this, CoroutineDemoActivity::class.java))
            }

            R.id.btn_sharedpreference ->{
                startActivity(Intent(this, SharedPrefsActivity::class.java))
            }

            R.id.btn_details ->{
                startActivity(Intent(this, DetailsActivity::class.java))
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