# Gestor TO-DO CLI
### Funcionalidades y comandos
Recomendado que se escriban los comandos en minúsculas, pero no es obligatorio y no debería influir en nada según las pruebas.
<dl>
    <dt>add</dt> 
    <dd>Añade una tarea nueva a la lista y te avisa si ya existe, en ese caso no crea una nueva. Necesitas asignarle a cada tarea un <i>título</i> y una <i>descripción.</i><dd>  
    <dt>del</dt> 
    <dd>Elimina una tarea si existe, en caso contrario te avisa y no lo hace. Necesitas escribir el <i>título</i> de la tarea que quieres eliminar.<dd>  
    <dt>mark</dt> 
    <dd>Marca una tarea como completada si no lo está, te avisa si ya lo está y no hace nada. Necesitas escribir el <i>título</i> de la tarea que quieres marcar.<dd>  
    <dt>list</dt> 
    <dd>Muestra todas las tareas que hay en la lista de tareas con su <i>título</i>, <i>descripción</i> y su <i>estado</i> si hay elementos, si no los hay te avisa que está vacía.<dd>  
    <dt>?</dt>
    <dd>Te muestra una información reducida sobre los comandos disponibles.</dd>
    <dt>exit</dt>
    <dd>Cierra el programa con estado 0. Es decir, todo bien.<dd>  
</dl>

---

En caso de escribir un comando inválido o inexistente, el programa mostrará un mensaje de error y te volverá a solicitar un comando.