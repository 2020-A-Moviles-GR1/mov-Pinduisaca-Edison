import kotlin.collections.ArrayList

fun main(args:Array<String>) {
   val cocteles = ArrayList<cocteles>()
   val ingredientes = ArrayList<ingredientes>()
   leerCoctelesDeArchivo(cocteles)
   leerIngredientesDeArchivo(ingredientes)
   while (true)
      menuPrincipal(cocteles,ingredientes)
}

fun menuPrincipal(cocteles : ArrayList<cocteles>, ingredientes : ArrayList<ingredientes>){
   var aux:String
   aux="-        BAR SONTHY\n"
   aux+="1. Ingresar un Coctel\n"
   aux+="2. Mostrar cocteles registrados\n"
   aux+="3. Modificar una coctel\n"
   aux+="4. Eliminar una coctel\n"
   aux+="5. Menu de ingredientes\n"
   aux+="6. Salir\n"
   print(aux)
   var opcion:Int
   opcion = readLine().toString()!!.toInt()
   when(opcion){
      1-> addcoctel(cocteles)
      2-> listaCocteles(cocteles)
      3-> actualizarCoctel(cocteles)
      4-> eliminarCoctel(cocteles,ingredientes)
      5-> {while (menuIngredientes(cocteles, ingredientes)){ }}
      6-> {
         guardaCoctelesEnArchivo(cocteles)
         guardarIngredientesEnArchivo(ingredientes)
         System.exit(0)
      }
   }
}
fun menuIngredientes(cocteles : ArrayList<cocteles>, ingredientes : ArrayList<ingredientes>) : Boolean{
   var estado=true
   var aux:String
  aux="-       Menu de Ingredientes\n"
  aux+="1. Ingresar nuevo Ingrediente\n"
  aux+="2. Ingredientes disponibles\n"
  aux+="3. Editar un ingrediente\n"
  aux+="4. Eliminar un Ingrediente\n"
  aux+="5. Regresar al Menu de cocteles\n"
   print(aux)
   var opcion:Int
   opcion = readLine().toString()!!.toInt()
   when(opcion){
      1-> addIngredientes(cocteles,ingredientes)
      2-> mostrarIngredientes(ingredientes)
      3-> actualizarIngredientes(cocteles,ingredientes)
      4-> eliminarIngredientes(ingredientes)
      5-> estado= false
   }
   return estado
}