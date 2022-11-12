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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import mvc.controller.gestores.GestorLicencia;
import mvc.controller.gestores.GestorPersona;
import mvc.model.Conductor;
import mvc.model.Persona;
import mvc.model.TipoDocumento;
import mvc.model.TipoGrupoSanguineo;
import mvc.model.TipoLicencia;
import mvc.view.VentanaAdmin;

public class PntCrearLicencia extends JPanel {
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
	private JDateChooser dcFechaNacimiento;
	private JComboBox cbTipoDocumentoCliente;
	private JComboBox cbGrupoSanguineoConductor;
	private JComboBox cbFactorRHConductor;
	private JComboBox cbDonanteDeOrganos;
	private JComboBox cbClaseLicencia;
	private JComboBox cbSexoCliente;
	
	JButton btnCrearTitular = new JButton("Crear titular");
	
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
	
	JTextPane txtpnDireccion = new JTextPane();
	txtpnDireccion.setText("Direcci\u00F3n");
	txtpnDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtpnDireccion.setEditable(false);
	txtpnDireccion.setBackground(SystemColor.menu);
	txtpnDireccion.setBounds(481, 57, 71, 22);
	panelConductor.add(txtpnDireccion);
	
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
	txtNombreCliente.setBounds(28, 11, 125, 20);
	panelConductor.add(txtNombreCliente);
	
	tfNombreCliente = new JTextField();
	tfNombreCliente.setBounds(156, 11, 260, 20);
	panelConductor.add(tfNombreCliente);
	tfNombreCliente.setColumns(10);
	
	JTextPane txtApellidoCliente = new JTextPane();
	txtApellidoCliente.setText("Apellido(s) (*)");
	txtApellidoCliente.setEditable(false);
	txtApellidoCliente.setBackground(SystemColor.menu);
	txtApellidoCliente.setBounds(468, 11, 89, 20);
	panelConductor.add(txtApellidoCliente);
	
	tfApellidoCliente = new JTextField();
	tfApellidoCliente.setColumns(10);
	tfApellidoCliente.setBounds(567, 11, 293, 20);
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
	
	cbTipoDocumentoCliente = new JComboBox();
	cbTipoDocumentoCliente.setBounds(78, 11, 85, 22);
	panelDocumento.add(cbTipoDocumentoCliente);
	
	JTextPane txtFechaNacCliente = new JTextPane();
	txtFechaNacCliente.setText("Fecha de nacimiento (*)");
	txtFechaNacCliente.setEditable(false);
	txtFechaNacCliente.setBackground(SystemColor.menu);
	txtFechaNacCliente.setBounds(30, 143, 133, 20);
	panelConductor.add(txtFechaNacCliente);
	
	JTextPane txtGrupoSangYFactRH = new JTextPane();
	txtGrupoSangYFactRH.setText("Grupo sangu\u00EDneo");
	txtGrupoSangYFactRH.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtGrupoSangYFactRH.setEditable(false);
	txtGrupoSangYFactRH.setBackground(SystemColor.menu);
	txtGrupoSangYFactRH.setBounds(41, 186, 103, 22);
	panelConductor.add(txtGrupoSangYFactRH);
	
	JPanel panelDocumento_1 = new JPanel();
	panelDocumento_1.setLayout(null);
	panelDocumento_1.setToolTipText("");
	panelDocumento_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelDocumento_1.setBounds(28, 197, 388, 78);
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
	
	cbGrupoSanguineoConductor = new JComboBox();
	cbGrupoSanguineoConductor.setBounds(114, 33, 69, 22);
	panelDocumento_1.add(cbGrupoSanguineoConductor);
	
	cbFactorRHConductor = new JComboBox();
	cbFactorRHConductor.setBounds(287, 33, 69, 22);
	panelDocumento_1.add(cbFactorRHConductor);
	
	JTextPane txtpnDonadorDeOrganos = new JTextPane();
	txtpnDonadorDeOrganos.setText("Donador de organos (*)");
	txtpnDonadorDeOrganos.setEditable(false);
	txtpnDonadorDeOrganos.setBackground(SystemColor.menu);
	txtpnDonadorDeOrganos.setBounds(28, 310, 80, 34);
	panelConductor.add(txtpnDonadorDeOrganos);
	
	cbDonanteDeOrganos = new JComboBox();
	cbDonanteDeOrganos.setBounds(118, 322, 100, 22);
	panelConductor.add(cbDonanteDeOrganos);
	
	JTextPane txtpnClaseLicencia = new JTextPane();
	txtpnClaseLicencia.setText("Clase (*)");
	txtpnClaseLicencia.setEditable(false);
	txtpnClaseLicencia.setBackground(SystemColor.menu);
	txtpnClaseLicencia.setBounds(239, 322, 59, 20);
	panelConductor.add(txtpnClaseLicencia);
	
