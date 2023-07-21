package com.example.shoes_tap

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import androidx.navigation.fragment.findNavController
import com.example.shoes_tap.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private var imageUrl: String? = null
    private var dato: String? = null
    private var precio: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageUrl = arguments?.getString(ARG_IMAGE_URL)
            dato = arguments?.getString(ARG_DATO)
            precio = arguments?.getString(ARG_PRECIO)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this)
            .load(imageUrl)
            .into(binding.imgSecFrag)

        binding.txtProductName.text = dato
        binding.txtPrice.text = precio


        binding.btnAddCart.setOnClickListener {
            val carritoFragment = ThirdFragment()
            val bundle = Bundle().apply {
                putString("image_url", imageUrl)
                putString("dato", dato)
                putString("precio", precio)
            }
            carritoFragment.arguments = bundle

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, carritoFragment)
                .addToBackStack(null)
                .commit()
        }
        binding.btnBack.setOnClickListener {
            val nextFragment = FirstFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, nextFragment)
                .addToBackStack(null)
                .commit()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_IMAGE_URL = "image_url"
        private const val ARG_DATO = "dato"
        private const val ARG_PRECIO = "precio"
    }
}
