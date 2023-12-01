
public class UsuarioAluno extends Usuario{
    private int matricula;
    private static final int MAX_LIVROS_ALUNO = 5;


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