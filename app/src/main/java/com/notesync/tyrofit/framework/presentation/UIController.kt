package com.notesync.tyrofit.framework.presentation

import com.notesync.tyrofit.businesss.domain.state.Response
import com.notesync.tyrofit.businesss.domain.state.StateMessageCallback

interface UIController {

    fun displayProgressBar(isDisplayed: Boolean)

    fun hideSoftKeyboard()

    fun onResponseReceived(
        response: Response,
        stateMessageCallback: StateMessageCallback
    )


}