import java.util.*

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