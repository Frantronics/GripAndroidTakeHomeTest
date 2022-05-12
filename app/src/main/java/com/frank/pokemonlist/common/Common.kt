package com.frank.pokemonlist.common

import com.frank.pokemonlist.model.Pokemon

object Common {

    var pokemonList:List<Pokemon> = ArrayList()
    const val KEY_ENABLE_HOME = "position"

    fun findPokemonByNum(num: String?): Pokemon?{
        for(pokemon: Pokemon in Common.pokemonList){
            if(pokemon.num.equals(num)){
                return pokemon
            }
        }
        return null
    }
}