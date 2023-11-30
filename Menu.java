import java.util.Scanner;

import java.util.List;

public class Menu{

    public Menu(){
        Biblioteca biblioteca = new Biblioteca();
        Scanner input = new Scanner(System.in);
        int a=0;

        while (a!=3) {
            System.out.println("=====================================\n O que você deseja fazer?\n1. Mexer em livros\n2. Mexer em Usuarios\n3-Encerrar programa");
            a = input.nextInt();
            if(a==1){

                System.out.print("1. Adicionar livro\n2. Remover livro\n3. Realizar empréstimo\n4. Devolver livro\n5. Listar livros\n6. Listar livros emprestados\n7Listar livros disponíveis\n8. Sair\n\n");
                int b = input.nextInt();

                switch (b) {
                case 1:
                    
                //adicionar livro
                    System.out.println("Digite o nome do livro que você deseja adicionar: ");
                    String nome = input.next();
                    input.nextLine();
                    System.out.println("Digite o respectivo nome do autor: ");
                    String autor = input.next();
                    input.nextLine();
                    System.out.println("Digite o ano de publicação: ");
                    String ano = input.next();
                    input.nextLine();
                    System.out.println("Digite o número de exemplares disponíveis: ");
                    int exemplaresDisponiveis = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite o código do livro: ");
                    String codigo = input.next();
                    


                    
                    Livro livro01 = new Livro(nome, ano, autor, codigo);
                    biblioteca.adicionarLivro(livro01);
                    LivroFisico livroF01 = new LivroFisico(livro01, exemplaresDisponiveis);
                    //vai dar erro por que vai repetir nome de variável
                    break;
            
                case 2:
                    System.out.println("Digite o nome do livro que você deseja remover? ");
                    String nomeRemover = input.next();
                    biblioteca.removerLivro(nomeRemover);
                    break;
                    //remover por codigo

                case 3:
                    //emprestar livro: primeiro vai mostrar a lista de livros
                    System.out.println("Digite o nome do livro que você deseja buscar: ");
                    String nomeBuscar = input.next();
                    List<LivroFisico> livrosEncontrados = biblioteca.buscarLivro(nomeBuscar);


                    //depois o usuário vai digitar o respectivo código do livro desejado
                    System.out.println("Informe o livro que deseja com base no seu código: ");
                    String codigoLivroEscolhido = input.next();
                    LivroFisico emprestimo = null;
                    for(LivroFisico livro02: livrosEncontrados){
                        if(livro02.getCodigo().equals(codigoLivroEscolhido)){
                            emprestimo = livro02;
                            break;
                        }
                    }
                    if(emprestimo != null){
                        System.out.println("Informe o código do usuário que vai receber o livro: ");
                        int idAcharUsuario = input.nextInt();
                        Usuario usuario = biblioteca.descobrirUsuario(idAcharUsuario);

                        try{
                            biblioteca.realizarEmprestimo(usuario, emprestimo);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    //System.out.println("Digite o codigo do usuario que vai receber o livro: ");
                    //int codigo = input.nextInt();
                    //Usuario user = biblioteca.buscarUsuario(codigo);
                    //LivroFisico livroEncontrado = biblioteca.buscarLivro(nome);
                    //biblioteca.realizarEmprestimo(user, livroEncontrado);
                    break;
                case 4:
                    //devolver livro
                    System.out.println("Digite o codigo do aluno ou professor que deseja devolver o livro: ");
                    int codUser01 = input.nextInt();
                    Usuario usuarioDevolverLivro = biblioteca.descobrirUsuario(codUser01);
                    System.out.println("Digite o código do livro a ser devolvido: ");
                    String livroASerDevolvido = input.next();
                    LivroFisico livroDevolucao = biblioteca.buscarLivroPorId(livroASerDevolvido);
                    biblioteca.devolverEmprestimo(usuarioDevolverLivro, livroDevolucao);
                    break;
                case 5:
            }
            
            
                // //remover livro
                // else if(b == 2){
                    
                // }
                // //realizar emprestimo
                // else if(b == 3){

                // } else if(b == 4){
                    
                // }

                
            }else if(a == 2){
                System.out.print("1. Adicionar usuário\n2. Remover usuário\n3. Buscar usuário\n5. Listar Usuario\n6. Sair\n");
                int c = input.nextInt();
                
                switch (c) {
                    case 1:
                        System.out.println("\n1. Cadastrar Aluno;\n2. Cadastrar Professor.");
                        int opcaoCadastro = input.nextInt();
                        
                        if(opcaoCadastro == 1){
                            System.out.println("Informe o nome do Aluno: ");
                            String nomeUser = input.next();
                            System.out.println("Informe a matrícula do Aluno: ");
                            int matricula = input.nextInt();

                            UsuarioAluno userAluno = new UsuarioAluno(nomeUser, matricula);
                            biblioteca.cadastrarUsuario(userAluno);
                        } else if(opcaoCadastro == 2){
                            System.out.println("Informe o nome do Professor: ");
                            String nomeUser = input.next();
                            System.out.println("Informe o código do Professor: ");
                            int codigo = input.nextInt();

                            UsuarioProfessor userProfessor = new UsuarioProfessor(nomeUser, codigo);
                            biblioteca.cadastrarUsuario(userProfessor);
                        } else{
                            System.out.println("Esse código não existe no sistema ");
                        }
                        break;

                    case 2:
                        System.out.println("Informe o Usuário que deseja remover: ");
                        String nomeUser = input.next();

                        biblioteca.removerUsuario(nomeUser);
                        
                
                    default:
                        break;
                }
            }
        }
    }

}