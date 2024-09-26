package com.data.source.remote

import android.util.Log
import com.data.source.remote.network.ApiResponse
import com.data.source.remote.network.ApiService
import com.data.source.remote.response.ResultsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllMovie(): Flow<ApiResponse<List<ResultsItem>>> {

        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    Log.d("API", "berhasil")
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                    Log.d("API", "gagal")
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
                Log.d("API", "tidak bisa")
            }
        }.flowOn(Dispatchers.IO)
    }
}