public class Urna
{
    private static final int MINCAPACIDAD = 1;
    private Bola[] bolas;                           // <<R>>

    public Urna(int capacidad) {
        assert capacidad>=MINCAPACIDAD:
                String.format("La capacidad de una urna debe ser >=%d (capacidad=%d)",
                        MINCAPACIDAD, capacidad);
        bolas = new Bola[capacidad];
    }
    
    // Accesores

    public int getCapacidad() {
        return bolas.length;
    }
    
    // Otros metodos
    
    public void agregar() {    
        agregar(Bola.generar());
    }
    
    public void agregar(Bola bola) {
        assert bola!=null: "La bola a agregar a la urna no puede ser nula";
        assert !estaLlena():
           String.format("No es posible agregar la bola %s porque la urna esta llena", bola);
        for (int i = 0; i < getCapacidad(); i++) {
            if (bolas[i]==null) {
                bolas[i] = bola;
                return;
            }
        }
        System.err.println("El programa no debe llegar a ejecutar esta línea");
        System.exit(1);
    }

    public void agregar(Color color) {
        agregar(new Bola(color));    
    }    
    
    public boolean estaLlena() {
        return numBolas()==getCapacidad();
    }
    
    public boolean estaVacia() {
        return numBolas()==0;
    }
    
    public void llenar() {
        while (!estaLlena())
            agregar();           
    }
    
    public int numBolas() {
        int contador=0;
        for (int i = 0; i < getCapacidad(); i++) {
            if (bolas[i]!=null)
                contador++;
        }
        return contador;
    }

    // Saca una bola de la posición indicada
    private Bola sacar(int pos) {
        assert pos>=0 && pos<getCapacidad():
            String.format("La posición no existe (pos=%d) pos [%d,%d]", pos, 0, getCapacidad()-1);
        assert bolas[pos]!=null:
            String.format("No es posible sacar una bola porque no existe bola en la posición %d",
                    pos);
        Bola aux=bolas[pos];
        bolas[pos]=null;
        return aux;
    }
    
    public Bola sacar() {
        assert !estaVacia(): "No es posible sacar una bola porque la urna esta vacia";

        // Creamos un array con las posiciones donde están las bolas
        int n=numBolas();
        int[] posiciones=new int[n];
        for (int i = 0, j = 0; i < getCapacidad(); i++) {
            if (bolas[i]!=null) {
                posiciones[j++]=i;
            }
        }
        // Elegimos aleatoriamente una posición del array de bolas original
        int pos=posiciones[(int)(Math.random()*n)];

        // Sacamos la bola que esté en la posición obtenida aleatoriamente
        return sacar(pos);
    }

    public Bola sacar(Color color) {
        assert color!=null: "El color de la bola a sacar no puede ser nulo";
        assert !estaVacia(): "No es posible sacar una bola porque la urna esta vacia";

        for (int i = 0; i < getCapacidad(); i++) {
            if (bolas[i].getColor().equals(color))
                return sacar(i);
        }
        return null;
    }
    
    public void vaciar() {
        for (int i = 0; i < getCapacidad(); i++)
            bolas[i]=null;
    }

    public String toString() {
        StringBuilder aux = new StringBuilder();
        aux.append("|");
        for (int i = 0; i < getCapacidad() ; i++) {
            aux.append(String.format("%s", bolas[i] == null ? " " : bolas[i]));
            aux.append("|");
        }
        aux.append(String.format(" %d/%d", numBolas(), getCapacidad()));
        aux.append(estaVacia() ? " VACIA" : "");
        aux.append(estaLlena() ? " LLENA" : "");
                
        return aux.toString();
    }
}
