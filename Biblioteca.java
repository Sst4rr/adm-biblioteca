//atualizar livros em posse


import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;

    Scanner input = new Scanner(System.in);

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro "+ livro+ " adicionado com sucesso!");
    }

    public void removerLivro(String titulo) {
        Livro livroARemover = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livroARemover = livro;
                break;
            }
        }
        if(livroARemover != null){
            livros.remove(livroARemover);
            System.out.print("Livro "+livroARemover.getTitulo()+" removido com sucesso!" );
        }else{
            System.out.println("Livro '" +titulo+ "' não encontrado.");
        }// tratamento de erro
    }


    public void cadastrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public void removerUsuario(String u) {
        Usuario usuarioRemove = null;
        
        for(Usuario usuario : usuarios){
            if(usuario.getNome().equalsIgnoreCase(u)){
                usuarioRemove = usuario;
                break;
            }
        }

        if(usuarioRemove != null){
            usuarios.remove(usuarioRemove);
            System.out.println("Usuário " + u + "removido com sucesso!");
        } else{
            System.out.println("O usuário " + u + "não foi encontrado.");
        }
    }

    
    //add contains com o toLowerCase
    //emprestar pelo id
    public List<LivroFisico> buscarLivro(String titulo) {
        List<LivroFisico> livrosEncontrados = new ArrayList<>();
        String parteTituloLowerCase = titulo.toLowerCase();
        for (Livro livro : livros) {
            if(livro instanceof LivroFisico){
                LivroFisico livroFisico = (LivroFisico) livro;
            String tituloLowerCase = livroFisico.getTitulo().toLowerCase();
            if (tituloLowerCase.contains(parteTituloLowerCase)) {
                livrosEncontrados.add(livroFisico);
            }
        }
    }
        if (!livrosEncontrados.isEmpty()) {
            System.out.println("Livros encontrados com o título '" + titulo + "':");
            for (LivroFisico livroEncontrado : livrosEncontrados) {
                System.out.println("- Código: " + livroEncontrado.getCodigo() + ", Título: " + livroEncontrado.getTitulo());
            }
        } else {
            System.out.println("Nenhum livro encontrado com o título '" + titulo + "'.");
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
        if (u.getLivrosEmprestados().contains(livro)){
            //verificar em livros em posse do usuário e não os emprestados
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


    //add contains
    public List<Usuario> buscarUsuario(int idBusca) throws Exception{
        List<Usuario> usuariosEncontrados = new ArrayList<>();
        try {
            for (Usuario usuario : usuarios) {
                if (usuario instanceof UsuarioAluno) {
                    UsuarioAluno aluno = (UsuarioAluno) usuario;
                    if (aluno.getMatricula() == idBusca) {
                    System.out.println("Usuário encontrado: " + aluno.getNome());
                    usuariosEncontrados.add(aluno);
                    }
                }else if (usuario instanceof UsuarioProfessor) {
                    UsuarioProfessor professor = (UsuarioProfessor) usuario;
                    if (professor.getcodigo() == idBusca) {
                        System.out.println("Usuário encontrado: " + professor.getNome());
                        usuariosEncontrados.add(professor);
                }
            }
        }
        if(usuariosEncontrados.isEmpty()){
            throw new Exception("Nenhum usuário encontrado com esse Id.");
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

    public Usuario descobrirUsuario (int cod){
        List<Usuario> usuariosDescobertos =  new ArrayList<>();
        System.out.println("Digite 1 se o usuário for professor e 2 se for aluno: ");
        int us = input.nextInt();
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


    //buscar livros emprestados por usuario6
    //buscar livros disponiveis
    //buscar livros emprestados

