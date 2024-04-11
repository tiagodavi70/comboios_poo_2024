class Vagao(var comprimento: Double, comboio: Comboio) {
    var quantMaximaLugares: Int = 30
        get() { return field }
        set(value) {
            field = value
        }
    private var lugares: MutableList<Lugar> = mutableListOf<Lugar>()

    fun adicionarLugar(lugar: Lugar) : Boolean {
        if (lugares.size >= quantMaximaLugares) {
            return false
        } else {
            lugares.add(lugar)
            return true
        }
    }

    fun quantLugares(): Int {
        return lugares.size
    }
}