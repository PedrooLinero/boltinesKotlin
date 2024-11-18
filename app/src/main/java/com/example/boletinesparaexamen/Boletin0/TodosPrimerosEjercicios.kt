package com.example.boletinesparaexamen.Boletin0

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// ACTIVIDAD 1
/*fun multiplica(a: Int, b: Int): Int {
    return a * b
}

// ACTIVIDAD 2
fun esPar(a: Int): Boolean = a % 2 == 0


// ACTIVIDAD 5
class coche(val marca: String, val modelo: String)

// ACTIVIDAD 6
class Persona (val nombre: String, val edad: Int){
    init {
        println("Persona creada: Se llama $nombre y tiene $edad años")
    }
}

// ACTIVIDAD 7
data class producto(val nombre: String, var precio: Int)

// ACTIVIDAD 8
enum class diaSemana{LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO}

fun main() {
    val numero1 = 5
    val numero2 = 10
    val resultado = multiplica(numero1, numero2)
    println("El resultado de multiplicar $numero1 por $numero2 es: $resultado")

    println("*******************************************************************")

    val numero = 86
    val res = esPar(numero)
    println("El numero $numero es $res")

    println("*******************************************************************")


    // ACTIVIDAD 3
    val nombre = "Pedro" // val es inmutable
    var edad = 18 // var es mutable

    println("Mi nombre es $nombre y tengo $edad años")

    edad = 20 // cambio la edad de 18 a 20

    println("Mi nombre es $nombre y tengo $edad años")

    println("*******************************************************************")

    // ACTIVIDAD 4

    val numDouble = 9.99
    val numInt = numDouble.toInt()
    println("$numInt")


    println("*******************************************************************")

    val miCoche = coche("Nissan", "Qashqai")
    println("Mi coche es un ${miCoche.marca} ${miCoche.modelo}")

    println("*******************************************************************")

    val pers = Persona("Pepe", 25)
    println("${pers.nombre} y ${pers.edad}")

    println("*******************************************************************")

    val productoOriginal = producto("cuaderno", 2)
    val productoModificado = productoOriginal.copy("televisor", 250)
    println("${productoOriginal.nombre} y ${productoOriginal.precio}")
    println("${productoModificado.nombre} y ${productoModificado.precio}")

    println("*******************************************************************")

    val dia = diaSemana.LUNES
    when (dia) {
        diaSemana.LUNES -> println("¡Es lunes! Comienza la semana.")
        diaSemana.MARTES -> println("¡Es martes! Vamos a seguir trabajando.")
        diaSemana.MIERCOLES -> println("¡Es miércoles! Estamos a mitad de semana.")
        diaSemana.JUEVES -> println("¡Es jueves! Casi es fin de semana.")
        diaSemana.VIERNES -> println("¡Es viernes! ¡El fin de semana está cerca!")
        diaSemana.SABADO -> println("¡Es sábado! Disfruta del día libre.")
        diaSemana.DOMINGO -> println("¡Es domingo! Prepárate para la semana.")
    }

    println("*******************************************************************")

    // ACTIVIDAD 9
    val edades : Int = 20
    when {
        edades < 18 -> println("Eres menor de edad")
        edades in 18..70 -> println("Eres un adulto")
        edades > 70 -> println("Eres de edad anciana")
        else -> println("Edad no valida")
    }

    println("*******************************************************************")

    // ACTIVIDAD 10
    var lista = listOf(1,2,3,4,5,6,7,8,9)
    for(numero in lista){
        println(numero)
    }

    println("*******************************************************************")

}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimerosEjerciciosTheme {
        Greeting("Android")
    }
}


// EJERCICIO 1 ESTADOS
@Composable
fun ejercicio1Estados() {
    // Usamos rememberSaveable para mantener el estado del contador
    var count by rememberSaveable { mutableStateOf(0)  }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = count.toString(), // Convertimos el contador a String
            onValueChange = { },
            enabled = false, // Hacemos que el TextField sea solo lectura
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Contador: $count", modifier = Modifier.padding(16.dp))

        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { count++ }) {
                Text("Incrementar")
            }
            Button(onClick = { count-- }) {
                Text("Decrementar")
            }
        }
    }
}

// EJERCICIO 2 ESTADOS
@Composable
fun ejercicio2Estados() {
    // Define el estado de la lista de tareas
    var tasks by rememberSaveable { mutableStateOf(mutableListOf<String>()) }
    var newTask by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = newTask,
            onValueChange = { newTask = it },
            placeholder = { Text("Agregar nueva tarea") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (newTask.isNotBlank()) {
                    tasks.add(newTask)
                    newTask = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Agregar Tarea")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Componente hijo que muestra la lista de tareas
        TaskList(
            tasks = tasks,
            onRemoveTask = { task -> tasks.remove(task) }
        )
    }
}

@Composable
fun TaskList(tasks: List<String>, onRemoveTask: (String) -> Unit) {
    Column {
        for (task in tasks) {
            // Componente hijo que muestra cada tarea
            TaskItem(task = task, onRemoveTask = onRemoveTask)
        }
    }
}

@Composable
fun TaskItem(task: String, onRemoveTask: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = task)
        Button(onClick = { onRemoveTask(task) }) {
            Text("Eliminar")
        }
    }
}

// EJERCICIO 3 ESTADOS
/*@Composable
fun ColorSelectorApp() {
    // Define el estado del color seleccionado
    var selectedColor by remember { mutableStateOf(android.graphics.Color().Transparent) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Muestra el color seleccionado
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(selectedColor)
                .border(BorderStroke(2.dp, Color.Black)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Seleccionado", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Componente hijo que muestra la lista de colores
        ColorList(
            colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan),
            onColorSelected = { color -> selectedColor = color }
        )
    }
}

@Composable
fun ColorList(colors: List<Color>, onColorSelected: (Color) -> Unit) {
    Column {
        for (color in colors) {
            ColorItem(color = color, onColorSelected = onColorSelected)
        }
    }
}

@Composable
fun ColorItem(color: Color, onColorSelected: (Color) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color)
            .clickable { onColorSelected(color) },
        contentAlignment = Alignment.Center
    ) {
        Text(text = color.toString(), color = Color.White)
    }
}
*/