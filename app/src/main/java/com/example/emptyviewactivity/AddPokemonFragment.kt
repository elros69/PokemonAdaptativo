package com.example.emptyviewactivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddPokemonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddPokemonFragment : Fragment() {

    private val pokemonViewModel: PokemonViewModel by activityViewModels()

    private lateinit var v: View
    private lateinit var addNameField: EditText
    private lateinit var addTipo1Field: EditText
    private lateinit var addTipo2Field: EditText
    private lateinit var addAlturaField: EditText
    private lateinit var addPesoField: EditText
    private lateinit var addDescripcionField: EditText
    private lateinit var cancelAddButton: Button
    private lateinit var acceptAddPokemon: Button
    private lateinit var imageViewAddPokemon: ImageView
    private lateinit var addImageButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        v = inflater.inflate(R.layout.fragment_add_pokemon, container, false)
        addNameField = v.findViewById(R.id.addNameField)
        addTipo1Field = v.findViewById(R.id.addTipo1Field)
        addTipo2Field = v.findViewById(R.id.addTipo2Field)
        addAlturaField = v.findViewById(R.id.addTipo2Field)
        addPesoField = v.findViewById(R.id.addPesoField)
        addDescripcionField = v.findViewById(R.id.addDescripcionField)
        cancelAddButton = v.findViewById(R.id.cancelAddButton)
        acceptAddPokemon = v.findViewById(R.id.acceptAddPokemon)
        imageViewAddPokemon = v.findViewById(R.id.imageViewAddPokemon)
        addImageButton = v.findViewById(R.id.addImageButton)
        imageViewAddPokemon.setImageResource(R.drawable.pokeball)



        val getImage = registerForActivityResult(ActivityResultContracts.GetContent()) {
                uri: Uri? ->
            imageViewAddPokemon.setImageURI(uri)
        }

        addImageButton.setOnClickListener {
            getImage.launch("image/*")
        }

        cancelAddButton.setOnClickListener {
            val fm: FragmentManager = parentFragmentManager
            fm.popBackStack()
        }

        // Creo las cosas pa añadir pokemon
        acceptAddPokemon.setOnClickListener {

            if (checkFields()) {
                val pokemon = Pokemon(
                    addNameField.text.toString(),
                    addAlturaField.text.toString(),
                    addTipo1Field.text.toString(),
                    addTipo2Field.text.toString(),
                    addPesoField.text.toString(),
                    0,
                    addDescripcionField.text.toString()
                    )
                pokemonViewModel.addPokemon(pokemon)

                val snackbarAddPokemon = Snackbar.make(
                    v, "Pokemon añadido", Snackbar.LENGTH_SHORT).show()

                addNameField.setText("")
                addAlturaField.setText("")
                addTipo2Field.setText("")
                addTipo1Field.setText("")
                addPesoField.setText("")
                addDescripcionField.setText("")
                imageViewAddPokemon.setImageResource(R.drawable.pokeball)
            }
        }

        return v
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            AddPokemonFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private fun checkFields(): Boolean {
        if (addNameField.text.isEmpty() || addAlturaField.text.isEmpty() || addTipo1Field.text.isEmpty() ||
            addTipo2Field.text.isEmpty() || addDescripcionField.text.isEmpty() || addAlturaField.text.isEmpty()) {
            return false
        }
        return true
    }

}