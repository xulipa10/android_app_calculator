package com.key.tools.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.key.tools.calculator.databinding.ActivityTaxaMetabolicaBasalBinding


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
        var valor_atividade = 0.0
        val nivel_atividade = findViewById<TextView>(R.id.nivel_de_atividades)
        val resultado_f = findViewById<TextView>(R.id.resultado_f)
        calcular.setBackgroundColor(applicationContext.getColor(R.color.black))



        calcular.setOnClickListener {
            var resultado = 1.0

            if (masculino.isChecked){
                sexo = "M"
            }
            else if (feminino.isChecked){
                sexo = "F"
            }
            if(ep.text.toString() == "" || ei.text.toString() == "" || ea.text.toString() == ""){
                aviso.text = "  Preencha todos os campos." }
            else{
                peso = ep.text.toString().toDouble()
                idade = ei.text.toString().toInt()
                altura_em_cm = ea.text.toString().toInt()
                tmb_masculino = 66.5 + (13.75 * peso) + (5.003 * altura_em_cm) - (6.75 * idade)
                tmb_feminino = 655.1 + (9.563 * peso) + (1.850 * altura_em_cm) - (4.676 * idade)
                if (masculino.isChecked){resultado = tmb_masculino * valor_atividade}
                if (feminino.isChecked){resultado = tmb_feminino * valor_atividade}
                if (sexo == "M"){resultado_f.text = resultado.toInt().toString() + "  kcal/dia"}
                if (sexo == "F"){resultado_f.text = resultado.toInt().toString() + "  kcal/dia"}
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

        nivel_atividade.setOnClickListener {

            PopupMenu(applicationContext, nivel_atividade).apply {
                menuInflater.inflate(R.menu.tmb_menu, this.menu)
                setOnMenuItemClickListener { item : MenuItem ->
                    when (item.itemId){
                        R.id.nivel_de_atividades -> {
                            nivel_atividade.text = "TMB (repouso)"
                            valor_atividade = 1.0
                            true
                        }
                        R.id.sedentário -> {
                            nivel_atividade.text = "Sedentário"
                            valor_atividade = 1.2
                            true
                        }
                        R.id.l_ativo -> {
                            nivel_atividade.text = "Levemente ativo"
                            valor_atividade = 1.375
                            true
                        }
                        R.id.m_ativo -> {
                            nivel_atividade.text = "Moderadamente ativo"
                            valor_atividade = 1.55
                            true
                        }
                        R.id.muito_ativo -> {
                            nivel_atividade.text = "Muito ativo"
                            valor_atividade = 1.725
                            true
                        }
                        R.id.atleta -> {
                            nivel_atividade.text = "atleta"
                            valor_atividade = 1.9
                            true
                        }

                        else -> {false}
                    }

                }
                show()
            }
        }




/// Calculadora de Taxa Metabólica Basal (Harris-Benedict)
///Toast.makeText(applicationContext, masculino.isChecked.toString() + feminino.isChecked.toString(), Toast.LENGTH_LONG).show()


        }


















}


