package com.example.boletinesparaexamen.Boletin3

import android.widget.ProgressBar
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import kotlinx.coroutines.delay

@Composable
fun PantallaDeProgresoDeTarea() {
    // Estado para controlar el progreso
    var progreso by remember { mutableStateOf(0f) }
    var tareaEnEjecucion by remember { mutableStateOf(false) }

    // Función para iniciar la tarea
    val iniciarTarea = {
        tareaEnEjecucion = true
        progreso = 0f
    }

    // Función para detener la tarea
    val detenerTarea = {
        tareaEnEjecucion = false
    }

    // Actualización del progreso de la tarea cada 100 ms
    LaunchedEffect(tareaEnEjecucion) {
        if (tareaEnEjecucion) {
            while (progreso < 1f) {
                delay(100)  // 100ms de retraso por cada incremento
                progreso += 0.01f  // Incremento de progreso en 1%
            }
        }
    }

    // Layout para la pantalla
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Texto mostrando el progreso
        Text(text = "Progreso: ${(progreso * 100).toInt()}%")

        Spacer(modifier = Modifier.height(16.dp))

        // ProgressBar horizontal que se actualiza conforme avanza la tarea
        AndroidView(
            factory = { context ->
                ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal).apply {
                    max = 100  // Establece el valor máximo del ProgressBar
                    progress = (progreso * 100).toInt()  // Asigna el progreso actual
                }
            },
            update = { progressBar ->
                progressBar.progress = (progreso * 100).toInt()  // Actualiza el progreso
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para iniciar la tarea
        Button(
            onClick = iniciarTarea,
            enabled = !tareaEnEjecucion,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Iniciar tarea")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para detener la tarea
        Button(
            onClick = detenerTarea,
            enabled = tareaEnEjecucion,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Detener tarea")
        }
    }
}
