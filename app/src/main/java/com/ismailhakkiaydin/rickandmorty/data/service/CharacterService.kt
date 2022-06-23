package com.ismailhakkiaydin.rickandmorty.data.service

import com.ismailhakkiaydin.rickandmorty.data.response.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET(CHARACTER)
    suspend fun getCharacters(@Query("page") page: String): Response<CharacterResponse>

    companion object {
        const val CHARACTER = "character"
    }
}