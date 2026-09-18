import Excepciones.TareaDuplicadaException;
import Excepciones.TareaNoEncontradaException;

Scanner teclado = new Scanner(System.in);
GestorTareas gestorTareas = new GestorTareas();

void main() {
    // Este arte ASCII lo he creado en la siguiente página web (El enlace redirige a los mismos ajustes que he puesto)
    // https://patorjk.com/software/taag/#p=display&f=ANSI+Shadow&t=TO-DO&x=none&v=4&h=4&w=80&we=false
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
        switch (entrada) {
            case "add":
                titulo = validarTitulo();
                descripcion = validarDescripcion();
                try {
                    gestorTareas.agregar(titulo, descripcion);
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
            case "?":
                System.out.print("""
                                   ╭ Lista de comandos:
                                   │ ⇨ add:   Añade una tarea.
                                   │ ⇨ del:   Elimina una tarea.
                                   │ ⇨ mark:  Marca una tarea como completada.
                                   │ ⇨ list:  Muestra todas las tareas que hay.
                                   ╰ ⇨ exit:  Cierra el programa.
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