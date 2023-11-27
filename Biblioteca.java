import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro "+ livro+ " adicionado com sucesso!");
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
        System.out.println("Livro " + livro + " removido com sucesso!");
    }


    public void cadastrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public void removerUsuario(Usuario u) {
        usuarios.remove(u);
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

    public void realizarEmprestimo(Usuario u, LivroFisico livro) throws Exception {
        
        if (!usuarios.contains(u)) {
            throw new Exception("Usuário não cadastrado na biblioteca.");
        }
        if (u instanceof UsuarioAluno && u.getLivrosEmprestados().size() >= 5) {
            throw new Exception("Limite de empréstimos atingido para alunos.");
        }
        if (u.getLivrosEmprestados().contains(livro)) {
            throw new Exception("Este livro já foi emprestado para o usuário.");
        }
        try {
            livro.emprestar();
            u.pegarLivro(livro);
            System.out.println(livro.getTitulo() + " emprestado para "+ u.getNome() + " com sucesso. ");
        } catch (Exception e) {
            System.out.println("Erro ao realizar o empréstimo: " + e.getMessage());
        }
    }

    public void devolverEmprestimo(Usuario u, LivroFisico livro) {
        if(u.getLivrosEmprestados().contains(livro)){
            u.devolverLivro(livro);
            livro.devolver();
            System.out.println("Livro devolvido com sucesso por: " + u.getNome());
        } else{
            System.out.println(u.getNome() + " Não devolver este livro, pois você não o adquiriu.");
        }
         
    }

    public Usuario buscarUsuario(int idBusca) throws Exception{
        try {
            for (Usuario usuario : usuarios) {
                if (usuario instanceof UsuarioAluno) {
                    UsuarioAluno aluno = (UsuarioAluno) usuario;
                    if (aluno.getMatricula() == idBusca) {
                    System.out.println("Usuário encontrado: " + aluno.getNome());
                    return aluno;
                    }
                }else if (usuario instanceof UsuarioProfessor) {
                    UsuarioProfessor professor = (UsuarioProfessor) usuario;
                    if (professor.getcodigo() == idBusca) {
                        System.out.println("Usuário encontrado: " + professor.getNome());
                        return professor;
                }
            }
        }
        } catch (Exception e){
            e.printStackTrace();
        } return null;
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    public void listarLivrosEmprestados() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getLivrosEmprestados());
        }
    }

    //listar livros disponiveis para emprestimo
    // public void listarLivrosDisponiveis() {
    //     for (Livro livro : livros) {
    //         if (livro instanceof LivroFisico) {
    //             LivroFisico livroFisico = (LivroFisico) livro;
    //             if (livroFisico.isDisponivel()) {
    //                 System.out.println(livroFisico.getTitulo() + " está disponível para empréstimo.");
    //             }
    //         }
    //     }
    // }

}


    //buscar livros emprestados por usuario
    //buscar livros disponiveis
    //buscar livros emprestados

