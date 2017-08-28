package com.omitsis.forecastktapp.ui.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.omitsis.forecastktapp.BaseActivity
import com.omitsis.forecastktapp.R
import com.omitsis.forecastktapp.model.auxModel
import javax.inject.Inject

import kotlinx.android.synthetic.main.activity_detail.*
class DetailActivity : BaseActivity() {

    @Inject
    lateinit var auxModel : auxModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        getActivityComponent().inject(this)

        setViews()
    }

    private fun setViews() {
        population.text = auxModel.city.name
        val iconUrl = "http://api.openweathermap.org/img/w/${auxModel.forecast.weather[0].icon}.png"
        Glide.with(this).load(iconUrl).into(icon)
        currentTemp.text = auxModel.forecast.temp.day.toString()
        description.text = auxModel.forecast.weather[0].description
        minTemp.text = auxModel.forecast.temp.min.toString()
        maxTemp.text = auxModel.forecast.temp.max.toString()
    }
}
