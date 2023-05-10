package com.oceanbrasil.ocean_jornada_android_maio_2023

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openTreasureHuntActivity()
    }

    private fun openTreasureHuntActivity() {
        val treasureHuntIntent = Intent(this, TreasureHuntActivity::class.java)
        startActivity(treasureHuntIntent)
    }
}
