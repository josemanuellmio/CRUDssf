# CRUD de Personas en Java Swing

Aplicacion sencilla de escritorio hecha en Java. El proyecto implementa un CRUD de personas usando el patron Modelo-Vista-Controlador (MVC) y una interfaz grafica creada con Java Swing.

## Funcionalidades

- Listar personas en una tabla.
- Crear una nueva persona.
- Seleccionar una persona para ver sus datos.
- Actualizar los datos de una persona.
- Eliminar una persona con confirmacion previa.
- Limpiar el formulario.

## Estructura del proyecto

```text
src/
+-- Main.java
+-- controlador/
|   +-- PersonaController.java
+-- modelo/
|   +-- Persona.java
|   +-- PersonaRepository.java
+-- vista/
    +-- PersonaVista.java
```

## Patron MVC

El proyecto esta separado en tres partes principales:

- Modelo: contiene la clase `Persona` y el repositorio `PersonaRepository`, donde se guardan los datos en memoria.
- Vista: contiene `PersonaVista`, que se encarga de mostrar la ventana, la tabla, los campos de texto y los botones.
- Controlador: contiene `PersonaController`, que conecta la vista con el modelo y gestiona las acciones del usuario.

## Como ejecutar

Desde la raiz del proyecto, compilar:

```bash
javac -d out src/Main.java src/modelo/Persona.java src/modelo/PersonaRepository.java src/vista/PersonaVista.java src/controlador/PersonaController.java
```

Ejecutar:

```bash
java -cp out Main
```

Tambien se puede abrir el proyecto con IntelliJ IDEA y ejecutar la clase `Main`.

## Ramas utilizadas

El repositorio se organiza con las siguientes ramas:

- `main`: version principal del proyecto.
- `developer`: rama de desarrollo donde se integran los cambios antes de pasar a `main`.
- `feature`: rama usada para desarrollar el CRUD.
- `fix`: rama usada para aplicar una correccion sobre la eliminacion de personas.

## Commits principales

El desarrollo se ha dividido en commits progresivos para reflejar los cambios importantes:

- Setup del proyecto.
- Crear modelo de personas.
- Crear vista Swing de personas.
- Conectar CRUD con controlador.
- Agregar confirmacion al eliminar personas.
