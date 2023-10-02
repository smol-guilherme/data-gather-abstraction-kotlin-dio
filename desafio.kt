enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, var duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    val leituraInscritos: List<Usuario> = inscritos
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun mostrarMatriculados() {
        if(leituraInscritos.count() == 0) {
            println("Não foram encontradas matrículas para $nome")
            return
        }
        println("Matriculados na formação $nome:")
        for(usuario in inscritos) {
            println("${usuario.nome}")
    }
    }
}

fun main() {
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
