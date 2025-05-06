package test.projeto.excecoes;

public class AutorNotFoundException extends RuntimeException {

    public AutorNotFoundException() {
        super("Autor não encontrado.");
    }

    public AutorNotFoundException(String message) {
        super(message);
    }
}
