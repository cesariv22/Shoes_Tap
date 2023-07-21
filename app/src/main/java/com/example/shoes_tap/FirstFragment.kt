package com.example.shoes_tap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoes_tap.databinding.FragmentFirstBinding


class FirstFragment : Fragment(), Adapter.OnItemClickListener {

    override fun onItemClick(datos: DatosLista) {
        val imageUrl = datos.getUrl()
        val dato = datos.getDato()
        val precio = datos.getPrecio()

        val secondFragment = SecondFragment()
        val bundle = Bundle()
        bundle.putString("image_url", imageUrl)
        bundle.putString("dato", dato)
        bundle.putString("precio", precio.toString())
        secondFragment.arguments = bundle

        val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, secondFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.rv
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val shoeList = returnShoeList()
        adapter = Adapter(shoeList, this)
        adapter.setOnItemClickListener(this)
        recyclerView.adapter = adapter

        binding.btnGoCart.setOnClickListener {
            val nextFragment = ThirdFragment()
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
    fun returnShoeList(): List<DatosLista> {
        val shoeList = mutableListOf<DatosLista>()
        val shoeItem1 = DatosLista( "https://media.gettyimages.com/id/172417586/es/foto/elegante-zapatos-de-cuero-negro.jpg?s=612x612&w=0&k=20&c=y0HIZ1DX6qnFfHOKH7KzIM2S6g8Wl1IO5pDy6LrjWoE=", "Descripción Zapato 1",99.99)
        shoeList.add(shoeItem1)
        val shoeItem2 = DatosLista("https://media.gettyimages.com/id/171224469/es/foto/zapatos-de-lona.jpg?s=612x612&w=0&k=20&c=DqWaqD5s54W-IkoH9M_UbvzwFlzOG_GA5nX0yUFn0_Y=", "Descripción Zapato 2", 79.99)
        shoeList.add(shoeItem2)
        val shoeItem3 = DatosLista( "https://media.gettyimages.com/id/185246744/es/foto/zapatillas-de-deporte.jpg?s=612x612&w=0&k=20&c=TLIsxImwGZeXliqjyMXkWzBNFKKGtlmbfWVRjv79OWo=","Descripción Zapato 3", 149.99)
        shoeList.add(shoeItem3)
        val shoeItem4 = DatosLista( "https://media.gettyimages.com/id/171253262/es/foto/zapatos-de-cuero-marr%C3%B3n.jpg?s=612x612&w=0&k=20&c=0FuoIVgY_urcib1gI_F_DPaHfi-v1RGMzRsymeAFv0g=", "Descripción Zapato 4", 129.99)
        shoeList.add(shoeItem4)
        val shoeItem5 = DatosLista("https://media.gettyimages.com/id/1169282638/es/foto/running-shoe-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=vpqpqbVGmqDrZ1Sv1vba0j6qQM5DClNpUONoL9zmS8Y=", "Descripción Zapato 5", 109.99)
        shoeList.add(shoeItem5)
        val shoeItem6 = DatosLista( "https://media.gettyimages.com/id/182897295/es/foto/rosa-de-lona-zapatos.jpg?s=612x612&w=0&k=20&c=KzS-8yQqfs-i7DKwB_hocGJdh-nzyd9XbsD7IIyY1xc=", "Descripción Zapato 6", 89.99)
        shoeList.add(shoeItem6)
        val shoeItem7 = DatosLista("https://media.gettyimages.com/id/648181890/es/foto/sport-shoes-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=3Od8CsxIDorV8c894vRR07pRs7wHA7y9qWdTNRIfCBE=", "Descripción Zapato 7", 199.99)
        shoeList.add(shoeItem7)
        val shoeItem8 = DatosLista( "https://media.gettyimages.com/id/185063401/es/foto/zapatos-de-cuero-de-ante.jpg?s=612x612&w=0&k=20&c=WTlFosi-UjSpt9N9mfzToqhpBMb_DGv0EeYIMcVqYeo=", "Descripción Zapato 8",169.99)
        shoeList.add(shoeItem8)
        val shoeItem9 = DatosLista( "https://media.gettyimages.com/id/182780951/es/foto/fundas-de-oro-f%C3%BAtbol.jpg?s=612x612&w=0&k=20&c=VajD6eyqrEXohDDF2ne3ffhEKGcUTsJxUbUbZS2ja3A=", "Descripción Zapato 9", 119.99)
        shoeList.add(shoeItem9)
        val shoeItem10 = DatosLista( "https://media.gettyimages.com/id/157434344/es/foto/zapatillas-negro.jpg?s=612x612&w=0&k=20&c=df54UYsOxyCJxQ_HUiiBSO8KdslrHR_pbWDnSyt018s=", "Descripción Zapato 10", 149.99)
        shoeList.add(shoeItem10)
        return shoeList
    }
}