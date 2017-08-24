package com.omitsis.forecastktapp.api

import com.omitsis.forecastktapp.model.ForecastList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitApi {
    @GET("/data/2.5/forecast/daily?mode=json&units=metric&cnt=7&appid=603905bf808e9c6c06934299de229798&q=94043")
    fun get(): Call<ForecastList>

    companion object {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}
