package com.example.emptyviewactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PokemonAdapter(private val listaPokemon: List<Pokemon>): Adapter<PokemonAdapter.PokemonViewHolder>() {

    var click: ((Int, Pokemon) -> Unit)? = null

   inner class PokemonViewHolder(internal val view: View): ViewHolder(view) {
       internal val textNombre: TextView = view.findViewById(R.id.textNombre)
       internal val textAltura: TextView = view.findViewById(R.id.textAltura)
       internal val textTipo1: TextView = view.findViewById(R.id.textTipo1)
       internal val textTipo2: TextView = view.findViewById(R.id.textTipo2)
       internal val textPeso: TextView = view.findViewById(R.id.textPeso)
       internal val imagePokemon: ImageView = view.findViewById(R.id.imagePokemon)
       internal val buttonPokemonDetail: Button = view.findViewById<Button>(R.id.buttonPokemonDetail)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pokemon_layout, parent, false))
    }

    override fun getItemCount(): Int = listaPokemon.size


    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.textNombre.setText(listaPokemon[position].nombre)
        holder.textAltura.setText(listaPokemon[position].altura)
        holder.textTipo1.setText(listaPokemon[position].tipo1)
        holder.textTipo2.setText(listaPokemon[position].tipo2)
        holder.textPeso.setText(listaPokemon[position].peso)
        holder.imagePokemon.setImageResource(listaPokemon[position].imagenId)

        holder.buttonPokemonDetail.setOnClickListener {
            this.click?.let { it1 -> it1(position, listaPokemon[position]) }
        }

    }

}