package com.latihan.cnn.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.crocodic.core.api.ApiCode
import com.crocodic.core.api.ApiObserver
import com.crocodic.core.api.ApiResponse
import com.crocodic.core.extension.toList
import com.google.gson.Gson
import com.latihan.cnn.R
import com.latihan.cnn.api.ApiService
import com.latihan.cnn.base.viewmodel.BaseViewModel
import com.latihan.cnn.data.article.ArticleEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val apiService: ApiService,
    private val gson: Gson
) : BaseViewModel(apiService) {

    val dataArticle = MutableLiveData<List<ArticleEntity>>()

    fun listTerbaru() = viewModelScope.launch(Dispatchers.IO) {
        apiResponse.postValue(ApiResponse().responseLoading())
        apiService.getTerbaru()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : ApiObserver(true) {
                override fun onSuccess(t: String) {
                    val responseJson = JSONObject(t)

                    val apiStatus = responseJson.getBoolean("success")
                    val apiMessage = responseJson.getString(ApiCode.MESSAGE)
                    android.util.Log.d("MainActivity", "FriendData : $t")

                    if (apiStatus) {
                        val user = responseJson.getJSONObject(ApiCode.DATA).getJSONArray("posts").toList<ArticleEntity>(gson)
                        dataArticle.postValue(user)
                        apiResponse.postValue(ApiResponse().responseSuccess(apiMessage))
                    } else {
                        apiResponse.postValue(ApiResponse().responseWrong(apiMessage))
                    }

                }

                override fun onError(e: Throwable) {
                    apiResponse.postValue(ApiResponse().responseError(e))
                }
            })
    }

}