package com.notesync.tyrofit.di

import com.notesync.tyrofit.businesss.interactors.GetCardio
import com.notesync.tyrofit.framework.presentation.common.ViewModelFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi

@FlowPreview
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
@Module
object ViewModelModule {


    @JvmStatic
    @Provides
    fun provideViewModelFactory(
        getCardio: GetCardio
    ): ViewModelFactory {
        return ViewModelFactory(
            getCardio
        )
    }
}