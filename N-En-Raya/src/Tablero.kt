class Tablero (var n : Int ){

    val casillas :Array<Array<Casilla>> = Array(n) { Array(n) { Casilla(null) } }

    private var filas: Int = n
    private var columnas: Int = n

    private var minFila:Int = 0
    private var maxFila: Int = filas -1
    private var minColumnas: Int = 0
    private var maxColumnas: Int = columnas -1

    var ocupadas: Int = 0




}