import java.io.File

class ingredientes (
    var nombre_ingre:String,
    var tipo_ingre:String,
    var refrigeracion:Boolean,
    var coctel:String
){
    override fun toString(): String {
        return "Ingrediente(Nombre='$nombre_ingre', " +
                "Tipo de Ingrediente=$tipo_ingre, " +
                "Refrigeracion=$refrigeracion, " +
                "Coctel='$coctel')"
    }
}

fun guardarIngredientesEnArchivo(ingredientes : ArrayList<ingredientes>){
    var aux:String=""
    for (i in ingredientes) {
        aux += i.nombre_ingre+"--"+i.tipo_ingre+"--"+i.refrigeracion+"--"+i.coctel+"\n"
    }
    File("ingredientes.txt").writeText(aux)
}
fun leerIngredientesDeArchivo(ingredientes : ArrayList<ingredientes>){
    File("ingredientes.txt").forEachLine {
        var datos = it.split("--")
        ingredientes.add(ingredientes(datos[0],datos[1],datos[2]!!.toBoolean(),datos[3]))
    }
}

fun addIngredientes(cocteles : ArrayList<cocteles>, ingredientes : ArrayList<ingredientes>){
    print("Ingredientes del coctel -> ")
    val coctel = readLine().toString()
    val aux = cocteles.find {
            it : cocteles ->
        it.nombre_coctel==coctel
    }
    if(aux != null){
        print("Ingresar el nombre del Ingrediente: ")
        val nombre = readLine().toString()
        print("Ingresar el tipo de Ingrediente ")
        val tipo = readLine().toString()
        print("Necesita Refrigeracion (true/false) ")
        val caducidad = readLine().toString().toBoolean()
        ingredientes.add( ingredientes(nombre,tipo,caducidad,coctel))
    }else{
        println("Revise la list de cocteles")
    }
}

fun mostrarIngredientes(ingredientes : ArrayList<ingredientes>) {
    println("Ingrese el nombre del Coctel para ver su receta: ")
    val coctel = readLine().toString()
    if (coctel == "") {
        for (i in ingredientes) {
            println(i)
        }
    } else {
        val ingredientes = ingredientes.filter { iteracion: ingredientes ->
            iteracion.coctel == coctel
        }
        for (i in ingredientes) {
            println(i)
        }
    }
}
fun actualizarIngredientes(cocteles : ArrayList<cocteles>, ingredientes : ArrayList<ingredientes>){
    print("Ingresen el nombre del ingrediente a actualizar: ")
    var nombre = readLine().toString()
    var ingrediente=ingredientes.removeIf {
            iteracion : ingredientes ->
        iteracion.nombre_ingre==nombre
    }
    if(ingrediente){
        addIngredientes(cocteles,ingredientes)
    }else{
        println("Revise la lista de Ingredientes")
    }
}
fun eliminarIngredientes(ingredientes : ArrayList<ingredientes>){
    print("Ingresen el nombre del ingrediente a Eliminar: ")
    val nombre = readLine().toString()
    val resultado=ingredientes.removeIf {
            iteracion : ingredientes ->
        iteracion.nombre_ingre==nombre
    }
    if (!resultado) println("No existe el Ingrediente")
}

fun eliminarComp(nomCoctel: String, ingredientes: ArrayList<ingredientes>){
    ingredientes.removeIf {
            iteracion : ingredientes ->
        iteracion.coctel==nomCoctel }
}