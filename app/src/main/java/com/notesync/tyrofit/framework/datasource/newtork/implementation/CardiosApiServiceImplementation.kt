package com.notesync.tyrofit.framework.datasource.newtork.implementation

import com.notesync.tyrofit.businesss.domain.model.Cardio
import com.notesync.tyrofit.framework.datasource.newtork.APIService
import com.notesync.tyrofit.framework.datasource.newtork.abstraction.CardiosApiService
import com.notesync.tyrofit.framework.datasource.newtork.mappers.NetworkEntityMapper
import com.notesync.tyrofit.util.printLogD
import javax.inject.Inject

class CardiosApiServiceImplementation @Inject constructor(
    private val apiService: APIService,
    private val mapper: NetworkEntityMapper
) : CardiosApiService {

    override suspend fun getCardios(): List<Cardio> {
        return apiService.getCardios(14).data.map {
            printLogD("ApiService",it.category_name)
            mapper.mapFromEntity(it)
        }
    }
}