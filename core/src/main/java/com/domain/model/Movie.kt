package com.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val movieId: String,
    val name: String,
    val description: String,
    val image: String,
    val backgroundImage: String,
    val like: Double,
    val popularity: Double,
    val isFavorite: Boolean
) : Parcelable
