package com.frank.pokemonlist.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.frank.pokemonlist.R
import com.frank.pokemonlist.clickListenerInterface.IItemClickListener
import com.frank.pokemonlist.common.Common
import com.frank.pokemonlist.model.Pokemon

class PokemonListAdapter(internal var context: Context,
                         internal var pokemonList: List<Pokemon>): RecyclerView.Adapter<PokemonListAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var pokemon_img: ImageView
        internal var pokemon_text: TextView

        // Click listener for the Pokemon list
        internal var itemClickListener:IItemClickListener? = null
        fun setItemClickListener(itemClickListener: IItemClickListener){
            this.itemClickListener = itemClickListener
        }

        init {
            pokemon_img = itemView.findViewById(R.id.pokemon_image) as ImageView
            pokemon_text = itemView.findViewById(R.id.pokemon_name) as TextView

            itemView.setOnClickListener{ view -> itemClickListener!!.onClick(view, adapterPosition)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(
            R.layout.pokemon_list_item,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(pokemonList[position].img).into(holder.pokemon_img)
        holder.pokemon_text.text = pokemonList[position].name

        // click event
        holder.setItemClickListener(object: IItemClickListener{
            override fun onClick(view: View, position: Int) {

//                Toast.makeText(context, "Pokemon: "+ pokemonList[position].name + " Clicked",
//                Toast.LENGTH_SHORT).show()
                LocalBroadcastManager.getInstance(context)
                    .sendBroadcast(Intent(Common.KEY_ENABLE_HOME).putExtra("position", position))
            }

        })
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}