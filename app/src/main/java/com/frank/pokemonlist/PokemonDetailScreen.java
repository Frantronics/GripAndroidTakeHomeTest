package com.frank.pokemonlist;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.frank.pokemonlist.model.JPokemon;


/**
 * Detail screen for Pokemon
 */
public class PokemonDetailScreen extends Fragment {

    ImageView pokemon_img;
    TextView pokemon_name,
             pokemon_height,
             pokemon_weight;
    RecyclerView recycler_type;

    static PokemonDetailScreen instance;

    public static PokemonDetailScreen getInstance(){
        if(instance == null){
            instance = new PokemonDetailScreen();
        }
        return instance;
    }

    public PokemonDetailScreen(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView =  inflater.inflate(R.layout.fragment_pokemon_detail_screen, container, false);

        pokemon_img = itemView.findViewById(R.id.pokemon_detail_image);
        pokemon_name = itemView.findViewById(R.id.detail_name);
        pokemon_height = itemView.findViewById(R.id.height);
        pokemon_weight = itemView.findViewById(R.id.weight);

        recycler_type = itemView.findViewById(R.id.recycler_type);
        recycler_type.setHasFixedSize(true);
        recycler_type.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

       // setDetailPokemon(jPokemon);

        return itemView;
    }


    private void setDetailPokemon(JPokemon pokemon){
        // Get Pokemon image
        Glide.with(getActivity()).load(pokemon.getImg()).into(pokemon_img);

        pokemon_name.setText(pokemon.getName());
        pokemon_height.setText("Height: " + pokemon.getHeight());
        pokemon_weight.setText("Weight: " + pokemon.getWeight());

    }

}