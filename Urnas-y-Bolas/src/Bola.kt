import kotlin.random.Random

class Bola (private val numero: Int,
            private val color: Color
) {

    companion object {
        private var contador: Int = 0

        fun generarBola(): Bola {
            var colores = Color.values()
            var colorAleatorio = colores[Random.nextInt(colores.size)]
            contador++
            return Bola(contador, colorAleatorio)
        }

        fun generarBolaColor(color:String): Bola {
            contador++
            when(color){
            "azul" -> return Bola(contador, Color.AZUL)
            "rojo" -> return Bola(contador, Color.ROJO)
            "verde" -> return Bola(contador, Color.VERDE)
            "amarillo" -> return Bola(contador, Color.AMARILLO)
            else -> println("No ha y bolas de color $color")
            }
            return Bola(contador, Color.ROJO)
        }

        fun totalBolasCreadas(){
            println("Se han creado un total de $contador bolas" )
        }
    }


    val getColor: Color
        get() {
            return color
        }

    val getNumber: Int
        get() {
            return numero
        }



    override fun toString(): String {
        return "Bola(numero=$numero, color=$color)"
    }


}