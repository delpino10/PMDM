class Urna {
    private val capacidad: Int = 3
    private val urnaBolas = mutableListOf<Bola>()

    fun agregarUrna(bola:Bola){
            if(urnaBolas.size >= capacidad){
                throw IllegalArgumentException("La Urna está llena")
            }
                println("Bola introducida: $bola")
                urnaBolas.add(bola)


    }

    fun mostrarUrna(){
        for(bola in urnaBolas){
            println(bola)
        }
    }

}