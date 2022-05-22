package com.example.ec12.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.ec12.R
import com.example.ec12.R.*

class NosotrosFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout.fragment_nosotros, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bRegresar= view.findViewById<Button>(R.id.bRegresarNosotros)

        bRegresar.setOnClickListener{
            val fm= this.parentFragmentManager
            fm.popBackStack()
        }
    }

}