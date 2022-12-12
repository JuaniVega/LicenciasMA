package mvc.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import mvc.controller.dto.EmitirLicenciaDTO;
import mvc.controller.gestores.GestorLicencia;
import mvc.controller.gestores.GestorPersona;
import mvc.model.Conductor;
import mvc.model.Licencia;
import mvc.model.TipoDocumento;
import mvc.model.TipoGrupoSanguineo;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;

public class PntDarAltaTitularUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2439382630198569769L;
	
	private JTextField tfNombreCliente;
	private JTextField tfApellidoCliente;
	private JTextField tfNroDocumentoCliente;
	private JTextField tfCalleCliente;
	private JTextField tfNombreAdmin;
	private JTextField tfApellidoAdmin;
	private JTextField tfNumDirCliente;
	private JTextField tfDptoCliente;
	private JTextField tfPisoCliente;
	private JTextField tfFechaEmision;
	private JTextField tfFechaNacimConductor;
	private JComboBox<String> cbTipoDocumentoCliente;
	private JComboBox cbSexoCliente;
	private JComboBox<String> cbGrupoSanguineoConductor;
	private JTextPane txtpnObservaciones;
	private JTextArea taObservaciones;
	private JLabel lblErrorLicencias;
	private JLabel lblErrorDonantes;
	
	private JButton btnCrearTitular = new JButton("Crear titular");
	private JButton btnEmitirLicencia;
	
	private ArrayList<String> licenciasSelec = new ArrayList<String>();
	private ArrayList<Integer> costosLicencias = new ArrayList<Integer>();
	private ArrayList<JCheckBox> licenciasCheckBox = new ArrayList<JCheckBox>();
	private EmitirLicenciaDTO emitirLicenciaDTO = new EmitirLicenciaDTO();
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
	
	private boolean licenciasConCDE=false;
	
	public PntDarAltaTitularUI() {
		setLocation(-31, -63);
	setPreferredSize(new Dimension(980, 650));
	setLayout(null);
	
	JTextPane txtDatosAdmin = new JTextPane();
	txtDatosAdmin.setBounds(41, 443, 142, 20);
	add(txtDatosAdmin);
	txtDatosAdmin.setText("Datos administrativo");
	txtDatosAdmin.setFont(new Font("Tahoma", Font.BOLD, 13));
	txtDatosAdmin.setEditable(false);
	txtDatosAdmin.setBackground(SystemColor.menu);
	
	JTextPane txtDatosConductor = new JTextPane();
	txtDatosConductor.setFont(new Font("Tahoma", Font.BOLD, 13));
	txtDatosConductor.setBounds(44, 48, 115, 20);
	add(txtDatosConductor);
	txtDatosConductor.setBackground(SystemColor.menu);
	txtDatosConductor.setEditable(false);
	txtDatosConductor.setText("Datos conductor");
	
	JTextPane txtpnEmitirLicencia = new JTextPane();
	txtpnEmitirLicencia.setText("EMITIR LICENCIA");
	txtpnEmitirLicencia.setFont(new Font("Tahoma", Font.BOLD, 21));
	txtpnEmitirLicencia.setEditable(false);
	txtpnEmitirLicencia.setBackground(SystemColor.menu);
	txtpnEmitirLicencia.setBounds(393, 11, 219, 37);
	add(txtpnEmitirLicencia);
	
	JPanel panelConductor = new JPanel();
	panelConductor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelConductor.setToolTipText("");
	panelConductor.setBounds(31, 59, 908, 373);
	add(panelConductor);
	panelConductor.setLayout(null);
	
	JTextPane txtpnDireccion = new JTextPane();
	txtpnDireccion.setText("Direcci\u00F3n");
	txtpnDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtpnDireccion.setEditable(false);
	txtpnDireccion.setBackground(SystemColor.menu);
	txtpnDireccion.setBounds(481, 66, 59, 22);
	panelConductor.add(txtpnDireccion);
	
	JTextPane txtDocumentoCliente = new JTextPane();
	txtDocumentoCliente.setText("Documento");
	txtDocumentoCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtDocumentoCliente.setEditable(false);
	txtDocumentoCliente.setBackground(SystemColor.menu);
	txtDocumentoCliente.setBounds(41, 66, 71, 22);
	panelConductor.add(txtDocumentoCliente);
	
	JTextPane txtNombreCliente = new JTextPane();
	txtNombreCliente.setText("Nombre completo (*)");
	txtNombreCliente.setEditable(false);
	txtNombreCliente.setBackground(SystemColor.menu);
	txtNombreCliente.setBounds(28, 25, 125, 20);
	panelConductor.add(txtNombreCliente);
	
	tfNombreCliente = new JTextField();
	tfNombreCliente.setEditable(false);
	tfNombreCliente.setBounds(156, 25, 260, 20);
	panelConductor.add(tfNombreCliente);
	tfNombreCliente.setColumns(10);
	
	JTextPane txtApellidoCliente = new JTextPane();
	txtApellidoCliente.setText("Apellido(s) (*)");
	txtApellidoCliente.setEditable(false);
	txtApellidoCliente.setBackground(SystemColor.menu);
	txtApellidoCliente.setBounds(468, 25, 89, 20);
	panelConductor.add(txtApellidoCliente);
	
	tfApellidoCliente = new JTextField();
	tfApellidoCliente.setEditable(false);
	tfApellidoCliente.setColumns(10);
	tfApellidoCliente.setBounds(567, 25, 293, 20);
	panelConductor.add(tfApellidoCliente);
	
	JPanel panelDocumento = new JPanel();
	panelDocumento.setLayout(null);
	panelDocumento.setToolTipText("");
	panelDocumento.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelDocumento.setBounds(28, 77, 388, 49);
	panelConductor.add(panelDocumento);
	
	JTextPane txtTipoDocumentoCliente = new JTextPane();
	txtTipoDocumentoCliente.setText("Tipo (*)");
	txtTipoDocumentoCliente.setEditable(false);
	txtTipoDocumentoCliente.setBackground(SystemColor.menu);
	txtTipoDocumentoCliente.setBounds(10, 11, 58, 20);
	panelDocumento.add(txtTipoDocumentoCliente);
	
	tfNroDocumentoCliente = new JTextField();
	tfNroDocumentoCliente.setEditable(false);
	tfNroDocumentoCliente.setColumns(10);
	tfNroDocumentoCliente.setBounds(244, 11, 120, 20);
	panelDocumento.add(tfNroDocumentoCliente);
	
	JTextPane txtNroDocumentoCliente = new JTextPane();
	txtNroDocumentoCliente.setText("N\u00FAmero (*)");
	txtNroDocumentoCliente.setEditable(false);
	txtNroDocumentoCliente.setBackground(SystemColor.menu);
	txtNroDocumentoCliente.setBounds(173, 11, 71, 20);
	panelDocumento.add(txtNroDocumentoCliente);
	
	cbTipoDocumentoCliente = new JComboBox();
	cbTipoDocumentoCliente.setEnabled(false);
	cbTipoDocumentoCliente.setBounds(78, 11, 85, 22);
	panelDocumento.add(cbTipoDocumentoCliente);
	
	JTextPane txtFechaNacCliente = new JTextPane();
	txtFechaNacCliente.setText("Fecha de nacimiento (*)");
	txtFechaNacCliente.setEditable(false);
	txtFechaNacCliente.setBackground(SystemColor.menu);
	txtFechaNacCliente.setBounds(30, 154, 133, 20);
	panelConductor.add(txtFechaNacCliente);
	
	txtpnObservaciones = new JTextPane();
	txtpnObservaciones.setText("Observaciones (*)");
	txtpnObservaciones.setEditable(false);
	txtpnObservaciones.setBackground(SystemColor.menu);
	txtpnObservaciones.setBounds(468, 197, 107, 22);
	panelConductor.add(txtpnObservaciones);
	
	taObservaciones = new JTextArea();
	taObservaciones.setEnabled(false);
	taObservaciones.setToolTipText("Observaciones");
	taObservaciones.setBounds(585, 197, 275, 147);
	panelConductor.add(taObservaciones);
	
	JTextPane txtpnSexoCliente = new JTextPane();
	txtpnSexoCliente.setText("Sexo (*)");
	txtpnSexoCliente.setEditable(false);
	txtpnSexoCliente.setBackground(SystemColor.menu);
	txtpnSexoCliente.setBounds(287, 154, 58, 20);
	panelConductor.add(txtpnSexoCliente);
	
	cbSexoCliente = new JComboBox();
	cbSexoCliente.setEnabled(false);
	cbSexoCliente.setBounds(352, 154, 64, 22);
	panelConductor.add(cbSexoCliente);
	
	JPanel panelDocumento_2 = new JPanel();
	panelDocumento_2.setLayout(null);
	panelDocumento_2.setToolTipText("");
	panelDocumento_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelDocumento_2.setBounds(468, 77, 392, 78);
	panelConductor.add(panelDocumento_2);
	
	JTextPane txtCalle = new JTextPane();
	txtCalle.setBounds(10, 11, 59, 20);
	panelDocumento_2.add(txtCalle);
	txtCalle.setText("Calle (*)");
	txtCalle.setEditable(false);
	txtCalle.setBackground(SystemColor.menu);
	
	tfCalleCliente = new JTextField();
	tfCalleCliente.setEditable(false);
	tfCalleCliente.setBounds(70, 11, 160, 20);
	panelDocumento_2.add(tfCalleCliente);
	tfCalleCliente.setColumns(10);
	
	JTextPane txtpnNumero = new JTextPane();
	txtpnNumero.setText("N\u00FAmero (*)");
	txtpnNumero.setEditable(false);
	txtpnNumero.setBackground(SystemColor.menu);
	txtpnNumero.setBounds(240, 11, 74, 20);
	panelDocumento_2.add(txtpnNumero);
	
	tfNumDirCliente = new JTextField();
	tfNumDirCliente.setEditable(false);
	tfNumDirCliente.setColumns(10);
	tfNumDirCliente.setBounds(314, 11, 64, 20);
	panelDocumento_2.add(tfNumDirCliente);
	
	JTextPane txtpnDpto = new JTextPane();
	txtpnDpto.setText("Dpto");
	txtpnDpto.setEditable(false);
	txtpnDpto.setBackground(SystemColor.menu);
	txtpnDpto.setBounds(20, 42, 47, 20);
	panelDocumento_2.add(txtpnDpto);
	
	tfDptoCliente = new JTextField();
	tfDptoCliente.setEditable(false);
	tfDptoCliente.setColumns(10);
	tfDptoCliente.setBounds(70, 42, 59, 20);
	panelDocumento_2.add(tfDptoCliente);
	
	JTextPane txtpnPiso = new JTextPane();
	txtpnPiso.setText("Piso");
	txtpnPiso.setEditable(false);
	txtpnPiso.setBackground(SystemColor.menu);
	txtpnPiso.setBounds(161, 42, 47, 20);
	panelDocumento_2.add(txtpnPiso);
	
	tfPisoCliente = new JTextField();
	tfPisoCliente.setEditable(false);
	tfPisoCliente.setColumns(10);
	tfPisoCliente.setBounds(209, 42, 64, 20);
	panelDocumento_2.add(tfPisoCliente);
	
	tfFechaNacimConductor = new JTextField();
	tfFechaNacimConductor.setEditable(false);
	tfFechaNacimConductor.setColumns(10);
	tfFechaNacimConductor.setBounds(169, 154, 107, 20);
	panelConductor.add(tfFechaNacimConductor);
	
	JTextPane txtGrupoSanguineo = new JTextPane();
	txtGrupoSanguineo.setText("Grupo sangu\u00EDneo (*)");
	txtGrupoSanguineo.setEditable(false);
	txtGrupoSanguineo.setBackground(SystemColor.menu);
	txtGrupoSanguineo.setBounds(28, 209, 122, 33);
	panelConductor.add(txtGrupoSanguineo);
	
	cbGrupoSanguineoConductor = new JComboBox();
	cbGrupoSanguineoConductor.setEnabled(false);
	cbGrupoSanguineoConductor.setBounds(156, 209, 88, 22);
	panelConductor.add(cbGrupoSanguineoConductor);
	
	lblErrorLicencias = new JLabel("");
	lblErrorLicencias.setForeground(Color.RED);
	lblErrorLicencias.setBounds(28, 348, 388, 25);
	panelConductor.add(lblErrorLicencias);
	
	lblErrorDonantes = new JLabel("");
	lblErrorDonantes.setForeground(Color.RED);
	lblErrorDonantes.setBounds(265, 242, 243, 14);
	panelConductor.add(lblErrorDonantes);
	
	JPanel panelAdmin = new JPanel();
	panelAdmin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelAdmin.setBounds(31, 454, 908, 121);
	add(panelAdmin);
	panelAdmin.setLayout(null);
	
	JTextPane txtNombreAdmin = new JTextPane();
	txtNombreAdmin.setText("Nombre completo (*)");
	txtNombreAdmin.setEditable(false);
	txtNombreAdmin.setBackground(SystemColor.menu);
	txtNombreAdmin.setBounds(10, 25, 131, 20);
	panelAdmin.add(txtNombreAdmin);
	
	tfNombreAdmin = new JTextField();
	tfNombreAdmin.setEditable(false);
	tfNombreAdmin.setColumns(10);
	tfNombreAdmin.setBounds(147, 25, 275, 20);
	panelAdmin.add(tfNombreAdmin);
	
	JTextPane txtApellidoAdmin = new JTextPane();
	txtApellidoAdmin.setText("Apellido(s) (*)");
	txtApellidoAdmin.setEditable(false);
	txtApellidoAdmin.setBackground(SystemColor.menu);
	txtApellidoAdmin.setBounds(491, 25, 85, 20);
	panelAdmin.add(txtApellidoAdmin);
	
	tfApellidoAdmin = new JTextField();
	tfApellidoAdmin.setEditable(false);
	tfApellidoAdmin.setColumns(10);
	tfApellidoAdmin.setBounds(586, 25, 275, 20);
	panelAdmin.add(tfApellidoAdmin);
	
	JTextPane txtFechaEmision = new JTextPane();
	txtFechaEmision.setText("Fecha de emisi\u00F3n (*)");
	txtFechaEmision.setEditable(false);
	txtFechaEmision.setBackground(SystemColor.menu);
	txtFechaEmision.setBounds(10, 76, 131, 20);
	panelAdmin.add(txtFechaEmision);
	
	tfFechaEmision = new JTextField();
	tfFechaEmision.setEditable(false);
	tfFechaEmision.setColumns(10);
	tfFechaEmision.setBounds(147, 76, 275, 20);
	panelAdmin.add(tfFechaEmision);
	
	JButton btnAtras = new JButton("Atr\u00E1s");
	btnAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	btnAtras.setBounds(41, 602, 118, 37);
	add(btnAtras);
	
	}
	

	protected void limpiarPantalla() {
		tfNombreCliente.setText("");
		tfApellidoCliente.setText("");
		cbTipoDocumentoCliente.setSelectedIndex(0);
		tfNroDocumentoCliente.setText("");
		tfCalleCliente.setText("");
		tfNumDirCliente.setText("");
		tfPisoCliente.setText("");
		tfDptoCliente.setText("");
		cbGrupoSanguineoConductor.setSelectedIndex(0);
		cbSexoCliente.setSelectedIndex(0);
		tfFechaNacimConductor.setText("");
		taObservaciones.setText("");
		taObservaciones.setEnabled(false);
		lblErrorLicencias.setText("");
		lblErrorDonantes.setText("");
		
	}

}

