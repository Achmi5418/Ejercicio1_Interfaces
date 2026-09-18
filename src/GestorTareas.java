import Excepciones.TareaDuplicadaException;
import Excepciones.TareaNoEncontradaException;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private final List<Tarea> tareas;

    public GestorTareas() {
        tareas = new ArrayList<>();
    }

    public void agregar(String titulo, String descripcion) throws TareaDuplicadaException {
        Tarea tareaTemporal = buscadorTareas(titulo, descripcion);
        if (tareaTemporal != null) {
            throw new TareaDuplicadaException();
        }
        Tarea tarea = new Tarea(titulo, descripcion, false);
        tareas.add(tarea);
        System.out.println("╰ [INFO] La tarea se ha creado.");
    }

    public void eliminar(String titulo) throws TareaNoEncontradaException {
        Tarea tareaTemporal = buscadorTareas(titulo);
        if (tareaTemporal != null) {
            tareas.remove(tareaTemporal);
            System.out.println("╰ [INFO] La tarea se ha eliminado.");
        } else {
            throw new TareaNoEncontradaException(titulo);
        }
    }

    public void marcarCompletado(String titulo) throws TareaNoEncontradaException {
        Tarea tareaTemporal = buscadorTareas(titulo);
        if (tareaTemporal != null && !tareaTemporal.estaCompletado()) {
            tareaTemporal.establecerCompletado(true);
            System.out.println("╰ [INFO] La tarea se ha completado.");
        } else if (tareaTemporal != null) {
            System.out.println("╰ [INFO] La tarea ya está completada.");
        }  else {
            throw new TareaNoEncontradaException(titulo);
        }
    }

    public void mostrarLista() {
        for (Tarea tarea : tareas) {
            System.out.println(tarea);
        }
        if (tareas.isEmpty()) {
            System.out.println("• [ERROR] No hay ninguna tarea en la lista.");
        }
    }

    private Tarea buscadorTareas(String titulo, String descripcion) {
        Tarea tareaTemporal = null;
        int indice = 0;
        while (indice < tareas.size() && tareaTemporal == null) {
            if (tareas.get(indice).obtenerTitulo().equals(titulo) && tareas.get(indice).obtenerDescripcion().equals(descripcion)) {
                tareaTemporal = tareas.get(indice);
            }
            indice++;
        }
        return tareaTemporal;
    }

    private Tarea buscadorTareas(String titulo) {
        Tarea tareaTemporal = null;
        int indice = 0;
        while (indice < tareas.size() && tareaTemporal == null) {
            if (tareas.get(indice).obtenerTitulo().equals(titulo)) {
                tareaTemporal = tareas.get(indice);
            }
            indice++;
        }
        return tareaTemporal;
    }
}
