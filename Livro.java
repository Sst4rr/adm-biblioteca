    
// Classe Livro como classe mãe
class Livro {
    private String titulo;
    private String anoPublicacao;
    private String autor;

    public Livro(String titulo, String anoPublicacao, String autor) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
    }

    // getter
    
    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public String getAnoPublicacao(){
        return this.anoPublicacao;
    }
    
    //setters

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setAnoPublicacao(String anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }
    
}






