import java.util.ArrayList;
import java.util.List;

public class Usuario {
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

    // Métodos
    public void pegarLivro(LivroFisico livro) {
        livrosEmprestados.add(livro);
    }

    public void devolverLivro(LivroFisico livro) {
        livrosEmprestados.remove(livro);
    }

    public String baixarLivro(LivroDigital livro) {
        livrosBaixados.add(livro);
        return "Livro '" + livro.getTitulo() + "' baixado com sucesso.";
    }
}
