package com.example.shoes_tap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoes_tap.databinding.ItemCartBinding


class AdapterCarrito(private var items: List<DatosLista>) : RecyclerView.Adapter<AdapterCarrito.ViewHolder>() {

    private var onItemClickListener: ((DatosLista) -> Unit)? = null


    fun setOnItemClickListener(listener: (DatosLista) -> Unit) {
        onItemClickListener = listener
    }

    inner class ViewHolder(private val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(datos: DatosLista) {
            // Muestra los datos del carrito
            Glide.with(binding.root)
                .load(datos.getUrl())
                .into(binding.imgTerFrag)

            binding.textNameCart.text = datos.getDato()
            binding.textPrecioCart.text = datos.getPrecio().toString()

            binding.btnRemove.setOnClickListener {
                onItemClickListener?.invoke(datos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datos = items[position]
        holder.bind(datos)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun updateItems(items: List<DatosLista>) {
        this.items = items
        notifyDataSetChanged()
    }
    fun setItems(items: List<DatosLista>) {
        this.items = items
    }
}
