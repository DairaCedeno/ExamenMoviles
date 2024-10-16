package com.example.medicoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicoapp.data.Cita
import com.example.medicoapp.repository.CitaRepository
import kotlinx.coroutines.launch

class CitaViewModel(private val repository: CitaRepository) : ViewModel() {
    fun obtenerCitasPorMedico(medicoId: Int) = repository.obtenerCitasPorMedico(medicoId)

    fun insertarCita(cita: Cita) {
        viewModelScope.launch {
            repository.insertarCita(cita)
        }
    }
}
