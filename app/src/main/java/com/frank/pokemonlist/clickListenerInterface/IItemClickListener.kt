package com.frank.pokemonlist.clickListenerInterface

import android.view.View

interface IItemClickListener {
    fun onClick(view: View, position: Int)
}