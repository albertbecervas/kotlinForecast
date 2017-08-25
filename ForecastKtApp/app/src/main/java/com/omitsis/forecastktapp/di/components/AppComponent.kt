package com.omitsis.forecastktapp.di.components

import com.omitsis.forecastktapp.App
import com.omitsis.forecastktapp.di.ApplicationScope
import com.omitsis.forecastktapp.di.modules.AppModule
import dagger.Component

@ApplicationScope
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(app: App)

}