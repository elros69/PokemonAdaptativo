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
                "Altaria", "1.1", "Dragón", "Volador", "20.6", R.drawable.altaria,
                "Altaria canta de maravilla, como una soprano. Tiene unas alas que parecen nubes de algodón." +
                          " Este Pokémon aprovecha las corrientes ascendentes y remonta el vuelo con sus flamantes alas hacia" +
                          " la inmensidad del cielo azul. Altaria baila y revolotea por el cielo entre ondeantes nubes que parecen de algodón."
            )
        )
        this._pokemons.add(
            Pokemon(
                "Mimikyu", "0.2", "Fantasma", "Hada", "0.7", R.drawable.mimikyu,
                "Mimikyu es un Pokémon pequeño, de pie a 2.54 cm de altura, y se oculta casi por completo debajo de un disfraz." +
                        " Tiene ojos negros que se pueden ver a través del cuerpo de su disfraz, y una vaga apariencia de un pie o parte" +
                        " inferior del cuerpo se puede ver en el borde de su disfraz."
            )
        )
        this._pokemons.add(
            Pokemon(
                "Seviper", "2.7", "Veneno", "None", "55.5", R.drawable.seviper,
                "Seviper es conocido por su carácter agrio e inmoviliza a sus contrincantes enroscando su cuerpo a su alrededor." +
                        " HA: Seviper, el Pokémon colmillo de serpiente." +
                        " Seviper es conocido por su mal carácter, inmoviliza a sus oponentes envolviendo su cuerpo alrededor de ellos."
            )
        )
        this._pokemons.add(
            Pokemon(
                "Zamazenta", "2.9", "Lucha", "Acero", "785", R.drawable.zamazenta,
                "Zamazenta es el Pokémon legendario exclusivo de Pokémon Escudo. Primero aparecerá como un Pokémon de tipo lucha" +
                        " con su Escudo Oxidado en Bosque Oniria. No obstante se transformará " +
                        "en un Pokémon tipo lucha/acero. A diferencia de Zacian, que se centra en el ataque, Zamazenta prefiere las tácticas defensivas."
            )
        )
    }
}