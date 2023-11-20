/**
 * Classe que representa um usuário professor.
 */
public class UsuarioProfessor extends Usuario{
    private int codigo;
    private static final int MAX_LIVROS_PROFESSOR = 10;
    /**
     * Construtor da classe UsuarioProfessor.
     * @param nome O nome do Usuário
     * @param codigo  O código do Usuário
     */
    public UsuarioProfessor (String nome, int codigo){
        super(nome);
        this.codigo = codigo;
    }

    public int getcodigo(){
        return codigo;
    }

    @Override
    protected int getMaxLivrosPermitidos() {
        return MAX_LIVROS_PROFESSOR;
    }

}