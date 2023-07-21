package com.example.shoes_tap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoes_tap.databinding.ItemRvBinding



class Adapter(private val datosLista: List<DatosLista>, private val fragment: Fragment) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(datos: DatosLista)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datos = datosLista[position]
        holder.bind(datos)
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(datos)
        }

    }

    override fun getItemCount(): Int {
        return datosLista.size
    }

    inner class ViewHolder(private val binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(datos: DatosLista) {
            Glide.with(binding.root)
                .load(datos.getUrl())
                .into(binding.imgSegFrag)

            binding.textNameProd.text = datos.getDato()
            binding.textPrecio.text = datos.getPrecio().toString()
        }
    }
}