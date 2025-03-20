class Animal ( nombre: String ){

    companion object{
        private var contador :Int = 0
    }

    private var nombre :String = ""
    private val numero :Int

    init {
        require(nombre.isNotEmpty()){ "El nombre de un animal no puede estar vacío"}
        require(nombre.isNotBlank()){ "El nombre de un animal no puede estar formado solo por caracteres de espaciado en blanco"}
    this.nombre = nombre
    this.numero = ++contador
    }

    override fun toString(): String {
        return "Animal(nombre='$nombre', numero=$numero)"
    }


}