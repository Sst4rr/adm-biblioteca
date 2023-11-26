
/**
 * Classe LivroFisico que representa um livro físico.
 */
class LivroFisico extends Livro {

    private int copiasDisponiveis;
    private String status;

    /**
     * Construtor da classe LivroFisico.
     * 
     * @param titulo            Titulo do livro
     * @param anoPublicacao     Ano de publicação do livro
     * @param autor             Autor do livro
     * @param copiasDisponiveis Quantidade de cópias disponíveis do livro
     */
    public LivroFisico(String titulo, String anoPublicacao, String autor, int copiasDisponiveis) {
        super(titulo, anoPublicacao, autor);
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

    /**
     * Função para reaização de empréstimos de livro físico;
     * Verificar se há cópias diponíveis e decrementa se houver;
     * Caso não haja cópias retorna um erro .    
     * * @return String com o resultado.
     */
    public String realizarEmprestimo(){
        if(this.getCopiasDisponiveis()>1){
            this.setCopiasDisponiveis(this.getCopiasDisponiveis()-1);
            this.setStatus("Emprestado");
            return "Livro emprestado.";
        } else if(this.getCopiasDisponiveis() == 1){
            this.setStatus("Emprestado");
            this.setCopiasDisponiveis(0);
            return "Ultima cópia emprestada. Não há mais exemplares, tente novamente após 7 dias.";
        } else{
            return "Não há mais exemplares disponíveis.";
        }

    }

    /**
     * Método para devolver um livro.
     * 
     * @param usuario O usuário que está devolvendo o livro.
     */
    public void devolverlivro() {
        this.copiasDisponiveis++;
        this.status = "Disponível";
    }
}