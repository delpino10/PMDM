// Urnas y bolas 0.4

import org.fusesource.jansi.AnsiConsole;


public class Principal
{
    private static final String LINEA1 = "-".repeat(50);
    
    public static void main(String[] args) {
        // version0p1();
        // version0p2();
        // version0p3();
        version0p4();
    }

    private static void mostrarUrnas(Urna u1, Urna u2, Urna u3) {
        System.out.printf("Urnas\nUrna 1 %s\nUrna 2 %s\nUrna 3 %s\n", u1, u2, u3);        
        System.out.println(LINEA1);    
    }   
        
    private static void version0p1() {
        // Creacion de 4 bolas de 2 formas distintas
        Bola bola1 = new Bola(Color.AZUL);
        Bola bola2 = Bola.generar();
        Bola bola3 = new Bola(Color.VERDE);
        Bola bola4 = Bola.generar();        
        System.out.printf("Bolas\n%s\n%s\n%s\n%s\n", bola1, bola2, bola3, bola4);
        System.out.println(LINEA1);
        
        // Creacion de 3 urnas
        Urna u1 = new Urna(3);
        Urna u2 = new Urna(5);
        Urna u3 = new Urna(7);
        System.out.printf("Urnas\n%s\n%s\n%s\n", u1, u2, u3);
        System.out.println(LINEA1);
        
        // Agrego 3 bolas a la primera urna
        u1.agregar(bola1);
        u1.agregar(bola2);
        u1.agregar(bola3);
        System.out.printf("Urnas\n%s\n%s\n%s\n", u1, u2, u3);        
        System.out.println(LINEA1);
        
        // Muevo una bola de color AZUL de la primera a la segunda urna
        u2.agregar(u1.sacar(Color.AZUL));  
        System.out.printf("Urnas\n%s\n%s\n%s\n", u1, u2, u3);        
        System.out.println(LINEA1);
        
        // Lleno la tercera urna
        u3.llenar();
        System.out.printf("Urnas\n%s\n%s\n%s\n", u1, u2, u3);        
        System.out.println(LINEA1);
                
        // Saco una bola aleatoriamente de la urna 3
        Bola sacada = u3.sacar();
        System.out.println("Bola sacada de la urna 3="+sacada);
        System.out.printf("Urnas\n%s\n%s\n%s\n", u1, u2, u3);        
        System.out.println(LINEA1);       
    }    
    
    public static void version0p2() { 
        // Creacion de 4 bolas de 2 formas distintas
        Bola bola1 = new Bola(Color.AZUL);
        Bola bola2 = Bola.generar();
        Bola bola3 = new Bola(Color.VERDE);
        Bola bola4 = Bola.generar();        
        System.out.printf("Bolas\n%s\n%s\n%s\n%s\n", bola1, bola2, bola3, bola4);
        System.out.println(LINEA1);
        
        // Creacion de 3 urnas
        Urna u1 = new Urna(3);
        Urna u2 = new Urna(5);
        Urna u3 = new Urna(7);
        mostrarUrnas(u1, u2, u3);  
        
        // Agrego 3 bolas a la primera urna y 2 a la segunda urna (5 formas distintas)
        u1.agregar();
        u1.agregar(Color.AZUL);
        u1.agregar(bola1);
        u2.agregar(Bola.generar());
        u2.agregar(new Bola(Color.AMARILLO));
        mostrarUrnas(u1, u2, u3);
        
        // Mostrar el numero de una bola
        System.out.printf("La primera bola creada es la numero "+bola1.getNumero());   
        
        // Mover una bola de color AZUL de la primera a la segunda urna
        u2.agregar(u1.sacar(Color.AZUL));
        mostrarUrnas(u1, u2, u3);      
        
        // Llenar la tercer urna
        u3.llenar();
        System.out.println("He llenado la tercera urna");
        mostrarUrnas(u1, u2, u3);
        
        // Sacamos una bola aleatoriamente de la urna 3        
        Bola sacada = u3.sacar();
        System.out.printf("Hemos sacamos una bola aleatoriamente (bola=%s) de la urna 3\n", sacada);
        mostrarUrnas(u1, u2, u3);  
        
        // Mostramos el numero de bolas de la urna 3
        int n = u3.numBolas();
        System.out.printf("La urna 3 tiene %d bola%s\n", n, n==1 ? "" : "s");
        mostrarUrnas(u1, u2, u3);   
        
        // Mostrar el numero total de bolas contenidas en las 3 urnas
        System.out.printf("Numero total de bolas en las 3 urnas=%d\n", 
            u1.numBolas()+u2.numBolas()+u3.numBolas());
            
        // Mostrar el numero total de bolas creadas
        System.out.printf("Numero total de bolas creadas=%d\n", Bola.totalBolas());            
    }
    
