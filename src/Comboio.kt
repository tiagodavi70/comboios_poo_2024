class Comboio(var modelo: String, var velocidade: Double) {
    var quantMaximaVagoes: Int = 1
        get() { return field }
        set(value) {
            field = value
        }
    private var vagoes: MutableList<Vagao> = mutableListOf<Vagao>()

    fun adicionarLugar(vagao: Vagao) : Boolean {
        if (vagoes.size >= quantMaximaVagoes) {
            return false
        } else {
            vagoes.add(vagao)
            return true
        }
    }

    fun quantLugares(): Int {
        return vagoes.size
    }
}