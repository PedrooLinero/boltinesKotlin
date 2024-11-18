package com.example.colorselectorapp

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("RememberReturnType")
@Composable
fun SelecColorConElevacionEstado() {
    // Definir el estado del color seleccionado
    val selectedColor = remember { mutableStateOf(Color.White) }

    // Pasar el estado y la función para cambiar el color al componente hijo
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Selecciona un color")

        // Mostrar el color seleccionado en una vista
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(selectedColor.value)
                .padding(8.dp)
        ) {
            Text(
                text = "Color",
                modifier = Modifier.align(Alignment.Center),
                color = if (selectedColor.value != Color.White) Color.White else Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Componente hijo para mostrar los colores sin bucles
        ColorSelectorRow(selectedColor)
    }
}

@Composable
fun ColorSelectorRow(selectedColor: MutableState<Color>) {
    // Definir los colores manualmente
    val color1 = Color.Red
    val color2 = Color.Green
    val color3 = Color.Blue
    val color4 = Color.Yellow
    val color5 = Color.Cyan
    val color6 = Color.Magenta

    // Mostrar los recuadros de colores
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ColorBox(color = color1, selectedColor = selectedColor)
        Spacer(modifier = Modifier.width(8.dp))

        ColorBox(color = color2, selectedColor = selectedColor)
        Spacer(modifier = Modifier.width(8.dp))

        ColorBox(color = color3, selectedColor = selectedColor)
        Spacer(modifier = Modifier.width(8.dp))

        ColorBox(color = color4, selectedColor = selectedColor)
        Spacer(modifier = Modifier.width(8.dp))

        ColorBox(color = color5, selectedColor = selectedColor)
        Spacer(modifier = Modifier.width(8.dp))

        ColorBox(color = color6, selectedColor = selectedColor)
    }

    // con bucle
    /*for (color in colors) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(color)
                .padding(8.dp)
                .clickable {
                    selectedColor.value = color
                }
        )
        Spacer(modifier = Modifier.width(8.dp)) // Espacio entre los recuadros
    }*/
}

@Composable
fun ColorBox(color: Color, selectedColor: MutableState<Color>) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(color)
            .padding(8.dp)
            .clickable {
                selectedColor.value = color
            }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SelecColorConElevacionEstado()
}
