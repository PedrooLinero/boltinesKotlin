package com.example.boletinesparaexamen.Boletin1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PerfilDeUsuario() {
    // Valores definidos dentro de la función
    val imagenUrl = "https://www.example.com/sample.jpg"  // Usar una URL válida
    val nombre = "Juan Pérez"
    val biografia = "Desarrollador apasionado por la tecnología y la innovación. Amante del café y los desafíos."

    Column(
        modifier = Modifier
            .fillMaxSize() // Asegúrate de que ocupe todo el tamaño disponible
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, // Centrar el contenido verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centrar el contenido horizontalmente
    ) {
        // Imagen de perfil
        AsyncImage(
            model = imagenUrl,
            contentDescription = "Imagen de perfil",
            modifier = Modifier
                .size(128.dp) // Tamaño de la imagen
                .padding(bottom = 16.dp)
        )
        // Nombre del usuario
        Text(
            text = nombre,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // Biografía del usuario
        Text(
            text = biografia,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

// Función de previsualización
@Preview(showBackground = true)
@Composable
fun PreviewPerfilDeUsuario() {
    PerfilDeUsuario()
}
