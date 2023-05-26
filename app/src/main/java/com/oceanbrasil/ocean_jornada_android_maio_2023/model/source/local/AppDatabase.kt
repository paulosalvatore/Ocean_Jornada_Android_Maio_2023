package com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.local.hint.HintDao
import com.oceanbrasil.ocean_jornada_android_maio_2023.model.source.local.hint.HintEntity

@Database(entities = [HintEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun hintDao(): HintDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).build().also { instance = it }
        }
    }
}
