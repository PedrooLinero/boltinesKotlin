package com.example.boletinesparaexamen.Boletin2

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ContadorConElevacionDeEstado() {
    // Definir el estado del contador
    val contador = remember { mutableStateOf(0) }

    // Pasa el estado y las funciones de incremento y decremento al componente hijo
    ContadorControles(contador = contador)
}

@Composable
fun ContadorControles(contador: androidx.compose.runtime.MutableState<Int>) {
    // Centrar el contenido de la columna en toda la pantalla
    Column(
        modifier = Modifier.fillMaxSize(), // Esto hace que ocupe todo el tamaño de la pantalla
        horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center // Centra verticalmente
    ) {
        Text(text = "Contador: ${contador.value}")
        Button(onClick = { contador.value++ }) {
            Text("Incrementar")
        }
        Button(onClick = { contador.value-- }) {
            Text("Decrementar")
        }
    }
}