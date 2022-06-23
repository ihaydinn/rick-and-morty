package com.ismailhakkiaydin.rickandmorty.ui.chracter.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.ismailhakkiaydin.rickandmorty.R
import com.ismailhakkiaydin.rickandmorty.data.entity.Character
import com.ismailhakkiaydin.rickandmorty.databinding.ItemCharacterBinding
import com.ismailhakkiaydin.rickandmorty.ext.loadFromUrl
import com.ismailhakkiaydin.rickandmorty.ext.setBackgroundDrawable
import com.ismailhakkiaydin.rickandmorty.ext.setCardViewBackground


class CharacterViewHolder(
    private val binding: ItemCharacterBinding,
    onItemClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }

    @SuppressLint("ResourceAsColor")
    fun bind(model: Character) {
        binding.apply {
            textViewName.text = model.name
            textViewGender.text = model.gender
            imageViewProfile.loadFromUrl(
                url = model.image,
                placeholder = R.drawable.bg_species
            )

            textViewSpecies.apply {
                this.text = model.species
                this.setBackgroundDrawable()
            }

            cardViewItem.apply {
                when (model.species) {
                    Species.HUMAN.type -> {
                        this.setCardViewBackground(Species.HUMAN.color)
                    }

                    Species.ALIEN.type -> {
                        this.setCardViewBackground(Species.ALIEN.color)
                    }

                    Species.HUMANOID.type -> {
                        this.setCardViewBackground(Species.HUMANOID.color)
                    }

                    Species.UNKNOWN.type -> {
                        this.setCardViewBackground(Species.UNKNOWN.color)
                    }

                    Species.POOPYBUTTHOLS.type -> {
                        this.setCardViewBackground(Species.POOPYBUTTHOLS.color)
                    }

                    Species.MYTHOLOGICAL_CREATURE.type -> {
                        this.setCardViewBackground(Species.MYTHOLOGICAL_CREATURE.color)
                    }

                    Species.ANIMAL.type -> {
                        this.setCardViewBackground(Species.ANIMAL.color)
                    }

                    Species.ROBOT.type -> {
                        this.setCardViewBackground(Species.ROBOT.color)
                    }

                    Species.CRONENBERG.type -> {
                        this.setCardViewBackground(Species.CRONENBERG.color)
                    }

                    Species.DISEASE.type -> {
                        this.setCardViewBackground(Species.DISEASE.color)
                    }
                }
            }
        }
    }
}