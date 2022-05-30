package com.latihan.cnn.api

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("terbaru/")
    fun getTerbaru(): Single<String>

    @GET("nasional/")
    fun getNasional(): Single<String>

    @GET("internasional/")
    fun getInternasional(): Single<String>

    @GET("ekonomi/")
    fun getEkonomi(): Single<String>

    @GET("olahraga")
    fun getOlahraga(): Single<String>

    @GET("teknologi")
    fun getTeknologi(): Single<String>

    @GET("hiburan")
    fun getHiburan(): Single<String>

    @GET("gayaHidup")
    fun getGayaHidup(): Single<String>

}