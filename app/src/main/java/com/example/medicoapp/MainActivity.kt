package com.example.medicoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.ViewModelProvider
import com.example.medicoapp.data.AppDatabase
import com.example.medicoapp.data.Cita
import com.example.medicoapp.data.Medico
import com.example.medicoapp.repository.MedicoRepository
import com.example.medicoapp.repository.CitaRepository
import com.example.medicoapp.ui.MedicoListScreen
import com.example.medicoapp.viewmodel.MedicoViewModel
import com.example.medicoapp.viewmodel.CitaViewModel
import com.example.medicoapp.ui.theme.MedicoAppTheme
import com.example.medicoapp.viewmodel.CitaViewModelFactory
import com.example.medicoapp.viewmodel.MedicoViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar la base de datos y los ViewModels
        val database = AppDatabase.getDatabase(this)
        val medicoRepository = MedicoRepository(database.medicoDao())
        val citaRepository = CitaRepository(database.citaDao())
        val medicoViewModel = ViewModelProvider(this, MedicoViewModelFactory(medicoRepository)).get(MedicoViewModel::class.java)
        val citaViewModel = ViewModelProvider(this, CitaViewModelFactory(citaRepository)).get(CitaViewModel::class.java)

        // Llenar la base de datos con datos iniciales
        llenarDatosIniciales(medicoViewModel, citaViewModel)

        setContent {
            MedicoAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MedicoListScreen(medicoViewModel)
                }
            }
        }
    }

    private fun llenarDatosIniciales(medicoViewModel: MedicoViewModel, citaViewModel: CitaViewModel) {
        coroutineScope.launch {

            val medico1 = Medico(nombre = "Dr. Juan Pérez", especialidad = "Cardiología", uriImagen = "")
            val medico2 = Medico(nombre = "Dra. Ana García", especialidad = "Pediatría", uriImagen = "")


            medicoViewModel.insertarMedico(medico1)
            medicoViewModel.insertarMedico(medico2)


            citaViewModel.insertarCita(Cita(medicoId = 1, fecha = "2024-10-15", descripcion = "Consulta de rutina"))
            citaViewModel.insertarCita(Cita(medicoId = 1, fecha = "2024-10-20", descripcion = "Chequeo de presión"))
            citaViewModel.insertarCita(Cita(medicoId = 2, fecha = "2024-10-18", descripcion = "Revisión anual"))
        }
    }
}
