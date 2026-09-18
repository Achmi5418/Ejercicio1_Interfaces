package Excepciones;

public class TareaNoEncontradaException extends RuntimeException {
    public TareaNoEncontradaException(String nombre) {
        super("La tarea con el nombre \"" + nombre + "\" no existe");
    }
}
