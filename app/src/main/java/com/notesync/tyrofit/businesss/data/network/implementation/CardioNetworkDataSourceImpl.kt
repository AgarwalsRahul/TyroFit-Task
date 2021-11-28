package com.notesync.tyrofit.businesss.data.network.implementation

import com.notesync.tyrofit.businesss.data.network.abstraction.CardioNetworkDataSource
import com.notesync.tyrofit.businesss.domain.model.Cardio
import com.notesync.tyrofit.framework.datasource.newtork.abstraction.CardiosApiService
import javax.inject.Inject

class CardioNetworkDataSourceImpl @Inject constructor(private val cardiosApiService: CardiosApiService) :
    CardioNetworkDataSource {
    override suspend fun getCardios(): List<Cardio> {
        return cardiosApiService.getCardios()
    }
}