import java.io.File
import kotlin.collections.ArrayList

fun main(args:Array<String>) {
   val cocteles = ArrayList<cocteles>()
   val ingredientes = ArrayList<ingredientes>()
   leerCoctelesDeArchivo(cocteles)
   leerIngredientesDeArchivo(ingredientes)
   while (true)
      menuPrincipal(cocteles,ingredientes)
}

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
class ingredientes(
   var nombre_ingre:String,
   var tipo_ingre:String,
   var refrigeracion:Boolean,
   var caducidad:String
){
   override fun toString(): String {
      return "Ingrediente(Nombre='$nombre_ingre', Tipo de Ingrediente=$tipo_ingre, Refrigeracion=$refrigeracion, Fecha de caducidad='$caducidad')"
   }
}

fun agregarCoctel(cocteles : ArrayList<cocteles>){
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

fun guardarIngredientesEnArchivo(ingredientes : ArrayList<ingredientes>){
   var aux:String=""
   for (i in ingredientes) {
      aux += i.nombre_ingre+"--"+i.tipo_ingre+"--"+i.refrigeracion+"--"+i.caducidad+"\n"
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
   print("Ingresar el nuevo Ingrediente: ")
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

fun mostrarModelos(ingredientes : ArrayList<ingredientes>){
   println("Ingrese el nombre de la Coctel o para mostrar todos lo Ingredientes: ")
   val coctel = readLine().toString()
   if(coctel==""){
      for (i in ingredientes) {
         println(i)
      }
   }else{
      val ingredientes = ingredientes.filter {
            iteracion : ingredientes ->
            iteracion.caducidad==coctel
      }
      for (i in ingredientes) {
         println(i)
      }
   }
}
fun actualizarRecetaCocteles(cocteles : ArrayList<cocteles>, ingredientes : ArrayList<ingredientes>){
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
         iteracion.caducidad==nomCoctel }
}

fun menuPrincipal(cocteles : ArrayList<cocteles>, ingredientes : ArrayList<ingredientes>){
   var texto:String
   texto="-          Menu Principal        "+"\n"
   texto+="1. Ingresar un Coctel        "+"\n"
   texto+="2. Mostrar las cocteles registradas  "+"\n"
   texto+="3. Modificar una coctel             "+"\n"
   texto+="4. Eliminar una coctel              "+"\n"
   texto+="5. Menu de ingredientes              "+"\n"
   texto+="6. Salir                           "+"\n"
   texto+="--------------------------------------"+"\n"
   println(texto)
   var opcion:Int
   while(true){
      try {
         opcion = readLine().toString()!!.toInt()
         if(opcion>6 || opcion<1){
            print("ingrese un valor correcto")
         }else{
            break
         }
      }catch (e: NumberFormatException){
         print("Ingrese un valor valido")
      }
   }
   when(opcion){
      1-> agregarCoctel(cocteles)
      2-> listaCocteles(cocteles)
      3-> actualizarCoctel(cocteles)
      4-> eliminarCoctel(cocteles,ingredientes)
      5-> {
         while (menuModelos(cocteles, ingredientes)){ }
      }
      6-> {
         guardaCoctelesEnArchivo(cocteles)
         guardarIngredientesEnArchivo(ingredientes)
         System.exit(0)
      }
   }
}
fun menuModelos(cocteles : ArrayList<cocteles>, ingredientes : ArrayList<ingredientes>) : Boolean{
   var estado=true
   var texto:String
  texto="-       Menu de Ingredientes        "+"\n"
   texto+="1. Ingresar una nueva Ingredi     "+"\n"
   texto+="2. Mostrar las Ingred registradas "+"\n"
   texto+="3. Modificar una ingredi           "+"\n"
   texto+="4. Eliminar una Ingred             "+"\n"
   texto+="5. Menu Ccoctels                  "+"\n"
   println(texto)
   var opcion:Int
   while(true){
      try {
         opcion = readLine().toString()!!.toInt()
         if(opcion>5 || opcion<1){
            print("ingrese un valor correcto")
         }else{
            break
         }
      }catch (e: NumberFormatException){
         print("Ingrese un valor valido")
      }
   }
   when(opcion){
      1-> addIngredientes(cocteles,ingredientes)
      2-> mostrarModelos(ingredientes)
      3-> actualizarRecetaCocteles(cocteles,ingredientes)
      4-> eliminarIngredientes(ingredientes)
      5-> estado= false
   }
   return estado
}