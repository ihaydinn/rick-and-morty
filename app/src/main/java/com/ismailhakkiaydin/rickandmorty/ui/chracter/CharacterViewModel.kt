package com.ismailhakkiaydin.rickandmorty.ui.chracter

import androidx.lifecycle.viewModelScope
import com.ismailhakkiaydin.rickandmorty.base.BaseViewModel
import com.ismailhakkiaydin.rickandmorty.data.mapper.toDomainModel
import com.ismailhakkiaydin.rickandmorty.data.repository.CharacterRepository
import com.ismailhakkiaydin.rickandmorty.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : BaseViewModel() {


    fun getCharacters(page: String){
        viewModelScope.launch {
            when(val result = repository.getCharacters(page = page)){
                is Resource.Success -> {
                    result?.data.let { character ->
                        character?.results?.forEach {
                            it?.let {
                                it.toDomainModel()
                            }
                        }
                    }
                }
                is Resource.Error -> {
                    result.message?.let {
                        val a = it
                    }
                }
            }

        }
    }

}