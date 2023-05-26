package com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.remote

import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.remote.entities.Hint

interface HintCallback {
    fun onResult(hints: List<Hint>)
}
