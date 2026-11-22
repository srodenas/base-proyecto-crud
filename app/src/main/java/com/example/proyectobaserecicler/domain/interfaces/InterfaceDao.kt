package com.example.proyectobaserecicler.domain.interfaces

import com.example.proyectobaserecicler.domain.models.Hotel

/*
Esta interfaz, define el acceso a datos.
 */

interface InterfaceDao {
    fun getDataHotels(): List<Hotel>
  // fun getHotel(a:Int) : Hotel
  //  fun addHotel(hotel : Hotel) : Boolean

}