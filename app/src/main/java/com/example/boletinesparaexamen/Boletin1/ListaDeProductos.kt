package com.example.boletines.Boletin1
//Objetivo: Crear una pantalla que muestre una lista de productos en una LazyColumn,
//cada uno con una imagen, un nombre y un precio.
//1. Define una data class Product con name, price y imageUrl.
//2. Usa LazyColumn para mostrar la lista de productos.
//3. Cada elemento de la lista debe mostrar una AsyncImage, un Text para el
//nombre y otro Text para el precio


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage


import java.net.URL

data class Producto(
    val nombre : String,
    val precio : Double,
    val imagen : String)

val listaProductos = listOf(
    Producto("Producto1", 10.0,"https://loremflickr.com/400/400/seville?lock=1"),
    Producto("Producto2", 20.0, "https://loremflickr.com/400/400/seville?lock=2"),
    Producto("Producto3", 30.0, "https://loremflickr.com/400/400/seville?lock=3")
)

@Composable
fun ListaProductosScreen(productos: List<Producto>) {
    LazyColumn {
        items(productos) { productos ->
            ProductoItem(productos)
        }
    }
}

@Composable
fun ProductoItem(producto: Producto) {
    Row(
        modifier = Modifier.fillMaxSize().padding(8.dp)


    ){

        AsyncImage(
            model= producto.imagen,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.width(150.dp)

        )
        Column (modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = producto.nombre,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 4.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "$${producto.precio}")
        }

    }
}
@Composable
fun MainScreen(){
    ListaProductosScreen(listaProductos)

}