package com.notesync.tyrofit.framework.presentation.main.state

import android.os.Parcelable
import com.notesync.tyrofit.businesss.domain.model.Cardio
import com.notesync.tyrofit.businesss.domain.state.ViewState
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainViewState(
 var listData:ArrayList<Cardio>?=null,
):Parcelable,ViewState
