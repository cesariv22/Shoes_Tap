package com.example.shoes_tap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoes_tap.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    private var carritoDeCompras = DataCartList.getInstance()
    private lateinit var adapter: AdapterCarrito

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rv2
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = AdapterCarrito(carritoDeCompras.obtenerItems())
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener { datos ->
            carritoDeCompras.eliminarItem(datos)
            adapter.updateItems(carritoDeCompras.obtenerItems())
        }

        val imageUrl = arguments?.getString("image_url")
        val dato = arguments?.getString("dato")
        val precio = arguments?.getString("precio")

        if (imageUrl != null && dato != null && precio != null) {
            val item = DatosLista(imageUrl, dato, precio.toDouble())
            carritoDeCompras.agregarItem(item)
            adapter.updateItems(carritoDeCompras.obtenerItems())
        }
        binding.btnBackInit.setOnClickListener {
            val nextFragment = FirstFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, nextFragment)
                .addToBackStack(null)
                .commit()
        }
        binding.btnDeleteAll.setOnClickListener {
            carritoDeCompras.limpiarCarrito()
            adapter.updateItems(carritoDeCompras.obtenerItems())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
