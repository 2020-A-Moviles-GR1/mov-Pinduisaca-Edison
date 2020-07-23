import java.io.File
import javax.swing.JOptionPane

class cocteles(
    var nombre_coctel:String,
    var concentracion:String,
    var precio:Double,
    var presentacion:String
){
    override fun toString(): String {
        return "Coctel(Nombre='$nombre_coctel', Concentracion='$concentracion', Precio='$precio', Presentacion=$presentacion )"
    }
}
fun addcoctel(cocteles : ArrayList<cocteles>){
    print("Ingresar el nombre del coctel: ")
    val nombre_coctel = readLine().toString()
    print("Ingresar concentracion (Fuerte/Medio/Suave) ")
    val concentracion = readLine().toString()
    print("Ingresar el precio: ")
    val precio = readLine().toString().toDouble()
    print("Ingresar el tipo de copa (copa coctel windsor/vaso grande/vaso pequenio/shot) ")
    val presentacion = readLine().toString()
    cocteles.add( cocteles(nombre_coctel,concentracion,precio,presentacion))
}

fun eliminarCoctel(cocteles : ArrayList<cocteles>, ingredientes: ArrayList<ingredientes>){
    print("Ingresar nombre del Coctel a Eliminar: ")
    var nombre = readLine().toString()
    var eliminar_coctel=cocteles.removeIf {
            iteracion : cocteles ->
        iteracion.nombre_coctel==nombre
    }
    if(eliminar_coctel){
        eliminarComp(nombre,ingredientes)
    }else{
        print("Revisar la lista de cocteles")
    }
}

fun listaCocteles(cocteles : ArrayList<cocteles>){
    for (i in cocteles) {
        println(i)
    }
}
fun actualizarCoctel(cocteles : ArrayList<cocteles>){
    print("Ingresar el nombre del Coctel que desea actualizar: ")
    val nombre = readLine().toString()
    val actualizarCoctel = cocteles.removeIf {
            iteracion : cocteles ->
        iteracion.nombre_coctel==nombre
    }
    if(actualizarCoctel){
        print("Ingresar concentracion (Fuerte/Medio/Suave)")
        val concentracion = readLine().toString()
        print("Ingresar el precio: ")
        val precio = readLine().toString().toDouble()
        print("Ingresar el tipo de copa (copa coctel windsor/vaso grande/vaso pequenio/shot)")
        val presentacion = readLine().toString()
        cocteles.add( cocteles(nombre,concentracion,precio,presentacion))
    }else{
        println("Revisar la lista de cocteles")
    }
}

fun guardaCoctelesEnArchivo(cocteles : ArrayList<cocteles>){
    var aux:String=""
    for (i in cocteles) {
        aux += i.nombre_coctel+"--"+i.concentracion+"--"+i.precio+"--"+i.presentacion+"--"+"\n"
    }
    File("cocteles.txt").writeText(aux)
}
fun leerCoctelesDeArchivo(cocteles : ArrayList<cocteles>){
    File("cocteles.txt").forEachLine {
        var datos = it.split("--")
        cocteles.add(cocteles(datos[0],datos[1],datos[2].toDouble(),datos[3]))
    }
}