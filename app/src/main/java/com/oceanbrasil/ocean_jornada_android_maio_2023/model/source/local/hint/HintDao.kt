package com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.local.hint

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HintDao {
    @Insert
    fun insert(hint: HintEntity)

    @Query("SELECT * FROM hints")
    fun findAll(): List<HintEntity>
}
