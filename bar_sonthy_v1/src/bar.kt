import java.io.*
import java.util.*

class bar {
    //valor de las variables
    var id = 0
        private set
    var descripcion: String? = null
        private set
    var precio = 0.0
        private set
    var cantidad = 0
        private set
    var FicheroProducto = File("productos.txt")
    var cositas = ArrayList<bar>()
    var objeto: bar? = null

    //zona de metodos
    constructor(id: Int, descripcion: String?, precio: Double, cantidad: Int) {
        this.id = id
        this.descripcion = descripcion
        this.precio = precio
        this.cantidad = cantidad
    }

    constructor() {}

    //Modificar variables
    fun setId(n: Int): Int {
        return n.also { id = it }
    }

    fun setDescripcion(n: String): String {
        return n.also { descripcion = it }
    }

    fun setPrecio(n: Double): Double {
        return n.also { precio = it }
    }

    fun setCantidad(n: Int): Int {
        return n.also { cantidad = it }
    }

    //Zona de metodos importantes
    fun comprobarBd() {
        try {
            //Varialble con la ruta donde esta el archivo de la bd de los productos  
            //File FicheroProducto= new File("./Bd/productos.txt");
            //crear el fichero de base de datos de productos   
            if (!FicheroProducto.exists()) {
                FicheroProducto.createNewFile()
                println("Base de datos de productos creada se insertara el producto")
            } else {
                println("La base de datos de productos existe")
            }
        } catch (ex: Exception) {
            //Captura un posible error le imprime en pantalla   
            println(ex.message)
        }
    }

    fun InsertarProductos(id: Int, descripcion: String?, precio: Double, cantidad: Int) {
        try {
            this.id = id
            this.descripcion = descripcion
            this.precio = precio
            this.cantidad = cantidad

            /*
             * Abro el flujo de escritura, sobre el fichero con codificacion utf8
             * con la clase BufferedWriter
             */
            val Fescribe =
                BufferedWriter(OutputStreamWriter(FileOutputStream(FicheroProducto, true), "utf-8"))
            /*Escribe en el fichero la cadena que recibe la función.
             *el string "\r\n" significa salto de linea  y el \t significa tabulacion  */Fescribe.write(
                """$id	$descripcion	$precio	$cantidad
"""
            )
            println("El producto a sido insertado en la base de datos") //Cierra el flujo de escritura  
            Fescribe.close()
        } catch (ex: Exception) {
            //Captura un posible error le imprime en pantalla   
            println(ex.message)
        }
    }

    fun DetxtAObjeto() {
        try {
            var linea: String? = null
            val leerFichero = BufferedReader(FileReader(FicheroProducto))
            while (leerFichero.readLine().also { linea = it } != null) {
                //este bucle es para meter todos los datos leidos de archivo de texto separlo en atributos y convertirlos a objeto para poder trabajar con el 
                //en esta parte le digo que lo separe en tokens pero ojo estos tokens son solo Strings tengo que convertirlos para poder emterlos en el objeto y trabajar con ellos
                val mistokens = StringTokenizer(linea, "\t")
                val id = mistokens.nextToken().trim { it <= ' ' }
                val descripcion = mistokens.nextToken().trim { it <= ' ' }
                val precio = mistokens.nextToken().trim { it <= ' ' }
                val cantidad = mistokens.nextToken().trim { it <= ' ' }

                //transformo los tipo de String a los tipos que hace falta int double 
                val idOperar = id.toInt()
                val preciOperar = precio.toDouble()
                val cantidadOperar = cantidad.toInt()


                //lo paso al constructor para que me cree los objetos
                objeto = bar(idOperar, descripcion, preciOperar, cantidadOperar)
                //lo añado al vecto para poder jugetear con el 
                cositas.add(objeto!!)
            }
            leerFichero.close()
        } catch (ex: Exception) {
            //Captura un posible error le imprime en pantalla   
            println(ex.message)
        }
    }

    fun ActualizarArraList() {
        //Este es el ArrayList declarado arriba 
        cositas.clear()
        DetxtAObjeto()
    }

    fun MostrarObjetos() {
        if (cositas.size == 0) {
            DetxtAObjeto()
        }
        println("=========================== Articulo=========================================================================================================================================================================================")
        for (n in cositas) {
            println("El id es:" + n.id + "\t" + "La descripcion es:" + n.descripcion + "\t" + "El precio es:" + n.precio + "\t" + "La cantaidad es:" + n.cantidad)
        }
        println("============================FIN==============================================================================================================================================================================================")
    }

