package test.projeto.excecoes;

public class LivroNotFoundException extends RuntimeException {

    public LivroNotFoundException(){
        super("Livro não encontrado");
    }

    public LivroNotFoundException(String message) {
        super(message);
    }

}
