package com.ismailhakkiaydin.rickandmorty.ext

import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.ismailhakkiaydin.rickandmorty.ui.chracter.adapter.Species


fun CardView.setCardViewBackground(color: Int){
    this.setCardBackgroundColor(
        ContextCompat.getColor(
            this.context,
            color
        )
    )
}