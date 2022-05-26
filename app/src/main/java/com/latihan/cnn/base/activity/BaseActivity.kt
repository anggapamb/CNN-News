package com.latihan.cnn.base.activity

import androidx.databinding.ViewDataBinding
import com.crocodic.core.base.activity.CoreActivity
import com.crocodic.core.data.CoreSession
import com.crocodic.core.extension.clearNotification
import com.google.gson.Gson
import com.latihan.cnn.base.viewmodel.BaseViewModel
import com.latihan.cnn.data.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

open class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : CoreActivity<VB, VM>() {

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var appDatabase: AppDatabase

    @Inject
    lateinit var session: CoreSession

    override fun authLogoutSuccess() {
        loadingDialog.dismiss()
        expiredDialog.dismiss()
        clearNotification()
        GlobalScope.launch {
            appDatabase.clearAllTables()
        }
    }

}