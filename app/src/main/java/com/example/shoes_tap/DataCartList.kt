package com.example.shoes_tap

import android.util.Log

class DataCartList private constructor(){

    private val itemsCart: MutableList<DatosLista> = mutableListOf()

    fun agregarItem(item: DatosLista) {
        itemsCart.add(item)
    }

    fun obtenerItems(): List<DatosLista> {
        Log.d("DataCartList", "Cantidad de elementos en itemsCart: ${itemsCart.size}")
        return itemsCart.toList()
    }
    fun eliminarItem(item: DatosLista) {
        itemsCart.remove(item)
    }
    fun limpiarCarrito() {
        itemsCart.clear()
    }


    companion object {
        private var instance: DataCartList? = null

        fun getInstance(): DataCartList {
            if (instance == null) {
                instance = DataCartList()
            }
            return instance!!
        }
    }
}