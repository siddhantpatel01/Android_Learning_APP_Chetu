package com.example.android_learning_app

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.android_learning_app.databinding.ActivityImplicitIntentBinding

class Implicit_Intent : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityImplicitIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImplicitIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.call.setOnClickListener(this)
        binding.email.setOnClickListener(this)
        binding.dial.setOnClickListener(this)
        binding.view.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.dial -> {
                // Toast.makeText(this,"dial",Toast.LENGTH_SHORT).show()
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:6387511508")
                startActivity(intent)

            }
//            Calling method
            R.id.call -> {
                //Toast.makeText(this,"call",Toast.LENGTH_SHORT).show()
                if (ContextCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.CALL_PHONE
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    val intent = Intent(Intent.ACTION_CALL)
                    intent.data = Uri.parse("tel:6387511508")
                    startActivity(intent)
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.CALL_PHONE),
                        1001
                    )
                }
            }

            R.id.email -> {

                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:") // only email apps should handle this
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("siddhantpatel445@gmail.com"))
                    putExtra(
                        Intent.EXTRA_SUBJECT,
                        "I hope you enjoy your Android development journey "
                    )

                }
                startActivity(intent)
            }
            R.id.view ->{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/reference/android/content/Intent"))
                startActivity(intent)
            }
        }
    }
}