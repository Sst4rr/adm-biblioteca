    

class Livro {
    private String titulo;
    private String anoPublicacao;
    private String autor;
    private String codigo;

    public Livro(String titulo, String anoPublicacao, String autor, String codigo) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
        this.codigo = codigo;
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

    public String getCodigo(){
        return this.codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
}






