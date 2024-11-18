package com.example.boletinesparaexamen.Boletin0

fun multiplica(a : Int, b: Int){
    println("La multiplicacion de $a y $b es ${a * b}")
}

fun esPar(a: Int): Boolean {
    if(a % 2 == 0){
        return true
    } else {
        return false
    }
}

fun main (){
    print(multiplica(5, 7))
    print(esPar(8))
}