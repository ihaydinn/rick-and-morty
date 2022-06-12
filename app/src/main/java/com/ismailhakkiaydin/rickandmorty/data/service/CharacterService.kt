package com.ismailhakkiaydin.rickandmorty.data.service

import com.ismailhakkiaydin.rickandmorty.data.model.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET(CHARACTER)
    suspend fun getCharacters(@Query("page") page: String): Response<Character>

    companion object {
        const val CHARACTER = "character"
    }
}