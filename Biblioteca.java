import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public List<Livro> buscarLivro(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public void realizarEmprestimo(Usuario u, LivroFisico l) throws Exception {
        if (!usuarios.contains(u)) {
            throw new Exception("Usuário não cadastrado na biblioteca.");
        }
        if (!livros.contains(l)) {
            throw new Exception("Livro não disponível na biblioteca.");
        }
        if (u instanceof UsuarioAluno && u.getLivrosEmprestados().size() >= 5) {
            throw new Exception("Limite de empréstimos atingido para alunos.");
        }
        if (u.getLivrosEmprestados().contains(l)) {
            throw new Exception("Este livro já foi emprestado para o usuário.");
        }
        if (l.emprestarlivro(u)) {
            throw new Exception("Este livro já está emprestado.");
        }

        u.pegarLivro(l);
    }

    
    public Usuario buscarUsuario(int idBusca) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof UsuarioProfessor && ((UsuarioProfessor) usuario).getcodigo() == idBusca) {
                return usuario;
            } else if (usuario instanceof UsuarioAluno && ((UsuarioAluno) usuario).getMatricula() == idBusca) {
                return usuario;
            }
        }
        return null; // Retorna null se não encontrar o usuário com o ID
    }
}
