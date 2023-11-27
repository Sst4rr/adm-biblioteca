    

class Livro {
    private String titulo;
    private String anoPublicacao;
    private String autor;

    public Livro(String titulo, String anoPublicacao, String autor) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
    }

    // Construtor de cópia
    @Override
    public String toString(){
        return "Livro:" + this.titulo + ", Autor:" + this.autor + ", Ano de Publicação:" + this.anoPublicacao;
    }
    
    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public String getAnoPublicacao(){
        return this.anoPublicacao;
    }
    
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






