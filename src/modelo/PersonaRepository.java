package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PersonaRepository {
    private final List<Persona> personas = new ArrayList<>();
    private int siguienteId = 1;

    public PersonaRepository() {
        crear("Ana Garcia", "ana@example.com", "600111222");
        crear("Carlos Perez", "carlos@example.com", "600333444");
    }

    public List<Persona> obtenerTodas() {
        return Collections.unmodifiableList(personas);
    }

    public Persona crear(String nombre, String email, String telefono) {
        Persona persona = new Persona(siguienteId, nombre, email, telefono);
        siguienteId++;
        personas.add(persona);
        return persona;
    }

    public Optional<Persona> buscarPorId(int id) {
        return personas.stream()
                .filter(persona -> persona.getId() == id)
                .findFirst();
    }

    public boolean actualizar(int id, String nombre, String email, String telefono) {
        Optional<Persona> personaEncontrada = buscarPorId(id);

        if (personaEncontrada.isEmpty()) {
            return false;
        }

        Persona persona = personaEncontrada.get();
        persona.setNombre(nombre);
        persona.setEmail(email);
        persona.setTelefono(telefono);
        return true;
    }

    public boolean eliminar(int id) {
        return personas.removeIf(persona -> persona.getId() == id);
    }
}
