package com.data.source.local

import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: com.data.source.local.room.MovieDao) {

    fun getAllMovie(): Flow<List<com.data.source.local.entity.MovieEntity>> = movieDao.getAllMovie()

    fun getFavoriteMovie(): Flow<List<com.data.source.local.entity.MovieEntity>> =
        movieDao.getFavoriteMovie()

    suspend fun insertMovie(movieList: List<com.data.source.local.entity.MovieEntity>) =
        movieDao.insertMovie(movieList)

    fun setFavoriteMovie(movie: com.data.source.local.entity.MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }
}