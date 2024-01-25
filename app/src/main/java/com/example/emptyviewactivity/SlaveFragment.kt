package com.example.emptyviewactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView

class SlaveFragment : Fragment() {

        private lateinit var v: View
        private val pokemonViewModel: PokemonViewModel by activityViewModels()
        private var pokemonSelected: Pokemon? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    public fun update() {
        pokemonSelected = pokemonViewModel.selected
        this.pokemonViewModel.selected?.let {
            v.findViewById<TextView>(R.id.textNameDetail).text = pokemonSelected?.nombre
            v.findViewById<ImageView>(R.id.imagePokemonDetail).setImageResource(pokemonSelected!!.imagenId)
            v.findViewById<TextView>(R.id.textType1Detail).text = pokemonSelected?.tipo1
            v.findViewById<TextView>(R.id.textType2Detail).text = pokemonSelected?.tipo2
            v.findViewById<TextView>(R.id.textAlturaDetail).text = pokemonSelected?.altura
            v.findViewById<TextView>(R.id.textView8).text = pokemonSelected?.peso
            v.findViewById<TextView>(R.id.textDescriptionDetail).text = pokemonSelected?.description
        }
    }

    override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_slave, container, false)
        this.update()

        val fm: FragmentManager = parentFragmentManager
        if (resources.getBoolean(R.bool.horizontal)) {
            // Va hacia atrás
            fm.popBackStack()
        }

        return v
    }

    companion object {

        fun newInstance() =
            SlaveFragment().apply {

            }
    }
}