    private static void version0p3() {
        // Creacion de 3 urnas
        Urna u1 = new Urna(3);
        Urna u2 = new Urna(3);
        Urna u3 = new Urna(3);
        mostrarUrnas(u1, u2, u3);
        
        // Agregar 3 bolas usando for        
        System.out.println("Agrego 3 bolas a la urna 1 (for)");
        agregarBolasFor(u1, 3);
        mostrarUrnas(u1, u2, u3);
            
        // Agregar 3 bolas usando while        
        System.out.println("Agrego 3 bolas a la urna 2 (while)");
        agregarBolasWhile(u2, 3);
        mostrarUrnas(u1, u2, u3);
        
        // Sacar 3 bolas de una urna usando do-while
        System.out.println("Saco 3 bolas a la urna 2 (do-while)");
        sacarBolasDoWhile(u2, 3);
        mostrarUrnas(u1, u2, u3);
    }
    
    private static void agregarBolasFor(Urna urna, int n) {
        assert urna!=null: "La urna no puede ser nula";
        int capacidad=urna.getCapacidad();
        assert n>=0 && n<=capacidad: 
            String.format("El numero de bolas a agregar debe estar en el rango [0,%d] (n=%d)", capacidad, n);
        for (int i=1; i<=n && !urna.estaLlena(); i++)
            urna.agregar();        
    }
    
    private static void agregarBolasWhile(Urna urna, int n) {
        assert urna!=null: "La urna no puede ser nula";    
        int capacidad=urna.getCapacidad();
        assert n>=0 && n<=capacidad: 
            String.format("El numero de bolas a agregar debe estar en el rango [0,%d] (n=%d)", capacidad, n);
        int i=0;
        while (++i<=n && !urna.estaLlena())
            urna.agregar();
    }

    private static void sacarBolasDoWhile(Urna urna, int n) {
        assert urna!=null: "La urna no puede ser nula";    
        int numBolas=urna.numBolas();
        assert n>=0 && n<=numBolas: 
            String.format("No puedo sacar %d bola/s que en la urna hay %d bola/s", n, numBolas);
        int i=0;
        do {
            urna.sacar();            
        } while (++i<=n && !urna.estaVacia());
    }
    private static void version0p4() {
        System.setProperty("jansi.passthrough", "true");
        AnsiConsole.systemInstall();

        // Creacion de 3 urnas
        Urna u1 = new Urna(3);
        Urna u2 = new Urna(5);
        Urna u3 = new Urna(7);
        mostrarUrnas(u1, u2, u3);

        // Agregar 3 bolas usando for
        System.out.println("Agrego 3 bolas a la urna 1 (for)");
        agregarBolasFor(u1, 3);
        mostrarUrnas(u1, u2, u3);

        // Agregar 3 bolas usando while
        System.out.println("Agrego 3 bolas a la urna 2 (while)");
        agregarBolasWhile(u2, 3);
        mostrarUrnas(u1, u2, u3);

        // Sacar 3 bolas de una urna usando do-while
        System.out.println("Saco 3 bolas a la urna 2 (do-while)");
        sacarBolasDoWhile(u2, 3);
        mostrarUrnas(u1, u2, u3);

        AnsiConsole.systemUninstall();
    }



}
