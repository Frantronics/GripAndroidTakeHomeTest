package com.frank.pokemonlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.frank.pokemonlist.common.Common
import com.frank.pokemonlist.model.Pokemon


class PokemonDetail : Fragment() {

    internal lateinit var pokemon_img: ImageView
    internal lateinit var pokemon_name: TextView
    internal lateinit var pokemon_height: TextView
    internal lateinit var pokemon_weight: TextView

    internal lateinit var recycler_type: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val itemView = inflater.inflate(R.layout.fragment_pokemon_detail_screen, container, false)

        val pokemon: Pokemon?
        if(requireArguments().getString("numm") == null){
            pokemon = Common.pokemonList[requireArguments().getInt("position")]
        }
        else{
            pokemon = Common.findPokemonByNum(requireArguments().getString("num"))
        }

        pokemon_img = itemView.findViewById(R.id.pokemon_detail_image) as ImageView

        pokemon_name = itemView.findViewById(R.id.detail_name) as TextView
        pokemon_height = itemView.findViewById(R.id.height) as TextView
        pokemon_weight = itemView.findViewById(R.id.weight) as TextView

        recycler_type = itemView.findViewById(R.id.recycler_type) as RecyclerView
        recycler_type.setHasFixedSize(true)
        recycler_type.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        setDetailDisplayPokemon(pokemon)
        return itemView

    }

    private fun setDetailDisplayPokemon(pokemon: Pokemon?) {
      // Pokemon Image
        Glide.with(requireActivity()).load(pokemon!!.img).into(pokemon_img)

        pokemon_name.text = pokemon.name
        pokemon_height.text = "Height " + pokemon.height
        pokemon_weight.text = "Weight " + pokemon.weight

    }

    companion object {
        internal var instance: PokemonDetail? = null

        fun getInstance(): PokemonDetail{
            if(instance == null){
                instance = PokemonDetail()
            }
            return instance!!
        }
    }
}