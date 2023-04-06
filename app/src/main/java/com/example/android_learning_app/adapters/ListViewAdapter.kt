package com.example.android_learning_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.android_learning_app.R
import com.example.android_learning_app.databinding.LayoutItemsBinding
import com.example.androidconcept_tp_5.model.Student

class ListViewAdapter(private val listOfStudents: ArrayList<Student>): BaseAdapter() {
    override fun getCount(): Int {
        return listOfStudents.size
    }

    override fun getItem(position: Int): Any {
        return listOfStudents[position]
    }

    override fun getItemId(pos: Int): Long {
        return listOfStudents[pos].hashCode().toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        view = LayoutInflater.from(parent!!.context).inflate(R.layout.layout_items, parent, false)
        val binding = DataBindingUtil.bind<LayoutItemsBinding>(view)
        binding!!.tvFname.text =  listOfStudents[position].fName
        binding!!.tvLname.text =  listOfStudents[position].lName
        binding!!.tvPhone.text =  listOfStudents[position].phone

        view.setOnClickListener {
            Toast.makeText(parent!!.context, listOfStudents[position].srNo, Toast.LENGTH_SHORT).show()
        }

        return view
    }
}