package com.example.boletinesparaexamen.Boletin1
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PantallaDeLogin() {
    // Estado para el nombre de usuario y la contraseña
    var nombreUsuario by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }

    // Acción al presionar el botón
    fun enviarDatos() {
        // Aquí puedes implementar lo que sucede al enviar los datos (ej. validación)
        println("Nombre de usuario: $nombreUsuario")
        println("Contraseña: $contrasena")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, // Centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
    ) {
        // Título de la pantalla
        Text(
            text = "Pantalla de Login",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Campo de texto para el nombre de usuario
        TextField(
            value = nombreUsuario,
            onValueChange = { nombreUsuario = it },
            label = { Text("Nombre de usuario") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // Campo de texto para la contraseña
        TextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(), // Oculta la contraseña
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
        )

        // Botón de enviar
        Button(
            onClick = { enviarDatos() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Enviar")
        }
    }
}

