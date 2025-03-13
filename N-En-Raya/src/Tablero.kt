import jdk.internal.vm.StackChunk.init
import java.util.*

class Tablero (var n : Int ){

    private lateinit var casillas: Array<Array<Casilla>>
    private var filas: Int = n
    private var columnas: Int = n

    private var minFila:Int = 0
    private var maxFila: Int = filas -1
    private var minColumnas: Int = 0
    private var maxColumnas: Int = columnas -1

    var ocupadas: Int = 0

    fun tablero (n : Int ) {
        filas = n
        columnas = n
        minFila = 0
        maxFila = filas -1
        minColumnas = 0
        maxColumnas = columnas -1

        ocupadas = 0



        fun inicializarTablero(){
            /* Inicializar el arreglo bidimensional de Casillas */
            casillas = Array(filas) { Array(columnas) { Casilla(
            ) } }
        }

        fun esFila(n: Int):Boolean{
            return (n >= minFila && n <= maxFila)
        }

        fun esColumna(n: Int):Boolean{
            return (n >= minColumnas && n <= maxColumnas)
        }

        fun esCoordenados(c : Coordenada):Boolean{
            var fila = c.fila
            var columna = c.columna

            return (n >= minFila && n <= maxFila)
                    && (columna>=minColumnas && columna<=maxColumnas);
        }

        fun leerCoordenadas() : Coordenada{
            val scanner = Scanner(System.`in`)
            var correcto = false
            var fila: Int
            var columna: Int

            // Leer Fila
            do {
                fila = scanner.nextInt()
                correcto= esFila(fila)
                if(!correcto){
                    println("Error: Fila incorrecta $fila")
                }
            }while(!correcto)

            // Leer Columa
            do {
                columna = scanner.nextInt()
                correcto= esColumna(columna)
                if(!correcto){
                    println("Error: Columna incorrecta $columna")
                }
            }while(!correcto)

            return Coordenada(fila, columna)

        }

        fun colocar (f : Ficha, c : Coordenada) :Boolean{
            if(!esCoordenados(c)){
                return false
            }

            var fila = c.fila
            var columna = c.columna

            val casilla = casillas[fila][c.fila]

            if(!casilla.estaVacia()) return false

            casillas[fila][columna].colocar(f)
        }



    }

}



