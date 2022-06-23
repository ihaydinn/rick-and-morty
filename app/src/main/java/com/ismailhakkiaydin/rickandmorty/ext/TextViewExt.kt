package com.ismailhakkiaydin.rickandmorty.ext

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.ismailhakkiaydin.rickandmorty.R


fun TextView.setBackgroundDrawable(){
    this.background = ContextCompat.getDrawable(this.context, R.drawable.bg_species)
}