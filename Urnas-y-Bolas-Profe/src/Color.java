import org.fusesource.jansi.Ansi;

public enum Color
{
    AMARILLO(Ansi.Color.YELLOW), AZUL(Ansi.Color.BLUE),
    ROJO(Ansi.Color.RED), VERDE(Ansi.Color.GREEN);

    private Ansi.Color color;

    Color(Ansi.Color color) {
        this.color=color;
    }

    public Ansi.Color getColor() {
        return color;
    }
}
