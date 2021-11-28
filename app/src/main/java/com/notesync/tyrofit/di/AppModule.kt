package com.notesync.tyrofit.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.notesync.tyrofit.businesss.data.network.abstraction.CardioNetworkDataSource
import com.notesync.tyrofit.businesss.data.network.implementation.CardioNetworkDataSourceImpl
import com.notesync.tyrofit.businesss.interactors.GetCardio
import com.notesync.tyrofit.framework.datasource.newtork.APIService
import com.notesync.tyrofit.framework.datasource.newtork.abstraction.CardiosApiService
import com.notesync.tyrofit.framework.datasource.newtork.implementation.CardiosApiServiceImplementation
import com.notesync.tyrofit.framework.datasource.newtork.mappers.NetworkEntityMapper
import com.notesync.tyrofit.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRetrofitBuilder(gsonBuilder: Gson): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideApiService(retrofitBuilder: Retrofit.Builder): APIService {
        return retrofitBuilder.build().create(APIService::class.java)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideNetworkEntityMapper(): NetworkEntityMapper {
        return NetworkEntityMapper()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideCardiosApiService(
        apiService: APIService,
        mapper: NetworkEntityMapper
    ): CardiosApiService {
        return CardiosApiServiceImplementation(apiService, mapper)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideCardioNetworkDataSource(
        cardiosApiService: CardiosApiService
    ): CardioNetworkDataSource {
        return CardioNetworkDataSourceImpl(cardiosApiService)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideCardioInteractor(
        cardioNetworkDataSource: CardioNetworkDataSource
    ): GetCardio {
        return GetCardio(cardioNetworkDataSource)
    }
}