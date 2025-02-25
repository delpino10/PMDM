class Urna(capacidad: Int) {
    companion object {
        private const val MINCAPACIDAD = 1
    }

    private val bolas: Array<Bola?> // <<R>>

    init {
        require(capacidad >= MINCAPACIDAD) {
            "La capacidad de una urna debe ser >=$MINCAPACIDAD (capacidad=$capacidad)"
        }
        bolas = arrayOfNulls(capacidad)
    }

    // Accesores
    val capacidad: Int
        get() = bolas.size

    // Otros métodos
    fun agregar() {
        agregar(Bola.generar())
    }

    fun agregar(bola: Bola) {
        requireNotNull(bola) { "La bola a agregar a la urna no puede ser nula" }
        require(!estaLlena()) {
            "No es posible agregar la bola $bola porque la urna está llena"
        }

        for (i in bolas.indices) {
            if (bolas[i] == null) {
                bolas[i] = bola
                return
            }
        }

        println("El programa no debe llegar a ejecutar esta línea")
        System.exit(1)
    }

    fun agregar(color: Color) {
        agregar(Bola(color))
    }

    fun estaLlena(): Boolean {
        return numBolas() == capacidad
    }

    fun estaVacia(): Boolean {
        return numBolas() == 0
    }

    fun llenar() {
        while (!estaLlena()) agregar()
    }

    fun numBolas(): Int {
        var contador = 0
        for (bola in bolas) {
            if (bola != null) contador++
        }
        return contador
    }

    // Saca una bola de la posición indicada
    private fun sacar(pos: Int): Bola {
        require(pos in 0 until capacidad) {
            "La posición no existe (pos=$pos) pos [0,$capacidad-1]"
        }
        requireNotNull(bolas[pos]) { "No es posible sacar una bola porque no existe bola en la posición $pos" }

        val aux = bolas[pos]
        bolas[pos] = null
        return aux!!
    }

    fun sacar(): Bola {
        require(!estaVacia()) { "No es posible sacar una bola porque la urna está vacía" }

        // Creamos un array con las posiciones donde están las bolas
        val n = numBolas()
        val posiciones = IntArray(n)
        var j = 0
        for (i in bolas.indices) {
            if (bolas[i] != null) {
                posiciones[j++] = i
            }
        }
        // Elegimos aleatoriamente una posición del array de bolas original
        val pos = posiciones[(Math.random() * n).toInt()]

        // Sacamos la bola que esté en la posición obtenida aleatoriamente
        return sacar(pos)
    }

    fun sacar(color: Color): Bola? {
        requireNotNull(color) { "El color de la bola a sacar no puede ser nulo" }
        require(!estaVacia()) { "No es posible sacar una bola porque la urna está vacía" }

        for (i in bolas.indices) {
            if (bolas[i]?.getColor() == color) return sacar(i)
        }
        return null
    }

    fun vaciar() {
        for (i in bolas.indices) {
            bolas[i] = null
        }
    }

    override fun toString(): String {
        val aux = StringBuilder()
        aux.append("|")
        for (i in bolas.indices) {
            aux.append(bolas[i]?.toString() ?: " ")
            aux.append("|")
        }
        aux.append(" ${numBolas()}/$capacidad")
        if (estaVacia()) aux.append(" VACÍA")
        if (estaLlena()) aux.append(" LLENA")

        return aux.toString()
    }
}
