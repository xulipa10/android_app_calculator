package com.key.tools.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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




           }

    override fun onStart() {
        super.onStart()
        var male_check = all_widgets.masculino.isChecked()
        var female_check = all_widgets.feminino.isChecked()


        if (male_check == true and female_check == true){
            all_widgets.avisoCheckBox.text = "Por favor marque apenas um checkbox"
        }else{
            all_widgets.avisoCheckBox.text = ""
        }


    }










    fun onClick(view: View) {



        var tmb_feminino = 655.1 + (9.563 * peso) + (1.850 * altura_em_cm) - (4.676 * idade)
        var tmb_masculino = 66.5 + (13.75 * peso) + (5.003 * altura_em_cm) - (6.75 * idade)


    }


}