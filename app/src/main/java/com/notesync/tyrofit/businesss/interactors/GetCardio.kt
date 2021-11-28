package com.notesync.tyrofit.businesss.interactors

import android.util.Log
import com.notesync.tyrofit.businesss.data.network.ApiResponseHandler
import com.notesync.tyrofit.businesss.data.network.abstraction.CardioNetworkDataSource
import com.notesync.tyrofit.businesss.data.util.safeApiCall
import com.notesync.tyrofit.businesss.domain.model.Cardio
import com.notesync.tyrofit.businesss.domain.state.*
import com.notesync.tyrofit.framework.presentation.main.state.MainViewState
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCardio(private val cardioNetworkDataSource: CardioNetworkDataSource) {

    companion object {
        const val SUCCESS_FETCH = "Successfully Fetched"
    }


    fun getCardio(stateEvent: StateEvent): Flow<DataState<MainViewState>> = flow {

        val result = safeApiCall(IO) {
            cardioNetworkDataSource.getCardios()
        }

        val response = object : ApiResponseHandler<MainViewState, List<Cardio>>(
            stateEvent = stateEvent,
            response = result
        ) {
            override suspend fun handleSuccess(resultObj: List<Cardio>): DataState<MainViewState> {
                if (resultObj.isEmpty()) {
                    return DataState.data(
                        Response("No data", UIComponentType.SnackBar(), MessageType.Error()),
                        null,
                        stateEvent
                    )
                }
                Log.d("GetCardio","$resultObj")
                return DataState.data(
                    data = MainViewState(listData = ArrayList(resultObj)),
                    response = Response(
                        SUCCESS_FETCH,
                        UIComponentType.None(),
                        MessageType.Success()
                    ),
                    stateEvent = stateEvent
                )

            }

        }.getResult()

        emit(response)
    }
}