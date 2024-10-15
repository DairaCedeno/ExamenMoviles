package com.example.medicoapp.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.medicoapp.repository.MedicoRepository

class MedicoViewModelFactory(private val repository: MedicoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MedicoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MedicoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
