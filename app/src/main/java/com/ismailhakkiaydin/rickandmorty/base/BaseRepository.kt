package com.ismailhakkiaydin.rickandmorty.base

import com.ismailhakkiaydin.rickandmorty.base.dispatcher.DispatcherProvider
import com.ismailhakkiaydin.rickandmorty.util.Resource
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException


abstract class BaseRepository constructor(private val dispatcher: DispatcherProvider) {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Resource<T> {
        return withContext(dispatcher.io) {
            try {
                val result = apiCall.invoke()
                when ((result as Response<*>).code()) {
                    in 200..300 -> Resource.Success(result)
                    401 -> Resource.Error("Error")
                    else -> Resource.Error(result.message())
                }
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> Resource.Error(throwable.message())
                    is SocketTimeoutException -> Resource.Error("Error")
                    is IOException -> Resource.Error("Error")
                    else -> {
                        Resource.Error("Error")
                    }
                }
            }
        }
    }
}