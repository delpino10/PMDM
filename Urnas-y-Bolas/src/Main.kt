
fun main(args: Array<String>) {
    val urna1 = mutableListOf<Bola>()
    val urna2 = mutableListOf<Bola>()
    val urna3 = mutableListOf<Bola>()

    var bola1 = Bola.generarBola()
    var bola2 = Bola.generarBola()
    var bola3 = Bola.generarBola()
    var bola4 = Bola.generarBola()

    var bola5 = Bola(5, Color.ROJO)
    var bola6 = Bola(6, Color.VERDE)

    var urna = Urna()

    try {
       /* urna.llenarUrna(bola1, urna1)
        urna.llenarUrna(bola2, urna1)
        urna.llenarUrna(bola3)
        urna.llenarUrna(bola4)*/
        for (i in 1..3) {
            val bola = Bola.generarBola()
            urna.llenarUrna(bola, urna1)
        }
    }catch (e:IllegalArgumentException){
        println("La urna está llena")
    }

//    try {
//        //Saca todas las bolas de la urna hasta que esta este vacía
//        urna.sacarBolaAleatoriamente(urna1)
//    }catch (e:IllegalArgumentException){
//        System.err.println("La urna esta vacia")
//    }

//    urna.sacarBolaColor(Color.ROJO)
//
//    try {
//        urna.estaVacia()
//    }catch (e:IllegalArgumentException){
//        System.err.println("La urna esta vacia por el método estaVacia()")
//    }

    try {
        urna.mostrarUrna(urna1)
    }catch (e:IllegalArgumentException){
        System.err.println("La urna esta vacia. No Hay bola que mostrar")
    }


}
