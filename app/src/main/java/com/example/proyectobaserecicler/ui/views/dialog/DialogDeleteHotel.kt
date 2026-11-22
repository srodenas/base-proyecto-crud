package com.santi.pmdm.virgen.hospedaje.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment


/*
Diálogo para el borrado de un hotel.
Necesito un listener que sea del tipo interfaz para delegar las funciones onClick.
No utilizaré funciones de orden superior.
 */
class DialogDeleteHotel(
                        val pos : Int,
                        val name: String,
                        val onDeleteHotelDialog : (Int) -> Unit
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage("¿Deseas borrar el alojamiento $name?")

            .setPositiveButton("Sí") { dialog, id ->
                onDeleteHotelDialog(pos)
            }

            .setNegativeButton("No") { dialog, id ->
                dialog.dismiss()
            }

        return builder.create()
    }
}