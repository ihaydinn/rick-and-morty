package com.ismailhakkiaydin.rickandmorty.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originName: String,
    val originUrl: String,
    val location: String,
    val locationUrl: String,
    val image: String,
    val episode: List<String>
) : Parcelable

