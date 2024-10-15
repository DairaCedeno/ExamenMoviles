package com.example.medicoapp.data


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicoDao {
    @Query("SELECT * FROM medico")
    fun obtenerTodosLosMedicos(): Flow<List<Medico>>

    @Insert
    suspend fun insertarMedico(medico: Medico)
}

