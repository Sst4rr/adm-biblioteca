

class LivroFisico extends Livro {
    
    private int copiasDisponiveis;

    public LivroFisico(String titulo, String anoPublicacao, String autor, int copiasDisponiveis) {
        super(titulo, anoPublicacao, autor);
        this.copiasDisponiveis = copiasDisponiveis;
    }


    public int getCopiasDisponiveis(){
        return this.copiasDisponiveis;
    }
    
    public void setCopiasDisponiveis(int copiasDisponiveis){
        this.copiasDisponiveis = copiasDisponiveis;
    }
    

    //função emprestar
    public void emprestar(){
        if(this.copiasDisponiveis > 0){
            this.copiasDisponiveis--;
        }
    }

    //função devolver
    public void devolver(String titulo){
        this.copiasDisponiveis++;
    }
}