
/**
 * Classe que representa um usuário do tipo aluno.
 */
public class UsuarioAluno extends Usuario{
    private int matricula;
    private static final int MAX_LIVROS_ALUNO = 5;

    /**
     * Construtor da classe UsuarioAluno.
     * @param nome O nome do Usuário
     * @param matricula   A matricula do Usuário
     */
    public UsuarioAluno (String nome, int matricula){
        super(nome);
        this.matricula = matricula;
    }

    public int getMatricula(){
        return matricula;
    }

    @Override
    protected int getMaxLivrosPermitidos() {
        return MAX_LIVROS_ALUNO;
    }




}