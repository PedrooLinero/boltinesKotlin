package com.example.boletinesparaexamen.Navegacion

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PantallaDeInicio(volver: () -> Unit) {
    // Contenedor principal con Scaffold
    Scaffold(
        topBar = {
            // Barra superior
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
                Button(onClick = volver) {
                    Text(text = "Atrás")
                }
            }
        },
        floatingActionButton = {
            // FloatingActionButton
            FloatingActionButton(
                onClick = volver,
                content = {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
                }
            )
        },
        content = {
            // Contenido central de la pantalla
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Bienvenido a la Pantalla de Inicio")
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewPantallaDeInicio() {
    PantallaDeInicio(volver = {})
}
