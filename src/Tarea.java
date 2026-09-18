public class Tarea {
    private final String titulo;
    private final String descripcion;
    private boolean completado;

    public Tarea(String titulo, String descripcion, boolean completado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completado = completado;
    }

    public String obtenerTitulo() {
        return titulo;
    }

    public String obtenerDescripcion() {
        return descripcion;
    }

    public boolean estaCompletado() {
        return completado;
    }

    public void establecerCompletado(boolean completado) {
        this.completado = completado;
    }

    @Override
    public String toString() {
        String icono;
        String mensaje;
        if (completado) {
            icono = "☑";
            mensaje = "Hecho";
        } else {
            icono = "☐";
            mensaje = "Por hacer";
        }
        return String.format("╭ Nombre: %s\n│ ╭ Descripción: %s\n╰ ╰ %s Estado: %s", titulo, descripcion, icono, mensaje);
    }
}