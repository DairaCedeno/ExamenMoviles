package com.example.medicoapp.repository

import com.example.medicoapp.data.Cita
import com.example.medicoapp.data.CitaDao

class CitaRepository(private val citaDao: CitaDao) {

    fun obtenerCitasPorMedico(medicoId: Int) = citaDao.obtenerCitasPorMedico(medicoId)

    suspend fun insertarCita(cita: Cita) {
        citaDao.insertarCita(cita)

    }
}
