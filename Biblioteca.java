import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    private List<Livro> livros;
    private List<LivroFisico> livrofisico;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.livrofisico = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarLivroFisico(LivroFisico livroF){
        livrofisico.add(livroF);
    }

    public void cadastrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public List<Livro> buscarLivro(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        String tituloLowerCase = titulo.toLowerCase();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public String realizarEmprestimo(Usuario u, LivroFisico livro) throws Exception {
        if (!usuarios.contains(u)) {
            throw new Exception("Usuário não cadastrado na biblioteca.");
        }
        if (u instanceof UsuarioAluno && u.getLivrosEmprestados().size() >= 5) {
            throw new Exception("Limite de empréstimos atingido para alunos.");
        }
        if (u.getLivrosEmprestados().contains(livro)) {
            throw new Exception("Este livro já foi emprestado para o usuário.");
        }
        if (!livrofisico.contains(livro)) {
            throw new Exception("Livro não disponível na biblioteca.");
        }
        try {
            String resultadoEmprestimo = livro.realizarEmprestimo();
            u.pegarLivro(livro);
            return resultadoEmprestimo;
        } catch (Exception e) {
            return "Erro ao realizar o empréstimo: " + e.getMessage();
        }
    }

    public void devolverEmprestimo(Usuario u, LivroFisico livro) {
        u.devolverLivro(livro);
        livro.devolverlivro();
    }

    public Usuario buscarUsuario(int idBusca) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof UsuarioAluno) {
                UsuarioAluno aluno = (UsuarioAluno) usuario;
                if (aluno.getMatricula() == idBusca) {
                    return aluno;
                }
            } else if (usuario instanceof UsuarioProfessor) {
                UsuarioProfessor professor = (UsuarioProfessor) usuario;
                if (professor.getcodigo() == idBusca) {
                    return professor;
                }
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }
}
