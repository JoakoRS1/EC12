package com.example.ec12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val data = getIntent().getStringExtra("NOMBRE")
        Log.i("Inicio",data.toString())

    }
}