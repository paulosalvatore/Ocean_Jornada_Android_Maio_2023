package com.oceanbrasil.ocean_jornada_android_maio_2023.viewmodel

import androidx.lifecycle.ViewModel
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.repository.HintsRepository

class HintsViewModel : ViewModel() {
    private val hintsRepository = HintsRepository

    val hints = hintsRepository.hints

    // TODO: Implementar
//        val appDatabase = AppDatabase.getInstance(this)
//        val hintDao = appDatabase.hintDao()
}
