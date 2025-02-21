
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

    urna.agregaBolaColor("rojo", urna1)
    urna.agregaBolaColor("verde", urna1)
    urna.agregaBolaColor("azul", urna1)

    urna.agregaBolaAleatoria(urna2)
    urna.agregaBolaAleatoria(urna2)

    urna.mostrarUrna("urna1",urna1)
    urna.mostrarUrna("urna2", urna2)


}
