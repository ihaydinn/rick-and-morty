package com.ismailhakkiaydin.rickandmorty.ui.chracter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ismailhakkiaydin.rickandmorty.R
import com.ismailhakkiaydin.rickandmorty.base.BaseFragment
import com.ismailhakkiaydin.rickandmorty.databinding.ActivityMainBinding
import com.ismailhakkiaydin.rickandmorty.databinding.FragmentCharacterBinding
import com.ismailhakkiaydin.rickandmorty.ui.chracter.adapter.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>(FragmentCharacterBinding::inflate) {

    lateinit var adapter: CharacterAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)


        viewModel.getCharacters("1")

        binding?.recyclerViewCharacters?.adapter = CharacterAdapter{
            findNavController().navigate(R.id.action_characterFragment_to_characterDetailFragment)
        }.apply {
            adapter = this
        }

        viewModel.data.observe(viewLifecycleOwner){
            it?.let {
                adapter.submitList(it)
            }
        }

        return binding?.root

    }


}