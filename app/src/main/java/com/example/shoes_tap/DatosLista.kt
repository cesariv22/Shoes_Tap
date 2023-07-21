package com.example.shoes_tap

class DatosLista(private val url: String, private val dato: String, private val precio: Double) {

    fun getUrl(): String {
        return url
    }
    fun getDato(): String {
        return dato
    }
    fun getPrecio(): Double {
        return precio
    }
}
