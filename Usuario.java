// public class Usuario {
//     private String nome;
//     private int idade;

//     public Usuario(String nome, int idade){
//         this.nome = nome;
//         this.idade = idade;
//     }

//     public String getNome(){
//         return this.nome;
//     }

//     public int getIdade(){
//         return this.idade;
//     }

//     public void setNome(String nome){
//         validarNome(nome);
//         this.nome = nome;
//     }
// }



// Classe Usuario como classe mãe
class Usuario {
    private int id;
    private String nome;
    // outros atributos comuns a usuários

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // getters e setters
}