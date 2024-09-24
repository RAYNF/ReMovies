package com.example.removies.presentation.ui.detail

import androidx.lifecycle.ViewModel
import com.domain.model.Movie
import com.domain.usecase.MovieUseCase


class DetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus: Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)

}