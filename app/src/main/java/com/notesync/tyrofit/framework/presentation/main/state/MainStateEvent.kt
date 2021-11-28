package com.notesync.tyrofit.framework.presentation.main.state

import com.notesync.tyrofit.businesss.domain.state.StateEvent
import com.notesync.tyrofit.businesss.domain.state.StateMessage

sealed class MainStateEvent :StateEvent {

    object GetCardiosEvent :MainStateEvent(){
        override fun errorInfo(): String {
            return "Error while fetching cardio"
        }

        override fun eventName(): String {
            return "GetCardiosEvent"
        }

        override fun shouldDisplayProgressBar(): Boolean {
            return true
        }

    }

    class CreateStateMessageEvent(
        val stateMessage: StateMessage
    ) : MainStateEvent() {

        override fun errorInfo(): String {
            return "Error creating a new state message."
        }

        override fun eventName(): String {
            return "CreateStateMessageEvent"
        }

        override fun shouldDisplayProgressBar() = false
    }
}