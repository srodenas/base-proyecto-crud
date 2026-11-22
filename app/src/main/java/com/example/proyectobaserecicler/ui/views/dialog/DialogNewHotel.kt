package com.example.proyectobaserecicler.ui.views.dialog
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.proyectobaserecicler.R
import com.example.proyectobaserecicler.databinding.DialogNewHotelBinding
import com.example.proyectobaserecicler.domain.models.Hotel
import com.example.proyectobaserecicler.ui.views.MainActivity


class DialogNewHotel (
    val onNewHotelDialog: (Hotel)-> Unit
): DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater

        val viewDialogNewHotel =
            inflater.inflate(R.layout.dialog_new_hotel, null)

        builder
            .setView(viewDialogNewHotel)
            .setPositiveButton("Añadir") { dialog, id ->

                val newHotel = recoverDataLayout(viewDialogNewHotel)
                if (
                    newHotel.name.isNullOrEmpty() ||
                    newHotel.city.isNullOrEmpty() ||
                    newHotel.province.isNullOrEmpty() ||
                    newHotel.phone.isNullOrEmpty()
                ) {
                    Toast.makeText(
                        requireContext(),
                        "Algún campo está vacío",
                        Toast.LENGTH_LONG
                    ).show()

                    dialog.cancel()

                } else {
                    onNewHotelDialog(newHotel)
                }
            }

            .setNegativeButton("Cancelar") { dialog, id ->
                dialog.cancel()
            }

        return builder.create()
    }


    private fun recoverDataLayout(view: View): Hotel {
        val binding = DialogNewHotelBinding.bind(view)
        return Hotel(
            binding.txtViewName.text.toString(),
            binding.txtViewCity.text.toString(),
            binding.txtViewProvence.text.toString(),
            binding.txtViewPhone.text.toString(),
            binding.txtViewUrlImage.text.toString()
        )
    }
}

