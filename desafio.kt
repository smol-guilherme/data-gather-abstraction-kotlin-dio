enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }
            
data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, var duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    val leituraInscritos: List<Usuario> = inscritos
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun matricular(usuarios: List<Usuario>) {
        inscritos.addAll(usuarios)
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
    // Dummy Users
    val usuario1 = Usuario("Alice", "alice@example.com")
    val usuario2 = Usuario("Bob", "bob@example.com")
    val usuario3 = Usuario("Charlie", "charlie@example.com")
    val usuarios = listOf(
    Usuario("Alice", "alice@example.com"),
    Usuario("Bob", "bob@example.com"),
    usuario3,
    Usuario("David", "david@example.com"),
    Usuario("Eve", "eve@example.com")
    )

    // Dummy Content
    val conteudo1 = ConteudoEducacional("Curso de Kotlin Básico", Nivel.BASICO, 60)
    val conteudo2 = ConteudoEducacional("Curso de Kotlin Avançado", Nivel.AVANCADO, 90)
    val conteudo3 = ConteudoEducacional("Curso de Android Intermediário", Nivel.INTERMEDIARIO, 75)

    // Dummy Formation with Users
    val formacao1 = Formacao("Formação de Programação", listOf(conteudo1, conteudo2))
    formacao1.mostrarMatriculados()
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao1.mostrarMatriculados()

    val formacao2 = Formacao("Formação de Desenvolvimento Android", listOf(conteudo2, conteudo3))
    formacao2.mostrarMatriculados()
    formacao2.matricular(usuarios)
    formacao2.mostrarMatriculados()
}
