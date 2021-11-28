package com.notesync.tyrofit.di

import com.notesync.tyrofit.framework.presentation.BaseActivity
import com.notesync.tyrofit.framework.presentation.BaseApplication
import com.notesync.tyrofit.framework.presentation.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi
import javax.inject.Singleton

@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
@FlowPreview
@Singleton
@Component(
    modules = [AppModule::class,ViewModelModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: BaseApplication): AppComponent
    }

    fun inject(baseActivity: BaseActivity)

    fun inject(mainActivity: MainActivity)

}