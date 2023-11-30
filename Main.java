public class Main {
    //trocar para Main

    public static void main(String[] args) throws Exception {
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
        UsuarioProfessor prof02 = new UsuarioProfessor("Antonieta", 02);
        UsuarioProfessor prof03 = new UsuarioProfessor("Jurandir", 03);
        UsuarioProfessor prof04 = new UsuarioProfessor("Maicon Douglas", 04);
        UsuarioProfessor prof05 = new UsuarioProfessor("Joefferson Silva", 05);

        biblioteca.cadastrarUsuario(prof01);
        biblioteca.cadastrarUsuario(prof02);
        biblioteca.cadastrarUsuario(prof03);
        biblioteca.cadastrarUsuario(prof04);
        biblioteca.cadastrarUsuario(prof05);
        //criação cadastro Livros

        Livro livro01 = new Livro("o pequeno principe", "1932", "Antoine de Saint-Exupéry", "01");
        Livro livro02 = new Livro("harry potter e a pedra filosofal", "1997", "J. K. Rowling", "02");
        Livro livro03 = new Livro("A morte do José", "2003", "Mariollo","03");
        Livro livro04 = new Livro("Casa da Árvore", "1890", "Mariellen Almeida","04");
        Livro livro05 = new Livro("Monstro so Lago", "1909", "Albert Nirlen","05");

        //Adicionar livros a biblioteca
        biblioteca.adicionarLivro(livro01);
        biblioteca.adicionarLivro(livro02);
        biblioteca.adicionarLivro(livro03);
        biblioteca.adicionarLivro(livro04);
        biblioteca.adicionarLivro(livro05);

        //Adicionar livros físicos
        LivroFisico livroF01 = new LivroFisico(livro01,2);
        LivroFisico livroF02 = new LivroFisico(livro02,10);
        //Realizar emprestimo
        biblioteca.realizarEmprestimo(aluno01, livroF01);
    
        biblioteca.realizarEmprestimo(aluno05, livroF01);
        
        biblioteca.realizarEmprestimo(aluno02, livroF01);

        biblioteca.realizarEmprestimo(aluno03, livroF02);
        

        //buscar livro
        System.out.println(biblioteca.buscarLivro("o pequeno principe"));

        // //buscar usuario
        biblioteca.buscarUsuario(01);

        // devolver emprestimo
        biblioteca.devolverEmprestimo(aluno01, livroF01);
        biblioteca.devolverEmprestimo(aluno01, livroF01);
        

        // biblioteca.listarLivrosDisponiveis();
        

    }
}

