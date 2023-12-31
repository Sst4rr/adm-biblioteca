import java.util.ArrayList;
import java.util.List;


public abstract class Usuario{
    private String nome;
    private List<LivroFisico> livrosEmprestados;
    private List<LivroDigital> livrosBaixados;
    private List<LivroFisico> livrosEmPosse;


    public Usuario(String nome) {
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
        this.livrosBaixados = new ArrayList<>();
        this.livrosEmPosse = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
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

    public void pegarLivro(LivroFisico livro) throws Exception {
        if (livrosEmPosse.contains(livro)) {
            throw new Exception("Livro já emprestado para você!");
        } else if (livrosEmprestados.size() >= getMaxLivrosPermitidos()) {
            throw new Exception("Você já possui o número máximo de livros permitidos.");
        } else {
            livrosEmPosse.add(livro);
        }
    }
        
    public void devolverLivro(LivroFisico livro){
        livrosEmPosse.remove(livro);
        livrosEmprestados.add(livro);
        System.out.println("Livro '" + livro.getTitulo() + "' devolvido com sucesso.");
    }

    public String baixarLivro(LivroDigital livro) {
        livrosBaixados.add(livro);
        return "Livro" + livro.getTitulo() + "' baixado com sucesso.";
    }

    public String livrosEmprestadosToString() {
        String livros = "";
        for (LivroFisico livro : livrosEmprestados) {
            livros += livro.getTitulo() + ", ";
        }
        return livros;
    }
    
    protected abstract int getMaxLivrosPermitidos();

}
