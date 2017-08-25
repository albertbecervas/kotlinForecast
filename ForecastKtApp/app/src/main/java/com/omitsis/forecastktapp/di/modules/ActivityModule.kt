package com.omitsis.forecastktapp.di.modules

import android.app.Activity
import com.omitsis.forecastktapp.di.ActivityScope
import com.omitsis.forecastktapp.di.components.AppComponent
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(activity: Activity, appComponent: AppComponent?) {

    private val mActivity: Activity = activity
    private val mAppComponent: AppComponent? = appComponent

    @Provides
    @ActivityScope
    fun providesActivity() : Activity = mActivity

}