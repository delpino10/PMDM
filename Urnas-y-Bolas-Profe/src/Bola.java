import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

public class Bola
{
    private static final char BOLA='\u25CF';    // Representación textual
    private static int contador = 0;            // Nº de bolas que existen
    private int numero;                         // >=1, AUTO, NO MODIFICABLE
    private Color color;                        // NO MODIFICABLE, NO NULO
    
    public Bola(Color color) {
        setNumero(++contador);
        setColor(color);
    }
    
    public static Bola generar() {
        Color[] colores = Color.values();
        int n = (int)(Math.random()*colores.length);
        return new Bola(colores[n]);
    }

    // Accesores
    
    public Color getColor() {
        return color;
    }
    public int getNumero() {
        return numero;
    }
        
    // Mutadores
    
    private void setNumero(int numero) {
        assert numero>=1: 
            String.format("El numero debe ser >=1 (numero=%d)", numero);
        this.numero = numero;
    }
    
    private void setColor(Color color) {
        assert color!=null: "El color no puede ser nulo";       
        this.color = color;        
    }
    
    public static int totalBolas() {
        return contador;
    }

    public String toString() {
        return ansi().fg(color.getColor()).a(BOLA).reset().toString();
    }


}
