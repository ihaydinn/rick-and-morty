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
                    401 -> Resource.Error("401: " + result.message())
                    else -> Resource.Error(result.message())
                }
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> Resource.Error("HttpException: " + throwable.message())
                    is SocketTimeoutException -> Resource.Error("SocketTimeoutException: " + throwable.message)
                    is IOException -> Resource.Error("IOException: " + throwable.message)
                    else -> {
                        Resource.Error("else: " + throwable.message)
                    }
                }
            }
        }
    }
}