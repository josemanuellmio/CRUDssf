# Documentacion GitBook: CRUD con MVC

## 1. Introduccion

Este documento explica como se ha realizado un CRUD de personas en Java aplicando la metodologia Modelo-Vista-Controlador (MVC). Tambien recoge como se ha organizado el trabajo usando Taiga para la gestion de tareas, GitHub para alojar el repositorio, Markdown para redactar la documentacion, GitBook para publicarla y GitFlow para gestionar las ramas del proyecto.

El proyecto es una aplicacion de escritorio hecha con Java Swing. Permite crear, consultar, actualizar y eliminar personas desde una interfaz grafica sencilla.

## 2. Objetivo del proyecto

El objetivo principal es construir una aplicacion CRUD manteniendo el codigo separado por responsabilidades:

- El modelo almacena y gestiona los datos.
- La vista muestra la interfaz grafica al usuario.
- El controlador conecta la vista con el modelo y ejecuta las acciones del usuario.

Ademas, el proyecto sirve para practicar un flujo de trabajo profesional:

- Planificacion de tareas en Taiga.
- Control de versiones en Git.
- Publicacion del repositorio en GitHub.
- Documentacion en Markdown.
- Publicacion de la documentacion en GitBook.
- Gestion de ramas con GitFlow.

## 3. Integrantes del grupo

Los integrantes del grupo son:

- Jose Manuel
- Samara
- Handrup
- Fernando

## 4. Reparto de tareas

| Integrante | Aportacion principal |
| --- | --- |
| Jose Manuel | Organizacion del repositorio, gestion de ramas con GitFlow y documentacion en GitBook. |
| Samara | Desarrollo y revision del modelo, incluyendo la clase `Persona` y el repositorio de datos. |
| Handrup | Desarrollo y revision de la vista Swing, incluyendo la tabla, el formulario y los botones. |
| Fernando | Desarrollo y revision del controlador, conexion del CRUD y pruebas manuales de funcionamiento. |

## 5. Herramientas utilizadas

| Herramienta | Uso en el proyecto |
| --- | --- |
| Java | Lenguaje usado para desarrollar la aplicacion. |
| Swing | Libreria grafica usada para construir la interfaz. |
| Git | Sistema de control de versiones usado para registrar los cambios. |
| GitHub | Plataforma donde se aloja el repositorio remoto. |
| Taiga | Herramienta usada para organizar historias, tareas y seguimiento del trabajo. |
| Markdown | Formato usado para escribir esta documentacion. |
| GitBook | Plataforma usada para publicar la documentacion del proyecto. |
| GitFlow | Metodologia de ramas usada para separar desarrollo, funcionalidades y correcciones. |

## 6. Estructura del repositorio

La estructura principal del proyecto es:

```text
CRUDSSFgrupo/
|-- README.md
|-- DOCUMENTACION.md
|-- SUMMARY.md
|-- src/
    |-- Main.java
    |-- controlador/
    |   |-- PersonaController.java
    |-- modelo/
    |   |-- Persona.java
    |   |-- PersonaRepository.java
    |-- vista/
        |-- PersonaVista.java
```

Cada carpeta tiene una responsabilidad concreta:

- `src/modelo`: contiene las clases relacionadas con los datos.
- `src/vista`: contiene la interfaz grafica.
- `src/controlador`: contiene la logica que responde a las acciones del usuario.
- `Main.java`: inicia la aplicacion creando modelo, vista y controlador.
- `README.md`: resumen general del proyecto.
- `DOCUMENTACION.md`: documentacion completa para GitBook.
- `SUMMARY.md`: indice de navegacion usado por GitBook.

## 7. Aplicacion de la metodologia MVC

MVC separa una aplicacion en tres partes. Esta separacion ayuda a que el codigo sea mas facil de entender, mantener y ampliar.

### 7.1 Modelo

El modelo esta en el paquete `modelo`.

#### Clase `Persona`

`Persona` representa la entidad principal del sistema. Cada persona tiene:

- `id`: identificador numerico.
- `nombre`: nombre de la persona.
- `email`: correo electronico.
- `telefono`: numero de telefono.

