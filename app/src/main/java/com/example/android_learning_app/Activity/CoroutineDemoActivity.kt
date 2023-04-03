package com.example.android_learning_app.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.android_learning_app.R
import com.example.android_learning_app.databinding.ActivityCoroutineDemoBinding
import com.example.android_learning_app.kotlinConcepts.BusinessLogic
import kotlinx.coroutines.*

class CoroutineDemoActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityCoroutineDemoBinding
    var count: Int = 0
    val TAG = "Coroutine_Coroutine"
     lateinit var exception: CoroutineExceptionHandler
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutine_demo)
        
        
        binding.btnClick.setOnClickListener(this)
        binding.btnDownload.setOnClickListener(this)
        binding.btnAsync.setOnClickListener(this)
        binding.btnExceptionHandler.setOnClickListener(this)

       exception =  CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.d(TAG, " CoroutineExceptionHandler handled")
        }
    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_click ->{
                count++
                binding.tvCount.text = "${Thread.currentThread().name} $count"
            }
            
            R.id.btn_download ->{
//                downloading()

                CoroutineScope(Dispatchers.Main).launch {
                    val total = BusinessLogic().getOutPut()
                    Log.d("TotalCount", "onClick: $total")
                }
            }

            R.id.btn_async ->{
                CoroutineScope(Dispatchers.Main).async{
//                    asyncBuilderConcept()
                    task1()
                    task2()

                    val task1 = async { task1() }
                    val task2 = async { task2() }

                    val totalTime1 = task1.await()
                    val totalTime2 = task2.await()
                    Log.d(TAG, "Total Time taken1 $totalTime1")
                    Log.d(TAG, "Total Time taken2 $totalTime2")
                }
            }

            R.id.btn_exception_handler ->{
                CoroutineScope(Dispatchers.Main).launch(exception){
                    val child1 = launch { 
                        delay(2000)
                        Log.d(TAG, "onClick: Child 1")

                        throw CancellationException("Cancelation occured")
//                        throw Exception("Exception occured...")
//                        val i = 10/0
//                        Log.d(TAG, "onClick: $i")
//                        try{
//                            val i = 10/0
//                        }catch (e: Exception){
//                            Log.d(TAG, "Exception  handle")
//                        }
                    }
                    
                    val child2 = launch { 
                        delay(4000)
                        Log.d(TAG, "onClick: Child2")
                    }

//                    child1.cancel()
                    Log.d(TAG, "onClick: Parent")
                }
            }
        }
    }

    private suspend fun asyncBuilderConcept() {
        var count: Int = 100
        val job = CoroutineScope(Dispatchers.Main).async {
            Log.d(TAG, "Before increament $count")
            count++
            return@async count
        }

        Log.d(TAG, "After increament ${job.await()}")
    }

    private fun downloading() { 
        val job = CoroutineScope(Dispatchers.IO).launch { 
            for (i in 1..1000){
                Log.d(TAG, "downloading in ${Thread.currentThread().name}: $i")
                withContext(Dispatchers.Main){
                    binding.tvDownload.text = "Downloading in ${Thread.currentThread().name} \n $i"
                }
            }
            binding.tvDownload.text = "completed..."
        }

        Log.d("TAG_TAG_TAG", "downloading: $job")
    }

    private fun task1(){
        CoroutineScope(Dispatchers.Main).async {
            delay(1000)
            Log.d(TAG, "task1: completed")
            return@async
        }
    }

    private fun task2(){
        CoroutineScope(Dispatchers.Main).async {
            delay(4000)
            Thread.sleep(1000)
            Log.d(TAG, "task2: completed")
            return@async
        }
    }




}