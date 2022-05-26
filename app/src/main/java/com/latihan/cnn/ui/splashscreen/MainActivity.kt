package com.latihan.cnn.ui.splashscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.crocodic.core.extension.openActivity
import com.crocodic.core.extension.tos
import com.latihan.cnn.R
import com.latihan.cnn.base.activity.BaseActivity
import com.latihan.cnn.databinding.ActivityMainBinding
import com.latihan.cnn.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayoutRes(R.layout.activity_main)

        //fullscreen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        //transparent status bar
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )


        Handler(Looper.getMainLooper()).postDelayed({
            openActivity<HomeActivity>()
            finish()
        },  3000)

    }
}