La clase contiene atributos privados, constructor, getters y setters.

#### Clase `PersonaRepository`

`PersonaRepository` actua como repositorio de datos. En este proyecto los datos se guardan en memoria usando una lista de personas.

Sus operaciones principales son:

| Metodo | Funcion |
| --- | --- |
| `obtenerTodas()` | Devuelve todas las personas registradas. |
| `crear(nombre, email, telefono)` | Crea una nueva persona y le asigna un id. |
| `buscarPorId(id)` | Busca una persona concreta por su identificador. |
| `actualizar(id, nombre, email, telefono)` | Modifica los datos de una persona existente. |
| `eliminar(id)` | Elimina una persona por su identificador. |

Al guardar los datos en memoria, la informacion se pierde al cerrar la aplicacion. Para una practica de CRUD esto es suficiente, porque permite centrarse en la arquitectura MVC y en el flujo de trabajo con Git.

### 7.2 Vista

La vista esta en el paquete `vista`.

La clase `PersonaVista` extiende de `JFrame` y construye la ventana principal de la aplicacion. Incluye:

- Una tabla para listar personas.
- Campos de texto para introducir nombre, email y telefono.
- Botones para crear, actualizar, eliminar y limpiar.
- Mensajes de aviso mediante `JOptionPane`.
- Confirmacion antes de eliminar una persona.

La vista no modifica directamente los datos. Su responsabilidad es mostrar informacion, recoger datos del formulario y exponer metodos para que el controlador pueda interactuar con ella.

### 7.3 Controlador

El controlador esta en el paquete `controlador`.

La clase `PersonaController` conecta la vista con el repositorio. Sus responsabilidades son:

- Escuchar los botones de la interfaz.
- Validar que los campos obligatorios no esten vacios.
- Crear personas cuando el usuario pulsa `Crear`.
- Cargar los datos de una persona cuando se selecciona una fila de la tabla.
- Actualizar una persona seleccionada.
- Eliminar una persona tras pedir confirmacion.
- Refrescar la tabla despues de cada cambio.

El controlador evita que la vista tenga logica de negocio y evita que el modelo dependa de la interfaz grafica.

## 8. Funcionamiento del CRUD

CRUD significa:

- `Create`: crear registros.
- `Read`: consultar o listar registros.
- `Update`: actualizar registros.
- `Delete`: eliminar registros.

En este proyecto, cada operacion se reparte entre vista, controlador y modelo.

### 8.1 Crear una persona

1. El usuario escribe nombre, email y telefono.
2. Pulsa el boton `Crear`.
3. `PersonaController` valida que los campos no esten vacios.
4. El controlador llama a `repository.crear(...)`.
5. `PersonaRepository` crea la persona, asigna un id y la guarda en la lista.
6. La vista limpia el formulario y refresca la tabla.

### 8.2 Leer personas

1. Al iniciar la aplicacion, `PersonaController` llama a `refrescarTabla()`.
2. El controlador obtiene las personas con `repository.obtenerTodas()`.
3. La vista muestra los datos en la tabla usando `mostrarPersonas(...)`.

### 8.3 Actualizar una persona

1. El usuario selecciona una fila de la tabla.
2. La vista carga los datos en el formulario.
3. El usuario modifica los campos necesarios.
4. Pulsa el boton `Actualizar`.
5. El controlador comprueba que haya una persona seleccionada y que el formulario sea valido.
6. El controlador llama a `repository.actualizar(...)`.
7. La tabla se refresca con los datos actualizados.

### 8.4 Eliminar una persona

1. El usuario selecciona una persona de la tabla.
2. Pulsa el boton `Eliminar`.
3. El controlador comprueba que haya una persona seleccionada.
4. La vista muestra una confirmacion antes de borrar.
5. Si el usuario confirma, el controlador llama a `repository.eliminar(id)`.
6. La tabla se actualiza y el formulario se limpia.

## 9. Flujo general de la aplicacion

El flujo de ejecucion es:

