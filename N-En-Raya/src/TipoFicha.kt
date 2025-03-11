import org.fusesource.jansi.Ansi

import org.fusesource.jansi.Ansi.Color.GREEN
import org.fusesource.jansi.Ansi.Color.RED
import org.fusesource.jansi.Ansi.ansi

enum class TipoFicha {
    O,X;

    fun toAnsi() : Ansi {
        val oAnsi = ansi().fg(GREEN).a(O).reset()
        val xAnsi = ansi().fg(RED).a(X).reset()

        return if (this == O) oAnsi else xAnsi
    }


}