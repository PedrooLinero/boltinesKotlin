package com.example.boletinesparaexamen.Boletin1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CarruselDeImagenes() {
    // Lista de URLs de imágenes.
    val listaImagenes = listOf(
        "https://es.rc-cdn.community.thermomix.com/recipeimage/wnt35g3q-9824f-069524-cfcd2-ls13zaaq/7d2802dd-24b1-421c-b4ea-6586bacf7a6a/main/chocolate-con-churros-madrid-libro-simplemente-espectacular.jpg",
        "https://img.rtve.es/imagenes/solomillo-whisky-tapa-sevilla/1693555333923.jpg",
        "https://imag.bonviveur.com/croquetas-de-cocido-o-puchero.jpg",
        "https://www.gerardcoma.com/wp-content/uploads/2024/07/tortilla-de-patats.jpg"
    )

    // Usar un Box para centrar el LazyRow en la pantalla.
    Box(
        modifier = Modifier
            .fillMaxSize() // Llenar toda la pantalla.
            .padding(16.dp), // Margen alrededor del carrusel.
        contentAlignment = Alignment.Center // Centrar el contenido dentro del Box.
    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Iterar sobre la lista de imágenes.
            items(listaImagenes) { url ->
                AsyncImage(
                    model = url,
                    contentDescription = "Imagen del carrusel",
                    modifier = Modifier
                        .size(300.dp, 200.dp)
                        .clip(RoundedCornerShape(16.dp)) // Bordes redondeados.
                        .background(Color.LightGray), // Color de fondo mientras carga.
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

