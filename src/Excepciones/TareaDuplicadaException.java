package Excepciones;

public class TareaDuplicadaException extends RuntimeException {
    public TareaDuplicadaException() {
        super("La tarea ya esta en la lista.");
    }
}
