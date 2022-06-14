package com.ismailhakkiaydin.rickandmorty.data.repository

import com.ismailhakkiaydin.rickandmorty.base.BaseRepository
import com.ismailhakkiaydin.rickandmorty.base.dispatcher.DispatcherProvider
import com.ismailhakkiaydin.rickandmorty.data.model.Character
import com.ismailhakkiaydin.rickandmorty.data.service.CharacterService
import com.ismailhakkiaydin.rickandmorty.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CharacterRepository @Inject constructor(
    private val api: CharacterService,
    dispatcher: DispatcherProvider
) : BaseRepository(dispatcher = dispatcher) {

    suspend fun getCharacters(page: String): Resource<Character?>? {
        val networkResponse = safeApiCall {
            api.getCharacters(page = page)
        }
        return when (networkResponse) {
            is Resource.Success -> {
                val result = networkResponse.data
                result?.isSuccessful.let {
                    it?.let {
                        Resource.Success(result?.body())
                    } ?: result?.message()?.let { message ->
                        Resource.Error(message = message)
                    }
                }
            }
            is Resource.Error -> Resource.Error(networkResponse.message.orEmpty())
            else -> Resource.Error(networkResponse.message.orEmpty())
        }
    }

}