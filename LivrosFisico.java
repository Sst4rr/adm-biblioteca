
// Classe LivroFisico como extensão de Livro
class LivroFisico extends Livro {
    // Atributos específicos para livros físicos, se houver
    private int quantidadeDisponivel;

    public LivroFisico(int id, String titulo, String autor, int quantidadeDisponivel) {
        super(id, titulo, autor);
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    // getters e setters
}