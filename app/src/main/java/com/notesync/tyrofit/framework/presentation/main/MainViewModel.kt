package com.notesync.tyrofit.framework.presentation.main

import android.util.Log
import com.notesync.tyrofit.businesss.domain.model.Cardio
import com.notesync.tyrofit.businesss.domain.state.DataState
import com.notesync.tyrofit.businesss.domain.state.StateEvent
import com.notesync.tyrofit.businesss.interactors.GetCardio
import com.notesync.tyrofit.framework.presentation.common.BaseViewModel
import com.notesync.tyrofit.framework.presentation.main.state.MainStateEvent
import com.notesync.tyrofit.framework.presentation.main.state.MainViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@FlowPreview
class MainViewModel(private val getCardio: GetCardio) : BaseViewModel<MainViewState>() {
    override fun handleNewData(data: MainViewState) {
        data.let { viewState ->
            viewState.listData?.let {
                Log.d("MainViewModel","$it")
                setListData(it)
            }

        }
    }

    override fun setStateEvent(stateEvent: StateEvent) {
        val job: Flow<DataState<MainViewState>> = when (stateEvent) {
            is MainStateEvent.GetCardiosEvent -> {
                getCardio.getCardio(stateEvent)
            }
            is MainStateEvent.CreateStateMessageEvent -> {
                emitStateMessageEvent(
                    stateMessage = stateEvent.stateMessage,
                    stateEvent = stateEvent
                )
            }
            else -> {
                emitInvalidStateEvent(stateEvent)
            }
        }
        launchJob(stateEvent, job)
    }

    override fun initNewViewState(): MainViewState {
        return MainViewState()
    }

    fun setListData(data: ArrayList<Cardio>) {
        val update = getCurrentViewStateOrNew()
        update.listData = data
        setViewState(update)
    }
}