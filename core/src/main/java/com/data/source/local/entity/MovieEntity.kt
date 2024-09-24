package com.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "backgroundImage")
    var backgroundImage: String,

    @ColumnInfo(name = "like")
    var like: Double,

    @ColumnInfo(name = "popularity")
    var popularity: Double,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false

) : Parcelable