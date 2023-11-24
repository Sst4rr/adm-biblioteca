public class Main {
    //trocar para Main

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        //criação cadastro usuário Aluno

        UsuarioAluno aluno01 = new UsuarioAluno("Marcos", 01);
        UsuarioAluno aluno02 = new UsuarioAluno("Pedro", 02);
        UsuarioAluno aluno03 = new UsuarioAluno("Sabryna", 03);
        UsuarioAluno aluno04 = new UsuarioAluno("Sandra", 04);
        UsuarioAluno aluno05 = new UsuarioAluno("Brenda", 05);

        biblioteca.cadastrarUsuario(aluno01);
        biblioteca.cadastrarUsuario(aluno02);
        biblioteca.cadastrarUsuario(aluno03);
        biblioteca.cadastrarUsuario(aluno04);
        biblioteca.cadastrarUsuario(aluno05);
        
        //criação cadastro usuario Professor
        UsuarioProfessor prof01 = new UsuarioProfessor("José Antônio", 01);
        UsuarioProfessor prof02 = new UsuarioProfessor("Antonieta", 2);

        biblioteca.cadastrarUsuario(prof01);
        biblioteca.cadastrarUsuario(prof02);
        //criação cadastro Livros

        Livro livro01 = new Livro("o pequeno principe", "1932", "Antoine de Saint-Exupéry");
        Livro livro02 = new Livro("harry potter e a pedra filosofal", "1997", "J. K. Rowling");

        //Adicionar livros a biblioteca
        biblioteca.adicionarLivro(livro01);
        biblioteca.adicionarLivro(livro02);

        //buscar livro
        System.out.println(biblioteca.buscarLivro("o pequeno principe"));

        //buscar usuario
        biblioteca.buscarUsuario(01);
        //tem que sobrescrever isso aqui pq n printa direto

    }
}

