package com.example.boletinesparaexamen

import ListaDeTareas
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.boletines.Boletin1.MainScreen
import com.example.boletinesparaexamen.Boletin1.CarruselDeImagenes
import com.example.boletinesparaexamen.Boletin1.CuadrículaDeCategorias
import com.example.boletinesparaexamen.Boletin1.PantallaDeLogin
import com.example.boletinesparaexamen.Boletin1.PantallaDeRegistro
import com.example.boletinesparaexamen.Boletin1.PerfilDeUsuario
import com.example.boletinesparaexamen.Boletin2.ContadorConElevacionDeEstado
import com.example.boletinesparaexamen.Boletin3.ControlDeLuzInteligente
import com.example.boletinesparaexamen.Boletin3.EncuestaInteractiva
import com.example.boletinesparaexamen.Boletin3.FormularioRegistro
import com.example.boletinesparaexamen.Boletin3.ListaDeTareasConSecciones
import com.example.boletinesparaexamen.Boletin3.PantallaDeProgresoDeTarea
import com.example.boletinesparaexamen.Navegacion.MyApp
import com.example.boletinesparaexamen.ui.theme.BoletinesParaExamenTheme
import com.example.colorselectorapp.SelecColorConElevacionEstado

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            CarruselDeImagenes()
            //CuadrículaDeCategorias()
            //PerfilDeUsuario()
            //PantallaDeLogin()
            //PantallaDeRegistro()

            //ContadorConElevacionDeEstado()
            //ListaDeTareas()
            //SelecColorConElevacionEstado()

            //FormularioRegistro()
            //PantallaDeProgresoDeTarea()
            //ListaDeTareasConSecciones()
            //EncuestaInteractiva()
            //ControlDeLuzInteligente()

            //MyApp()

        }
    }
}
