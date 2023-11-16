public class Usuario {
    private String nome;
    private int idade;

    public Usuario(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setNome(String nome){
        validarNome(nome);
        this.nome = nome;
    }
}