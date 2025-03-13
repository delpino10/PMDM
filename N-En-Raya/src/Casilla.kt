data class Casilla (private var ficha : Ficha) {

    fun estaVacia() : Boolean{
        return ficha == null
    }

    fun colocar(ficha : Ficha){
        this.ficha = ficha
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(other !is Casilla) return false

        return (this.estaVacia() && other.estaVacia()) || ficha == other.ficha
    }

    override fun hashCode(): Int {
        return ficha?.hashCode() ?: 0 // Si ficha es null, devuelve 0
    }
}