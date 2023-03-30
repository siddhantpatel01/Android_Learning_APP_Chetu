package com.example.android_learning_app.Activity

import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.android_learning_app.databinding.ActivityShowViewBinding


@Suppress("DEPRECATION")
open class show_view : AppCompatActivity() {

    private lateinit var binding: ActivityShowViewBinding
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityShowViewBinding.inflate(layoutInflater)
        binding.reload.setOnRefreshListener {
            binding.reload.setRefreshing(true);
        }
        setContentView(binding.root)
        binding.show.webViewClient = show_web_view()

        binding.show.loadUrl("https://music.youtube.com/")
        binding.show.settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        binding.show.settings.javaScriptEnabled = true
        binding.show.webViewRenderProcess
        getSupportActionBar()?.hide()

    }
    inner class show_web_view : WebViewClient(){
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            binding.progressbar.visibility = View.GONE
        }
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {

            return super.shouldOverrideUrlLoading(view, request)
        }
    }

    override fun onBackPressed() {
        if(binding.show.canGoBack()){
            binding.show.goBack()
        }else {
            super.onBackPressed()
        }
    }
}