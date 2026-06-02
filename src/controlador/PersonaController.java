package controlador;

import modelo.Persona;
import modelo.PersonaRepository;
import vista.PersonaVista;

public class PersonaController {
    private final PersonaRepository repository;
    private final PersonaVista vista;

    public PersonaController(PersonaRepository repository, PersonaVista vista) {
        this.repository = repository;
        this.vista = vista;
        configurarEventos();
        refrescarTabla();
    }

    private void configurarEventos() {
        vista.getBotonCrear().addActionListener(event -> crearPersona());
        vista.getBotonActualizar().addActionListener(event -> actualizarPersona());
        vista.getBotonEliminar().addActionListener(event -> eliminarPersona());
        vista.getBotonLimpiar().addActionListener(event -> vista.limpiarFormulario());

        vista.getTablaPersonas().getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                cargarPersonaSeleccionada();
            }
        });
    }

    private void crearPersona() {
        if (!formularioValido()) {
            return;
        }

        repository.crear(vista.getNombre(), vista.getEmail(), vista.getTelefono());
        vista.limpiarFormulario();
        refrescarTabla();
    }

    private void actualizarPersona() {
        int id = vista.obtenerIdSeleccionado();

        if (id == -1) {
            vista.mostrarMensaje("Selecciona una persona para actualizar.");
            return;
        }

        if (!formularioValido()) {
            return;
        }

        repository.actualizar(id, vista.getNombre(), vista.getEmail(), vista.getTelefono());
        vista.limpiarFormulario();
        refrescarTabla();
    }

    private void eliminarPersona() {
        int id = vista.obtenerIdSeleccionado();

        if (id == -1) {
            vista.mostrarMensaje("Selecciona una persona para eliminar.");
            return;
        }

        if (!vista.confirmarEliminacion()) {
            return;
        }

        repository.eliminar(id);
        vista.limpiarFormulario();
        refrescarTabla();
    }

    private void cargarPersonaSeleccionada() {
        int id = vista.obtenerIdSeleccionado();

        if (id == -1) {
            return;
        }

        repository.buscarPorId(id).ifPresent(vista::cargarPersonaEnFormulario);
    }

    private boolean formularioValido() {
        if (vista.getNombre().isBlank() || vista.getEmail().isBlank() || vista.getTelefono().isBlank()) {
            vista.mostrarMensaje("Todos los campos son obligatorios.");
            return false;
        }

        return true;
    }

    private void refrescarTabla() {
        vista.mostrarPersonas(repository.obtenerTodas());
    }
}
