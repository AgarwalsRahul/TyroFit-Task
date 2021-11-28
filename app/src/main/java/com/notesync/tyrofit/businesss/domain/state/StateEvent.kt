package com.notesync.tyrofit.businesss.domain.state

interface StateEvent {
    fun errorInfo(): String

    fun eventName(): String

    fun shouldDisplayProgressBar(): Boolean
}