package com.latihan.cnn.base.viewmodel

import androidx.lifecycle.viewModelScope
import com.crocodic.core.base.viewmodel.CoreViewModel
import com.latihan.cnn.api.ApiService
import kotlinx.coroutines.launch

open class BaseViewModel(private val apiService: ApiService) : CoreViewModel() {

    override fun apiLogout() = viewModelScope.launch { }

    override fun apiRenewToken() = viewModelScope.launch { }

}