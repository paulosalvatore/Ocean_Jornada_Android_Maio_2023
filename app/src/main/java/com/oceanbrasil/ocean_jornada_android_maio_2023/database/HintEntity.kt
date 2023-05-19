package com.oceanbrasil.ocean_jornada_android_maio_2023.database

import androidx.room.PrimaryKey

data class HintEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double
)
