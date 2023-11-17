import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe UsuarioProfessor como extensão de Usuario
class UsuarioProfessor extends Usuario{
    //Variáveis//
    private long matricula;
    private String ministrar;

    //Construtores//
    public UsuarioProfessor(String nome, int idade, char sexo, int iD, long matricula, String ministrar){
        super(nome, idade, sexo, iD);
        this.matricula = matricula;
        this.ministrar = ministrar;
    }

    //Método get//
    public long getMatricula(){
        return matricula;
    }

    public String getMinistrar(){
        return ministrar;
    }


    //Método set//

    public void setMatricula(long novaMatricula){
        this.matricula = novaMatricula;
    }

    public void setMinistrar(String novaMinistrar){
        this.ministrar = novaMinistrar;
    }
    
    
}
