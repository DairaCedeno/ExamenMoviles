package com.example.medicoapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medicoapp.data.Cita
import com.example.medicoapp.viewmodel.CitaViewModel

@Composable
fun CitaListScreen(medicoId: Int, viewModel: CitaViewModel) {

    val citas by viewModel.obtenerCitasPorMedico(medicoId).collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Citas Programadas", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        if (citas.isEmpty()) {
            Text(text = "No hay citas programadas.")
        } else {
            citas.forEach { cita ->
                CitaListItem(cita)
            }
        }
    }
}

@Composable
fun CitaListItem(cita: Cita) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Fecha: ${cita.fecha}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Descripción: ${cita.descripcion}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
