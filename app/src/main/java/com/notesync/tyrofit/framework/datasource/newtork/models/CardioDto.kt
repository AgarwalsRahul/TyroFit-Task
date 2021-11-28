package com.notesync.tyrofit.framework.datasource.newtork.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.notesync.tyrofit.businesss.domain.model.WorkoutPlan

class CardioDto(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("category_id")
    @Expose
    val category_id: Int,
    @SerializedName("trainer_id")
    @Expose
    val trainer_id: Int,
    @SerializedName("image")
    @Expose
    val image: String,
    @SerializedName("duration")
    @Expose
    val duration: Long,
    @SerializedName("min_calories")
    @Expose
    val min_calories: Int,
    @SerializedName("max_calories")
    @Expose
    val max_calories: Int,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("difficulty_level")
    @Expose
    val difficulty_level: Int,
    @SerializedName("createdAt")
    @Expose
    val createdAt: Long,
    @SerializedName("updatedAt")
    @Expose
    val updatedAt: Long?,
    @SerializedName("video")
    @Expose
    val video: String,
    @SerializedName("video_updatedAt")
    @Expose
    val video_updatedAt: Long?,
    @SerializedName("equipments")
    @Expose
    val equipments: List<String>,
    @SerializedName("workout_plans")
    @Expose
    val workout_plans: List<WorkoutPlanDto>,
    @SerializedName("trainer_name")
    @Expose
    val trainer_name: String,
    @SerializedName("difficulty_level_name")
    @Expose
    val difficulty_level_name: String,
    @SerializedName("category_name")
    @Expose
    val category_name: String
)

class WorkoutPlanDto(
    @SerializedName("name")
    @Expose
    val name:String,
    @SerializedName("reps")
    @Expose
    val reps:String,
)