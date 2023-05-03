package com.oceanbrasil.ocean_jornada_android_maio_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // <> -> Tipo da informação
        // () -> ID do elemento
        // Para acessar os IDs -> R.id.VALOR_DO_ID
        // Variáveis -> val ou var
        // val -> variável que inicia o valor e nunca mais muda
        // var -> variável que inicia o valor e pode mudar depois
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btEnviar = findViewById<Button>(R.id.btEnviar)

        // Criamos um Listener para o evento de clique no botão
        btEnviar.setOnClickListener {
            // O que escrevermos aqui nesse bloco
            // será executado ao clicar no botão

            tvResultado.text = "Samsung Ocean"
        }
    }
}
