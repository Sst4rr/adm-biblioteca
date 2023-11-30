/**
 * Classe LivroDigital
 */

public class LivroDigital extends Livro {
    private String formato;
    private double tamanho;
    private String URL;

   
    public LivroDigital(String titulo, String anoPublicacao, String autor, String formato, double tamanho, String URL, String codigo) {
        super(titulo, anoPublicacao, autor, codigo);
        this.formato = formato;
        this.tamanho = tamanho;
        this.URL = URL;
    }

    public String getFormato() {
        return formato;
    }

     public double getTamanho() {
        return tamanho;
    }

    public String getURL() {
        return URL;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }


    public String baixarLivro() {
        return "Livro '" + this.getTitulo() + "' baixado com sucesso do seguinte URL: " + this.URL;
    }
}
