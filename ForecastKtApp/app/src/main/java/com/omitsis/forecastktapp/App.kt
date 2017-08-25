package com.omitsis.forecastktapp

import android.app.Application
import com.omitsis.forecastktapp.di.components.AppComponent
import com.omitsis.forecastktapp.di.components.DaggerAppComponent
import com.omitsis.forecastktapp.di.modules.AppModule

class App : Application() {

    var mAppComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        mAppComponent = getAppComponent()
    }

    fun getAppComponent(): AppComponent{
        if(mAppComponent == null){
            mAppComponent = DaggerAppComponent
                    .builder()
                    .appModule(AppModule(this))
                    .build()
        }

        return mAppComponent as AppComponent
    }

    fun resetAppComponent(){
        mAppComponent = null
        getAppComponent()
    }
}