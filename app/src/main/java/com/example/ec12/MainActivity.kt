package com.example.ec12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.example.ec12.fragments.NosotrosFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var mlMain: DrawerLayout
    private lateinit var nvInicio: NavigationView

    private val fragNosotros = NosotrosFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = getIntent().getStringExtra("NOMBRE")
        Log.i("Inicio",data.toString())

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

        //Cargar fragment por defecto


    }

    private fun mostrarFragCartelera(ft: FragmentTransaction) {
        TODO("Not yet implemented")
    }

    private fun mostrarFragNosotros(ft: FragmentTransaction) {
        ft.replace(R.id.fcvItems, fragNosotros)
    }
}