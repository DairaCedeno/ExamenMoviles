package com.example.medicoapp.repository

import com.example.medicoapp.data.Medico
import com.example.medicoapp.data.MedicoDao

class MedicoRepository(private val medicoDao: MedicoDao) {

    fun obtenerTodosLosMedicos() = medicoDao.obtenerTodosLosMedicos()

    suspend fun insertarMedico(medico: Medico) {
        medicoDao.insertarMedico(medico)
    }
}
