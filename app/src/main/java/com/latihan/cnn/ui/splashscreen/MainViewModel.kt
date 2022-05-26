package com.latihan.cnn.ui.splashscreen

import com.latihan.cnn.api.ApiService
import com.latihan.cnn.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val apiService: ApiService
) : BaseViewModel(apiService) {

}