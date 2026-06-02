package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import modelo.Persona;

public class PersonaVista extends JFrame {
    private final DefaultTableModel tableModel;
    private final JTable tablaPersonas;
    private final JTextField campoNombre;
    private final JTextField campoEmail;
    private final JTextField campoTelefono;
    private final JButton botonCrear;
    private final JButton botonActualizar;
    private final JButton botonEliminar;
    private final JButton botonLimpiar;

    public PersonaVista() {
        setTitle("CRUD de Personas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(760, 420);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Nombre", "Email", "Telefono"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaPersonas = new JTable(tableModel);
        tablaPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        campoNombre = new JTextField(20);
        campoEmail = new JTextField(20);
        campoTelefono = new JTextField(20);

        botonCrear = new JButton("Crear");
        botonActualizar = new JButton("Actualizar");
        botonEliminar = new JButton("Eliminar");
        botonLimpiar = new JButton("Limpiar");

        add(new JScrollPane(tablaPersonas), BorderLayout.CENTER);
        add(crearPanelFormulario(), BorderLayout.SOUTH);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        agregarCampo(panel, gbc, "Nombre:", campoNombre, 0);
        agregarCampo(panel, gbc, "Email:", campoEmail, 1);
        agregarCampo(panel, gbc, "Telefono:", campoTelefono, 2);

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonCrear);
        panelBotones.add(botonActualizar);
        panelBotones.add(botonEliminar);
        panelBotones.add(botonLimpiar);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(panelBotones, gbc);

        return panel;
    }

    private void agregarCampo(JPanel panel, GridBagConstraints gbc, String etiqueta, JTextField campo, int fila) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.gridwidth = 1;
        panel.add(new JLabel(etiqueta), gbc);

        gbc.gridx = 1;
        panel.add(campo, gbc);
    }

    public void mostrarPersonas(List<Persona> personas) {
        tableModel.setRowCount(0);

        for (Persona persona : personas) {
            tableModel.addRow(new Object[]{
                    persona.getId(),
                    persona.getNombre(),
                    persona.getEmail(),
                    persona.getTelefono()
            });
        }
    }

    public int obtenerIdSeleccionado() {
        int filaSeleccionada = tablaPersonas.getSelectedRow();

        if (filaSeleccionada == -1) {
            return -1;
        }

        return (int) tableModel.getValueAt(filaSeleccionada, 0);
    }

    public void cargarPersonaEnFormulario(Persona persona) {
        campoNombre.setText(persona.getNombre());
        campoEmail.setText(persona.getEmail());
        campoTelefono.setText(persona.getTelefono());
    }

    public void limpiarFormulario() {
        campoNombre.setText("");
        campoEmail.setText("");
        campoTelefono.setText("");
        tablaPersonas.clearSelection();
    }

    public String getNombre() {
        return campoNombre.getText().trim();
    }

    public String getEmail() {
        return campoEmail.getText().trim();
    }

    public String getTelefono() {
        return campoTelefono.getText().trim();
    }

    public JButton getBotonCrear() {
        return botonCrear;
    }

    public JButton getBotonActualizar() {
        return botonActualizar;
    }

    public JButton getBotonEliminar() {
        return botonEliminar;
    }

    public JButton getBotonLimpiar() {
        return botonLimpiar;
    }

    public JTable getTablaPersonas() {
        return tablaPersonas;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public boolean confirmarEliminacion() {
        int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que quieres eliminar la persona seleccionada?",
                "Confirmar eliminacion",
                JOptionPane.YES_NO_OPTION
        );

        return respuesta == JOptionPane.YES_OPTION;
    }

    public void iniciar() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}
