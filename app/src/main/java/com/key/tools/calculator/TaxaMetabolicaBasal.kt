package com.key.tools.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import com.key.tools.calculator.databinding.ActivityTaxaMetabolicaBasalBinding


class TaxaMetabolicaBasal : AppCompatActivity() {
    private lateinit var all_widgets: ActivityTaxaMetabolicaBasalBinding

    var peso = 0
    var altura_em_cm = 0
    var idade = 0
    var sexo = ""




    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        all_widgets = ActivityTaxaMetabolicaBasalBinding.inflate(layoutInflater)
        val view = all_widgets.root
        setContentView(view)
        setContentView(R.layout.activity_taxa_metabolica_basal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) {
            v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val calcular = findViewById<Button>(R.id.calcular)
        val masculino = findViewById<CheckBox>(R.id.masculino)
        val feminino = findViewById<CheckBox>(R.id.feminino)

        calcular.setOnClickListener {
            Toast.makeText(applicationContext, "teste", Toast.LENGTH_LONG).show()
            feminino.setChecked(false)
            masculino.setChecked(false)




            var tmb_feminino = 655.1 + (9.563 * peso) + (1.850 * altura_em_cm) - (4.676 * idade)
            var tmb_masculino = 66.5 + (13.75 * peso) + (5.003 * altura_em_cm) - (6.75 * idade)


        }



           }


















}


