package com.example.removies.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.domain.usecase.MovieUseCase


class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {

    val movie = movieUseCase.getAllMovie().asLiveData()
}