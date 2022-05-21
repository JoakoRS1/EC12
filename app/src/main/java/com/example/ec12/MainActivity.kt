package com.example.ec12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.example.ec12.fragments.CarteleraFragment
import com.example.ec12.fragments.NosotrosFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var mlMain: DrawerLayout
    private lateinit var nvInicio: NavigationView

    private val fragNosotros = NosotrosFragment()
    private val fragCartelera = CarteleraFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = intent.getStringExtra("NOMBRE")
        Log.i("Inicio",data.toString())
        if (data!= null){
            val bundle= Bundle()
            bundle.putString("NOMBRE", data)
            fragCartelera.arguments= bundle
        }


        mlMain = findViewById(R.id.dlMain)
        nvInicio = findViewById(R.id.nvInicio)

        nvInicio.setNavigationItemSelectedListener {
            it.setChecked(true)

            val ft = supportFragmentManager.beginTransaction()

            when(it.itemId){
                R.id.iCartelera -> mostrarFragCartelera(ft)
                R.id.iNosotros -> mostrarFragNosotros(ft)
            }

            ft.commit()

            mlMain.closeDrawers()
            true
        }

        val ft = supportFragmentManager.beginTransaction()
        mostrarFragCartelera(ft)
        ft.commit()
        //Cargar fragment por defecto


    }

    private fun mostrarFragCartelera(ft: FragmentTransaction) {
        ft.replace(R.id.fcvItems, fragCartelera)
    }

    private fun mostrarFragNosotros(ft: FragmentTransaction) {
        ft.replace(R.id.fcvItems, fragNosotros)
    }
}