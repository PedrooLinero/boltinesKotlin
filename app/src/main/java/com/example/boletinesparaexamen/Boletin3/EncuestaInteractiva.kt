package com.example.boletinesparaexamen.Boletin3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Datos de las preguntas
data class Pregunta(val titulo: String, val opciones: List<String>, var respuestaSeleccionada: String? = null)

@Composable
fun EncuestaInteractiva() {
    // Estado que contiene las preguntas y respuestas (inicialmente sin respuestas)
    var preguntas by remember {
        mutableStateOf(
            listOf(
                Pregunta("¿Cuál es tu color favorito?", listOf("Rojo", "Verde", "Azul", "Amarillo")),
                Pregunta("¿Cuál es tu comida favorita?", listOf("Pizza", "Sushi", "Hamburguesa", "Pasta")),
                Pregunta("¿Qué tipo de música prefieres?", listOf("Rock", "Pop", "Jazz", "Clásica"))
            )
        )
    }

    // Layout de la encuesta
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título de la encuesta
        Text(text = "Encuesta Interactiva", modifier = Modifier.padding(bottom = 16.dp))

        // Mostrar las preguntas en LazyColumn
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)  // Espaciado entre elementos
        ) {
            items(preguntas) { pregunta ->
                PreguntaItem(pregunta) { respuesta ->
                    // Actualizar la respuesta seleccionada de la pregunta
                    preguntas = preguntas.map {
                        if (it == pregunta) it.copy(respuestaSeleccionada = respuesta)
                        else it
                    }
                }
            }
        }
    }
}

@Composable
fun PreguntaItem(pregunta: Pregunta, onRespuestaChanged: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Título de la pregunta
        Text(text = pregunta.titulo, modifier = Modifier.padding(bottom = 8.dp))

        // Mostrar opciones (RadioButtons) para cada pregunta
        pregunta.opciones.forEach { opcion ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp) // Espaciado entre cada opción
            ) {
                RadioButton(
                    selected = pregunta.respuestaSeleccionada == opcion,
                    onClick = { onRespuestaChanged(opcion) }
                )
                Text(text = opcion, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}
