package com.key.tools.calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        val imc_botao = findViewById<Button>(R.id.imc_button)



        imc_botao.setOnClickListener {
            val activity = Intent(this, imc::class.java)
            startActivity(activity)
            finish()
        }





    }

    fun abrirTaxa(view: View) {

        val activity = Intent(this, TaxaMetabolicaBasal::class.java)
        print("intent criado")
        startActivity(activity)
        print("activity started")
        finish()



    }


}
