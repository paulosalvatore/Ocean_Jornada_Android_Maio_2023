package com.oceanbrasil.ocean_jornada_android_maio_2023.model.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.domain.Hint
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.local.HintsLocalDataSource
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.remote.HintsRemoteDataSource
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.remote.HintCallback
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.remote.entities.HintApiModel

class HintsRepository(application: Application) {
    private val hintsRemoteDataSource = HintsRemoteDataSource

    private val hintsLocalDataSource = HintsLocalDataSource(application)

    val hints = MutableLiveData<List<Hint>>()

    init {
        hintsRemoteDataSource.listHints(object : HintCallback {
            override fun onResult(hintApiModels: List<HintApiModel>) {
                val hintsDomain = hintApiModels.map {
                    Hint(it.id, it.name, it.latitude, it.longitude)
                }

                Thread {
                    hintsLocalDataSource.insertAll(hintsDomain)

                    val hintsFromDb = hintsLocalDataSource.findAll()

                    print(hintsFromDb)

                    hints.postValue(hintsFromDb)
                }.start()
            }
        })
    }
}
