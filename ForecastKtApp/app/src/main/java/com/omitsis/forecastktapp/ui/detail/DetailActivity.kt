package com.omitsis.forecastktapp.ui.detail

import android.os.Bundle
import com.omitsis.forecastktapp.BaseActivity
import com.omitsis.forecastktapp.R
import com.omitsis.forecastktapp.model.auxModel
import javax.inject.Inject

class DetailActivity : BaseActivity() {

    @Inject
    lateinit var auxModel : auxModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getActivityComponent().inject(this)

        var vd: String? = auxModel.forecast.deg.toString()
        setContentView(R.layout.activity_detail)
    }
}
