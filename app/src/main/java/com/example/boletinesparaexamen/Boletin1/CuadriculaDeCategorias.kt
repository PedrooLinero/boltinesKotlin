package com.example.boletinesparaexamen.Boletin1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter

// 1. Data class para las categorías
data class Category(
    val name: String,
    val imageUrl: String
)

@Composable
fun CuadrículaDeCategorias() {
    // Lista de categorías con nombres e imágenes.
    val categories = listOf(
        Category("Tecnología", "https://via.placeholder.com/150/FF0000/FFFFFF?text=Tech"),
        Category("Ropa", "https://via.placeholder.com/150/00FF00/FFFFFF?text=Fashion"),
        Category("Hogar", "https://via.placeholder.com/150/0000FF/FFFFFF?text=Home"),
        Category("Deportes", "https://via.placeholder.com/150/FFFF00/FFFFFF?text=Sports"),
        Category("Libros", "https://via.placeholder.com/150/FF00FF/FFFFFF?text=Books"),
        Category("Electrónica", "https://via.placeholder.com/150/00FFFF/FFFFFF?text=Electronics"),
    )

    // 2. Usar LazyVerticalGrid para la cuadrícula
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 columnas fijas
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Margen alrededor de la cuadrícula
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 3. Iterar sobre la lista de categorías
        items(categories) { category ->
            CategoriaItem(category)
        }
    }
}

@Composable
fun CategoriaItem(category: Category) {
    // Diseño de cada elemento de la cuadrícula
    Column(
        modifier = Modifier
            .background(Color.LightGray, RoundedCornerShape(16.dp)) // Fondo con bordes redondeados
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen de la categoría
        AsyncImage(
            model = category.imageUrl,
            contentDescription = category.name,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(12.dp)) // Bordes redondeados para la imagen
                .background(Color.White),
            placeholder = rememberAsyncImagePainter("https://via.placeholder.com/100x100.png?text=Loading"),
            error = rememberAsyncImagePainter("https://via.placeholder.com/100x100.png?text=Error")
        )

        Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre imagen y texto

        // Nombre de la categoría
        Text(
            text = category.name,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}
