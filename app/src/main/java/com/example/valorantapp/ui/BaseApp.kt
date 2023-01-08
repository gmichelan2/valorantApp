package com.example.valorantapp.ui

import android.app.Application
import androidx.room.Room
import com.example.valorantapp.model.database.ValorantDatabase

class BaseApp: Application() {

    lateinit var db: ValorantDatabase
    private set

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            ValorantDatabase::class.java, "valorant-db"
        ).build()
    }
}