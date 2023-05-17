package com.oceanbrasil.ocean_jornada_android_maio_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HintsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hints_list)

        // Pegar a referência da RecyclerView
        val rvHints = findViewById<RecyclerView>(R.id.rvHints)

        // Inicializar LayoutManager
        val layoutManager = LinearLayoutManager(this)
        rvHints.layoutManager = layoutManager

        // Inicializar Adapter (Precisamos criar o Adapter)
        // TODO: Substituir listOf pela chamada na API
        val hintsList = listOf(
            Hint(1, "Local da Dica", 10.0, 10.0),
            Hint(2, "Local da Dica", 10.0, 10.0),
            Hint(3, "Local da Dica", 10.0, 10.0)
        )
        val adapter = HintsListAdapter(hintsList)
        rvHints.adapter = adapter
    }
}