    fun modificarFichero() {
        try {
            //lo primero es Buscar el dato si no como lo vas a modificar
            //lo segundo es mostrarlo por logica si no sabes lo que tienes como vas a modificarlo 
            //lo tercero es modificarlo para esto tienes que saber que dentro de este objeto tu quieres modificar un campo ahora hay que desplegar un switch case para saber que valor vas a modificar 
            //cuarto ya tienes el ArrayList, modficicalo,   
            if (cositas.size == 0) {
                DetxtAObjeto()
            }
            //PASO 1 Y 2 FUNCION DE BUSQUEDA Y MOSTRADO 
            val en = Scanner(System.`in`).useDelimiter("\n")
            //PASO 3 CREAR UN SWIRH CASE CON LAS OPCIONES A MODIFICAR
            //creo una variable para escanear lo que entra por teclado para asi poder modificar mas facilmente
            var opc = 10
            while (opc != 7) {
                menu()
                opc = en.nextInt()
                when (opc) {
                    1 -> {
                        println("Introducir el id del producto y la nueva id")

                        //n.getId()==idNumero

                        // String      cadena=en.next(); 
                        val idNumero = en.nextInt()
                        val numero = en.nextInt()
                        for (n in cositas) {
                            if (n.id == idNumero) {
                                n.id = numero
                                println("=========================== Articulo=========================================================================================================================================================================================")
                                println("El id es:" + n.id + "\t" + "La descripcion es:" + n.descripcion + "\t" + "El precio es:" + n.precio + "\t" + "La cantaidad es:" + n.cantidad)
                                println("============================FIN==============================================================================================================================================================================================")
                                break
                            } else {
                                println("el producto no ha sido encontrado")
                            }
                        }
                    }
                    2 -> {
                        println("Inserte la descripcion del producto y la  nueva descripcion del mismo")
                        val cadena = en.next()
                        val cadenaNueva = en.next()
                        for (n in cositas) {
                            if (n.descripcion == cadena) {
                                n.descripcion = cadenaNueva
                                println("=========================== Articulo=========================================================================================================================================================================================")
                                println("El id es:" + n.id + "\t" + "La descripcion es:" + n.descripcion + "\t" + "El precio es:" + n.precio + "\t" + "La cantaidad es:" + n.cantidad)
                                println("============================FIN==============================================================================================================================================================================================")
                                break
                            } else {
                                println("el producto no ha sido encontrado")
                            }
                        }
                    }
                    3 -> {
                        println("Inserte la descripcion del producto y el precio nuevo")
                        var cadena = en.next()
                        val precioNuevo = en.nextDouble()
                        for (n in cositas) {
                            if (n.descripcion == cadena) {
                                n.precio = precioNuevo
                                println("=========================== Articulo=========================================================================================================================================================================================")
                                println("El id es:" + n.id + "\t" + "La descripcion es:" + n.descripcion + "\t" + "El precio es:" + n.precio + "\t" + "La cantaidad es:" + n.cantidad)
                                println("============================FIN==============================================================================================================================================================================================")
                                break
                            } else {
                                println("el producto no ha sido encontrado")
                            }
                        }
                    }
                    4 -> {
                        println("Inserte la descripcion y la cantidad nueva ")
                        var cadena = en.next()
                        var numero = en.nextInt()
                        for (n in cositas) {
                            if (n.descripcion == cadena) {
                                n.cantidad = numero
                                println("=========================== Articulo=========================================================================================================================================================================================")
                                println("El id es:" + n.id + "\t" + "La descripcion es:" + n.descripcion + "\t" + "El precio es:" + n.precio + "\t" + "La cantaidad es:" + n.cantidad)
                                println("============================FIN==============================================================================================================================================================================================")
                                break
                            } else {
                                println("el producto no ha sido encontrado")
                            }
                        }
                    }
                    5 -> {
                        println("Guardar")
                        try {
                            val bw = BufferedWriter(FileWriter(FicheroProducto))
                            for (n in cositas) {
                                bw.write(
                                    """${n.id}	${n.descripcion}	${n.precio}	${n.cantidad}
"""
                                )
                            }
                            bw.close()
                        } catch (ex: Exception) {
                            //Captura un posible error le imprime en pantalla   
                            println(ex.message)
                        }
                    }
                    6 -> {
                        println("inserte el ID del producto que va borrar de la bd")
                        val v = en.nextInt()
                        try {
                            val bw = BufferedWriter(FileWriter(FicheroProducto))
                            for (n in cositas) {
                                if (n.id != v) {
                                    bw.write(
                                        """${n.id}	${n.descripcion}	${n.precio}	${n.cantidad}
"""
                                    )
                                } else {
                                    println("el producto ha sido eliminado")
                                }
                            }
                            bw.close()
                            cositas.clear()
                            DetxtAObjeto()
                        } catch (ex: Exception) {
                            //Captura un posible error le imprime en pantalla   
                            println(ex.message)
                        }
                    }
                }
            }
        } catch (ex: Exception) {
            //Captura un posible error le imprime en pantalla   
            println(ex.message)
        }
    }

    private fun menu() {
        println("--------Menu de modificaciones de productos -------")
        println("1. Modificar id")
        println("2. Modificar descripcion ")
        println("3. Modificar precio")
        println("4. Modificar cantidad")
        println("5. Guardar")
        println("6. Dar de bajar un proudcto existente")
        println("7. Salir")
    }

    //Main   
    fun main(args: Array<String?>?) {
        comprobarBd()
        InsertarProductos(3, "sandia", 1.56, 60000)
        MostrarObjetos()
        modificarFichero()
    }
}