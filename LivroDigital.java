public class LivroDigital extends Livro {
    private String formato;
    private int tamanho;
    private String URL;

    // Construtor
    public LivroDigital(String titulo, String autor, String formato, int tamanho, String URL) {
        super(titulo, autor);
        this.formato = formato;
        this.tamanho = tamanho;
        this.URL = URL;
    }

    // Getters e Setters
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    // Método para baixar o livro
    public String baixarLivro() {
        // Lógica simulada de baixar o livro
        return "Livro '" + this.getTitulo() + "' baixado com sucesso do seguinte URL: " + this.URL;
    }
}
