package view;

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
import java.awt.event.ActionEvent;

public class PntCrearLicencia extends JPanel {
	private JTextField tfNombreCliente;
	private JTextField tfApellidoCliente;
	private JTextField tfNroDocumentoCliente;
	private JTextField tfDireccionCliente;
	private JTextField tfNombreAdmin;
	private JTextField tfApellidoAdmin;
	
	public PntCrearLicencia() {
	setPreferredSize(new Dimension(980, 650));
	setLayout(null);
	
	JTextPane txtDatosAdmin = new JTextPane();
	txtDatosAdmin.setBounds(41, 415, 142, 20);
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
	panelConductor.setBounds(31, 59, 908, 345);
	add(panelConductor);
	panelConductor.setLayout(null);
	
	JTextPane txtDocumentoCliente = new JTextPane();
	txtDocumentoCliente.setText("Documento");
	txtDocumentoCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtDocumentoCliente.setEditable(false);
	txtDocumentoCliente.setBackground(SystemColor.menu);
	txtDocumentoCliente.setBounds(41, 57, 71, 22);
	panelConductor.add(txtDocumentoCliente);
	
	JTextPane txtNombreCliente = new JTextPane();
	txtNombreCliente.setText("Nombre completo (*)");
	txtNombreCliente.setEditable(false);
	txtNombreCliente.setBackground(SystemColor.menu);
	txtNombreCliente.setBounds(10, 11, 125, 20);
	panelConductor.add(txtNombreCliente);
	
	tfNombreCliente = new JTextField();
	tfNombreCliente.setBounds(141, 11, 275, 20);
	panelConductor.add(tfNombreCliente);
	tfNombreCliente.setColumns(10);
	
	JTextPane txtApellidoCliente = new JTextPane();
	txtApellidoCliente.setText("Apellido(s) (*)");
	txtApellidoCliente.setEditable(false);
	txtApellidoCliente.setBackground(SystemColor.menu);
	txtApellidoCliente.setBounds(486, 11, 89, 20);
	panelConductor.add(txtApellidoCliente);
	
	tfApellidoCliente = new JTextField();
	tfApellidoCliente.setColumns(10);
	tfApellidoCliente.setBounds(585, 11, 275, 20);
	panelConductor.add(tfApellidoCliente);
	
	JPanel panelDocumento = new JPanel();
	panelDocumento.setLayout(null);
	panelDocumento.setToolTipText("");
	panelDocumento.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelDocumento.setBounds(28, 68, 388, 49);
	panelConductor.add(panelDocumento);
	
	JTextPane txtTipoDocumentoCliente = new JTextPane();
	txtTipoDocumentoCliente.setText("Tipo (*)");
	txtTipoDocumentoCliente.setEditable(false);
	txtTipoDocumentoCliente.setBackground(SystemColor.menu);
	txtTipoDocumentoCliente.setBounds(10, 11, 58, 20);
	panelDocumento.add(txtTipoDocumentoCliente);
	
	tfNroDocumentoCliente = new JTextField();
	tfNroDocumentoCliente.setColumns(10);
	tfNroDocumentoCliente.setBounds(244, 11, 120, 20);
	panelDocumento.add(tfNroDocumentoCliente);
	
	JTextPane txtNroDocumentoCliente = new JTextPane();
	txtNroDocumentoCliente.setText("N\u00FAmero (*)");
	txtNroDocumentoCliente.setEditable(false);
	txtNroDocumentoCliente.setBackground(SystemColor.menu);
	txtNroDocumentoCliente.setBounds(173, 11, 71, 20);
	panelDocumento.add(txtNroDocumentoCliente);
	
	JComboBox cbTipoDocumentoCliente = new JComboBox();
	cbTipoDocumentoCliente.setBounds(78, 11, 85, 22);
	panelDocumento.add(cbTipoDocumentoCliente);
	
	JTextPane txtDireccionCliente = new JTextPane();
	txtDireccionCliente.setText("Direcci\u00F3n (*)");
	txtDireccionCliente.setEditable(false);
	txtDireccionCliente.setBackground(SystemColor.menu);
	txtDireccionCliente.setBounds(501, 82, 74, 20);
	panelConductor.add(txtDireccionCliente);
	
	tfDireccionCliente = new JTextField();
	tfDireccionCliente.setColumns(10);
	tfDireccionCliente.setBounds(585, 82, 275, 20);
	panelConductor.add(tfDireccionCliente);
	
	JTextPane txtFechaNacCliente = new JTextPane();
	txtFechaNacCliente.setText("Fecha de nacimiento (*)");
	txtFechaNacCliente.setEditable(false);
	txtFechaNacCliente.setBackground(SystemColor.menu);
	txtFechaNacCliente.setBounds(445, 157, 141, 20);
	panelConductor.add(txtFechaNacCliente);
	
	JTextPane txtGrupoSangYFactRH = new JTextPane();
	txtGrupoSangYFactRH.setText("Grupo sangu\u00EDneo");
	txtGrupoSangYFactRH.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtGrupoSangYFactRH.setEditable(false);
	txtGrupoSangYFactRH.setBackground(SystemColor.menu);
	txtGrupoSangYFactRH.setBounds(41, 136, 103, 22);
	panelConductor.add(txtGrupoSangYFactRH);
	
	JPanel panelDocumento_1 = new JPanel();
	panelDocumento_1.setLayout(null);
	panelDocumento_1.setToolTipText("");
	panelDocumento_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelDocumento_1.setBounds(28, 147, 388, 78);
	panelConductor.add(panelDocumento_1);
	
	JTextPane txtGrupoSanguineo = new JTextPane();
	txtGrupoSanguineo.setText("Grupo sangu\u00EDneo (*)");
	txtGrupoSanguineo.setEditable(false);
	txtGrupoSanguineo.setBackground(SystemColor.menu);
	txtGrupoSanguineo.setBounds(10, 22, 94, 33);
	panelDocumento_1.add(txtGrupoSanguineo);
	
	JTextPane txtFactorRH = new JTextPane();
	txtFactorRH.setText("Factor RH (*)");
	txtFactorRH.setEditable(false);
	txtFactorRH.setBackground(SystemColor.menu);
	txtFactorRH.setBounds(205, 35, 82, 20);
	panelDocumento_1.add(txtFactorRH);
	
	JComboBox cbGrupoSanguineoConductor = new JComboBox();
	cbGrupoSanguineoConductor.setBounds(114, 33, 69, 22);
	panelDocumento_1.add(cbGrupoSanguineoConductor);
	
	JComboBox cbFactorRHConductor = new JComboBox();
	cbFactorRHConductor.setBounds(287, 33, 69, 22);
	panelDocumento_1.add(cbFactorRHConductor);
	
	JTextPane txtpnDonadorDeOrganos = new JTextPane();
	txtpnDonadorDeOrganos.setText("Donador de organos (*)");
	txtpnDonadorDeOrganos.setEditable(false);
	txtpnDonadorDeOrganos.setBackground(SystemColor.menu);
	txtpnDonadorDeOrganos.setBounds(28, 263, 80, 34);
	panelConductor.add(txtpnDonadorDeOrganos);
	
	JComboBox cbDonanteDeOrganos = new JComboBox();
	cbDonanteDeOrganos.setBounds(118, 275, 100, 22);
	panelConductor.add(cbDonanteDeOrganos);
	
	JTextPane txtpnClaseLicencia = new JTextPane();
	txtpnClaseLicencia.setText("Clase (*)");
	txtpnClaseLicencia.setEditable(false);
	txtpnClaseLicencia.setBackground(SystemColor.menu);
	txtpnClaseLicencia.setBounds(239, 275, 59, 20);
	panelConductor.add(txtpnClaseLicencia);
	
	JComboBox cbClaseLicencia = new JComboBox();
	cbClaseLicencia.setBounds(316, 275, 100, 22);
	panelConductor.add(cbClaseLicencia);
	
	JTextPane txtpnObservaciones = new JTextPane();
	txtpnObservaciones.setText("Observaciones (*)");
	txtpnObservaciones.setEditable(false);
	txtpnObservaciones.setBackground(SystemColor.menu);
	txtpnObservaciones.setBounds(468, 226, 107, 22);
	panelConductor.add(txtpnObservaciones);
	
	JTextArea taObservaciones = new JTextArea();
	taObservaciones.setToolTipText("Observaciones");
	taObservaciones.setBounds(585, 226, 275, 108);
	panelConductor.add(taObservaciones);
	
	JPanel panelAdmin = new JPanel();
	panelAdmin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelAdmin.setBounds(31, 426, 908, 153);
	add(panelAdmin);
	panelAdmin.setLayout(null);
	
	JTextPane txtNombreAdmin = new JTextPane();
	txtNombreAdmin.setText("Nombre completo (*)");
	txtNombreAdmin.setEditable(false);
	txtNombreAdmin.setBackground(SystemColor.menu);
	txtNombreAdmin.setBounds(10, 25, 131, 20);
	panelAdmin.add(txtNombreAdmin);
	
	tfNombreAdmin = new JTextField();
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
	tfApellidoAdmin.setColumns(10);
	tfApellidoAdmin.setBounds(586, 25, 275, 20);
	panelAdmin.add(tfApellidoAdmin);
	
	JTextPane txtFechaEmision = new JTextPane();
	txtFechaEmision.setText("Fecha de emisi\u00F3n (*)");
	txtFechaEmision.setEditable(false);
	txtFechaEmision.setBackground(SystemColor.menu);
	txtFechaEmision.setBounds(10, 89, 131, 20);
	panelAdmin.add(txtFechaEmision);
	
	JButton btnAtras = new JButton("Atr\u00E1s");
	btnAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	btnAtras.setBounds(41, 602, 118, 37);
	add(btnAtras);
	
	JButton btnSiguiente = new JButton("Siguiente");
	btnSiguiente.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnSiguiente.setBounds(810, 602, 118, 37);
	add(btnSiguiente);
	
	}
}
