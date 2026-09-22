import Excepciones.TareaDuplicadaException;
import Excepciones.TareaNoEncontradaException;

import java.util.Scanner;

Scanner teclado = new Scanner(System.in);
GestorTareas gestorTareas = new GestorTareas();

void main() {
    System.out.print("""
           Bienvenido al Gestor TO-DO CLI
           ████████╗ ██████╗       ██████╗  ██████╗                                     \s
           ╚══██╔══╝██╔═══██╗      ██╔══██╗██╔═══██╗
              ██║   ██║   ██║█████╗██║  ██║██║   ██║
              ██║   ██║   ██║╚════╝██║  ██║██║   ██║
              ██║   ╚██████╔╝      ██████╔╝╚██████╔╝
              ╚═╝    ╚═════╝       ╚═════╝  ╚═════╝                                     \s
                                                                                        \s
           ╭ Toda la información de los comandos y otras cositas en el archivo README.md,
           ╰ alternativamente puedes escribir "?" para verlo en el programa.            \s
           """);
    while (true) {
        System.out.print("> ");
        String entrada = teclado.nextLine().toLowerCase().trim();
        String titulo;
        String descripcion;
        String prioridad;
        switch (entrada) {
            case "add":
                titulo = validarTitulo();
                descripcion = validarDescripcion();
                prioridad = validarPrioridad();
                try {
                    gestorTareas.agregar(titulo, descripcion, prioridad);
                } catch (TareaDuplicadaException excepcion) {
                    System.out.println("╰ [ERROR] La tarea ya existe.");
                }
                break;
            case "del":
                titulo = validarTitulo();
                try {
                    gestorTareas.eliminar(titulo);
                } catch (TareaNoEncontradaException excepcion) {
                    System.out.println("╰ [ERROR] La tarea no existe.");
                }
                break;
            case "mark":
                titulo = validarTitulo();
                try {
                    gestorTareas.marcarCompletado(titulo);
                } catch (TareaNoEncontradaException excepcion) {
                    System.out.println("╰ [ERROR] La tarea no existe.");
                }
                break;
            case "list":
                gestorTareas.mostrarLista();
                break;
            case "filter":
                prioridad = validarPrioridad();
                gestorTareas.mostrarListaPorPrioridad(prioridad);
                break;
            case "?":
                System.out.print("""
                                   ╭ Lista de comandos:
                                   │ ⇨ add:    Añade una tarea.
                                   │ ⇨ del:    Elimina una tarea.
                                   │ ⇨ mark:   Marca una tarea como completada.
                                   │ ⇨ list:   Muestra todas las tareas que hay.
                                   │ ⇨ filter: Muestra las tareas según su prioridad.
                                   ╰ ⇨ exit:   Cierra el programa.
                                   """);
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("[ERROR] Comando inválido. Usa \"?\" o lee el README");
        }
    }
}

private String validarTitulo() {
    String titulo;
    do {
        System.out.print("╭ Título: ");
        titulo = teclado.nextLine().trim();
    } while (titulo.isEmpty());
    return titulo;
}

private String validarDescripcion() {
    String descripcion;
    do {
        System.out.print("│ Descripción: ");
        descripcion = teclado.nextLine().trim();
    } while (descripcion.isEmpty());
    return descripcion;
}

private String validarPrioridad() {
    String prioridad;
    while (true) {
        System.out.print("│ Prioridad (Alta / Media / Baja): ");
        prioridad = teclado.nextLine().trim().toLowerCase();
        if (prioridad.equals("alta") || prioridad.equals("media") || prioridad.equals("baja")) {
            // Se normaliza la primera letra en mayúscula (Alta, Media, Baja)
            return prioridad.substring(0, 1).toUpperCase() + prioridad.substring(1);
        }
        System.out.println("│ [ERROR] Debe indicar 'Alta', 'Media' o 'Baja'.");
    }
}