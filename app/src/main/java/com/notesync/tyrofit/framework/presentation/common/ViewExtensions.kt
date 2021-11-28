package com.notesync.tyrofit.framework.presentation.common

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.notesync.tyrofit.businesss.domain.state.StateMessageCallback
import com.notesync.tyrofit.util.TodoCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}


fun Activity.displayToast(
    @StringRes message: Int,
    stateMessageCallback: StateMessageCallback
) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    stateMessageCallback.removeMessageFromStack()
}

fun Activity.displayToast(
    message: String,
    stateMessageCallback: StateMessageCallback
) {
    Log.d("MainActivity", message)
    val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
    toast.show()

    stateMessageCallback.removeMessageFromStack()
}

fun Activity.displayToast(
    message: String,

    ) {
    Log.d("MainActivity", message)
    val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
    toast.show()

}