	cbClaseLicencia = new JComboBox();
	cbClaseLicencia.setBounds(316, 322, 100, 22);
	panelConductor.add(cbClaseLicencia);
	
	JTextPane txtpnObservaciones = new JTextPane();
	txtpnObservaciones.setText("Observaciones (*)");
	txtpnObservaciones.setEditable(false);
	txtpnObservaciones.setBackground(SystemColor.menu);
	txtpnObservaciones.setBounds(468, 197, 107, 22);
	panelConductor.add(txtpnObservaciones);
	
	JTextArea taObservaciones = new JTextArea();
	taObservaciones.setToolTipText("Observaciones");
	taObservaciones.setBounds(585, 197, 275, 147);
	panelConductor.add(taObservaciones);
	
	JTextPane txtpnSexoCliente = new JTextPane();
	txtpnSexoCliente.setText("Sexo (*)");
	txtpnSexoCliente.setEditable(false);
	txtpnSexoCliente.setBackground(SystemColor.menu);
	txtpnSexoCliente.setBounds(287, 143, 58, 20);
	panelConductor.add(txtpnSexoCliente);
	
	cbSexoCliente = new JComboBox();
	cbSexoCliente.setBounds(352, 143, 64, 22);
	panelConductor.add(cbSexoCliente);
	
	JPanel panelDocumento_2 = new JPanel();
	panelDocumento_2.setLayout(null);
	panelDocumento_2.setToolTipText("");
	panelDocumento_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelDocumento_2.setBounds(468, 68, 392, 78);
	panelConductor.add(panelDocumento_2);
	
	JTextPane txtCalle = new JTextPane();
	txtCalle.setBounds(10, 11, 59, 20);
	panelDocumento_2.add(txtCalle);
	txtCalle.setText("Calle (*)");
	txtCalle.setEditable(false);
	txtCalle.setBackground(SystemColor.menu);
	
	tfCalleCliente = new JTextField();
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
	tfPisoCliente.setColumns(10);
	tfPisoCliente.setBounds(209, 42, 64, 20);
	panelDocumento_2.add(tfPisoCliente);
	
	dcFechaNacimiento = new JDateChooser();
	dcFechaNacimiento.setBounds(162, 143, 115, 20);
	panelConductor.add(dcFechaNacimiento);
	
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
	
	JButton btnEmitirLicencia = new JButton("Emitir licencia");
	btnEmitirLicencia.setEnabled(false);
	btnEmitirLicencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnEmitirLicencia.setBounds(810, 602, 118, 37);
	add(btnEmitirLicencia);
	

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
					
					if(conductor.size()==0) {
						btnCrearTitular.setEnabled(true);
						VentanaAdmin.mensajeError("Persona no encontrada", "ERROR");
					}else {
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
		//TODO : Preguntar sobre num de dir, dpto y piso
		
		
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fechaNac = dateFormat.format(conductor.getFechaNacimiento());
		dcFechaNacimiento.setDate(Date.parse(fechaNac));*/
		
	}
	
	private void llenarCB() throws Exception {
		
		//Llena el combo box de tipo de documento
		List<TipoDocumento> tipoDoc= GestorPersona.obtenerTipoDocumento();
		int tamList = tipoDoc.size();

		cbTipoDocumentoCliente.addItem("Seleccionar opción");
		for(int i=0; i<tamList; i++) {
			cbTipoDocumentoCliente.addItem(tipoDoc.get(i).getTipoDocumentoTexto());
		}
		
		//Llena el combo box del tipo de sangre
		List<TipoGrupoSanguineo> tipoGrupoSang= GestorPersona.obtenerTipoGrupoSanguineo();
		int tamList1 = tipoGrupoSang.size();

		cbGrupoSanguineoConductor.addItem("Seleccionar opción");
		for(int i=0; i<tamList1; i++) {
			cbGrupoSanguineoConductor.addItem(tipoGrupoSang.get(i).getTipoGrupoSanguineoTexto());
		}
		
		//Llena el combo box del tipo de licencia
		List<TipoLicencia> tipoLicencia= GestorLicencia.obtenerTipoLicencia();
		int tamList2 = tipoLicencia.size();

		cbClaseLicencia.addItem("Seleccionar opción");
		for(int i=0; i<tamList2; i++) {
			cbClaseLicencia.addItem(tipoLicencia.get(i).getTipoLicenciaTexto());
		}
		
		//Llena el combo box de donante
			cbDonanteDeOrganos.addItem("Seleccionar opción");
			cbDonanteDeOrganos.addItem("SI");
			cbDonanteDeOrganos.addItem("NO");
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
			VentanaAdmin.mensajeError("El valor ingresado es incorrecto.\nIngrese un valor válido.", "ERROR");
			return false;
		}
		
	}
}
