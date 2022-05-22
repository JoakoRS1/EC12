package com.example.ec12.fragments

import CustomAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ec12.GestorPeliculas
import com.example.ec12.R

class CarteleraFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(
            R.layout.fragment_listado,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragDetalles = DetallesFragment()
        fun recycle(): RecyclerView {
            val recyclerView = view.findViewById<RecyclerView> (R.id.my_recycler_view)

            val layoutManager = LinearLayoutManager(activity)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = layoutManager
            return recyclerView
        }

        var nombre_usuario=arguments?.getString("NOMBRE")
        if (nombre_usuario==""){
            nombre_usuario="Usuario"
        }
        val toolbar= view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setTitle("Hola "+nombre_usuario)


        val listado= GestorPeliculas().obtenerPeliculas()
        val adapter = CustomAdapter(listado){
            Toast.makeText(activity, "Película:"+it.nombre, Toast.LENGTH_SHORT).show()
            //Mandar arguments a Fragment
            val bundle= Bundle()
            bundle.putString("NOMBRE", it.nombre)
            bundle.putString("DETALLE", it.resena)
            fragDetalles.arguments= bundle

            //Ir a FragmentDetalles
            val ft=this.parentFragmentManager.beginTransaction()
            ft.replace(R.id.fcvItems,fragDetalles)
            ft.addToBackStack(null)
            ft.commit()



        }
        recycle().adapter = adapter



       /* adapter.setOnItemClickListener(object: CustomAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(activity, "Película:"+listado[position].nombre, Toast.LENGTH_SHORT).show()
            }
        })*/

    }



}