package com.ismailhakkiaydin.rickandmorty.data.mapper

import com.ismailhakkiaydin.rickandmorty.data.entity.Character
import com.ismailhakkiaydin.rickandmorty.data.response.CharacterResponse


fun CharacterResponse.Result.toDomainModel() = Character(
    name = name.orEmpty(),
    status = status.orEmpty(),
    species = species.orEmpty(),
    type = type.orEmpty(),
    gender = gender.orEmpty(),
    originName = this.origin?.name.orEmpty(),
    originUrl = this.origin?.url.orEmpty(),
    location = this.location?.name.orEmpty(),
    locationUrl = this.location?.url.orEmpty(),
    image = image.orEmpty(),
    episode = episode as List<String>
)