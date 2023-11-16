import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



// Classe LivroDigital como extensão de Livro
class LivroDigital extends Livro {
    // Atributos específicos para livros digitais, se houver
    private String formato;

    public LivroDigital(int id, String titulo, String autor, String formato) {
        super(id, titulo, autor);
        this.formato = formato;
    }

    // getters e setters
}