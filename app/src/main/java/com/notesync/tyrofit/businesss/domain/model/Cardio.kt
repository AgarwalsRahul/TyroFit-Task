package com.notesync.tyrofit.businesss.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cardio(
    val id: Int,
    val name: String,
    val category_id: Int,
    val trainer_id: Int,
    val image: String,
    val duration: String,
    val min_calories: Int,
    val max_calories: Int,
    val description: String,
    val difficulty_level: Int,
    val createdAt: String,
    val updatedAt: String?,
    val video: String,
    val video_updatedAt: String?,
    val equipments: List<String>,
    val workout_plans: List<WorkoutPlan>,
    val trainer_name: String,
    val difficulty_level_name: String,
    val category_name: String

):Parcelable

@Parcelize
data class WorkoutPlan(
    val name: String,
    val reps: String
):Parcelable