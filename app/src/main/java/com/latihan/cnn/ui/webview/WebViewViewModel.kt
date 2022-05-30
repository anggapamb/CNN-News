package com.latihan.cnn.ui.webview

import com.latihan.cnn.api.ApiService
import com.latihan.cnn.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WebViewViewModel @Inject constructor(
    apiService: ApiService
) : BaseViewModel(apiService) {

}