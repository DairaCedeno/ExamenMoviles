package com.example.medicoapp

import android.app.Application
import com.example.medicoapp.data.AppDatabase

class MedicoApp : Application() {
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        // Inicializar la base de datos
        database = AppDatabase.getDatabase(this)
    }
}
