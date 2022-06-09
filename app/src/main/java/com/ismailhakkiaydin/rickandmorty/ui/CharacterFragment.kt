package com.ismailhakkiaydin.rickandmorty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ismailhakkiaydin.rickandmorty.base.BaseFragment
import com.ismailhakkiaydin.rickandmorty.databinding.ActivityMainBinding


class CharacterFragment :
    BaseFragment<ActivityMainBinding, CharacterViewModel>(ActivityMainBinding::inflate) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return binding?.root

    }


}