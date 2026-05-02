package excecoes;

public class SistemaFinalizadoException extends Exception {
    public SistemaFinalizadoException() {
        super("Sistema encerrado");
    }
}