```text
Main
  -> crea PersonaRepository
  -> crea PersonaVista
  -> crea PersonaController
  -> muestra la ventana
```

Despues, durante el uso de la aplicacion:

```text
Usuario
  -> interactua con PersonaVista
  -> PersonaController recibe el evento
  -> PersonaRepository modifica o consulta los datos
  -> PersonaVista actualiza la tabla y el formulario
```

Esta organizacion permite que cada clase tenga una funcion clara.

## 10. Planificacion con Taiga

Taiga se utiliza para organizar el trabajo antes y durante el desarrollo. Una forma sencilla de estructurar el proyecto en Taiga es la siguiente:

### 10.1 Epica

`Desarrollar CRUD de personas con arquitectura MVC`

### 10.2 Historias de usuario

| Historia | Descripcion |
| --- | --- |
| Crear modelo de persona | Como desarrollador, quiero definir la entidad `Persona` para representar los datos del sistema. |
| Crear repositorio | Como desarrollador, quiero almacenar personas en memoria para poder realizar operaciones CRUD. |
| Crear interfaz grafica | Como usuario, quiero una ventana con tabla, campos y botones para gestionar personas. |
| Conectar vista y modelo | Como usuario, quiero que los botones ejecuten acciones reales sobre los datos. |
| Confirmar eliminacion | Como usuario, quiero confirmar antes de eliminar una persona para evitar borrados accidentales. |
| Documentar el proyecto | Como estudiante, quiero explicar el proceso en GitBook para presentar el trabajo. |

### 10.3 Tareas tecnicas

- Crear estructura de paquetes `modelo`, `vista` y `controlador`.
- Implementar clase `Persona`.
- Implementar clase `PersonaRepository`.
- Implementar ventana `PersonaVista`.
- Implementar eventos en `PersonaController`.
- Probar crear, listar, actualizar y eliminar.
- Crear documentacion en Markdown.
- Subir el repositorio a GitHub.
- Publicar la documentacion en GitBook.

### 10.4 Seguimiento en tablero

En Taiga, las tareas pueden pasar por columnas como:

- `Backlog`: tareas pendientes de planificar.
- `Ready`: tareas preparadas para empezar.
- `In progress`: tareas en desarrollo.
- `Review`: tareas terminadas pendientes de revision.
- `Done`: tareas finalizadas.

Este seguimiento ayuda a ver el estado real del trabajo y a relacionar cada cambio del repositorio con una tarea concreta.

## 11. Gestion del repositorio con GitFlow

GitFlow permite separar el codigo estable, el desarrollo y los cambios especificos. En este repositorio se han usado las siguientes ramas:

| Rama | Uso |
| --- | --- |
| `main` | Version final y estable del proyecto. |
| `developer` | Rama de integracion del desarrollo antes de pasar a `main`. |
| `feature` | Rama usada para desarrollar la funcionalidad principal del CRUD. |
| `fix` | Rama usada para corregir o mejorar una funcionalidad concreta, como la confirmacion al eliminar. |

### 11.1 Flujo usado

El flujo de trabajo seguido es:

1. Crear la estructura inicial del proyecto.
2. Desarrollar el modelo en una rama de funcionalidad.
3. Crear la vista Swing.
4. Conectar la vista y el modelo mediante el controlador.
5. Integrar la funcionalidad en `developer`.
6. Crear una rama `fix` para la correccion de eliminacion.
7. Integrar la correccion.
8. Pasar la version final a `main`.
9. Subir todas las ramas a GitHub.

### 11.2 Comandos Git utiles

Crear y moverse a una rama:

```bash
git checkout -b feature
```

Guardar cambios:

```bash
git add .
git commit -m "Conectar CRUD con controlador"
```

Integrar una rama:

```bash
git checkout developer
git merge feature
```

Subir una rama a GitHub:

```bash
git push origin developer
```

Integrar la version final:

```bash
git checkout main
git merge developer
git push origin main
```

## 12. Uso de GitHub

GitHub se utiliza como repositorio remoto del proyecto. Al estar subido el repositorio completo, permite:

