package com.oceanbrasil.ocean_jornada_android_maio_2023.model.repository

import androidx.lifecycle.MutableLiveData
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.domain.Hint
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.remote.HintsRemoteDataSource
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.remote.HintCallback
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.remote.entities.HintApiModel

object HintsRepository {
    private val hintsRemoteDataSource = HintsRemoteDataSource

    val hints = MutableLiveData<List<Hint>>()

    init {
        hintsRemoteDataSource.listHints(object : HintCallback {
            override fun onResult(hintApiModels: List<HintApiModel>) {
                val hintsDomain = hintApiModels.map {
                    Hint(it.id, it.name, it.latitude, it.longitude)
                }

                hints.postValue(hintsDomain)
            }
        })
    }
}
