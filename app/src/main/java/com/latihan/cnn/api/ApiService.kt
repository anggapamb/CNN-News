package com.latihan.cnn.api

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("terbaru/")
    fun getTerbaru(): Single<String>

}