/**
 * Classe LivroDigital
 */

public class LivroDigital extends Livro {
    private String formato;
    private int tamanho;
    private String URL;

    /**
     * Construtor da classe LivroDigital.
     * @param titulo
     * @param anoPublicacao
     * @param autor
     * @param formato
     * @param tamanho
     * @param URL
     */
    public LivroDigital(String titulo, String anoPublicacao, String autor, String formato, int tamanho, String URL) {
        super(titulo, anoPublicacao, autor);
        this.formato = formato;
        this.tamanho = tamanho;
        this.URL = URL;
    }

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

    /**
     * Método para baixar um livro.
     * @return Mensagem de dowload do livro
     */
    public String baixarLivro() {
        return "Livro '" + this.getTitulo() + "' baixado com sucesso do seguinte URL: " + this.URL;
    }
}
