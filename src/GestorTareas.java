import Excepciones.TareaDuplicadaException;
import Excepciones.TareaNoEncontradaException;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private final List<Tarea> tareas;

    public GestorTareas() {
        tareas = new ArrayList<>();
    }

    public void agregar(String titulo, String descripcion, String prioridad) throws TareaDuplicadaException {
        Tarea tareaTemporal = buscadorTareas(titulo);
        if (tareaTemporal != null) {
            throw new TareaDuplicadaException();
        }
        Tarea tarea = new Tarea(titulo, descripcion, false, prioridad);
        tareas.add(tarea);
        System.out.println("╰ [INFO] La tarea se ha creado con éxito.");
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
        } else {
            throw new TareaNoEncontradaException(titulo);
        }
    }

    public void mostrarLista() {
        if (tareas.isEmpty()) {
            System.out.println("• [INFO] No hay ninguna tarea en la lista.");
            return;
        }
        for (Tarea tarea : tareas) {
            System.out.println(tarea);
        }
    }

    public void mostrarListaPorPrioridad(String prioridad) {
        boolean hayTareas = false;
        for (Tarea tarea : tareas) {
            if (tarea.obtenerPrioridad().equalsIgnoreCase(prioridad)) {
                System.out.println(tarea);
                hayTareas = true;
            }
        }
        if (!hayTareas) {
            System.out.println("╰ [INFO] No se encontraron tareas con prioridad: " + prioridad);
        }
    }

    private Tarea buscadorTareas(String titulo) {
        Tarea tareaTemporal = null;
        int indice = 0;
        while (indice < tareas.size() && tareaTemporal == null) {
            if (tareas.get(indice).obtenerTitulo().equalsIgnoreCase(titulo)) {
                tareaTemporal = tareas.get(indice);
            }
            indice++;
        }
        return tareaTemporal;
    }
}