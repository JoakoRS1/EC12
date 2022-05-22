package com.example.ec12.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.ec12.Pelicula
import com.example.ec12.R

class DetallesFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_detalles,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nombre= arguments?.getString("NOMBRE")
        val detalle= arguments?.getString("DETALLE")

        val tvNombre= view.findViewById<TextView>(R.id.dNombrePelicula)
        val tvdetalle= view.findViewById<TextView>(R.id.tvdetalles)

        tvNombre.text= nombre
        tvdetalle.text= detalle
    }
}