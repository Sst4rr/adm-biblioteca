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
        System.out.println("Livro adicionado: " + livro.getTitulo());
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
        System.out.println("Usuário: " + u.getNome() + " cadastrado com sucesso!!");
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
            System.out.println("Usuário " + u + " removido com sucesso!");
        } else{
            System.out.println("O usuário " + u + " não foi encontrado.");
        }
    }

    
    //add contains com o toLowerCase
    //emprestar pelo id
public List<LivroFisico> buscarLivro(String titulo) {
    List<LivroFisico> livrosEncontrados = new ArrayList<>();
    String parteTituloLowerCase = titulo.toLowerCase().trim(); // Convertendo para minúsculas e removendo espaços extras

    for (Livro livro : livros) {
        if (livro instanceof LivroFisico) {
            LivroFisico livroFisico = (LivroFisico) livro;
            String tituloLowerCase = livroFisico.getTitulo().toLowerCase().trim(); // Convertendo para minúsculas e removendo espaços extras
            
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
        if (u instanceof UsuarioAluno && u.getLivrosEmPosse().size() >= 5) {
            throw new Exception("Limite de empréstimos atingido para alunos.");
        }
        if (u.getLivrosEmPosse().contains(livro)){
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
        if(u.getLivrosEmPosse().contains(livro)){
            u.devolverLivro(livro);
            livro.devolver();
            System.out.println("Livro devolvido com sucesso por: " + u.getNome());
        } else{
            System.out.println(u.getNome() + " Não devolver este livro, pois você não o adquiriu.");
        }
         
    }


    //add contains
    public List<Usuario> buscarUsuario(int idBusca){
        List<Usuario> usuariosEncontrados = new ArrayList<>();

            for (Usuario usuario : usuarios) {
                if (usuario instanceof UsuarioAluno) {
                    UsuarioAluno aluno = (UsuarioAluno) usuario;
                    if (aluno.getMatricula() == idBusca) {
                         System.out.println("Usuário encontrado: " + aluno.getNome() + " Matrícula: " + aluno.getMatricula());
                         usuariosEncontrados.add(aluno);
                    }
                }else if (usuario instanceof UsuarioProfessor) {
                    UsuarioProfessor professor = (UsuarioProfessor) usuario;
                    if (professor.getcodigo() == idBusca) {
                        System.out.println("Usuário encontrado: " + professor.getNome() + " Código: " + professor.getcodigo());
                        usuariosEncontrados.add(professor);
                }
            }
        }
        if(usuariosEncontrados.isEmpty()){
            System.out.println("Não existe usuário relacionado a esse código.");
            
        }
        return usuariosEncontrados;
    }

    //Buscar usuario por nome

    public void listarUsuarios() {
        if(usuarios.isEmpty()){
            System.out.println("Lista vazia");
        }else{
        for (Usuario usuario : usuarios) {
            if(usuario instanceof UsuarioProfessor){
                UsuarioProfessor professor = (UsuarioProfessor) usuario;
                System.out.println("Nome: " + professor.getNome() + " Código: " + professor.getcodigo());
            }else if(usuario instanceof UsuarioAluno){
                UsuarioAluno aluno = (UsuarioAluno) usuario;
                System.out.println("Nome: " + aluno.getNome() + " Matrícula: " + aluno.getMatricula());
            }
        }
    }
}

    public void listarLivrosEmprestados() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getLivrosEmprestados());
        }
    }

    public Usuario descobrirUsuario (int codUser){
        
        Usuario usuario = null;
        try{
            for(Usuario user : usuarios){
                if(user instanceof UsuarioProfessor){
                    UsuarioProfessor professor = (UsuarioProfessor) user;
                    if(professor.getcodigo() == codUser){
                        usuario = professor;
                        break;
                    }
        
                } else if(user instanceof UsuarioAluno){
                     UsuarioAluno aluno = (UsuarioAluno) user;
                     if(aluno.getMatricula() == codUser){
                        usuario = aluno;
                        break;
              }
        }
    }
 } catch (Exception e){
        e.printStackTrace();
    }
        return usuario;
    }

    public LivroFisico buscarLivroPorId(String id) {
        LivroFisico livroEncontrado = null;
        for(Livro livro : livros){
            if(livro instanceof LivroFisico){
                LivroFisico livroFisico = (LivroFisico) livro;
                if(livroFisico.getCodigo().equals(id)){
                    livroEncontrado = livroFisico;
                    break;
                }
            }
        }
        return livroEncontrado;
    }

    public LivroDigital buscarLivroDigitalPorId(String id){
        LivroDigital livroEncontrado = null;
        for (Livro livro : livros) {
            if (livro instanceof LivroDigital) {
                LivroDigital livroDigital = (LivroDigital) livro;
                if(livroDigital.getCodigo().equals(id)){
                    livroEncontrado = livroDigital;
                    break;
                }

            }
        }
        return livroEncontrado;
    }

    public void ImprimirTodosOsLivros() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
        } else {
            System.out.println("Lista de Livros:");
    
            for (Livro livro : livros) {
                System.out.println(livro.toString());
            }
        }
    }


    public void imprimirLivrosEmPosse(Usuario u){
        if(u instanceof UsuarioAluno){
            UsuarioAluno aluno = (UsuarioAluno) u;
            if(aluno.getLivrosEmPosse().isEmpty()){
                System.out.println("Lista vazia.");
            } else{
                System.out.println("Segue a listagem: ");
                for(Livro livro : aluno.getLivrosEmPosse()){
                    System.out.println("Titulo: " + livro.getTitulo() + " Código: " + livro.getCodigo());
                }
            }
        } else if(u instanceof UsuarioProfessor){
            UsuarioProfessor professor = (UsuarioProfessor) u;
            if(professor.getLivrosEmPosse().isEmpty()){
                System.out.println("Lista vazia.");
            } else{
                System.out.println("Segue a listagem:");
                for(Livro livro : professor.getLivrosEmPosse()){
                    System.out.println("Titulo: " + livro.getTitulo() + " Código: " + livro.getCodigo());
                }
            }
        } else{
            System.out.println("Não foi possivel encontrar o usuário.");
        }
    }

    
    public void historicoLivros(Usuario u){
        if(u instanceof UsuarioAluno){
            UsuarioAluno aluno = (UsuarioAluno) u;
            if(aluno.getLivrosEmprestados().isEmpty()){
            System.out.println("Sem histórico.");
        } else {
            System.out.println("Segue a listagem: ");
            for(Livro livro : aluno.getLivrosEmprestados()){
                System.out.println("Titulo: " + livro.getTitulo() + " Código" + livro.getCodigo());
            }
        }
    } else if(u instanceof UsuarioProfessor){
        UsuarioProfessor professor = (UsuarioProfessor) u;
        if(professor.getLivrosEmprestados().isEmpty()){
            System.out.println("Sem histórico.");
        } else{
            System.out.println("Segue a listagem: ");
            for(Livro livro : professor.getLivrosEmprestados()){
                System.out.println("Titulo: " + livro.getTitulo() + " Código" + livro.getCodigo());
            }
        }

        }else{
            System.out.println("Não foi possivel encontrar o usuário.");
        }
    }
}

    



    //buscar livros emprestados por usuario6
    //buscar livros disponiveis
    //buscar livros emprestados

