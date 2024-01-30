package com.example.emptyviewactivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MasterFragment : Fragment() {

    private lateinit var v: View
    private val pokemonViewModel: PokemonViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_master, container, false)
        val recyclerView: RecyclerView = v.findViewById<RecyclerView>(R.id.recyclerViewPokemon)
        var adaptador = PokemonAdapter(this.pokemonViewModel.pokemons)
        adaptador.click = { position, pokemon ->
            run {

                // Se selecciona el pokemon
                this.pokemonViewModel.selected = pokemon
                val fm: FragmentManager = parentFragmentManager
                if (!resources.getBoolean(R.bool.horizontal)) {
                    // Pantallla Vertical
                    fm.commit {
                        replace(R.id.fragmentContainerView, SlaveFragment.newInstance())
                        addToBackStack("replacement")
                    }
                } else {
                    // Pantalla Horizontal
                    val contenedor = v.findViewById<FragmentContainerView>(R.id.fragmentContainerViewPokemonDetailLand)
                    val fragmentManager = childFragmentManager
                    val fragment = fragmentManager.findFragmentById(contenedor?.id ?: -1)
                    if (fragment != null && fragment is SlaveFragment) {
                        (fragment).update()
                    }
                }

            }
        }
        v.findViewById<Button>(R.id.addPokemonButton).setOnClickListener {
            val fm: FragmentManager = parentFragmentManager
            fm.commit {
                replace(R.id.fragmentContainerView, AddPokemonFragment.newInstance())
                addToBackStack("replacement")
            }
        }
        val layoutManager = GridLayoutManager(this.context, 1)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adaptador
        return v
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MasterFragment().apply {

            }
    }
}