- Guardar una copia del proyecto en la nube.
- Consultar el historial de commits.
- Revisar las ramas usadas en GitFlow.
- Compartir el proyecto con otras personas.
- Conectar el repositorio con GitBook para publicar la documentacion.

Para que el repositorio sea claro, es recomendable mantener:

- Un `README.md` con resumen, funcionalidades y ejecucion.
- Un `DOCUMENTACION.md` con la explicacion completa.
- Un `SUMMARY.md` para que GitBook genere la navegacion.
- Commits con mensajes concretos.
- Ramas subidas al remoto.

## 13. Documentacion con Markdown

Markdown es el formato usado para escribir la documentacion. Permite crear titulos, listas, tablas y bloques de codigo de forma sencilla.

Ejemplos usados en esta documentacion:

### Titulos

```markdown
# Titulo principal
## Apartado
### Subapartado
```

### Listas

```markdown
- Elemento 1
- Elemento 2
- Elemento 3
```

### Bloques de codigo

````markdown
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hola");
    }
}
```
````

### Tablas

```markdown
| Columna 1 | Columna 2 |
| --- | --- |
| Valor 1 | Valor 2 |
```

Usar Markdown facilita que la misma documentacion pueda verse correctamente en GitHub y en GitBook.

## 14. Publicacion en GitBook

Para publicar esta documentacion en GitBook desde GitHub:

1. Entrar en GitBook.
2. Crear un nuevo espacio de documentacion.
3. Seleccionar la opcion de sincronizar o importar desde GitHub.
4. Elegir el repositorio del proyecto.
5. Seleccionar la rama `main`.
6. Usar `SUMMARY.md` como indice de navegacion.
7. Revisar que `README.md` y `DOCUMENTACION.md` se muestran correctamente.
8. Publicar el espacio de GitBook.

El archivo `SUMMARY.md` define la navegacion principal:

```markdown
# Summary

- [Inicio](README.md)
- [Documentacion del CRUD MVC](DOCUMENTACION.md)
```

Cada vez que se actualice la documentacion en GitHub, GitBook puede sincronizar los cambios si la integracion esta activada.

## 15. Como ejecutar la aplicacion

Desde la raiz del proyecto, compilar:

```bash
javac -d out src/Main.java src/modelo/Persona.java src/modelo/PersonaRepository.java src/vista/PersonaVista.java src/controlador/PersonaController.java
```

Ejecutar:

```bash
java -cp out Main
```

Tambien se puede abrir el proyecto con IntelliJ IDEA y ejecutar la clase `Main`.

## 16. Pruebas manuales del CRUD

Para comprobar que la aplicacion funciona correctamente:

1. Ejecutar la clase `Main`.
2. Comprobar que aparecen personas iniciales en la tabla.
3. Escribir nombre, email y telefono.
4. Pulsar `Crear`.
5. Confirmar que la nueva persona aparece en la tabla.
6. Seleccionar una persona.
7. Modificar algun campo.
8. Pulsar `Actualizar`.
9. Confirmar que la tabla muestra los datos modificados.
10. Seleccionar una persona.
11. Pulsar `Eliminar`.
12. Confirmar la eliminacion.
13. Comprobar que la persona desaparece de la tabla.
14. Pulsar `Limpiar` y verificar que el formulario queda vacio.

Si todos estos pasos funcionan, el CRUD esta correctamente implementado.

## 17. Conclusiones

El proyecto demuestra como construir un CRUD sencillo aplicando MVC. La separacion entre modelo, vista y controlador permite mantener el codigo organizado:

- `Persona` y `PersonaRepository` gestionan los datos.
- `PersonaVista` gestiona la interfaz grafica.
- `PersonaController` gestiona los eventos y conecta la interfaz con los datos.

El uso de Taiga, GitHub, Markdown, GitBook y GitFlow complementa el desarrollo tecnico con una organizacion mas profesional del proyecto. Taiga ayuda a planificar, GitFlow ordena las ramas, GitHub guarda el historial, Markdown facilita la escritura y GitBook permite presentar la documentacion de forma clara.
