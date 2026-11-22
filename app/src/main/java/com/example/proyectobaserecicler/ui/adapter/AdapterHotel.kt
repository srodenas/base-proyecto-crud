package com.santi.pmdm.virgen.hospedaje.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectobaserecicler.R
import com.example.proyectobaserecicler.domain.models.Hotel


class AdapterHotel(
    var listHotel : MutableList<Hotel>,
    var deleteOnClick: (Int) -> Unit,
    var updateOnClick: ( Int) -> Unit
) : RecyclerView.Adapter<ViewHHotel>(){

  /*
  Método que crea la view del ViewHolderHotel
   */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHHotel {
        val layoutInflater = LayoutInflater.from(parent.context)//objeto para inflar la vista.
        val layoutItemHotel = R.layout.item_hotel  //accedo al xml del item a crear.
        val view =  layoutInflater.inflate(layoutItemHotel, parent, false)

      return ViewHHotel(
           view,
           deleteOnClick,
           updateOnClick
       )
    }

    /*
    Este método, debe renderizar todos los datos o propiedades de cada hotel con la view.
    Accedemos al objeto por medio de position
     */
    override fun onBindViewHolder(holder: ViewHHotel, position: Int) {
        holder.renderize(listHotel.get(position))  //renderizamos la view.
     }

    /*
    Este método, devuelve el número de objetos a representar en el recyclerView.
     */
    override fun getItemCount(): Int = listHotel.size
}