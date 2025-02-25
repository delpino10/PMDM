import org.fusesource.jansi.Ansi
import org.fusesource.jansi.AnsiConsole

class Bola(private val color: Color) {
    companion object {
        private const val BOLA = '\u25CF'  // Representación textual
        private var contador = 0           // Nº de bolas que existen

        // Método para generar una bola con un color aleatorio
        fun generar(): Bola {
            val colores = Color.values()
            val n = (Math.random() * colores.size).toInt()
            return Bola(colores[n])
        }

        // Método para obtener el total de bolas creadas
        fun totalBolas(): Int {
            return contador
        }
    }

    val numero: Int
    private val color: Color

    init {
        numero = ++contador
        this.color = color
    }

    // Métodos de acceso
    fun getColor(): Color {
        return color
    }


    fun getNumero(): Int {
        return numero
    }

    // Representación en texto de la bola con color
    override fun toString(): String {
        return Ansi.ansi().fg(color.getColor()).a(BOLA).reset().toString()
    }
}
