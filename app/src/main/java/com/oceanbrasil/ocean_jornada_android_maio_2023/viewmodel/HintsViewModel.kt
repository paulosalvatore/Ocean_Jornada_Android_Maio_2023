package com.oceanbrasil.ocean_jornada_android_maio_2023.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.domain.Hint
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.remote.ApiRepository
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.remote.HintCallback
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.remote.entities.HintApiModel

class HintsViewModel : ViewModel() {
    private val apiRepository = ApiRepository

    val hints = MutableLiveData<List<Hint>>()

    init {
        apiRepository.listHints(object : HintCallback {
            override fun onResult(hintApiModels: List<HintApiModel>) {
                val hintsDomain = hintApiModels.map {
                    Hint(it.id, it.name, it.latitude, it.longitude)
                }

                hints.postValue(hintsDomain)
            }
        })
    }
}
