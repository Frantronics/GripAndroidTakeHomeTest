package com.frank.pokemonlist.retrofit

import com.frank.pokemonlist.model.Pokedex
import io.reactivex.Observable
import retrofit2.http.GET

interface IPokemonList {
    @get:GET("pokedex.json")
    val listPokemon: Observable<Pokedex>
}