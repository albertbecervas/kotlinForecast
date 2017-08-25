package com.omitsis.forecastktapp.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.omitsis.forecastktapp.BaseActivity
import com.omitsis.forecastktapp.R
import com.omitsis.forecastktapp.api.RetrofitApi
import com.omitsis.forecastktapp.model.AppUser
import com.omitsis.forecastktapp.model.ForecastList
import kotlinx.android.synthetic.main.activity_jt_k.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : BaseActivity() {

//    @Inject
//    lateinit var appUser: AppUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jt_k)

        getActivityComponent().inject(this)

//        var user: String? = appUser.userName

        setViews()
    }

    private fun setViews() {
        getWeatherButton.setOnClickListener {
            getForecast()
        }
    }

    private fun getForecast() {
        val retrofitApi = RetrofitApi.retrofit.create(RetrofitApi::class.java)
        val call = retrofitApi.get()
        call.enqueue(object : Callback<ForecastList> {

            override fun onResponse(call: Call<ForecastList>, response: Response<ForecastList>) {
                val forecastList = response.body()

                val mAdapter = ForecastListAdapter(forecastList) { toast(it.pressure.toString()) }

                val mLayoutManager = LinearLayoutManager(applicationContext)
                recycler.layoutManager = mLayoutManager
                recycler.adapter = mAdapter
            }

            override fun onFailure(call: Call<ForecastList>, t: Throwable) {
            }
        })
    }

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }

}
