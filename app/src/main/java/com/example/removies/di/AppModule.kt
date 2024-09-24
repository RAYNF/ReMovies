package com.example.removies.di

import com.domain.usecase.MovieInteractor
import com.domain.usecase.MovieUseCase
import com.example.removies.presentation.ui.detail.DetailViewModel
import com.example.removies.presentation.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}