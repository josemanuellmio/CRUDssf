# Documentacion del proyecto

## Descripcion general

Este proyecto es una aplicacion de escritorio en Java para gestionar personas. La aplicacion permite crear, consultar, modificar y eliminar registros mediante una interfaz grafica sencilla hecha con Swing.

El objetivo principal es practicar el uso del patron Modelo-Vista-Controlador y organizar el trabajo con ramas de Git.

## Datos gestionados

Cada persona tiene los siguientes datos:

- Id: identificador numerico generado automaticamente.
- Nombre: nombre de la persona.
- Email: correo electronico.
- Telefono: numero de telefono.

Los datos se guardan en memoria, por lo que se pierden al cerrar la aplicacion. Para una practica sencilla de CRUD esto es suficiente, porque permite centrarse en la estructura del codigo y en la gestion de ramas.

## Modelo

El modelo esta formado por las clases del paquete `modelo`.

`Persona` representa los datos de una persona. Tiene atributos privados, constructor, getters y setters.

`PersonaRepository` se encarga de almacenar las personas en una lista. Tambien contiene los metodos necesarios para:

- Obtener todas las personas.
- Crear una persona.
- Buscar una persona por id.
- Actualizar una persona.
- Eliminar una persona.

## Vista

La vista esta en el paquete `vista`.

`PersonaVista` extiende de `JFrame` y muestra la ventana principal. Contiene:

- Una tabla para listar personas.
- Campos de texto para introducir nombre, email y telefono.
- Botones para crear, actualizar, eliminar y limpiar.
- Mensajes de aviso para el usuario.
- Confirmacion antes de eliminar una persona.

La vista no modifica los datos directamente. Solo muestra informacion y recoge las acciones del usuario.

## Controlador

El controlador esta en el paquete `controlador`.

`PersonaController` conecta la vista con el modelo. Su trabajo es escuchar los botones y ejecutar la accion correspondiente:

- Crear una persona cuando se pulsa el boton Crear.
- Cargar los datos de una persona al seleccionarla en la tabla.
- Actualizar la persona seleccionada.
- Eliminar la persona seleccionada despues de confirmar.
- Refrescar la tabla despues de cada cambio.

Tambien valida que los campos del formulario no esten vacios.

## Flujo de la aplicacion

1. La clase `Main` crea el repositorio, la vista y el controlador.
2. El controlador carga los datos iniciales en la tabla.
3. El usuario interactua con la ventana.
4. El controlador recibe la accion del usuario.
5. El repositorio modifica los datos.
6. La vista se actualiza para mostrar el estado actual.

## Uso de Git y ramas

El trabajo se organiza con cuatro ramas:

- `main`: contiene la version final y estable.
- `developer`: recibe las integraciones del desarrollo y correcciones.
- `feature`: se usa para implementar la funcionalidad principal del CRUD.
- `fix`: se usa para corregir la eliminacion, agregando confirmacion antes de borrar.

Esta organizacion permite separar el desarrollo principal, las nuevas funcionalidades y las correcciones.

## Prueba manual

Para comprobar la aplicacion:

1. Ejecutar la clase `Main`.
2. Revisar que aparecen personas iniciales en la tabla.
3. Escribir datos en el formulario y pulsar Crear.
4. Seleccionar una persona de la tabla.
5. Cambiar algun dato y pulsar Actualizar.
6. Seleccionar una persona y pulsar Eliminar.
7. Confirmar la eliminacion.
8. Pulsar Limpiar para vaciar el formulario.

Si todos estos pasos funcionan, el CRUD esta funcionando correctamente.
