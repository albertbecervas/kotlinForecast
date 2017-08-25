package com.omitsis.forecastktapp.di.modules

import com.omitsis.forecastktapp.App
import com.omitsis.forecastktapp.model.AppUser
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(application: App) {

    var app: App = application

    @Provides
    @Singleton
    fun providesApp(): App = app

    @Provides
    @Singleton
    internal fun providesAppUser(): AppUser =
            AppUser("Juanjo")

}