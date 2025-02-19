
fun main(args: Array<String>) {
    var bola1 = Bola.generarBola()
    var bola2 = Bola.generarBola()
    var bola3 = Bola.generarBola()
    var bola4 = Bola.generarBola()

    var urna = Urna()

    try {
        urna.agregarUrna(bola1)
        urna.agregarUrna(bola2)
        urna.agregarUrna(bola3)
        urna.agregarUrna(bola4)
    }catch (e:IllegalArgumentException){
        println("La urna está llena")
    }

    urna.mostrarUrna()
}
