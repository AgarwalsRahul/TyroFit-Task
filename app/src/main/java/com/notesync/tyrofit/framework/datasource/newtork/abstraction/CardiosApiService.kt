package com.notesync.tyrofit.framework.datasource.newtork.abstraction

import com.notesync.tyrofit.businesss.domain.model.Cardio
import com.notesync.tyrofit.framework.datasource.newtork.responses.CardioResponse

interface CardiosApiService {

    suspend fun getCardios():List<Cardio>
}