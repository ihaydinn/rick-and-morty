package com.ismailhakkiaydin.rickandmorty.ui.chracter.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ismailhakkiaydin.rickandmorty.R
import com.ismailhakkiaydin.rickandmorty.data.entity.Character
import com.ismailhakkiaydin.rickandmorty.data.response.CharacterResponse
import com.ismailhakkiaydin.rickandmorty.databinding.ItemCharacterBinding
import com.ismailhakkiaydin.rickandmorty.ext.loadFromUrl


class CharacterViewHolder(
    private val binding: ItemCharacterBinding,
    onItemClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }

    fun bind(model: Character) {
        binding.apply {
            textViewName.text = model.name
            textViewSpecies.text = model.species
            textViewGender.text = model.gender
            imageViewProfile.loadFromUrl(url = model.image, placeholder = R.drawable.ic_launcher_background)
        }
    }
}