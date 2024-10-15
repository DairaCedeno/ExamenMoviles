package com.example.medicoapp.repository

import com.example.medicoapp.data.Medico
import com.example.medicoapp.data.MedicoDao
import kotlinx.coroutines.flow.Flow


class MedicoRepository(private val medicoDao: MedicoDao) {
    fun obtenerTodosLosMedicos(): Flow<List<Medico>> {
        return medicoDao.obtenerTodosLosMedicos()
    }

    suspend fun insertarMedico(medico: Medico) {
        medicoDao.insertarMedico(medico)
    }
}
