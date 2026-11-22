package com.example.proyectobaserecicler.data

import com.example.proyectobaserecicler.domain.interfaces.InterfaceDao
import com.example.proyectobaserecicler.domain.models.Hotel

/*
. La mejor forma de hacer un DAO en kotlin, es implementar una clase con constructor
privado, que implemente de una interfaz (contrato)

. Dentro de la clase, incrustamos un objeto único que tenga como atributo una
  propiedad llamada myDao de tipo DatoHotels. Dicho atributo, será instanciado por delegación
  by lazy. Quiere decir:

  1.- La primera vez que se referencie al atributo myDato, este será creado y por tanto llamara
  al contructor desde dentro.
  2.- El resto de referencias, como ya se instanció myDao, no hará caso.
 */

class DaoHotels private constructor(): InterfaceDao {
    companion object {
        val myDao: DaoHotels by lazy{  //lazy delega a un primer acceso
            DaoHotels()  //Me creo sólo este objeto una vez.
        }
    }


    //Método que podría simular un acceso a la BBDD y devuelver todos los datos
    override
    fun getDataHotels(): List<Hotel>   = Repository.listHotels
}