import java.util.ArrayList;
import java.util.List;

/**
 * A classe Usuario representa um usuário do sistema de biblioteca.
 */
public abstract class Usuario{
    private String nome;
    private List<LivroFisico> livrosEmprestados;
    private List<LivroDigital> livrosBaixados;
    private List<LivroFisico> livrosEmPosse;

    /**
     * Construtor da classe Usuario.
     * @param nome O nome do Usuário
     */
    public Usuario(String nome) {
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
        this.livrosBaixados = new ArrayList<>();
        this.livrosEmPosse = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public List<LivroFisico> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public List<LivroDigital> getLivrosBaixados() {
        return livrosBaixados;
    }

    public List<LivroFisico> getLivrosEmPosse() {
        return livrosEmPosse;
    }


    /**
     * Método para pegar um livro emprestado.
     * @param livro O livro físico a ser emprestado
     * @throws Exception Exceção lançada caso o usuário já tenha o livro emprestado ou já tenha atingido o limite de livros permitidos.
     */
    public void pegarLivro(LivroFisico livro) throws Exception {
        if (livrosEmprestados.contains(livro)) {
            throw new Exception("Livro já emprestado para você!");
        } else if (livrosEmprestados.size() >= getMaxLivrosPermitidos()) {
            throw new Exception("Você já possui o número máximo de livros permitidos.");
        } else {
            livrosEmprestados.add(livro);
            livro.emprestarlivro(); // Chamada direta ao método emprestarlivro() de LivroFisico
        }
    }
        


  
    /**
     * Método para devolver um livro emprestado.
     * @param livro O livro físico a ser devolvido.
     * @throws Exception Exceção lançada caso o usuário não tenha o livro emprestado.
     */
    public void devolverLivro(LivroFisico livro){
        livrosEmprestados.remove(livro);
        livro.devolverlivro();
    }




    /**
     * Método para baixar um livro digital.
     * @param livro O livro digital a ser baixado.
     * @return Uma mensagem de sucesso.
     */
    public String baixarLivro(LivroDigital livro) {
        livrosBaixados.add(livro);
        return "Livro '" + livro.getTitulo() + "' baixado com sucesso.";
    }

    /**
     * Método abstrato para obter o número maximo de livros permitidos para o usuario.
     * @return O numero máximo de livros permitidos.
     */
    protected abstract int getMaxLivrosPermitidos();

}
