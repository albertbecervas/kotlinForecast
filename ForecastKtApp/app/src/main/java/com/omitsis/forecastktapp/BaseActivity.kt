package com.omitsis.forecastktapp

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.omitsis.forecastktapp.di.components.ActivityComponent
import com.omitsis.forecastktapp.di.components.DaggerActivityComponent
import com.omitsis.forecastktapp.di.modules.ActivityModule

open class BaseActivity : AppCompatActivity() {

    private var mActivityCompoent: ActivityComponent? = null
    private var mApplication: App? = null

    fun getActivityComponent(): ActivityComponent {
        if (mActivityCompoent == null) {
            mApplication = application as App
            mActivityCompoent = DaggerActivityComponent.builder()
                    .appComponent(mApplication!!.mAppComponent)
                    .activityModule(ActivityModule(this, mApplication!!.mAppComponent))
                    .build()
        }
        return mActivityCompoent as ActivityComponent
    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }
}