package com.omitsis.forecastktapp.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.omitsis.forecastktapp.R
import com.omitsis.forecastktapp.model.Forecast
import com.omitsis.forecastktapp.model.ForecastList
import kotlinx.android.synthetic.main.item_recycler.view.*

class ForecastListAdapter(private val forecastList: ForecastList, private val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(forecastList)
    }

    override fun getItemCount(): Int = forecastList.list.size

    class ViewHolder(itemView: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(itemView) {

        fun bindForecast(forecastList: ForecastList) {
            with(forecastList.list[adapterPosition]) {
                val iconUrl = "http://api.openweathermap.org/img/w/${weather[0].icon}.png"
                Glide.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.date.text = "Temp min -> ${temp.min} , ${weather[0].description}"
                itemView.description.text = weather[0].description
                itemView.maxTemperature.text = "${temp.max}"
                itemView.minTemperature.text = "${temp.min}"
                itemView.setOnClickListener { itemClick(this) }

            }

        }
    }
}
