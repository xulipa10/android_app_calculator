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
    var check = 0



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









    fun onClick(view: View) {
        var nada = all_widgets.feminino.isChecked
        Toast.makeText(applicationContext, nada.toString(), Toast.LENGTH_LONG).show()






    }



        var tmb_feminino = 655.1 + (9.563 * peso) + (1.850 * altura_em_cm) - (4.676 * idade)
        var tmb_masculino = 66.5 + (13.75 * peso) + (5.003 * altura_em_cm) - (6.75 * idade)


    fun feminino(view: View) {
        if (all_widgets.feminino.isChecked == false){
            all_widgets.feminino.toggle()
        }else if(all_widgets.feminino.isChecked == true){
            all_widgets.feminino.toggle()
        }
        Toast.makeText(applicationContext, all_widgets.feminino.isChecked.toString(), Toast.LENGTH_LONG).show()


    }

    fun masculino(view: View) {
        if (all_widgets.masculino.isChecked == false){
            all_widgets.masculino.toggle()
        }else if(all_widgets.masculino.isChecked == true){
            all_widgets.masculino.toggle()
        }
        Toast.makeText(applicationContext, all_widgets.masculino.isChecked.toString(), Toast.LENGTH_LONG).show()

    }


}


