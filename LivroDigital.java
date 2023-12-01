/**
 * Classe LivroDigital
 */

public class LivroDigital extends Livro {
    private String formato;
    private double tamanho;
    private String URL;

   
    public LivroDigital(Livro livro, String formato, double tamanho, String URL) {
        super(livro.getTitulo(), livro.getAnoPublicacao(), livro.getAutor(), livro.getCodigo());
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

    //sabemos que a função não tinha que receber parametro, mas a forma que a gente fez, para passar o respectivo link do livro para
    //o usuario, tivemos que passar paramentro
    public String baixarLivro(LivroDigital livro) {
        return "Dowload do arquivo em "+getFormato()+" com o tamanho "+getTamanho()+" será encontrado no seguinte link: "+getURL();
    }
}
