package com.oceanbrasil.ocean_jornada_android_maio_2023

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
        val etNome = findViewById<EditText>(R.id.etNome)

        // Desafio: Pegar o que está no EditText e colocar no TextView

        // Criamos um Listener para o evento de clique no botão
        btEnviar.setOnClickListener {
            // O que escrevermos aqui nesse bloco
            // será executado ao clicar no botão

            if (etNome.text.isEmpty()) {
                // Esse bloco só executa quando o etNome está vazio
                // Portanto, preciso exibir o erro aqui
                etNome.error = "Digite o nome!"
            } else {
                // Caso contrário, ou seja, se não estiver vazio, executa
                // esse bloco
                // Portanto, posso atualizar o TextView normalmente

                tvResultado.text = etNome.text
            }
        }

        // Abrir Nova Tela
        val btAbrirNovaTela = findViewById<Button>(R.id.btAbrirNovaTela)

        btAbrirNovaTela.setOnClickListener {
            // Criar uma Intent para abrir a nova tela
            val abrirNovaTela = Intent(this, ResultadoActivity::class.java)

            // Registra a Intent no Android
            startActivity(abrirNovaTela)
        }
    }
}
