import kotlin.random.Random

class Bola (private val numero: Int,
            private val color: Color
) {

    companion object {
        private var contador: Int = 0

        fun generarBola(): Bola {
            var colores = Color.values()
            var colorAleatorio = colores[Random.nextInt(colores.size)]
            contador ++
            return Bola(contador, colorAleatorio)
        }
    }


    val getColor: Color
        get() {
            return color
        }

    override fun toString(): String {
        return "Bola(numero=$numero, color=$color)"
    }


}