enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

open class Aluno(val name: String) {
    fun infos() {
        println("$name, Seja bem vindo!")
    }
}

class Usuario(name: String) : Aluno(name = name)


data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {

    fun imprimir(): String {
        return "Curso $nome com duração : $duracao "
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()

    fun matricular(usuario: Aluno) {
        inscritos.add(usuario)
    }

}

fun main() {
    val maria:Aluno = Usuario("Maria")
    println(maria.infos())
    
    val joao:Aluno = Usuario("João")
    println(joao.infos())

    val listaCursos = listOf(
        ConteudoEducacional("Kotlin"),
        ConteudoEducacional("Java")
    )

    var formacaoR = Formacao(Nivel.BASICO.toString(), listaCursos)

    formacaoR.matricular(maria)
    formacaoR.matricular(joao)
    
    println("Cursos de formação ${formacaoR.nome}")
    listaCursos.forEach { println(it.imprimir())
    
    formacaoR.inscritos.forEach { println("Inscritos: ${it.name}") }
    formacaoR.conteudos.forEach { println("Cursos: ${it.nome} - Duração: ${it.duracao}") }

    }
}
