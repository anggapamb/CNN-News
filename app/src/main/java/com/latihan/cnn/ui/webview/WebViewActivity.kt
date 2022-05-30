package com.latihan.cnn.ui.webview

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.latihan.cnn.R
import com.latihan.cnn.base.activity.BaseActivity
import com.latihan.cnn.databinding.ActivityWebViewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebViewActivity : BaseActivity<ActivityWebViewBinding, WebViewViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayoutRes(R.layout.activity_web_view)

        webViewSetup()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup() {

        val getUrl = intent.getStringExtra("dataWEB")

        binding.webView.webViewClient = WebViewClient()
        binding.webView.apply {
            loadUrl("$getUrl")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }
}