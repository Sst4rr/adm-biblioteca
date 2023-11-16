import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe UsuarioAluno como extensão de Usuario
class UsuarioAluno extends Usuario {
    // Atributos específicos para alunos, se houver
    private List<Livro> livrosEmprestados;

    public UsuarioAluno(int id, String nome) {
        super(id, nome);
        this.livrosEmprestados = new ArrayList<>();
    }

    // métodos específicos para alunos, como empréstimo de livros digitais
}