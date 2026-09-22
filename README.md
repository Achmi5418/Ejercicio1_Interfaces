# Gestor TO-DO CLI
### Funcionalidades y comandos
Recomendado que se escriban los comandos en minúsculas, pero no es obligatorio y no debería influir en nada según las pruebas.

### add
    Añade una tarea nueva a la lista y te avisa si ya existe, en ese caso no crea una nueva. Necesitas asignarle a cada tarea un título y una descripción.
### del
    Elimina una tarea si existe, en caso contrario te avisa y no lo hace. Necesitas escribir el título de la tarea que quieres eliminar.
### mark
    Marca una tarea como completada si no lo está, te avisa si ya lo está y no hace nada. Necesitas escribir el títulode la tarea que quieres marcar.
### list 
    Muestra todas las tareas que hay en la lista de tareas con su título, descripción y su estado si hay elementos, si no los hay te avisa que está vacía.
### ?
    Te muestra una información reducida sobre los comandos disponibles.
### exit
    Cierra el programa con estado 0. Es decir, todo bien.
### filter
    Puedes filtrar lastareas segun su prioridad  


---

En caso de escribir un comando inválido o inexistente, el programa mostrará un mensaje de error y te volverá a solicitar un comando.

### Implementación
Se necesita usar la versión 27 del OpenJDK (u otro JDK compatible) para ejecutar el programa.