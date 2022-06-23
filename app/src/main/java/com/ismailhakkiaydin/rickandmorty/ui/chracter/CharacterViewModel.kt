package com.ismailhakkiaydin.rickandmorty.ui.chracter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ismailhakkiaydin.rickandmorty.base.BaseViewModel
import com.ismailhakkiaydin.rickandmorty.data.entity.Character
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

    private val _data = MutableLiveData<List<Character>>()
    val data: LiveData<List<Character>> get() = _data

    fun getCharacters(page: String) {
        viewModelScope.launch {
            when (val result = repository.getCharacters(page = page)) {
                is Resource.Success -> {
                    result.data.let { character ->
                        val list = arrayListOf<Character>()
                        character?.results?.forEach {
                            it?.let {
                                list.add(it.toDomainModel())
                            }
                        }
                        _data.value = list
                    }
                }
                is Resource.Error -> {
                    result.message?.let {
                        val a = it
                    }
                }
                else -> {}
            }

        }
    }

}