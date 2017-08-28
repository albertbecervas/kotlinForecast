package com.omitsis.forecastktapp.di.modules

import android.app.Activity
import com.omitsis.forecastktapp.di.ActivityScope
import com.omitsis.forecastktapp.di.components.AppComponent
import com.omitsis.forecastktapp.model.AppUser
import com.omitsis.forecastktapp.model.auxModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(activity: Activity, appComponent: AppComponent?) {

    private val mActivity: Activity = activity
    private val mAppComponent: AppComponent? = appComponent

    @Provides
    @ActivityScope
    fun providesActivity() : Activity = mActivity

    @Provides
    @ActivityScope
    fun providesauxModel() : auxModel = auxModel

    @Provides
    @ActivityScope
    internal fun providesAppUser(): AppUser =
            AppUser("Juanjo")

}