import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    public Menu() {
        Biblioteca biblioteca = new Biblioteca();
        Scanner input = new Scanner(System.in);
        int a = 0;

        while (a != 3) {
            System.out.println(
                    "=====================================\n O que você deseja fazer?\n1. Mexer em livros\n2. Mexer em Usuarios e seus dados\n3. Encerrar programa");
            a = input.nextInt();
            if (a == 1) {

                System.out.print(
                        "=====================================\n0. Buscar livro\n1. Adicionar livro\n2. Remover livro\n3. Realizar empréstimo\n4. Devolver livro\n5. Listar todos os livros \n6. Baixar livro\n7. Sair\n\n");
                int b = input.nextInt();

                switch (b) {

                    case 0:

                        System.out.println("\nDigite o nome do livro que você quer buscar: ");
                        input.nextLine();
                        String buscarLivro = input.nextLine();
                        List<LivroFisico> livrosEncontrados = biblioteca.buscarLivroFisico(buscarLivro);
                        
                        if (!livrosEncontrados.isEmpty()) {
                            System.out.println("Livros encontrados:");
                            for (LivroFisico livroEncontrado : livrosEncontrados) {
                                System.out.println("Código: " + livroEncontrado.getCodigo() + " Título: " + livroEncontrado.getTitulo());
                            }
                        }
                        break;
                    case 1:

                        // adicionar livro
                        System.out.println(
                                "==================================\nDigite o nome do livro que você deseja adicionar: ");
                        input.nextLine();
                        String nome = input.nextLine();

                        System.out.println("Digite o respectivo nome do autor: ");
                        String autor = input.nextLine();

                        System.out.println("Digite o ano de publicação: ");
                        String ano = input.next();
                        input.nextLine();

                        System.out.println("Digite o número de exemplares disponíveis: ");
                        int exemplaresDisponiveis = input.nextInt();
                        input.nextLine();

                        System.out.println(
                                "Para o livro no formato digital, insira o link de dowload do respectivo livro: ");
                        String urlLivroDigital = input.nextLine();

                        System.out.println("Agora digite o formato do livro, ex: pdf, mobi, epub e etc:  ");
                        String formatoLivroDigital = input.nextLine();

                        System.out.println("Insira o tamanho do arquivo do livro: ");
                        double tamanhoDoArquivo = input.nextDouble();
                        input.nextLine();

                        System.out.println("Digite o código do livro: ");
                        String codigo = input.next();

                        Livro livro01 = new Livro(nome, ano, autor, codigo);
                        biblioteca.adicionarLivro(livro01);
                        LivroFisico livroF01 = new LivroFisico(livro01, exemplaresDisponiveis);
                        biblioteca.adicionarLivro(livroF01);
                        LivroDigital livroD01 = new LivroDigital(livro01, formatoLivroDigital, tamanhoDoArquivo,
                                urlLivroDigital);
                        biblioteca.adicionarLivro(livroD01);
                        // vai dar erro por que vai repetir nome de variável
                        break;

                    case 2:
                        // remover livro
                        System.out.println(
                                "==================================\nDigite o nome do livro que você deseja remover? ");
                        input.nextLine();
                        String nomeRemover = input.nextLine();
                        biblioteca.removerLivro(nomeRemover);
                        break;

                    case 3:
                        // emprestar livro: primeiro vai mostrar a lista de livros
                        System.out.println(
                                "==================================\nDigite o nome do livro que você deseja buscar: ");
                        String nomeBuscar = input.next();
                        List<LivroFisico> livroEncontrado = biblioteca.buscarLivroFisico(nomeBuscar);

                        // depois o usuário vai digitar o respectivo código do livro desejado
                        System.out.println("Informe o livro que deseja com base no seu código: ");
                        String codigoLivroEscolhido = input.next();
                        LivroFisico emprestimo = null;
                        for (LivroFisico livro02 : livroEncontrado) {
                            if (livro02.getCodigo().equals(codigoLivroEscolhido)) {
                                emprestimo = livro02;
                                break;
                            }
                        }
                        if (emprestimo != null) {
                            System.out.println("Informe o código do usuário que vai receber o livro: ");
                            int idAcharUsuario = input.nextInt();
                            Usuario usuario02 = biblioteca.descobrirUsuario(idAcharUsuario);

                            try {
                                biblioteca.realizarEmprestimo(usuario02, emprestimo);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        break;

                    case 4:
                        // devolver livro
                        System.out.println(
                                "====================================\nDigite o codigo do aluno ou professor que deseja devolver o livro: ");
                        int codUser01 = input.nextInt();
                        Usuario usuarioDevolverLivro = biblioteca.descobrirUsuario(codUser01);
                        System.out.println("Digite o código do livro a ser devolvido: ");
                        String livroASerDevolvido = input.next();

                        LivroFisico livroDevolucao = biblioteca.buscarLivroPorId(livroASerDevolvido);
                        biblioteca.devolverEmprestimo(usuarioDevolverLivro, livroDevolucao);
                        break;
                    case 5:
                        System.out.println("Os livros pertecententes a Biblioteca estão listados na lista a baixo: ");
                        biblioteca.ImprimirTodosOsLivros();
                        break;

                    case 6:
                        System.out.println("Digite o código do livro que você deseja baixar: ");
                        String codBaixar = input.next();
                        input.nextLine();
                        LivroDigital livroDigital = biblioteca.buscarLivroDigitalPorId(codBaixar);
                        break;

                    case 7:
                        // sair dessa aba
                        break;
                }

            } else if (a == 2) {
                System.out.print(
                        "1. Adicionar usuário\n2. Remover usuário\n3. Buscar usuário\n4. Listar Usuario\n5. Listar livros em posse de usuário\n6. Mostrar histórico de empréstimos\n7. Sair\n");
                int c = input.nextInt();

                switch (c) {
                    case 1:

                        System.out.println("\n1. Cadastrar Aluno;\n2. Cadastrar Professor.");
                        int opcaoCadastro = input.nextInt();

                        if (opcaoCadastro == 1) {
                            System.out.println("Informe o nome do Aluno: ");
                            String nomeUser = input.next();
                            System.out.println("Informe a matrícula do Aluno: ");
                            int matricula = input.nextInt();

                            UsuarioAluno userAluno = new UsuarioAluno(nomeUser, matricula);
                            biblioteca.cadastrarUsuario(userAluno);

                        } else if (opcaoCadastro == 2) {
                            System.out.println("Informe o nome do Professor: ");
                            String nomeUser = input.next();
                            System.out.println("Informe o código do Professor: ");
                            int codigo = input.nextInt();

                            UsuarioProfessor userProfessor = new UsuarioProfessor(nomeUser, codigo);
                            biblioteca.cadastrarUsuario(userProfessor);
                        } else {
                            System.out.println("Esse código é inválido! ");
                            break;
                        }

                        break;

                    case 2:
                        System.out.println("Informe o Usuário que deseja remover: ");
                        String nomeUser = input.next();
                        input.nextLine();
                        biblioteca.removerUsuario(nomeUser);
                        break;

                    case 3:
                        // buscar usuario
                        System.out.println("Informe o id do usuário que deseja buscar: ");
                        int idUser = input.nextInt();
                        List<Usuario> usuariosEncontrados03 = biblioteca.buscarUsuario(idUser);
                        break;

                    case 4:
                        // listar usuarios

                        biblioteca.listarUsuarios();
                        break;

                    case 5:
                        // Listar livros em posses de usuários
                        System.out.println("Informe o Id do usuário: ");
                        int idUsuario = input.nextInt();
                        input.nextLine();

                        Usuario usuarioEPosses = biblioteca.descobrirUsuario(idUsuario);
                        biblioteca.imprimirLivrosEmPosse(usuarioEPosses);

                        break;

                    case 6:
                        // Mostrar histórico de empréstimos
                        System.out.println("Digite id de usuario:");
                        int idUser01 = input.nextInt();
                        Usuario usuarioHistorico = biblioteca.descobrirUsuario(idUser01);
                        biblioteca.historicoLivros(usuarioHistorico);
                        break;

                    case 7:
                        // sair dessa aba
                        break;

                }
            }
        }
    }

}