package com.example.medicoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medico")
data class Medico(
    @PrimaryKey val id: Int,
    val nombre: String,
    val especialidad: String,
    val uriImagen: String // Ruta de la imagen guardada en almacenamiento
)
