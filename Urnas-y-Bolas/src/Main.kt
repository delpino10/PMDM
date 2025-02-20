
fun main(args: Array<String>) {
    var bola1 = Bola.generarBola()
    var bola2 = Bola.generarBola()
    var bola3 = Bola.generarBola()
    var bola4 = Bola.generarBola()

    var urna = Urna()

    try {
        urna.llenarUrna(bola1)
        urna.llenarUrna(bola2)
        urna.llenarUrna(bola3)
        urna.llenarUrna(bola4)
    }catch (e:IllegalArgumentException){
        println("La urna está llena")
    }

    try {
        //Saca todas las bolas de la urna hasta que esta este vacía
        urna.sacarBolaAleatoriamente()
    }catch (e:IllegalArgumentException){
        System.err.println("La urna esta vacia")
    }

    urna.sacarBolaColor(Color.ROJO)

    try {
        urna.estaVacia()
    }catch (e:IllegalArgumentException){
        System.err.println("La urna esta vacia por el método estaVacia()")
    }

    try {
        urna.mostrarUrna()
    }catch (e:IllegalArgumentException){
        System.err.println("La urna esta vacia. No Hay bola que mostrar")
    }


}
