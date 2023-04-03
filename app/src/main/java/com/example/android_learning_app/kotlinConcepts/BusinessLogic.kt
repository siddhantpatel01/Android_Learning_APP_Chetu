package com.example.android_learning_app.kotlinConcepts

import android.util.Log
import kotlinx.coroutines.*

class BusinessLogic {

    var count = 0
    lateinit var deferred : Deferred<Int>

    suspend fun getOutPut() : Int{
        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                count = 2000
            }
            deferred = async (Dispatchers.IO){
                delay(3000)
                return@async 10
            }
        }
        return count + deferred.await()
    }
}