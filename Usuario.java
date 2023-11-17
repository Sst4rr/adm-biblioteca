
import java.util.List;

public class Usuario {
        //Variáveis//
    private String nome;
    private List<livrosEmprestados> livrosEmprestados;
    private List<LivrosBaixado> livrosBaixados;
    private List<livroEmPosse> livroFisico;

        //Construtores//

    public Usuario(String nome, int idade, char sexo, int iD){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.iD = iD;
    }

        //Métodos get//

    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }

    
    public char getSexo(){
        return sexo;
    }

    public int getId(){
        return iD;
    }   


        //Métodos set//


    public void setNome(String nome){
        //validarNome(nome);
        this.nome = nome;
    }

    public void setIdade(int novaIdade){
        this.idade = novaIdade;
    }
    
    public void setSexo(char novoSexo){
        this.sexo = novoSexo;
    }
    
    public void setId(int novoID){
        this.iD = novoID;
    }

    //pegarLivro 



    public void devolverLivro(LivroFisico livro){
        this.livrosEmprestados.remove(livro);
        Livro devolverLivro = new devolver()
    }

}