package com.example.boletinesparaexamen.Boletin3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Datos de las tareas
data class Tarea(val titulo: String, var completada: Boolean)

@Composable
fun ListaDeTareasConSecciones() {
    // Estado que contiene las tareas (inicialmente todas sin marcar)
    var tareas by remember {
        mutableStateOf(
            listOf(
                Tarea("Comprar pan", false),
                Tarea("Lavar los platos", false),
                Tarea("Estudiar para el examen", false),
                Tarea("Hacer ejercicio", false),
                Tarea("Revisar el correo", false)
            )
        )
    }

    // Sección de tareas pendientes
    val tareasPendientes = tareas.filter { !it.completada }
    // Sección de tareas completadas
    val tareasCompletadas = tareas.filter { it.completada }

    // Layout de la pantalla
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título de la lista
        Text(text = "Lista de Tareas", modifier = Modifier.padding(bottom = 16.dp))

        // Sección de tareas pendientes
        if (tareasPendientes.isNotEmpty()) {
            Text(text = "Tareas Pendientes", modifier = Modifier.padding(bottom = 8.dp))
            LazyColumn {
                items(tareasPendientes) { tarea ->
                    TareaItem(tarea) { tareaCompletada ->
                        // Actualizamos el estado de la tarea en la lista
                        tareas = tareas.map {
                            if (it == tarea) it.copy(completada = tareaCompletada)
                            else it
                        }
                    }
                }
            }
        }

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        // Sección de tareas completadas
        if (tareasCompletadas.isNotEmpty()) {
            Text(text = "Tareas Completadas", modifier = Modifier.padding(bottom = 8.dp))
            LazyColumn {
                items(tareasCompletadas) { tarea ->
                    TareaItem(tarea) { tareaCompletada ->
                        // Actualizamos el estado de la tarea en la lista
                        tareas = tareas.map {
                            if (it == tarea) it.copy(completada = tareaCompletada)
                            else it
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TareaItem(tarea: Tarea, onCheckChanged: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Checkbox para marcar como completada
        Checkbox(
            checked = tarea.completada,
            onCheckedChange = { onCheckChanged(it) }
        )

        // Título de la tarea
        Text(text = tarea.titulo, modifier = Modifier.padding(start = 8.dp))
    }
}

@Preview
@Composable
fun PreviewListaDeTareas() {
    ListaDeTareasConSecciones()
}
