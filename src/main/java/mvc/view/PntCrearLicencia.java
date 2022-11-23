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

public class PntCrearLicencia extends JPanel {
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
	private JComboBox cbDonanteDeOrganos;
	private JComboBox cbSexoCliente;
	private JComboBox<String> cbGrupoSanguineoConductor;
	private JTextPane txtpnObservaciones;
	private JCheckBox chbxTipoLicenciaA;
	private JCheckBox chbxTipoLicenciaB;
	private JCheckBox chbxTipoLicenciaC;
	private JCheckBox chbxTipoLicenciaD;
	private JCheckBox chbxTipoLicenciaE;
	private JCheckBox chbxTipoLicenciaF;
	private JCheckBox chbxTipoLicenciaG;
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
	
	public PntCrearLicencia() {
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
	
	JTextPane txtpnClasesDeLicencias = new JTextPane();
	txtpnClasesDeLicencias.setText("Clases de licencias");
	txtpnClasesDeLicencias.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtpnClasesDeLicencias.setEditable(false);
	txtpnClasesDeLicencias.setBackground(SystemColor.menu);
	txtpnClasesDeLicencias.setBounds(41, 254, 114, 22);
	panelConductor.add(txtpnClasesDeLicencias);
	
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
	
	JTextPane txtpnDonadorDeOrganos = new JTextPane();
	txtpnDonadorDeOrganos.setText("Donante de organos (*)");
	txtpnDonadorDeOrganos.setEditable(false);
	txtpnDonadorDeOrganos.setBackground(SystemColor.menu);
	txtpnDonadorDeOrganos.setBounds(265, 209, 80, 34);
	panelConductor.add(txtpnDonadorDeOrganos);
	
	cbDonanteDeOrganos = new JComboBox();
	cbDonanteDeOrganos.setEnabled(false);
	cbDonanteDeOrganos.setBounds(345, 209, 71, 22);
	panelConductor.add(cbDonanteDeOrganos);
	
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
	
	JPanel panelClasesDeLicencias = new JPanel();
	panelClasesDeLicencias.setLayout(null);
	panelClasesDeLicencias.setToolTipText("");
	panelClasesDeLicencias.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelClasesDeLicencias.setBounds(28, 265, 388, 79);
	panelConductor.add(panelClasesDeLicencias);
	
	chbxTipoLicenciaA = new JCheckBox("A");
	chbxTipoLicenciaA.setEnabled(false);
	chbxTipoLicenciaA.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			agregarALista(chbxTipoLicenciaA,"1");
			
		}
	});
	chbxTipoLicenciaA.setBounds(19, 7, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaA);
	
	chbxTipoLicenciaB = new JCheckBox("B");
	chbxTipoLicenciaB.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaB);
	chbxTipoLicenciaB.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			validarRelacionesDeLicencias(chbxTipoLicenciaB, licenciasConCDE);
			agregarALista(chbxTipoLicenciaB,"2");
			
		}
	});
	chbxTipoLicenciaB.setBounds(19, 49, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaB);
	
	chbxTipoLicenciaC = new JCheckBox("C");
	chbxTipoLicenciaC.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaC);
	chbxTipoLicenciaC.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			validarRelacionesDeLicencias(chbxTipoLicenciaC, licenciasConCDE);
			agregarALista(chbxTipoLicenciaC,"3");
			
		}
	});
	chbxTipoLicenciaC.setBounds(102, 7, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaC);
	
	chbxTipoLicenciaD = new JCheckBox("D");
	chbxTipoLicenciaD.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaD);
	chbxTipoLicenciaD.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			validarRelacionesDeLicencias(chbxTipoLicenciaD, licenciasConCDE);
			agregarALista(chbxTipoLicenciaD,"4");
			
		}
	});
	chbxTipoLicenciaD.setBounds(102, 49, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaD);
	
	chbxTipoLicenciaE = new JCheckBox("E");
	chbxTipoLicenciaE.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaE);
	chbxTipoLicenciaE.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			validarRelacionesDeLicencias(chbxTipoLicenciaE, licenciasConCDE);
			agregarALista(chbxTipoLicenciaE,"5");
			
		}
	});
	chbxTipoLicenciaE.setBounds(193, 7, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaE);
	
	chbxTipoLicenciaF = new JCheckBox("F");
	chbxTipoLicenciaF.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaF);
	chbxTipoLicenciaF.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			validarRelacionesDeLicencias(chbxTipoLicenciaF, licenciasConCDE);
			agregarALista(chbxTipoLicenciaF,"6");
			
		}
	});
	chbxTipoLicenciaF.setBounds(193, 49, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaF);
	
	chbxTipoLicenciaG = new JCheckBox("G");
	chbxTipoLicenciaG.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaG);
	chbxTipoLicenciaG.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			validarRelacionesDeLicencias(chbxTipoLicenciaG, licenciasConCDE);
			agregarALista(chbxTipoLicenciaG,"7");
			
		}
	});
	chbxTipoLicenciaG.setBounds(287, 7, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaG);
	
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
	
	btnEmitirLicencia = new JButton("Emitir licencia");
	btnEmitirLicencia.setEnabled(false);
	btnEmitirLicencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(validarSelecciones()) {
				try {
					cargarEmitirLicenciaDTO();
					//GestorPersona.actualizarConductorDonante(emitirLicenciaDTO);
					//GestorLicencia.crearLicencia(emitirLicenciaDTO);
					PntImprimirLicencia pntImprimirLicencia= new PntImprimirLicencia(emitirLicenciaDTO);
					VentanaAdmin.cambiarPantalla(pntImprimirLicencia,VentanaAdmin.n_pntImprimirLicencia);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}		}
	});
	btnEmitirLicencia.setBounds(810, 602, 118, 37);
	add(btnEmitirLicencia);
	btnCrearTitular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.pntDarAltaTitularUI,VentanaAdmin.n_pntDarAltaTitularUI);
		}
	});
	

	btnCrearTitular.setEnabled(false);
	btnCrearTitular.setBounds(513, 602, 232, 37);
	add(btnCrearTitular);
	
	JButton btnBuscarTitular = new JButton("Buscar titular");
	btnBuscarTitular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String val = VentanaAdmin.mensajeBusqueda(null, "Ingrese DNI del titular");
			if(esDniValido(val)) {
				int dni = Integer.parseInt(val);
				List<Conductor> conductor;
				try {
					
					conductor = GestorPersona.obtenerConductorxDni(dni);
					
					limpiarPantalla();
					if(conductor.size()==0) {
						btnCrearTitular.setEnabled(true);
						btnEmitirLicencia.setEnabled(false);
						VentanaAdmin.mensajeError("Persona no encontrada", "ERROR");
					}else {
						validarLicenciaASeleccionar(conductor.get(0).getFechaNacimiento(), conductor.get(0).getDni());
						btnCrearTitular.setEnabled(false);
						cargarDatosenCampos(conductor.get(0));
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	});
	btnBuscarTitular.setBounds(231, 602, 232, 37);
	add(btnBuscarTitular);
	
	try {
		llenarCB();
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	
	}
	

	protected boolean validarSelecciones() {
		lblErrorDonantes.setText("");
		lblErrorLicencias.setText("");
		
		if(licenciasSelec.size()==0) {
			lblErrorLicencias.setText("Por favor seleccione un tipo de licencia.");
			return false;
		}
		if(cbDonanteDeOrganos.getSelectedIndex()==0) {
			lblErrorDonantes.setText("Por favor seleccione una opci�n.");
			return false;
		}
		return true;
		
	}

	protected void validarLicenciaASeleccionar(LocalDate fechaNacimiento, int dni) throws Exception {
		LocalDate fechaActual=LocalDate.now();
		Period periodAniosCond = Period.between(fechaNacimiento, fechaActual);
		int aniosConductor= periodAniosCond.getYears();
		
		int aniosAntiguedad= calcularAntiguedadLicB(dni, fechaActual);
		int licenciasCDE= calcularCantLicCDE(dni);
		
		if(aniosConductor<17) {
			cbDonanteDeOrganos.setEnabled(false);
			btnEmitirLicencia.setEnabled(false);
			lblErrorLicencias.setText("Menores de 17 a�os no pueden solicitar NINGUNA licencia.");
		}else if(aniosConductor<21) {
			taObservaciones.setEnabled(true);
			cbDonanteDeOrganos.setEnabled(true);
			btnEmitirLicencia.setEnabled(true);
			chbxTipoLicenciaA.setEnabled(true);
			chbxTipoLicenciaB.setEnabled(true);
			chbxTipoLicenciaF.setEnabled(true);
			chbxTipoLicenciaG.setEnabled(true);
			lblErrorLicencias.setText("Menores de 21 a�os no pueden solicitar licencias C, D o E.");
		}else if((aniosConductor>=21 && aniosAntiguedad<1)) {
			taObservaciones.setEnabled(true);
			cbDonanteDeOrganos.setEnabled(true);
			btnEmitirLicencia.setEnabled(true);
			chbxTipoLicenciaA.setEnabled(true);
			chbxTipoLicenciaB.setEnabled(true);
			chbxTipoLicenciaF.setEnabled(true);
			chbxTipoLicenciaG.setEnabled(true);
			lblErrorLicencias.setText("No posee 1 a�o o mas de antiguedad con licencia B.");
		}else if(aniosConductor>65 && licenciasCDE==0) {
			taObservaciones.setEnabled(true);
			cbDonanteDeOrganos.setEnabled(true);
			btnEmitirLicencia.setEnabled(true);
			chbxTipoLicenciaA.setEnabled(true);
			chbxTipoLicenciaB.setEnabled(true);
			chbxTipoLicenciaF.setEnabled(true);
			chbxTipoLicenciaG.setEnabled(true);
			lblErrorLicencias.setText("Mayores de 65 a�os no pueden solicitar licencias C, D o E por primera vez.");
		}else if(aniosConductor>=21 && aniosAntiguedad>=1) {
			taObservaciones.setEnabled(true);
			cbDonanteDeOrganos.setEnabled(true);
			btnEmitirLicencia.setEnabled(true);
			chbxTipoLicenciaA.setEnabled(true);
			chbxTipoLicenciaB.setEnabled(true);
			chbxTipoLicenciaC.setEnabled(true);
			chbxTipoLicenciaD.setEnabled(true);
			chbxTipoLicenciaE.setEnabled(true);
			chbxTipoLicenciaF.setEnabled(true);
			chbxTipoLicenciaG.setEnabled(true);
			licenciasConCDE=true;
		}
		
	}
	
	private void validarRelacionesDeLicencias(JCheckBox licencia, Boolean esLicenciaCDE) {
		if(licencia.isSelected()) {
			for(int i=0; i<licenciasCheckBox.size();i++) {
				if(!licenciasCheckBox.get(i).equals(licencia)) {
					licenciasCheckBox.get(i).setEnabled(false);
				}
			}
		}else {
			if(esLicenciaCDE) {
				for(int i=0; i<licenciasCheckBox.size();i++) {
						licenciasCheckBox.get(i).setEnabled(true);
				}
			}else {
				for(int i=0; i<licenciasCheckBox.size();i++) {
					if((!licenciasCheckBox.get(i).equals(chbxTipoLicenciaC)) && (!licenciasCheckBox.get(i).equals(chbxTipoLicenciaD)) && (!licenciasCheckBox.get(i).equals(chbxTipoLicenciaE))) {
						licenciasCheckBox.get(i).setEnabled(true);
					}
				}
			}
		}
	}



	private int calcularCantLicCDE(int dni) throws Exception {
		int cantLic=0;
		List<Licencia> licencias= GestorLicencia.obtenerLicenciaxDni(dni);
		
		for(int i=0; i<licencias.size();i++) {
			if(licencias.get(i).getIdTipoLicencia()==3 || licencias.get(i).getIdTipoLicencia()==4 || licencias.get(i).getIdTipoLicencia()==5) {
				cantLic++;
			}
		}
		
		return cantLic;
	}



	private int calcularAntiguedadLicB(int dni, LocalDate fechaActual) throws Exception {
		int aniosAntiguedad=0;
		List<Licencia> licencia= GestorLicencia.obtenerLicenciaxDnixTipo(dni, 2); 
		LocalDate fechaEmision=licencia.get(0).getFechaEmision();
		
		Period periodAniosEmision = Period.between(fechaEmision, fechaActual);
		aniosAntiguedad= periodAniosEmision.getYears();
		return aniosAntiguedad;
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
		cbDonanteDeOrganos.setSelectedIndex(0);
		cbDonanteDeOrganos.setEnabled(false);
		tfFechaNacimConductor.setText("");
		taObservaciones.setText("");
		taObservaciones.setEnabled(false);
		lblErrorLicencias.setText("");
		lblErrorDonantes.setText("");
		chbxTipoLicenciaA.setEnabled(false);
		chbxTipoLicenciaB.setEnabled(false);
		chbxTipoLicenciaC.setEnabled(false);
		chbxTipoLicenciaD.setEnabled(false);
		chbxTipoLicenciaE.setEnabled(false);
		chbxTipoLicenciaF.setEnabled(false);
		chbxTipoLicenciaG.setEnabled(false);
		chbxTipoLicenciaA.setSelected(false);
		chbxTipoLicenciaB.setSelected(false);
		chbxTipoLicenciaC.setSelected(false);
		chbxTipoLicenciaD.setSelected(false);
		chbxTipoLicenciaE.setSelected(false);
		chbxTipoLicenciaF.setSelected(false);
		chbxTipoLicenciaG.setSelected(false);
	}

	protected void habilitarChbxLicencias() {
		chbxTipoLicenciaA.setEnabled(true);
		chbxTipoLicenciaB.setEnabled(true);
		chbxTipoLicenciaC.setEnabled(true);
		chbxTipoLicenciaD.setEnabled(true);
		chbxTipoLicenciaE.setEnabled(true);
		chbxTipoLicenciaF.setEnabled(true);
		chbxTipoLicenciaG.setEnabled(true);
	}

	protected void agregarALista(JCheckBox chbxTipoLicencia, String i) {
		if(chbxTipoLicencia.isSelected()==true) {
			licenciasSelec.add(i);
		}else {
			licenciasSelec.remove(i);
		}
		
	}

	protected void cargarEmitirLicenciaDTO() throws Exception {
		emitirLicenciaDTO.setNombreCond(tfNombreCliente.getText());
		emitirLicenciaDTO.setApellidoCond(tfApellidoCliente.getText());
		emitirLicenciaDTO.setTipoDoc(cbTipoDocumentoCliente.getSelectedIndex());
		emitirLicenciaDTO.setNumDoc(Integer.parseInt(tfNroDocumentoCliente.getText()));
		emitirLicenciaDTO.setFechaNacimiento(LocalDate.parse(tfFechaNacimConductor.getText(),formatter));
		emitirLicenciaDTO.setSexo(cbSexoCliente.getSelectedItem().toString());
		emitirLicenciaDTO.setGrupoSang(cbGrupoSanguineoConductor.getSelectedIndex()); //1-Masc 2-Fem
		emitirLicenciaDTO.setEsDonante(esDonante());
		emitirLicenciaDTO.setCalle(tfCalleCliente.getText());
		emitirLicenciaDTO.setNumCalle(Integer.parseInt(tfNumDirCliente.getText()));
		emitirLicenciaDTO.setPiso(Integer.parseInt(tfPisoCliente.getText()));
		emitirLicenciaDTO.setDpto(tfDptoCliente.getText());
		emitirLicenciaDTO.setObservaciones(taObservaciones.getText());
		emitirLicenciaDTO.setLicenciasSeleccionadas(licenciasSelec);
		emitirLicenciaDTO.setFechaEmision(LocalDate.parse(tfFechaEmision.getText()));
		emitirLicenciaDTO.setFechaVigencia(GestorLicencia.calculoVigencia(emitirLicenciaDTO.getFechaNacimiento(), emitirLicenciaDTO.getNumDoc()));
		emitirLicenciaDTO.setEsCopia(false);
		emitirLicenciaDTO.setEstaVigente(true);
		
		for(int i=0; i<licenciasSelec.size(); i++) {
			Licencia licencia = new Licencia();
			String stringLicenciaSelec = licencia.getStringClaseLicencia(Integer.parseInt(licenciasSelec.get(i)));
			
			Integer costoLicencia=GestorLicencia.obtenerCostoxClasexAnio(stringLicenciaSelec , GestorLicencia.calculoAniosVigencia(emitirLicenciaDTO.getFechaNacimiento(), emitirLicenciaDTO.getNumDoc())).get(0).getCosto();
			costosLicencias.add(costoLicencia);
		}
		
		emitirLicenciaDTO.setCosto(costosLicencias);
	}

	private Boolean esDonante() {
		if(cbDonanteDeOrganos.getSelectedIndex()==1) {
			return true;
		}else {
			return false;
		}
	}

	private void cargarDatosenCampos(Conductor conductor) throws ParseException {
		tfNombreCliente.setText(conductor.getNombre());
		tfApellidoCliente.setText(conductor.getApellido());
		cbTipoDocumentoCliente.setSelectedIndex(conductor.getTipoDoc());
		tfNroDocumentoCliente.setText(Integer.toString(conductor.getDni()));
		tfCalleCliente.setText(conductor.getDireccion());
		tfNumDirCliente.setText(Integer.toString(conductor.getNumDir()));
		tfPisoCliente.setText(Integer.toString(conductor.getPiso()));
		tfDptoCliente.setText(conductor.getDpto());
		cbGrupoSanguineoConductor.setSelectedIndex(conductor.getTipoGrupoSanguineo());
		cbSexoCliente.setSelectedIndex(conductor.getCodSexo());
		tfFechaEmision.setText(LocalDate.now().toString());

		tfFechaNacimConductor.setText(String.valueOf(conductor.getFechaNacimiento().format(formatter)));
	}
	
	private void llenarCB() throws Exception {
		
		//Llena el combo box de tipo de documento
		List<TipoDocumento> tipoDoc= GestorPersona.obtenerTiposDocumentos();
		int tamList = tipoDoc.size();

		cbTipoDocumentoCliente.addItem("-Seleccione-");
		for(int i=0; i<tamList; i++) {
			cbTipoDocumentoCliente.addItem(tipoDoc.get(i).getTipo_doc());
		}
		
		//Llena el combo box del tipo de sangre
		List<TipoGrupoSanguineo> tipoGrupoSang= GestorPersona.obtenerTiposGrupoSanguineos();
		int tamList1 = tipoGrupoSang.size();
		
		cbGrupoSanguineoConductor.addItem("-Seleccione-");
		for(int i=0; i<tamList1; i++) {
			cbGrupoSanguineoConductor.addItem(tipoGrupoSang.get(i).getTipo_grupo_sanguineo());
		}
		
		//Llena el combo box de donante
		cbDonanteDeOrganos.addItem("-Seleccione-");
		cbDonanteDeOrganos.addItem("SI");
		cbDonanteDeOrganos.addItem("NO");

		//Llena el combo box de sexo
		cbSexoCliente.addItem("-Seleccione-");
		cbSexoCliente.addItem("M");
		cbSexoCliente.addItem("F");
	}

	private boolean esDniValido(String val) {
		int dni=0;
		if(!val.equals(null) && Integer.parseInt(val) > 0 ) {
			if (val.length() <= 8 && val.length() >= 7) {
				dni= Integer.parseInt(val);
				return true;
			}else {
				VentanaAdmin.mensajeError("La longitud del documento no es correcta", "ERROR");
				return false;
			}
		}else {
			VentanaAdmin.mensajeError("El valor ingresado es incorrecto.\nIngrese un valor v�lido.", "ERROR");
			return false;
		}
		
	}
}
