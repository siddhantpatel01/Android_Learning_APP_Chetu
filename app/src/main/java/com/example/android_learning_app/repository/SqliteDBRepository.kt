package com.example.android_learning_app.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


private const val DB_NAME = "_db_chetu"
private const val DB_VERSION = 1
private const val TABLE_NAME = "student"
private const val FNAME = "FirstName"
private const val LNAME = "LastName"
private const val PHONE = "Phone"
private const val SRNO = "Sr"

class SqliteDBRepository(private val context: Context) {

    val query = "CREATE TABLE $TABLE_NAME($SRNO INTEGER PRIMARY KEY AUTOINCREMENT, $FNAME TEXT, $LNAME TEXT, $PHONE TEXT)"
    val dbHelper = MyDbHelper(context)
    val sqliteDb = dbHelper.writableDatabase


    inner class MyDbHelper(private val context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION){
        override fun onCreate(sqliteDb: SQLiteDatabase?) {
            sqliteDb?.execSQL(query)
        }

        override fun onUpgrade(sqliteDb: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            // TODO("Not yet implemented")
        }

    }
}