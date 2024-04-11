fun main() {

    var comboio1 = Comboio("modelo1", 200.0)
    var vagao = Vagao(15.0, comboio1)

    // Normal, Prioridade, Estudante
    var lugar1 = Lugar("A1", "Normal", vagao)
    var lugar2 = Lugar("A1", "Normal", vagao)
    var lugar3 = Lugar("A1", "Prioridade", vagao)

    for (i in 0..49) {
        if (!vagao.adicionarLugar(lugar1)) {
            println("Adição não permitida. Número máximo de lugares alcançado")
        }
    }
    println(vagao.quantLugares())
    //    var arrayT: Array<Int> = Array<Int>(10) {0}
}