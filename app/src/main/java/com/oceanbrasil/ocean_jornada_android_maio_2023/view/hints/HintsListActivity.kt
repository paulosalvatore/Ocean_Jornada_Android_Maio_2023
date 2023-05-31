package com.oceanbrasil.ocean_jornada_android_maio_2023.view.hints

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.remote.entities.HintApiModel
import com.oceanbrasil.ocean_jornada_android_maio_2023.R
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.local.AppDatabase
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.local.hint.HintEntity

class HintsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hints_list)

        // TODO: Extrair
        val appDatabase = AppDatabase.getInstance(this)
        val hintDao = appDatabase.hintDao()

        // Iniciamos uma Thread nova
        Thread {
            // Executamos operações fora da Main Thread
            // TODO: Extrair
            val hintsEntities = hintDao.findAll()

            runOnUiThread {
                // Pegar a referência da RecyclerView
                val rvHints = findViewById<RecyclerView>(R.id.rvHints)

                // Inicializar LayoutManager
                val layoutManager = LinearLayoutManager(this)
                rvHints.layoutManager = layoutManager

                // Inicializar Adapter (Precisamos criar o Adapter)
                // TODO: Precisamos já receber o dado de Domain
                val hintsList = hintsEntities.map {
                    HintApiModel(it.id, it.name, it.latitude, it.longitude)
                }

                val adapter = HintsListAdapter(hintsList)
                rvHints.adapter = adapter
            }
        }.start()
    }
}
