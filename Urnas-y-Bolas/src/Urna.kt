import kotlin.random.Random

class Urna {
    private val capacidad: Int = 3
    private val urnaBolas = mutableListOf<Bola>()

    fun llenarUrna(bola:Bola, mutableList: MutableList<Bola>) {
            if(mutableList.size >= capacidad){
                throw IllegalArgumentException("La Urna está llena")
            }
                println("Bola introducida: $bola")
                mutableList.add(bola)
    }
// Saca una bola de aleatoriamente
    fun sacarBolaAleatoriamente(mutableList: MutableList<Bola>) {

        if(mutableList.size <= capacidad){
        val pos = Random.nextInt(mutableList.size)
        val x = mutableList[pos]
        mutableList.remove(x)
        println("Bola sacada aleatoriamente: $x")
        }
        if(mutableList.size == 0) {
            throw IllegalArgumentException("La Urna está vacia")
        }
    }
// Saca una bola de un color determinado
    fun sacarBolaColor(color: Color, mutableList: MutableList<Bola>) {
        val iterator = mutableList.iterator()  // Crea un iterador para recorrer la lista
        while (iterator.hasNext()) {
            val bola = iterator.next()
            if (color.equals(bola.getColor)) {  // Compara los colores
                iterator.remove()  // Elimina la bola de la lista de forma segura
                println("Bola de color $color sacada: $bola")
            }
        }
    }


    fun estaVacia(mutableList: MutableList<Bola>) {
        if (mutableList.isEmpty()){
            throw IllegalArgumentException("La Urna $mutableList esta vacia")
        }else
            mostrarUrna(mutableList)
    }


    fun mostrarUrna(mutableList: MutableList<Bola>){
        if(!mutableList.isEmpty()){
            for(bola in mutableList){
                println("En la urna quedan $bola")
            }
        }else{
            throw IllegalArgumentException("no se puede mostrar la urna $mutableList porque está vacía")
        }
    }

}