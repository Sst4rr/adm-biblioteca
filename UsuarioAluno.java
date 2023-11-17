import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe UsuarioAluno como extensão de Usuario
class UsuarioAluno extends Usuario{
    //Váriaveis//
   private long matricula;

   //Construtores// 
   public UsuarioAluno(String nome, int idade, char sexo, int iD, long matricula){
        super(nome, idade, sexo, iD);
        this.matricula = matricula;
   }

    //Métodos Get//

    public long setMatricula(){
        return matricula;
    }


    //Métodos Set//

    public void getMatricula(long novaMatricula){
        this.matricula = novaMatricula;
    }

}