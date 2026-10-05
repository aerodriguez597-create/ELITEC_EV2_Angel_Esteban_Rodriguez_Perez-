package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entity.Receta;
import entity.TipoReceta;
import model.RecetaModel;
import model.TipoRecetaModel;
import util.ValidateUtil;

public class FrmRegistraReceta extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField txtNombrePaciente;
    private JTextField txtNombreMedicamento;
    private JTextField txtDosis;
    private JTextField txtFrecuencia;
    private JTextField txtDuracion;
    private JTextField txtFechaEmision;
    private JTextField txtIndicaciones;
    private JComboBox<String> cboTipoReceta;
    private JButton btnRegistrar;
    private JButton btnLimpiar;

    private TipoRecetaModel tipoRecetaModel = new TipoRecetaModel();
    private RecetaModel recetaModel = new RecetaModel();
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmRegistraReceta frame = new FrmRegistraReceta();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrmRegistraReceta() {
        setTitle("Registro de Recetas Médicas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 550);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("REGISTRO DE RECETAS");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setBounds(120, 15, 300, 30);
        contentPane.add(lblTitulo);

        JLabel lblPaciente = new JLabel("Nombre del paciente:");
        lblPaciente.setBounds(40, 70, 160, 25);
        contentPane.add(lblPaciente);

        txtNombrePaciente = new JTextField();
        txtNombrePaciente.setBounds(210, 70, 280, 25);
        contentPane.add(txtNombrePaciente);

        JLabel lblMedicamento = new JLabel("Nombre del medicamento:");
        lblMedicamento.setBounds(40, 115, 170, 25);
        contentPane.add(lblMedicamento);

        txtNombreMedicamento = new JTextField();
        txtNombreMedicamento.setBounds(210, 115, 280, 25);
        contentPane.add(txtNombreMedicamento);

        JLabel lblDosis = new JLabel("Dosis:");
        lblDosis.setBounds(40, 160, 160, 25);
        contentPane.add(lblDosis);

        txtDosis = new JTextField();
        txtDosis.setBounds(210, 160, 280, 25);
        contentPane.add(txtDosis);

        JLabel lblFrecuencia = new JLabel("Frecuencia:");
        lblFrecuencia.setBounds(40, 205, 160, 25);
        contentPane.add(lblFrecuencia);

        txtFrecuencia = new JTextField();
        txtFrecuencia.setBounds(210, 205, 280, 25);
        contentPane.add(txtFrecuencia);

        JLabel lblDuracion = new JLabel("Duración (días):");
        lblDuracion.setBounds(40, 250, 160, 25);
        contentPane.add(lblDuracion);

        txtDuracion = new JTextField();
        txtDuracion.setBounds(210, 250, 280, 25);
        contentPane.add(txtDuracion);

        JLabel lblFecha = new JLabel("Fecha de emisión:");
        lblFecha.setBounds(40, 295, 160, 25);
        contentPane.add(lblFecha);

        txtFechaEmision = new JTextField();
        txtFechaEmision.setBounds(210, 295, 280, 25);
        contentPane.add(txtFechaEmision);

        JLabel lblIndicaciones = new JLabel("Indicaciones:");
        lblIndicaciones.setBounds(40, 340, 160, 25);
        contentPane.add(lblIndicaciones);

        txtIndicaciones = new JTextField();
        txtIndicaciones.setBounds(210, 340, 280, 25);
        contentPane.add(txtIndicaciones);

        JLabel lblTipo = new JLabel("Tipo de receta:");
        lblTipo.setBounds(40, 385, 160, 25);
        contentPane.add(lblTipo);

        cboTipoReceta = new JComboBox<String>();
        cboTipoReceta.setBounds(210, 385, 280, 25);
        contentPane.add(cboTipoReceta);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(130, 440, 120, 30);
        btnRegistrar.addActionListener(this);
        contentPane.add(btnRegistrar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(280, 440, 120, 30);
        btnLimpiar.addActionListener(this);
        contentPane.add(btnLimpiar);

        cargarComboTipo();

    }

    private void cargarComboTipo() {
        cboTipoReceta.removeAllItems();
        cboTipoReceta.addItem("[ Seleccione un tipo ]");
        List<TipoReceta> lista = tipoRecetaModel.listarTipoReceta();
        for (TipoReceta tipo : lista) {
            cboTipoReceta.addItem(
                tipo.getIdTipoReceta() + " - " + tipo.getDescripcion()
            );

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            registrarReceta();
        }

        if (e.getSource() == btnLimpiar) {
            limpiarFormulario();
        }
    }

    private void registrarReceta() {
        String nombrePaciente = txtNombrePaciente.getText().trim();
        String nombreMedicamento = txtNombreMedicamento.getText().trim();
        String dosis = txtDosis.getText().trim();
        String frecuencia = txtFrecuencia.getText().trim();
        String duracion = txtDuracion.getText().trim();
        String fechaEmision = txtFechaEmision.getText().trim();
        String indicaciones = txtIndicaciones.getText().trim();
        String tipoSeleccionado = (String) cboTipoReceta.getSelectedItem();

        // Validar campos vacíos
        if (nombrePaciente.isEmpty() || nombreMedicamento.isEmpty() || dosis.isEmpty() || frecuencia.isEmpty()  || duracion.isEmpty() || fechaEmision.isEmpty()  || indicaciones.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Complete todos los campos.", "Advertencia",JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar nombre del paciente
        if (!nombrePaciente.matches(ValidateUtil.TEXTO_40)) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un nombre de paciente válido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtNombrePaciente.requestFocus();
            return;
        }

        // Validar nombre del medicamento
        if (!nombreMedicamento.matches(ValidateUtil.TEXTO_40)) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un nombre de medicamento válido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtNombreMedicamento.requestFocus();
            return;
        }

        // Validar duración
        if (!duracion.matches(ValidateUtil.ENTERO_MAS_UN_DIGITO)) {
            JOptionPane.showMessageDialog(this,
                    "La duración debe ser un número entero.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtDuracion.requestFocus();
            return;
        }

        // Validar fecha
        if (!fechaEmision.matches(ValidateUtil.DATE_YYYY_MM_DD)) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese la fecha en formato YYYY-MM-DD.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

            txtFechaEmision.requestFocus();
            return;

        }

        // Validar tipo de receta
        if (tipoSeleccionado == null
                || tipoSeleccionado.equals("[ Seleccione un tipo ]")) {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un tipo de receta.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Receta objReceta = new Receta();
            objReceta.setNombrePaciente(nombrePaciente);
            objReceta.setNombreMedicamento(nombreMedicamento);
            objReceta.setDosis(dosis);
            objReceta.setFrecuencia(frecuencia);
            objReceta.setDuracion(Integer.parseInt(duracion));
            objReceta.setFechaEmision(LocalDate.parse(fechaEmision));
            objReceta.setIndicaciones(indicaciones);

            // Obtener el ID del tipo seleccionado
            int idTipo = Integer.parseInt(
                    tipoSeleccionado.split(" - ")[0]
            );
            TipoReceta tipoReceta = new TipoReceta();
            tipoReceta.setIdTipoReceta(idTipo);
            objReceta.setTipoReceta(tipoReceta);

            // Registrar en la base de datos
            int insertados = recetaModel.insertaReceta(objReceta);
            if (insertados > 0) {
                JOptionPane.showMessageDialog(this,
                        "Receta registrada correctamente.",
                        "Registro exitoso",
                        JOptionPane.INFORMATION_MESSAGE);
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(this,
                        "No se pudo registrar la receta.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Verifique los datos ingresados.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void limpiarFormulario() {
        txtNombrePaciente.setText("");
        txtNombreMedicamento.setText("");
        txtDosis.setText("");
        txtFrecuencia.setText("");
        txtDuracion.setText("");
        txtFechaEmision.setText("");
        txtIndicaciones.setText("");
        cboTipoReceta.setSelectedIndex(0);
        txtNombrePaciente.requestFocus();
    }
}