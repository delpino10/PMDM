data class Ficha (var ficha : TipoFicha?) {

    init{
        setTipoFicha(ficha)
    }

    fun setTipoFicha (ficha : TipoFicha?){
        requireNotNull(ficha){"Error: el tipo de ficha no puede ser nulo" }
        this.ficha = ficha
    }
}