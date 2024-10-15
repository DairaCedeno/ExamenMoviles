package com.example.medicoapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CitaDao {
    @Query("SELECT * FROM cita WHERE medicoId = :medicoId")
    fun obtenerCitasPorMedico(medicoId: Int): Flow<List<Cita>>

    @Insert
    suspend fun insertarCita(cita: Cita)
}
