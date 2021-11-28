package com.notesync.tyrofit.framework.presentation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        (application as BaseApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState, persistentState)
    }

    abstract fun inject()
}