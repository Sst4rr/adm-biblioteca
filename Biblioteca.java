import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe Biblioteca para gerenciar tudo
class Biblioteca {
    private Map<Integer, Livro> livros;
    private Map<Integer, Usuario> usuarios;

    public Biblioteca() {
        this.livros = new HashMap<>();
        this.usuarios = new HashMap<>();
    }

    // Métodos para cadastrar livros e usuários, empréstimos, devoluções, etc.
}
