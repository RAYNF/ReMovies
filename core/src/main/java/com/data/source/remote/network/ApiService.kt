package com.data.source.remote.network

import com.data.source.remote.response.MovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie/popular?api_key=8078620493e2e95b97ac7d3e41005591&language=en-US&page=1")
    suspend fun getList(): MovieResponse
}