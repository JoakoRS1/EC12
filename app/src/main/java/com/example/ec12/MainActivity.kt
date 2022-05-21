package com.example.ec12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var mlMain: DrawerLayout
    private lateinit var nvInicio: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = getIntent().getStringExtra("NOMBRE")
        Log.i("Inicio",data.toString())

        mlMain = findViewById(R.id.dlMain)
        nvInicio = findViewById(R.id.nvInicio)

        nvInicio.setNavigationItemSelectedListener {
            it.setChecked(true)

            when(it.itemId){
                R.id.iCartelera -> mostrarFragCartelera()
                R.id.iNosotros -> mostrarFragNosotros()
            }
            mlMain.closeDrawers()
            true
        }
    }

    private fun mostrarFragCartelera() {
        TODO("Not yet implemented")
    }

    private fun mostrarFragNosotros() {
        TODO("Not yet implemented")
    }
}