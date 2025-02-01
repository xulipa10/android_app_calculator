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
import kotlin.math.roundToInt


class TaxaMetabolicaBasal : AppCompatActivity() {
    private lateinit var all_widgets: ActivityTaxaMetabolicaBasalBinding
    var peso = 0.0
    var altura_em_cm = 0
    var idade = 0
    var sexo = ""
    var tmb_masculino = 0.0
    var tmb_feminino = 0.0




    @SuppressLint("WrongViewCast", "SetTextI18n")
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
        val aviso = findViewById<TextView>(R.id.avisocheckbox)
        val ep = findViewById<EditText>(R.id.text_peso)
        val ei = findViewById<EditText>(R.id.text_idade)
        val ea = findViewById<EditText>(R.id.text_altura)



        calcular.setOnClickListener {
            if(ep.text.toString() == "" || ei.text.toString() == "" || ea.text.toString() == ""){
                aviso.text = "Preencha todos os campos." }
            else{
                peso = ep.text.toString().toDouble()
                idade = ei.text.toString().toInt()
                altura_em_cm = ea.text.toString().toInt()
                tmb_masculino = 66.5 + (13.75 * peso) + (5.003 * altura_em_cm) - (6.75 * idade)
                tmb_feminino = 655.1 + (9.563 * peso) + (1.850 * altura_em_cm) - (4.676 * idade)
                Toast.makeText(applicationContext, tmb_feminino.toString() +"e"+ tmb_masculino.toString(), Toast.LENGTH_LONG).show()




            }



            if (masculino.isChecked and feminino.isChecked){
                aviso.text = "  Marque apenas uma opção"
                feminino.setChecked(false)
                masculino.setChecked(false)}

            else if (masculino.isChecked == false){ if (feminino.isChecked == false){
                aviso.text = "  Marque se é homem ou mulher" }}

            else if (feminino.isChecked == false){ if (masculino.isChecked == false){
                aviso.text = "  Marque se é homem ou mulher" }}


            else {
                aviso.text = ""

                }




            }




/// Calculadora de Taxa Metabólica Basal (Harris-Benedict)
///Toast.makeText(applicationContext, masculino.isChecked.toString() + feminino.isChecked.toString(), Toast.LENGTH_LONG).show()


        }

    fun calcularTaxa(){
        if (all_widgets.masculino.isChecked){
            tmb_masculino = 66.5 + (13.75 * peso) + (5.003 * altura_em_cm) - (6.75 * idade)
            all_widgets.avisocheckbox.text = ""
            sexo = "M" }
        else if (all_widgets.feminino.isChecked){
            tmb_feminino = 655.1 + (9.563 * peso) + (1.850 * altura_em_cm) - (4.676 * idade)
            all_widgets.avisocheckbox.text = ""
            sexo ="F" }
        else{
            sexo = ""

        }
        Toast.makeText(applicationContext, tmb_feminino.toString() + tmb_masculino.toString(), Toast.LENGTH_LONG).show()

           }


















}


