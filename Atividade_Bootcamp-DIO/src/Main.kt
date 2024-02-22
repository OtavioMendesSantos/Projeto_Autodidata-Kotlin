enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val idade: Int, val nivel: Nivel){
    override fun toString(): String{
        return "Nome: $nome, Idade: $idade, Nivel: $nivel"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60){
    override fun toString(): String{
        return "Conteúdo Educacional: $nome, Carga Horária: $duracao"
    }
}

data class Formacao(val nomeCurso: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun listarInscritos(){
        println("Inscritos no curso de $nomeCurso:")
        for (item in inscritos){
            println(item)
        }
    }

    fun listarConteudos(){
        println("Conteúdos do curso de $nomeCurso:")
        for (item in conteudos){
            println(item)
        }
    }
}

fun main() {
    val matematica = ConteudoEducacional("Matemática", 250)
    val portugues = ConteudoEducacional("Português", 250)
    val fisica = ConteudoEducacional("Física", 125)
    val historia = ConteudoEducacional("História", 125)

    val usuario1 = Usuario("Otávio", 18, Nivel.BASICO)
    val usuario2 = Usuario("Lucas", 18, Nivel.INTERMEDIARIO)
    val usuario3 = Usuario("Osvaldo", 18, Nivel.DIFICIL)
    val usuario4 = Usuario("Arthur", 18, Nivel.DIFICIL)

    val exatas = Formacao("Exatas", listOf(matematica, fisica))
    exatas.matricular(usuario1)
    exatas.matricular(usuario2)
    exatas.listarInscritos()
    exatas.listarConteudos()

    val humanas = Formacao("Humanas", listOf(portugues, historia))
    humanas.matricular(usuario3)
    humanas.matricular(usuario4)
    humanas.listarInscritos()
    humanas.listarConteudos()
}