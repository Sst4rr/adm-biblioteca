import java.util.ArrayList;
import java.util.List;

public abstract class Usuario{
    private String nome;
    private List<LivroFisico> livrosEmprestados;
    private List<LivroDigital> livrosBaixados;
    private List<LivroFisico> livrosEmPosse;

    // Construtor
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



    // Métodos
    public void pegarLivro(LivroFisico livro) throws Exception {
        if (livrosEmprestados.contains(livro)) {
            throw new Exception("Livro já emprestado para você!.");
        } else if (livrosEmprestados.size() >= getMaxLivrosPermitidos()) {
            throw new Exception("Você já possui o número máximo de livros permitidos.");
        }else{
            livrosEmprestados.add(livro);
            livro.emprestarlivro(this);
        }
        
    }



    public void devolverLivro(LivroFisico livro) {
        livrosEmprestados.remove(livro);
        livro.devolverlivro(this);
    }





    public String baixarLivro(LivroDigital livro) {
        livrosBaixados.add(livro);
        return "Livro '" + livro.getTitulo() + "' baixado com sucesso.";
    }

    
    protected abstract int getMaxLivrosPermitidos();

}
