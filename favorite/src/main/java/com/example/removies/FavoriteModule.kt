package com.example.removies

import com.example.removies.favorite.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { DashboardViewModel(get()) }
}