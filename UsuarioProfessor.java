
public class UsuarioProfessor extends Usuario{
    private int codigo;
    private static final int MAX_LIVROS_PROFESSOR = 20;
    
    
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