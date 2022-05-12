package com.frank.pokemonlist.model;

import java.util.List;

public class JPokedex {

    private List<JPokemon> pokemon;

    public JPokedex(){
    }

    public JPokedex(List<JPokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public List<JPokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<JPokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
