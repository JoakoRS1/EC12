package com.example.ec12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    private var mEteID : EditText? = null
    private var mButlog : Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //obtener id
        mEteID = findViewById(R.id.mEteID)
        mButlog= findViewById(R.id.mButLog)

        mButlog!!.setOnClickListener { v: View ->
            val nombre  : String = mEteID!!.text.toString()
            intent.setClass(this,MainActivity::class.java)
            val data = Bundle()
            data.putString("NOMBRE",nombre)
            intent.putExtras(data)

            startActivity(intent)

        }
    }
}