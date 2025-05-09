package com.key.tools.calculator


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class imc : AppCompatActivity() {
    var resultado = 0.0

    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val peso_imc = findViewById<TextView>(R.id.peso_imc)
        val altura_imc = findViewById<TextView>(R.id.altura_imc)
        val calcular_imc = findViewById<Button>(R.id.calcular_imc)
        val resultado_imc = findViewById<TextView>(R.id.imc_result)

        calcular_imc.setOnClickListener {
            var altura = altura_imc.text.toString().toDouble() / 100
            resultado = peso_imc.text.toString().toDouble() / (altura*altura)
            var nivel = ""
            if (resultado < 18.5){nivel = "Baixo Peso"}
            if (resultado >= 18.5 && resultado <= 24.9){nivel = "Normal"}
            if (resultado >= 25.0 && resultado <= 29.9 ){nivel = "Sobrepeso"}
            if (resultado >= 30.0 && resultado <= 39.9){nivel = "Obesidade"}
            if (resultado >= 40 ){nivel = "Extremo Obeso"}

            resultado_imc.text = nivel + " " + String.format( "%.2f" ,resultado.toFloat())
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        val activity = Intent(this, MainActivity::class.java)
        startActivity(activity)
        finish()


    }


}