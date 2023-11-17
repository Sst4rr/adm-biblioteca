// // public class Usuario {
// //     private String nome;
// //     private int idade;

// //     public Usuario(String nome, int idade){
// //         this.nome = nome;
// //         this.idade = idade;
// //     }

// //     public String getNome(){
// //         return this.nome;
// //     }

// //     public int getIdade(){
// //         return this.idade;
// //     }

// //     public void setNome(String nome){
// //         validarNome(nome);
// //         this.nome = nome;
// //     }
// // }



// // Classe Usuario como classe mãe
// class Usuario {
//     private int id;
//     private String nome;
//     // outros atributos comuns a usuários

//     public Usuario(int id, String nome) {
//         this.id = id;
//         this.nome = nome;
//     }

//     // getters e setters
// }


public class Usuario {
        //Variáveis//
    private String nome;
    private int idade;
    private char sexo;
    private int iD;

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
}