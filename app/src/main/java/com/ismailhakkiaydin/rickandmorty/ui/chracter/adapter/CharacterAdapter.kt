package com.ismailhakkiaydin.rickandmorty.ui.chracter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ismailhakkiaydin.rickandmorty.data.entity.Character
import com.ismailhakkiaydin.rickandmorty.databinding.ItemCharacterBinding


class CharacterAdapter(private val onItemClicked: (Character) -> Unit) :
    ListAdapter<Character, CharacterViewHolder>(CharacterDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) {
            onItemClicked(this.getItem(it))
        }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
}