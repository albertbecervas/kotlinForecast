package com.omitsis.forecastktapp.di.components

import com.omitsis.forecastktapp.di.ActivityScope
import com.omitsis.forecastktapp.di.modules.ActivityModule
import com.omitsis.forecastktapp.ui.detail.DetailActivity
import com.omitsis.forecastktapp.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity : MainActivity)

    fun inject(activity: DetailActivity)

}