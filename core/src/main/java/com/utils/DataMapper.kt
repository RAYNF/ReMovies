package com.utils

import com.data.source.remote.response.ResultsItem
import com.domain.model.Movie

object DataMapper {

    fun mapResponsesToEntities(input: List<ResultsItem>): List<com.data.source.local.entity.MovieEntity> {
        val movieList = ArrayList<com.data.source.local.entity.MovieEntity>()
        input.map {
            val tourism = com.data.source.local.entity.MovieEntity(
                movieId = it.id,
                name = it.title,
                description = it.overview,
                image = it.posterPath,
                backgroundImage = it.backdropPath,
                like = it.voteAverage,
                popularity = it.voteCount,
                isFavorite = false
            )
            movieList.add(tourism)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<com.data.source.local.entity.MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                name = it.name,
                description = it.description,
                image = it.image,
                backgroundImage = it.backgroundImage,
                like = it.like,
                popularity = it.popularity,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = com.data.source.local.entity.MovieEntity(
        movieId = input.movieId,
        name = input.name,
        description = input.description,
        image = input.image,
        backgroundImage = input.backgroundImage,
        like = input.like,
        popularity = input.popularity,
        isFavorite = input.isFavorite
    )
}