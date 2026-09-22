public class Tarea {
    private final String titulo;
    private final String descripcion;
    private boolean completado;
    private final String prioridad; // Añadimos prioridad y lo inicializamos en todo el codigo

    public Tarea(String titulo, String descripcion, boolean completado, String prioridad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completado = completado;
        this.prioridad = prioridad;
    }

    public String obtenerTitulo() {
        return titulo;
    }

    public String obtenerDescripcion() {
        return descripcion;
    }

    public String obtenerPrioridad() {
        return prioridad;
    }

    public boolean estaCompletado() {
        return completado;
    }

    public void establecerCompletado(boolean completado) {
        this.completado = completado;
    }

    @Override
    public String toString() {
        String icono = completado ? "☑" : "☐";
        String mensaje = completado ? "Hecho" : "Por hacer";

        return String.format(
                "╭ Nombre: %s\n" +
                        "│ Descripción: %s\n" +
                        "│ Prioridad: %s\n" +
                        "╰ %s Estado: %s",
                titulo, descripcion, prioridad, icono, mensaje
        );
    }
}