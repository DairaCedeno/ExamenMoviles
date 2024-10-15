package com.example.medicoapp.repository

import com.example.medicoapp.data.Cita
import com.example.medicoapp.data.CitaDao
import kotlinx.coroutines.flow.Flow


class CitaRepository(private val citaDao: CitaDao) {
    fun obtenerCitasPorMedico(medicoId: Int): Flow<List<Cita>> {
        return citaDao.obtenerCitasPorMedico(medicoId)
    }

    suspend fun insertarCita(cita: Cita) {
        citaDao.insertarCita(cita)
    }
}
