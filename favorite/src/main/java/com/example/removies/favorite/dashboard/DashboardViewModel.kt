package com.example.removies.favorite.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.domain.usecase.MovieUseCase

class DashboardViewModel(movieUseCase: MovieUseCase) : ViewModel() {

    val favoriteMovie = movieUseCase.getFavoriteMovie().asLiveData()
}