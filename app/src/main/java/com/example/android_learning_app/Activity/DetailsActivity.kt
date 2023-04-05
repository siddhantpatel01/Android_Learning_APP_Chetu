package com.example.android_learning_app.Activity

import android.app.ActionBar
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.android_learning_app.R
import com.example.android_learning_app.databinding.ActivityDetailsBinding
import com.example.android_learning_app.databinding.LayoutCreateDataBinding
import com.example.android_learning_app.factory.DetailsActivityViewModelFactory
import com.example.android_learning_app.repository.SqliteDBRepository
import com.example.android_learning_app.viewModels.DetailsActivtyViewModel

class DetailsActivity : AppCompatActivity(),
    View.OnClickListener/*, AdapterView.OnItemSelectedListener*/ {
    lateinit var binding: ActivityDetailsBinding
//    val data = arrayOf("AA", "BB", "CC", "DD", "EE")
    lateinit var factory: DetailsActivityViewModelFactory
    lateinit var viewModel: DetailsActivtyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)

//        val dataAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
//        binding.spinner.adapter = dataAdapter
//
//        binding.spinner.onItemSelectedListener = this


        factory = DetailsActivityViewModelFactory(SqliteDBRepository(this))
        viewModel = ViewModelProvider(this, factory)[DetailsActivtyViewModel::class.java]

        binding.btnCreateData.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val layoutCustomBinding = LayoutCreateDataBinding.inflate(layoutInflater)
        val dialog = Dialog(this)
        dialog.setContentView(layoutCustomBinding.root)
        dialog.setCancelable(false)
        val windowManager = WindowManager.LayoutParams()
        windowManager.width = ActionBar.LayoutParams.MATCH_PARENT
        windowManager.height = ActionBar.LayoutParams.WRAP_CONTENT
        dialog.window?.attributes = windowManager
        dialog.show()


        layoutCustomBinding.btnSubmit.setOnClickListener {
            viewModel.createData(layoutCustomBinding.tilFname.editText?.text.toString(), layoutCustomBinding.tilLname.editText?.text.toString(), layoutCustomBinding.tilPhone.editText?.text.toString())
            dialog.dismiss()
        }
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