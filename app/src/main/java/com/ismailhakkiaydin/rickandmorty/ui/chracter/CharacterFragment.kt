package com.ismailhakkiaydin.rickandmorty.ui.chracter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ismailhakkiaydin.rickandmorty.base.BaseFragment
import com.ismailhakkiaydin.rickandmorty.databinding.ActivityMainBinding
import com.ismailhakkiaydin.rickandmorty.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>(FragmentCharacterBinding::inflate) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return binding?.root

    }


}