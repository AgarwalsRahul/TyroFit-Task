package com.notesync.tyrofit.businesss.data.network.abstraction

import com.notesync.tyrofit.businesss.domain.model.Cardio

interface CardioNetworkDataSource {

    suspend fun getCardios():List<Cardio>

}