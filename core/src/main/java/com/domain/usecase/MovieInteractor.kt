package com.domain.usecase

import com.domain.model.Movie
import com.domain.repository.IMovieRepository


class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {
    override fun getAllMovie() = movieRepository.getAllMovie()

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(tourism: Movie, state: Boolean) =
        movieRepository.setFavoriteMovie(tourism, state)

}