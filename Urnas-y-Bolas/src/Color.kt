import org.fusesource.jansi.Ansi

enum class Color(val color: Ansi.Color) {
    AMARILLO(Ansi.Color.YELLOW),
    AZUL(Ansi.Color.BLUE),
    ROJO(Ansi.Color.RED),
    VERDE(Ansi.Color.GREEN);

    // Método para obtener el color asociado
    fun getColor(): Ansi.Color {
        return color
    }
}
