package com.example.medicoapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.medicoapp.viewmodel.CitaViewModel

@Composable
fun CitaListScreen(medicoId: Int, viewModel: CitaViewModel) {
    val citas = viewModel.obtenerCitasPorMedico(medicoId).collectAsState(initial = emptyList()).value

    LazyColumn {
        items(citas) { cita ->
            Text(text = "${cita.fecha}: ${cita.descripcion}")
        }
    }
}
