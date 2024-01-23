package com.example.emptyviewactivity

import androidx.lifecycle.ViewModel

class PokemonViewModel: ViewModel() {
    
    private var _pokemons: MutableList<Pokemon>
    private var _selected: Pokemon? = null
    val pokemons: List<Pokemon>
        get() = _pokemons.toList()
    var selected: Pokemon?
        get() = _selected
        set(item) {
            _selected = item
        }

    init {
        this._pokemons = mutableListOf()
        this._pokemons.add(
            Pokemon(
                "Altaria", "1.1", "Dragón", "Volador", "20.6"
            )
        )
        this._pokemons.add(
            Pokemon(
                "Mimikyu", "0.2", "Fantasma", "Hada", "0.7"
            )
        )
        this._pokemons.add(
            Pokemon(
                "Seviper", "2.7", "Veneno", "", "55.5"
            )
        )
        this._pokemons.add(
            Pokemon(
                "Zamazenta", "2.9", "Lucha", "Acero", "785"
            )
        )
    }
}