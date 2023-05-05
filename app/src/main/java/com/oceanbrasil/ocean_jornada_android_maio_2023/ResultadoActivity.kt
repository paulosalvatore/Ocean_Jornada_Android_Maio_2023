package com.oceanbrasil.ocean_jornada_android_maio_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        // Pegamos a informação digitada, pela Intent que originou essa tela
        val nomeDigitado = intent.getStringExtra("NOME_DIGITADO")

        // Atualizamos o tvResultado com o nome digitado na outra tela e
        // recebido pela Intent
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        tvResultado.text = nomeDigitado
    }
}
