import java.util.Scanner;

public class Menu{

    public Menu(){
        Biblioteca biblioteca = new Biblioteca();
        Scanner input = new Scanner(System.in);

        System.out.println("=====================================\n O que você deseja fazer?\n1. Mexer em livros\n2. Mexer em Usuarios\n");
        
        int a = input.nextInt();
        if(a == 1){
            System.out.print("1. Adicionar livro\n2. Remover livro\n3. Realizar empréstimo\n4. Devolver livro\n5. Listar livros\n6. Listar livros emprestados\n7Listar livros disponíveis\n8. Sair\n\n");
            int b = input.nextInt();
            if(b == 1){
                System.out.println("Digite o nome do livro");
                String nome = input.nextLine();
                System.out.println("Digite o nome do autor");
                String autor = input.nextLine();
                System.out.println("Digite o ano de publicação");
                String ano = input.nextLine();
                System.out.println("Digite o número de exemplares disponíveis");

                int exemplaresDisponiveis = input.nextInt();
                Livro livro01 = new Livro(nome, ano, autor);
                biblioteca.adicionarLivro(livro01);
                LivroFisico livroF01 = new LivroFisico(livro01, exemplaresDisponiveis);
            } else if()

            
        }else if(a == 2){
            System.out.print("1. Adicionar usuário\n2. Remover usuário\n3. Buscar usuário\n5. Listar Usuario\n6. Sair\n");
            int c = input.nextInt();
            if(c==1){
                System.out.println("Digite o nome so usuáro:");
                String nomeUser = input.nextLine();
                Usuario user = new Usuario(nomeUser);

            }
        }
    }
}