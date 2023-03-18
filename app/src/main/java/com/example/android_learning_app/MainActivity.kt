package com.example.android_learning_app

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_learning_app.databinding.ActivityMainBinding
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
        binding.btnWebView.setOnClickListener(this)
        binding.datepicker.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_web_view -> {
                val intent = Intent(this, show_view::class.java)
                startActivity(intent)
            }
            R.id.datepicker -> {
                // on below line we are getting
                // the instance of our calendar.
                val c = Calendar.getInstance()

                // on below line we are getting
                // our day, month and year.
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                // on below line we are creating a
                // variable for date picker dialog.
                val datePickerDialog = DatePickerDialog(
                    // on below line we are passing context.
                    this,
                    { view, year, monthOfYear, dayOfMonth ->
                        // on below line we are setting
                        // date to our text view.

                        selectedDateTV.text =
                            (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    },
                    // on below line we are passing year, month
                    // and day for the selected date in our date picker.
                    year,
                    month,
                    day
                )
                // at last we are calling show
                // to display our date picker dialog.
                datePickerDialog.show()

//                val intent = Intent(this,Date_picker::class.java)
//                startActivity(intent)

            }
        }
    }


}