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
fun PantallaDeRegistro() {
    // Estado para los campos del formulario
    var nombreUsuario by remember { mutableStateOf("") }
    var correoElectronico by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var confirmarContrasena by remember { mutableStateOf("") }

    // Acción al presionar el botón de enviar
    fun enviarDatos() {
        // Validación simple: comprobar si las contraseñas coinciden
        if (contrasena != confirmarContrasena) {
            println("Las contraseñas no coinciden.")
        } else {
            // Aquí puedes agregar la lógica para registrar al usuario
            println("Nombre de usuario: $nombreUsuario")
            println("Correo electrónico: $correoElectronico")
            println("Contraseña: $contrasena")
            println("Confirmación de contraseña: $confirmarContrasena")
        }
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
            text = "Pantalla de Registro",
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

        // Campo de texto para el correo electrónico
        TextField(
            value = correoElectronico,
            onValueChange = { correoElectronico = it },
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // Campo de texto para la contraseña
        TextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(), // Oculta la contraseña
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        // Campo de texto para confirmar la contraseña
        TextField(
            value = confirmarContrasena,
            onValueChange = { confirmarContrasena = it },
            label = { Text("Confirmar contraseña") },
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

