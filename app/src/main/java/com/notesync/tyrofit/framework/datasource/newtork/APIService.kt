package com.notesync.tyrofit.framework.datasource.newtork

import com.notesync.tyrofit.framework.datasource.newtork.responses.CardioResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("user/workout/all")
    suspend fun getCardios(
        @Query("category_id") categoryId: Int,
    ): CardioResponse
}