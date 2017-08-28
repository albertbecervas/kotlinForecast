package com.omitsis.forecastktapp.helpers

import com.omitsis.forecastktapp.model.Forecast

class Test private constructor() {
    var forecast: Forecast? = null

    companion object {
        var instance: Test? = null
    }

}
