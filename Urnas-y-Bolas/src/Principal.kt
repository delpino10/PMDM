import org.fusesource.jansi.AnsiConsole

class Principal {
    companion object {
        private const val LINEA1 = "-".repeat(50)
    }

//    fun main() {
//        // version0p1()
//        // version0p2()
//        // version0p3()
//        version0p4()
//    }

    private fun mostrarUrnas(u1: Urna, u2: Urna, u3: Urna) {
        println("Urnas\nUrna 1 $u1\nUrna 2 $u2\nUrna 3 $u3")
        println(LINEA1)
    }

    private fun version0p1() {
        // Creación de 4 bolas de 2 formas distintas
        val bola1 = Bola(Color.AZUL)
        val bola2 = Bola.generar()
        val bola3 = Bola(Color.VERDE)
        val bola4 = Bola.generar()
        println("Bolas\n$bola1\n$bola2\n$bola3\n$bola4")
        println(LINEA1)

        // Creación de 3 urnas
        val u1 = Urna(3)
        val u2 = Urna(5)
        val u3 = Urna(7)
        println("Urnas\n$u1\n$u2\n$u3")
        println(LINEA1)

        // Agrego 3 bolas a la primera urna
        u1.agregar(bola1)
        u1.agregar(bola2)
        u1.agregar(bola3)
        println("Urnas\n$u1\n$u2\n$u3")
        println(LINEA1)

        // Muevo una bola de color AZUL de la primera a la segunda urna
        u2.agregar(u1.sacar(Color.AZUL))
        println("Urnas\n$u1\n$u2\n$u3")
        println(LINEA1)

        // Lleno la tercera urna
        u3.llenar()
        println("Urnas\n$u1\n$u2\n$u3")
        println(LINEA1)

        // Saco una bola aleatoriamente de la urna 3
        val sacada = u3.sacar()
        println("Bola sacada de la urna 3=$sacada")
        println("Urnas\n$u1\n$u2\n$u3")
        println(LINEA1)
    }

    private fun version0p2() {
        // Creación de 4 bolas de 2 formas distintas
        val bola1 = Bola(Color.AZUL)
        val bola2 = Bola.generar()
        val bola3 = Bola(Color.VERDE)
        val bola4 = Bola.generar()
        println("Bolas\n$bola1\n$bola2\n$bola3\n$bola4")
        println(LINEA1)

        // Creación de 3 urnas
        val u1 = Urna(3)
        val u2 = Urna(5)
        val u3 = Urna(7)
        mostrarUrnas(u1, u2, u3)

        // Agrego 3 bolas a la primera urna y 2 a la segunda urna (5 formas distintas)
        u1.agregar()
        u1.agregar(Color.AZUL)
        u1.agregar(bola1)
        u2.agregar(Bola.generar())
        u2.agregar(Bola(Color.AMARILLO))
        mostrarUrnas(u1, u2, u3)

        // Mostrar el número de una bola
        println("La primera bola creada es la numero ${bola1.numero}")

        // Mover una bola de color AZUL de la primera a la segunda urna
        u2.agregar(u1.sacar(Color.AZUL))
        mostrarUrnas(u1, u2, u3)

        // Llenar la tercer urna
        u3.llenar()
        println("He llenado la tercera urna")
        mostrarUrnas(u1, u2, u3)

        // Sacamos una bola aleatoriamente de la urna 3
        val sacada = u3.sacar()
        println("Hemos sacado una bola aleatoriamente (bola=$sacada) de la urna 3")
        mostrarUrnas(u1, u2, u3)

        // Mostramos el número de bolas de la urna 3
        val n = u3.numBolas()
        println("La urna 3 tiene $n bola${if (n == 1) "" else "s"}")
        mostrarUrnas(u1, u2, u3)

        // Mostrar el número total de bolas contenidas en las 3 urnas
        println("Número total de bolas en las 3 urnas=${u1.numBolas() + u2.numBolas() + u3.numBolas()}")

        // Mostrar el número total de bolas creadas
        println("Número total de bolas creadas=${Bola.totalBolas()}")
    }

    private fun version0p3() {
        // Creación de 3 urnas
        val u1 = Urna(3)
        val u2 = Urna(3)
        val u3 = Urna(3)
        mostrarUrnas(u1, u2, u3)

        // Agregar 3 bolas usando for
        println("Agrego 3 bolas a la urna 1 (for)")
        agregarBolasFor(u1, 3)
        mostrarUrnas(u1, u2, u3)

        // Agregar 3 bolas usando while
        println("Agrego 3 bolas a la urna 2 (while)")
        agregarBolasWhile(u2, 3)
        mostrarUrnas(u1, u2, u3)

        // Sacar 3 bolas de una urna usando do-while
        println("Saco 3 bolas a la urna 2 (do-while)")
        sacarBolasDoWhile(u2, 3)
        mostrarUrnas(u1, u2, u3)
    }

    private fun agregarBolasFor(urna: Urna, n: Int) {
        requireNotNull(urna) { "La urna no puede ser nula" }
        val capacidad = urna.capacidad
        require(n in 0..capacidad) {
            "El número de bolas a agregar debe estar en el rango [0,$capacidad] (n=$n)"
        }
        for (i in 1..n) {
            if (!urna.estaLlena()) urna.agregar()
        }
    }

    private fun agregarBolasWhile(urna: Urna, n: Int) {
        requireNotNull(urna) { "La urna no puede ser nula" }
        val capacidad = urna.capacidad
        require(n in 0..capacidad) {
            "El número de bolas a agregar debe estar en el rango [0,$capacidad] (n=$n)"
        }
        var i = 0
        while (++i <= n && !urna.estaLlena()) {
            urna.agregar()
        }
    }

    private fun sacarBolasDoWhile(urna: Urna, n: Int) {
        requireNotNull(urna) { "La urna no puede ser nula" }
        val numBolas = urna.numBolas()
        require(n in 0..numBolas) {
            "No puedo sacar $n bola/s que en la urna hay $numBolas bola/s"
        }
        var i = 0
        do {
            urna.sacar()
        } while (++i <= n && !urna.estaVacia())
    }

    private fun version0p4() {
        System.setProperty("jansi.passthrough", "true")
        AnsiConsole.systemInstall()

        // Creación de 3 urnas
        val u1 = Urna(3)
        val u2 = Urna(5)
        val u3 = Urna(7)
        mostrarUrnas(u1, u2, u3)

        // Agregar 3 bolas usando for
        println("Agrego 3 bolas a la urna 1 (for)")
        agregarBolasFor(u1, 3)
        mostrarUrnas(u1, u2, u3)

        // Agregar 3 bolas usando while
        println("Agrego 3 bolas a la urna 2 (while)")
        agregarBolasWhile(u2, 3)
        mostrarUrnas(u1, u2, u3)

        // Sacar 3 bolas de una urna usando do-while
        println("Saco 3 bolas a la urna 2 (do-while)")
        sacarBolasDoWhile(u2, 3)
        mostrarUrnas(u1, u2, u3)

        AnsiConsole.systemUninstall()
    }
}

fun main() {
    val principal = Principal()
    principal.version0p4()
}

