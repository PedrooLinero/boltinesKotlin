package com.example.boletinesparaexamen.Navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable



@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Registro"){
        composable("Registro"){
            FrmLogin  {
                navController.navigate("Home")
            }
        }
        composable("Home"){
            PantallaDeInicio{
                navController.navigate("FrmLogin")
            }

        }


    }
}

