
/**
 * Classe LivroFisico que representa um livro físico.
 */
class LivroFisico extends Livro {

    private int copiasDisponiveis;

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
    }

    // teste

    public int getCopiasDisponiveis() {
        return this.copiasDisponiveis;
    }

    public void setCopiasDisponiveis(int copiasDisponiveis) {
        this.copiasDisponiveis = copiasDisponiveis;
    }

    /**
     * Método para emprestar um livro.
     * 
     * @param usuario O usuário que está emprestando o livro
     */
    public void emprestarlivro(Usuario usuario) {
        if (this.copiasDisponiveis > 0) {
            this.copiasDisponiveis--;
        } else {
            System.out.println("Não há mais exemplares disponíveis. Tente de novo futuramente!");
        }
    }

    /**
     * Método para devolver um livro.
     * 
     * @param usuario O usuário que está devolvendo o livro.
     */
    public void devolverlivro(Usuario usuario) {
        this.copiasDisponiveis++;
    }
}