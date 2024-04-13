import java.io.File

fun main() {

    var texto_estacoes: String = File("dados/linha_vouga_completo.csv").readText()
    var linhas_ficheiro: List<String> = texto_estacoes.split("\n")

    println(linhas_ficheiro.size)

    var lista_estacoes: MutableList<Estacao> = mutableListOf()
    for (linha_ficheiro in linhas_ficheiro.subList(1, linhas_ficheiro.size)) {
//        for (valor_coluna in linha.split(",")) {
//            println(valor_coluna)
//        }
        var valor_colunas = linha_ficheiro.split(",")
        var nome = valor_colunas[0]
        var latitude: Double = valor_colunas[2].toDouble()
        var longitude: Double = valor_colunas[3].toDouble()
        var distrito: String = "Aveiro"
        var coordenadas: Array<Double> = arrayOf(latitude, longitude)

        var estacao: Estacao = Estacao(nome, coordenadas, distrito, "", "")
        lista_estacoes.add(estacao)
    }

    var linha: Linha = Linha("Vouga", "Métrica")
    linha.estacoes = lista_estacoes
}