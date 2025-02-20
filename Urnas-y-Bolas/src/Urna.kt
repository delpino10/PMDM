import kotlin.random.Random

class Urna {
    private val capacidad: Int = 3
    private val urnaBolas = mutableListOf<Bola>()

    fun llenarUrna(bola:Bola){
            if(urnaBolas.size >= capacidad){
                throw IllegalArgumentException("La Urna está llena")
            }
                println("Bola introducida: $bola")
                urnaBolas.add(bola)
    }
// Saca una bola de aleatoriamente
    fun sacarBolaAleatoriamente(){

        if(urnaBolas.size <= capacidad){
        val pos = Random.nextInt(urnaBolas.size)
        val x = urnaBolas[pos]
        urnaBolas.remove(x)
        println("Bola sacada aleatoriamente: $x")
        }
        if(urnaBolas.size == 0) {
            throw IllegalArgumentException("La Urna está vacia")
        }
    }
// Saca una bola de un color determinado
    fun sacarBolaColor(color: Color) {
        val iterator = urnaBolas.iterator()  // Crea un iterador para recorrer la lista
        while (iterator.hasNext()) {
            val bola = iterator.next()
            if (color.equals(bola.getColor)) {  // Compara los colores
                iterator.remove()  // Elimina la bola de la lista de forma segura
                println("Bola de color $color sacada: $bola")
            }
        }
    }


    fun estaVacia(){
        if (urnaBolas.isEmpty()){
            throw IllegalArgumentException("La Urna esta vacia")
        }else
            mostrarUrna()
    }


    fun mostrarUrna(){
        if(!urnaBolas.isEmpty()){
            for(bola in urnaBolas){
                println("En la urna quedan $bola")
            }
        }else{
            throw IllegalArgumentException("no se puede mostrar la urna porque está vacía")
        }
    }

}