package com.ismailhakkiaydin.rickandmorty.ui.chracter.detail

import com.ismailhakkiaydin.rickandmorty.base.BaseFragment
import com.ismailhakkiaydin.rickandmorty.databinding.FragmentCharacterDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding, CharacterDetailViewModel>(
        FragmentCharacterDetailBinding::inflate
    ) {

}