package com.example.medicoapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.medicoapp.data.Medico
import com.example.medicoapp.viewmodel.MedicoViewModel

@Composable
fun MedicoListScreen(
    viewModel: MedicoViewModel,
    onMedicoClick: (Medico) -> Unit,
    navController: NavHostController,
) {
    val medicos = viewModel.medicos.collectAsState(initial = emptyList()).value

    LazyColumn {
        items(medicos) { medico ->
            MedicoListItem(medico = medico, onMedicoClick = onMedicoClick)
        }
    }
}

@Composable
fun MedicoListItem(medico: Medico, onMedicoClick: (Medico) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onMedicoClick(medico) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = medico.uriImagen,
            contentDescription = medico.nombre,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = medico.nombre, fontWeight = FontWeight.Bold)
            Text(text = medico.especialidad)
        }
    }
}
