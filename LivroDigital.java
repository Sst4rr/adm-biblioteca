import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



// Classe LivroDigital como extensão de Livro
class LivroDigital extends Livro {
    // Atributos específicos para livros digitais, se houver
    private String formato;

    public LivroDigital(String titulo, String anoPublicacao, String autor, String formato) {
        super(titulo, anoPublicacao, autor);
        this.formato = formato;
    }

    // getters e setters
}