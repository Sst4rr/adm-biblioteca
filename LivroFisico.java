
class LivroFisico extends Livro {

    private int copiasDisponiveis;
    private String status;


    public LivroFisico(Livro livro, int copiasDisponiveis) {
        super(livro.getTitulo(), livro.getAnoPublicacao(), livro.getAutor());
        this.copiasDisponiveis = copiasDisponiveis;
        this.status = "Disponível";
    }


    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public int getCopiasDisponiveis() {
        return this.copiasDisponiveis;
    }

    public void setCopiasDisponiveis(int copiasDisponiveis) {
        this.copiasDisponiveis = copiasDisponiveis;
    }


    public void emprestar() throws Exception {
        if(this.getCopiasDisponiveis()>1){
            this.setCopiasDisponiveis(this.getCopiasDisponiveis()-1);
            this.setStatus("Emprestado");
        } else if(this.getCopiasDisponiveis() == 1){
            this.setStatus("Emprestado");
            this.setCopiasDisponiveis(this.getCopiasDisponiveis()-1);
            System.out.println("Este é o último exemplar disponível.");
        } else{
            throw new Exception("Não há mais exemplares disponíveis.");
        }

    }


    public void devolver(){
        this.copiasDisponiveis++;
        this.status = "Disponível";
    }
}