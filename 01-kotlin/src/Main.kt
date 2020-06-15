import java.util.*
import java.util.function.Consumer

fun main (args:Array<String>){
    print ("Hola")
    //Ejemplo Java
    //Int edad = 31;

    //variables mutables
    var edadProfesor = 31

    //sin instancia,  se debe poner el tipo de dato.
    var edadCachorro:Int
    edadCachorro = 3


    //Variables inmutables(no se pueden reasignar)
    val numCuenta = 123456
    
    //Tipos de Variables
    val nombreProfesor = "Vicente Adrian"
    val sueldo = 12.20
    val apellidoProfesor = 'a'
    val fechaDeNacimiento = Date()
    
    when (sueldo){
        12.20 -> print ("Sueldo Normal")
        -12.20 -> print("Sueldo negativo")
        else -> println("No se reconoce el Sueldo")
    }
    val esSueldoMayorAlEstablecido = if (sueldo==12.20) true else false
    //Expresion ? X : Y
    // calcularSueldo(14.00, 1000.00)
    calcularSueldo(14.00 , 1000.00)

    val arregloConstante: Array<Int> = arrayOf(1,2,3)
    val arregloCumpleanios: ArrayList<Int> = arrayListOf(30,32,31,20,27,21)
    print(arregloCumpleanios)
    arregloCumpleanios.add(24)
    println(arregloCumpleanios)
    //arregloCumpleanios.remove(30)
    arregloCumpleanios.remove(30)
    println(arregloCumpleanios)


    arregloCumpleanios
        .forEach {
            println("Valor de la iteracion" + it)
    }
    arregloCumpleanios
        .forEach { valorIteracion : Int ->
            println("Valor Iteracion: " + valorIteracion)
        }
    arregloCumpleanios
        .forEach(
            { valorIteracion: Int ->
                println("Valor Iteracion: " + valorIteracion)
            }
        )
    //Map
    val respuestaMap = arregloCumpleanios
        .map { iterador: Int ->
            iterador * -1
        }
    val respuestaMapDos= arregloCumpleanios
        .map { iterador: Int ->
            val nuevoValor = iterador * -1
            val otroValor = nuevoValor * 2
            return@map otroValor
        }
    println(respuestaMap)
    println(respuestaMapDos)
    println(arregloCumpleanios)

    //Filter
    //1. Devolver una expresion (true / false)
    //2. Nuevo arreglo que cumpla la expresion

    val respuestaFilter = arregloCumpleanios
        .filter {
                iteracion:Int ->
            val esMayorA23 = iteracion > 23
            return@filter esMayorA23
        }
    arregloCumpleanios
        .filter {
                iteracion:Int -> iteracion > 23
        }
    println(respuestaFilter)
    println(arregloCumpleanios)
}


fun calcularSueldo(
        tasa: Double = 12.00,    //Tiene valor por defecto
        sueldo: Double,          //Requeridos!
        calculoEspecial: Int? = null//Pueden ser nulos
): Double {
    if (calculoEspecial != null){
        return sueldo * tasa * calculoEspecial
    } else {
        return sueldo * tasa
    }

}

fun imprimirMensaje(): Unit { //Unit  = Void
    print("")
}