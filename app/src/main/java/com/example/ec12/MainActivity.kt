package com.example.ec12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.example.ec12.fragments.CarteleraFragment
import com.example.ec12.fragments.NosotrosFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : FragmentActivity() {

    private lateinit var mlMain: DrawerLayout
    private lateinit var nvInicio: NavigationView
    private lateinit var tvNombre: TextView

    private val fragNosotros = NosotrosFragment()
    private val fragCartelera = CarteleraFragment()

    private var data: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mlMain = findViewById(R.id.dlMain)
        nvInicio = findViewById(R.id.nvInicio)


        nvInicio.setNavigationItemSelectedListener {
            it.setChecked(true)

            val ft = supportFragmentManager.beginTransaction()

            when(it.itemId){
                R.id.iCartelera -> mostrarFragCartelera(ft)
                R.id.iNosotros -> mostrarFragNosotros(ft)
            }
            ft.addToBackStack(null)

            ft.commit()

            mlMain.closeDrawers()
            true
        }

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fcvItems,fragCartelera)
        ft.commit()
        mlMain.openDrawer(nvInicio)
        //Cargar fragment por defecto

        data = intent.getStringExtra("NOMBRE")
        if (data!= ""){
            val bundle= Bundle()
            bundle.putString("NOMBRE", data)
            fragCartelera.arguments= bundle
            tvNombre = nvInicio.getHeaderView(0).findViewById(R.id.User)
            tvNombre.text=data
        }

    }

    private fun mostrarFragCartelera(ft: FragmentTransaction) {
        ft.replace(R.id.fcvItems, fragCartelera)
    }

    private fun mostrarFragNosotros(ft: FragmentTransaction) {
        ft.replace(R.id.fcvItems, fragNosotros)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}