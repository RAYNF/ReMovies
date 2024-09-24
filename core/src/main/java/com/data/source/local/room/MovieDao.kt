package com.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getAllMovie(): Flow<List<com.data.source.local.entity.MovieEntity>>

    @Query("SELECT * FROM movie WHERE isFavorite = 1")
    fun getFavoriteMovie(): Flow<List<com.data.source.local.entity.MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: List<com.data.source.local.entity.MovieEntity>)

    @Update
    fun updateFavoriteMovie(movie: com.data.source.local.entity.MovieEntity)
}