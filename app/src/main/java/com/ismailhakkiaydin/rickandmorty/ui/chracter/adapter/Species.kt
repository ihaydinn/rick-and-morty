package com.ismailhakkiaydin.rickandmorty.ui.chracter.adapter

import android.graphics.Color
import com.ismailhakkiaydin.rickandmorty.R


enum class Species(val type: String, val color: Int) {
    HUMAN("Human", R.color.purple_500),
    ALIEN("Alien",R.color.teal_200),
    HUMANOID("Humanoid",Color.GRAY),
    UNKNOWN("Unknown",Color.GRAY),
    POOPYBUTTHOLS("Poopybutthols",Color.GRAY),
    MYTHOLOGICAL_CREATURE("Mythological Creature",Color.GRAY),
    ANIMAL("Animal",Color.GRAY),
    ROBOT("Robot",Color.GRAY),
    CRONENBERG("Cronenberg",Color.GRAY),
    DISEASE("Disease",Color.GRAY)

}
