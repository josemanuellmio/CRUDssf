import controlador.PersonaController;
import modelo.PersonaRepository;
import vista.PersonaVista;

public class Main {
    public static void main(String[] args) {
        PersonaRepository repository = new PersonaRepository();
        PersonaVista vista = new PersonaVista();

        new PersonaController(repository, vista);
        vista.iniciar();
    }
}
