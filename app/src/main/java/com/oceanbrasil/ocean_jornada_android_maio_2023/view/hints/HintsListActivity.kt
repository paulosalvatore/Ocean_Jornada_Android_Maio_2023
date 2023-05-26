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
        val hintEntity = HintEntity(1, "Brigadeiro", 10.0, 70.0)
        val hintEntity2 = HintEntity(2, "Trianon Masp", 20.0, 60.0)
        val hintEntity3 = HintEntity(3, "Paraíso", 30.0, 50.0)
        val hintEntity4 = HintEntity(4, "Consolação", 40.0, 40.0)

        // TODO: Extrair
        val appDatabase = AppDatabase.getInstance(this)
        val hintDao = appDatabase.hintDao()

        // Iniciamos uma Thread nova
        Thread {
            // Executamos operações fora da Main Thread
//            hintDao.insert(hintEntity)
//            hintDao.insert(hintEntity2)
//            hintDao.insert(hintEntity3)
//            hintDao.insert(hintEntity4)

            // TODO: Extrair
            val hintsEntities = hintDao.findAll()

            runOnUiThread {
                // Pegar a referência da RecyclerView
                val rvHints = findViewById<RecyclerView>(R.id.rvHints)

                // Inicializar LayoutManager
                val layoutManager = LinearLayoutManager(this)
                rvHints.layoutManager = layoutManager

                // Inicializar Adapter (Precisamos criar o Adapter)
//                val hintsList = listOf(
//                    Hint(1, "Brigadeiro", 10.0, 70.0),
//                    Hint(2, "Trianon Masp", 20.0, 60.0),
//                    Hint(3, "Paraíso", 30.0, 40.0)
//                )
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
