import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ListaDeTareas() {
    // Definir el estado de la lista de tareas
    val tareas = remember { mutableStateOf(listOf<String>()) }
    val nuevaTarea = remember { mutableStateOf("") }

    // Pasar el estado y las funciones a los componentes hijos
    Column(
        modifier = Modifier.fillMaxSize(), // Esto hace que ocupe todo el tamaño de la pantalla
        horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center // Centra verticalmente
    ) {
        AgregarTarea(nuevaTarea, tareas)
        MostrarTareas(tareas.value, tareas)
    }
}

@Composable
fun AgregarTarea(nuevaTarea: androidx.compose.runtime.MutableState<String>, tareas: androidx.compose.runtime.MutableState<List<String>>) {
    // Componente hijo para agregar tarea
    Column {
        TextField(
            value = nuevaTarea.value,
            onValueChange = { nuevaTarea.value = it },
            label = { Text("Nueva tarea") }
        )
        Button(onClick = { agregarTarea(nuevaTarea, tareas) }) {
            Text("Agregar Tarea")
        }
    }
}

fun agregarTarea(nuevaTarea: androidx.compose.runtime.MutableState<String>, tareas: androidx.compose.runtime.MutableState<List<String>>) {
    if (nuevaTarea.value.isNotBlank()) {
        tareas.value = tareas.value + nuevaTarea.value
        nuevaTarea.value = ""
    }
}

@Composable
fun MostrarTareas(tareas: List<String>, tareasState: androidx.compose.runtime.MutableState<List<String>>) {
    // Componente hijo para mostrar y eliminar tareas
    Column {
        for (tarea in tareas) {
            Column {
                Text(text = tarea)
                Button(onClick = { eliminarTarea(tarea, tareasState) }) {
                    Text("Eliminar")
                }
            }
        }
    }
}

fun eliminarTarea(tarea: String, tareasState: androidx.compose.runtime.MutableState<List<String>>) {
    tareasState.value = tareasState.value.filter { it != tarea }
}