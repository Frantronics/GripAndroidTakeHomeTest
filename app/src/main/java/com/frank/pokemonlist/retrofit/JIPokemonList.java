package com.frank.pokemonlist.retrofit;

import com.frank.pokemonlist.model.JPokedex;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface JIPokemonList {
    @GET("pokedex.json")
    Observable<JPokedex> getListPokemon();
}
