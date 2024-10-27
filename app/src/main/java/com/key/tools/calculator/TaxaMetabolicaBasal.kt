package com.key.tools.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class TaxaMetabolicaBasal : AppCompatActivity() {

    var peso = 0
    var altura_em_cm = 0
    var idade = 0
    var sexo = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_taxa_metabolica_basal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }






    }


    fun onClick(view: View) {



        var tmb_feminino = 655.1 + (9.563 * peso) + (1.850 * altura_em_cm) - (4.676 * idade)
        var tmb_masculino = 66.5 + (13.75 * peso) + (5.003 * altura_em_cm) - (6.75 * idade)


    }


}