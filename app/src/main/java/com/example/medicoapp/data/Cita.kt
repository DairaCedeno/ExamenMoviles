package com.example.medicoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cita")
data class Cita(
    @PrimaryKey val id: Int,
    val medicoId: Int, // Referencia a la tabla `Medico`
    val fecha: String,
    val descripcion: String
)
