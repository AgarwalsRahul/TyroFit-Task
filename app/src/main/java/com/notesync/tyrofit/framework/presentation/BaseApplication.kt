package com.notesync.tyrofit.framework.presentation

import android.app.Application
import com.notesync.tyrofit.di.AppComponent
import com.notesync.tyrofit.di.DaggerAppComponent
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
@ObsoleteCoroutinesApi
@FlowPreview
open class BaseApplication : Application() {



    lateinit var appComponent: AppComponent

    override fun onCreate() {

        super.onCreate()
        initAppComponent()
    }

    open fun initAppComponent() {
        appComponent = DaggerAppComponent.factory().create(this)
    }

}