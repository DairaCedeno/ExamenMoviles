package com.example.medicoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.medicoapp.repository.MedicoRepository
import com.example.medicoapp.data.Medico
import com.example.medicoapp.data.MedicoDao


class MedicoViewModel(private val repository: MedicoRepository) : ViewModel() {
    val medicos = repository.obtenerTodosLosMedicos()

    fun insertarMedico(medico: Medico) {
        viewModelScope.launch {
            repository.insertarMedico(medico)
        }
    }
}


