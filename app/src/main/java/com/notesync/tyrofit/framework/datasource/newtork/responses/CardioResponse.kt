package com.notesync.tyrofit.framework.datasource.newtork.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.notesync.tyrofit.framework.datasource.newtork.models.CardioDto

class CardioResponse(
    @SerializedName("success")
    @Expose
    val success: Boolean,
    @SerializedName("message")
    @Expose
    val message: String,
    @SerializedName("data")
    @Expose
    val data: List<CardioDto>
)

