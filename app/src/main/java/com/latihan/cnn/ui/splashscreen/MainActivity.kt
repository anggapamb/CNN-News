package com.latihan.cnn.ui.splashscreen

import android.os.Bundle
import com.crocodic.core.extension.tos
import com.latihan.cnn.R
import com.latihan.cnn.base.activity.BaseActivity
import com.latihan.cnn.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayoutRes(R.layout.activity_main)

        tos("Ini Splashscreen")

    }
}