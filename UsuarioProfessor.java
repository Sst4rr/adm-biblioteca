import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe UsuarioProfessor como extensão de Usuario
class UsuarioProfessor extends Usuario {
    // Atributos específicos para professores, se houver
    private List<Livro> livrosEmprestados;

    public UsuarioProfessor(int id, String nome) {
        super(id, nome);
        this.livrosEmprestados = new ArrayList<>();
    }

    // métodos específicos para professores, como empréstimo de livros físicos
}