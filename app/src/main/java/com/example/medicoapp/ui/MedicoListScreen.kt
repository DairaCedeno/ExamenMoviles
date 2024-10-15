package com.example.medicoapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.medicoapp.data.Medico
import com.example.medicoapp.viewmodel.MedicoViewModel
import com.example.medicoapp.viewmodel.CitaViewModel
import com.example.medicoapp.ui.CitaListScreen

@Composable
fun MedicoListScreen(viewModel: MedicoViewModel, citaViewModel: CitaViewModel) {
    // Obtener el estado de los médicos desde el ViewModel
    val medicos = viewModel.medicos.collectAsState(initial = emptyList()).value

    LazyColumn {
        items(medicos) { medico ->
            Text(
                text = medico.nombre,
                modifier = Modifier
                    .clickable {
                        // Llamar a la función para navegar a la pantalla de citas
                        CitaListScreen(medicoId = medico.id, citaViewModel = citaViewModel)
                    }
            )
        }
    }
}

