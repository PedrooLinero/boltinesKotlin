package com.example.boletinesparaexamen.Boletin3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Datos de las luces
data class Luz(val nombre: String, var encendida: Boolean, var intensidad: Float)

@Composable
fun ControlDeLuzInteligente() {
    // Estado que contiene las luces (inicialmente apagadas y con intensidad 0)
    var luces by remember {
        mutableStateOf(
            listOf(
                Luz("Sala", false, 0f),
                Luz("Cocina", false, 0f),
                Luz("Dormitorio", false, 0f),
                Luz("Baño", false, 0f),
                Luz("Comedor", false, 0f)
            )
        )
    }

    // Layout de la interfaz de control
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título de la interfaz
        Text(text = "Control de Luces Inteligentes", modifier = Modifier.padding(bottom = 16.dp))

        // Mostrar las luces en LazyColumn
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp) // Espaciado entre luces
        ) {
            items(luces) { luz ->
                LuzItem(luz) { nuevaIntensidad, estaEncendida ->
                    // Actualizar el estado de la luz (encendida y la intensidad)
                    luces = luces.map {
                        if (it == luz) it.copy(encendida = estaEncendida, intensidad = nuevaIntensidad)
                        else it
                    }
                }
            }
        }
    }
}

@Composable
fun LuzItem(luz: Luz, onEstadoCambiado: (Float, Boolean) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Nombre de la luz
        Text(text = luz.nombre, modifier = Modifier.padding(bottom = 8.dp))

        // Switch para encender/apagar la luz
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Encendida", modifier = Modifier.weight(1f))
            Switch(
                checked = luz.encendida,
                onCheckedChange = { onEstadoCambiado(luz.intensidad, it) }
            )
        }

        // Slider para ajustar la intensidad de la luz
        if (luz.encendida) {
            Text(text = "Intensidad: ${(luz.intensidad * 100).toInt()}%", modifier = Modifier.padding(bottom = 8.dp))
            Slider(
                value = luz.intensidad,
                onValueChange = { onEstadoCambiado(it, luz.encendida) },
                valueRange = 0f..1f,
                steps = 100,
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            // Si la luz está apagada, no mostrar el Slider
            Text(text = "Luz apagada", modifier = Modifier.padding(bottom = 8.dp))
        }
    }
}
