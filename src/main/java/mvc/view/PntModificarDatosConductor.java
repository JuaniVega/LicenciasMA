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
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import mvc.controller.dao.PersonaDao;
import mvc.controller.dto.EmitirLicenciaDTO;
import mvc.controller.dto.AdministradorDTO;
import mvc.controller.dto.ConductorDTO;
import mvc.controller.gestores.GestorLicencia;
import mvc.controller.gestores.GestorPersona;
import mvc.model.Conductor;
import mvc.model.Licencia;
import mvc.model.Persona;
import mvc.model.TipoDocumento;
import mvc.model.TipoGrupoSanguineo;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;

public class PntModificarDatosConductor extends JPanel {
	
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
	private JComboBox<String> cbTipoDocumentoCliente;
	private JComboBox cbSexoCliente;
	private JComboBox cbDonanteDeOrganos;
	private JComboBox<String> cbGrupoSanguineoConductor;
	private JLabel lblTipoDoc;
	private JLabel lblCalle;
	private JLabel lblSexo;
	private JLabel lblGrupoSang;
	private JLabel lblDonante;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JButton btnGuardarCambios;
	private JDateChooser dcFechaNacim;
	private int dni;
	
	public PntModificarDatosConductor() {
		
	}
	
	public PntModificarDatosConductor(final AdministradorDTO admin) {
		setLocation(-31, -63);
	setPreferredSize(new Dimension(980, 650));
	setLayout(null);
	
	JTextPane txtpnModificarDatos = new JTextPane();
	txtpnModificarDatos.setText("MODIFICAR DATOS DEL CONDUCTOR ");
	txtpnModificarDatos.setFont(new Font("Tahoma", Font.BOLD, 21));
	txtpnModificarDatos.setEditable(false);
	txtpnModificarDatos.setBackground(SystemColor.menu);
	txtpnModificarDatos.setBounds(284, 24, 444, 37);
	add(txtpnModificarDatos);
	
	JPanel panelConductor = new JPanel();
	panelConductor.setBorder(new TitledBorder(null, "Datos Conductor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelConductor.setToolTipText("");
	panelConductor.setBounds(31, 72, 908, 344);
	add(panelConductor);
	panelConductor.setLayout(null);
	
	JTextPane txtNombreCliente = new JTextPane();
	txtNombreCliente.setText("Nombre completo (*)");
	txtNombreCliente.setEditable(false);
	txtNombreCliente.setBackground(SystemColor.menu);
	txtNombreCliente.setBounds(28, 68, 125, 20);
	panelConductor.add(txtNombreCliente);
	
	tfNombreCliente = new JTextField();
	tfNombreCliente.setEnabled(false);
	tfNombreCliente.setBounds(163, 68, 268, 20);
	panelConductor.add(tfNombreCliente);
	tfNombreCliente.setColumns(10);
	
	JTextPane txtApellidoCliente = new JTextPane();
	txtApellidoCliente.setText("Apellido(s) (*)");
	txtApellidoCliente.setEditable(false);
	txtApellidoCliente.setBackground(SystemColor.menu);
	txtApellidoCliente.setBounds(468, 68, 89, 20);
	panelConductor.add(txtApellidoCliente);
	
	tfApellidoCliente = new JTextField();
	tfApellidoCliente.setEnabled(false);
	tfApellidoCliente.setColumns(10);
	tfApellidoCliente.setBounds(551, 69, 307, 20);
	panelConductor.add(tfApellidoCliente);
	
	JPanel panelDocumento = new JPanel();
	panelDocumento.setLayout(null);
	panelDocumento.setToolTipText("");
	panelDocumento.setBorder(new TitledBorder(null, "Documento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelDocumento.setBounds(28, 121, 430, 78);
	panelConductor.add(panelDocumento);
	
	JTextPane txtTipoDocumentoCliente = new JTextPane();
	txtTipoDocumentoCliente.setText("Tipo (*)");
	txtTipoDocumentoCliente.setEditable(false);
	txtTipoDocumentoCliente.setBackground(SystemColor.menu);
	txtTipoDocumentoCliente.setBounds(21, 24, 58, 20);
	panelDocumento.add(txtTipoDocumentoCliente);
	
	tfNroDocumentoCliente = new JTextField();
	tfNroDocumentoCliente.setEnabled(false);
	tfNroDocumentoCliente.setColumns(10);
	tfNroDocumentoCliente.setBounds(282, 24, 120, 20);
	panelDocumento.add(tfNroDocumentoCliente);
	
	JTextPane txtNroDocumentoCliente = new JTextPane();
	txtNroDocumentoCliente.setText("N\u00FAmero (*)");
	txtNroDocumentoCliente.setEditable(false);
	txtNroDocumentoCliente.setBackground(SystemColor.menu);
	txtNroDocumentoCliente.setBounds(201, 24, 71, 20);
	panelDocumento.add(txtNroDocumentoCliente);
	
	cbTipoDocumentoCliente = new JComboBox();
	cbTipoDocumentoCliente.setEnabled(false);
	cbTipoDocumentoCliente.setBounds(89, 24, 85, 22);
	panelDocumento.add(cbTipoDocumentoCliente);
	
	lblTipoDoc = new JLabel("");
	lblTipoDoc.setForeground(Color.RED);
	lblTipoDoc.setBounds(21, 53, 381, 14);
	panelDocumento.add(lblTipoDoc);
	
	JTextPane txtFechaNacCliente = new JTextPane();
	txtFechaNacCliente.setText("Fecha de nacimiento (*)");
	txtFechaNacCliente.setEditable(false);
	txtFechaNacCliente.setBackground(SystemColor.menu);
	txtFechaNacCliente.setBounds(28, 232, 133, 20);
	panelConductor.add(txtFechaNacCliente);
	
	JTextPane txtpnSexoCliente = new JTextPane();
	txtpnSexoCliente.setText("Sexo (*)");
	txtpnSexoCliente.setEditable(false);
	txtpnSexoCliente.setBackground(SystemColor.menu);
	txtpnSexoCliente.setBounds(299, 231, 48, 20);
	panelConductor.add(txtpnSexoCliente);
	
	cbSexoCliente = new JComboBox();
	cbSexoCliente.setEnabled(false);
	cbSexoCliente.setBounds(355, 231, 91, 22);
	panelConductor.add(cbSexoCliente);
	
	JPanel panelDocumento_2 = new JPanel();
	panelDocumento_2.setLayout(null);
	panelDocumento_2.setToolTipText("");
	panelDocumento_2.setBorder(new TitledBorder(null, "Direcci\u00F3n ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelDocumento_2.setBounds(468, 121, 406, 135);
	panelConductor.add(panelDocumento_2);
	
	JTextPane txtCalle = new JTextPane();
	txtCalle.setBounds(10, 30, 59, 20);
	panelDocumento_2.add(txtCalle);
	txtCalle.setText("Calle (*)");
	txtCalle.setEditable(false);
	txtCalle.setBackground(SystemColor.menu);
	
	tfCalleCliente = new JTextField();
	tfCalleCliente.setEnabled(false);
	tfCalleCliente.setBounds(70, 30, 160, 20);
	panelDocumento_2.add(tfCalleCliente);
	tfCalleCliente.setColumns(10);
	
	JTextPane txtpnNumero = new JTextPane();
	txtpnNumero.setText("N\u00FAmero (*)");
	txtpnNumero.setEditable(false);
	txtpnNumero.setBackground(SystemColor.menu);
	txtpnNumero.setBounds(240, 30, 74, 20);
	panelDocumento_2.add(txtpnNumero);
	
	tfNumDirCliente = new JTextField();
	tfNumDirCliente.setEnabled(false);
	tfNumDirCliente.setColumns(10);
	tfNumDirCliente.setBounds(318, 30, 64, 20);
	panelDocumento_2.add(tfNumDirCliente);
	
	JTextPane txtpnDpto = new JTextPane();
	txtpnDpto.setText("Dpto");
	txtpnDpto.setEditable(false);
	txtpnDpto.setBackground(SystemColor.menu);
	txtpnDpto.setBounds(48, 86, 47, 20);
	panelDocumento_2.add(txtpnDpto);
	
	tfDptoCliente = new JTextField();
	tfDptoCliente.setEnabled(false);
	tfDptoCliente.setColumns(10);
	tfDptoCliente.setBounds(105, 86, 59, 20);
	panelDocumento_2.add(tfDptoCliente);
	
	JTextPane txtpnPiso = new JTextPane();
	txtpnPiso.setText("Piso");
	txtpnPiso.setEditable(false);
	txtpnPiso.setBackground(SystemColor.menu);
	txtpnPiso.setBounds(193, 86, 47, 20);
	panelDocumento_2.add(txtpnPiso);
	
	tfPisoCliente = new JTextField();
	tfPisoCliente.setEnabled(false);
	tfPisoCliente.setColumns(10);
	tfPisoCliente.setBounds(250, 86, 64, 20);
	panelDocumento_2.add(tfPisoCliente);
	
	lblCalle = new JLabel("");
	lblCalle.setForeground(Color.RED);
	lblCalle.setBounds(10, 61, 372, 14);
	panelDocumento_2.add(lblCalle);
	
	JTextPane txtGrupoSanguineo = new JTextPane();
	txtGrupoSanguineo.setText("Grupo sangu\u00EDneo (*)");
	txtGrupoSanguineo.setEditable(false);
	txtGrupoSanguineo.setBackground(SystemColor.menu);
	txtGrupoSanguineo.setBounds(28, 288, 122, 33);
	panelConductor.add(txtGrupoSanguineo);
	
	cbGrupoSanguineoConductor = new JComboBox();
	cbGrupoSanguineoConductor.setEnabled(false);
	cbGrupoSanguineoConductor.setBounds(166, 287, 107, 22);
	panelConductor.add(cbGrupoSanguineoConductor);
	
	JTextPane txtpnDonanteDeOrganos = new JTextPane();
	txtpnDonanteDeOrganos.setText("Donante de organos (*)");
	txtpnDonanteDeOrganos.setEditable(false);
	txtpnDonanteDeOrganos.setBackground(SystemColor.menu);
	txtpnDonanteDeOrganos.setBounds(299, 288, 78, 33);
	panelConductor.add(txtpnDonanteDeOrganos);
	
	cbDonanteDeOrganos = new JComboBox();
	cbDonanteDeOrganos.setEnabled(false);
	cbDonanteDeOrganos.setBounds(379, 288, 67, 22);
	panelConductor.add(cbDonanteDeOrganos);
	
	dcFechaNacim = new JDateChooser();
	dcFechaNacim.setDateFormatString("dd MM yyyy");
	dcFechaNacim.setBounds(163, 232, 110, 20);
	dcFechaNacim.setEnabled(false);
	panelConductor.add(dcFechaNacim);
	
	lblSexo = new JLabel("");
	lblSexo.setForeground(Color.RED);
	lblSexo.setBounds(299, 262, 258, 14);
	panelConductor.add(lblSexo);
	
	lblGrupoSang = new JLabel("");
	lblGrupoSang.setForeground(Color.RED);
	lblGrupoSang.setBounds(28, 320, 245, 14);
	panelConductor.add(lblGrupoSang);
	
	lblDonante = new JLabel("");
	lblDonante.setForeground(Color.RED);
	lblDonante.setBounds(299, 321, 258, 14);
	panelConductor.add(lblDonante);
	
	lblNombre = new JLabel("");
	lblNombre.setForeground(Color.RED);
	lblNombre.setBounds(163, 99, 268, 14);
	panelConductor.add(lblNombre);
	
	lblApellido = new JLabel("");
	lblApellido.setForeground(Color.RED);
	lblApellido.setBounds(551, 99, 268, 14);
	panelConductor.add(lblApellido);
	
	JPanel panelAdmin = new JPanel();
	panelAdmin.setBorder(new TitledBorder(null, "Datos Administrador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelAdmin.setBounds(31, 427, 908, 137);
	add(panelAdmin);
	panelAdmin.setLayout(null);
	
	JTextPane txtNombreAdmin = new JTextPane();
	txtNombreAdmin.setText("Nombre completo (*)");
	txtNombreAdmin.setEditable(false);
	txtNombreAdmin.setBackground(SystemColor.menu);
	txtNombreAdmin.setBounds(32, 41, 131, 20);
	panelAdmin.add(txtNombreAdmin);
	
	tfNombreAdmin = new JTextField();
	tfNombreAdmin.setEditable(false);
	tfNombreAdmin.setColumns(10);
	tfNombreAdmin.setBounds(173, 41, 275, 20);
	tfNombreAdmin.setText(admin.getNombre());
	panelAdmin.add(tfNombreAdmin);
	
	JTextPane txtApellidoAdmin = new JTextPane();
	txtApellidoAdmin.setText("Apellido(s) (*)");
	txtApellidoAdmin.setEditable(false);
	txtApellidoAdmin.setBackground(SystemColor.menu);
	txtApellidoAdmin.setBounds(485, 41, 85, 20);
	panelAdmin.add(txtApellidoAdmin);
	
	tfApellidoAdmin = new JTextField();
	tfApellidoAdmin.setEditable(false);
	tfApellidoAdmin.setColumns(10);
	tfApellidoAdmin.setBounds(586, 41, 275, 20);
	tfApellidoAdmin.setText(admin.getApellido());
	panelAdmin.add(tfApellidoAdmin);
	
	JTextPane txtFechaEmision = new JTextPane();
	txtFechaEmision.setText("Fecha de emisi\u00F3n (*)");
	txtFechaEmision.setEditable(false);
	txtFechaEmision.setBackground(SystemColor.menu);
	txtFechaEmision.setBounds(32, 87, 131, 20);
	panelAdmin.add(txtFechaEmision);
	
	tfFechaEmision = new JTextField();
	tfFechaEmision.setEditable(false);
	tfFechaEmision.setColumns(10);
	tfFechaEmision.setBounds(173, 87, 275, 20);
	tfFechaEmision.setText(LocalDate.now().toString());
	panelAdmin.add(tfFechaEmision);
	
	JButton btnCancelar = new JButton("Atr\u00E1s");
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			MenuPrincipal menuPrincipal = new MenuPrincipal(admin);
			VentanaAdmin.cambiarPantalla(menuPrincipal, VentanaAdmin.n_pntmenuPrincipal);
			limpiarPantalla();
		}
	});
	btnCancelar.setBounds(41, 602, 118, 37);
	add(btnCancelar);
	
	
	JButton btnBuscarTitular = new JButton("Buscar titular");
	btnBuscarTitular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String val = VentanaAdmin.mensajeBusqueda(null, "Ingrese DNI del titular");
			if(esDniValido(val)) {
				dni = Integer.parseInt(val);
				List<Conductor> conductor;
				try {
					conductor = GestorPersona.obtenerConductorxDni(dni);
					
					limpiarPantalla();
					if( conductor.size()==0) {
						VentanaAdmin.mensajeError("Persona no encontrada", "ERROR");
					}else {
						habilitarCampos();
						btnGuardarCambios.setEnabled(true);
						cargarDatosenCampos(conductor.get(0));
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	});
	btnBuscarTitular.setBounds(374, 602, 232, 37);
	add(btnBuscarTitular);
	
	btnGuardarCambios = new JButton("Guardar cambios");
	btnGuardarCambios.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(validarCampos()) {
				ConductorDTO personaDTO = new ConductorDTO();
				try {
					personaDTO.setNombre(tfNombreCliente.getText());
					personaDTO.setApellido(tfApellidoCliente.getText());
					personaDTO.setCalle(tfCalleCliente.getText());
					personaDTO.setNumCalle(Integer.parseInt(tfNumDirCliente.getText()));
					if(tfPisoCliente.getText().isEmpty() || tfPisoCliente.getText().equals("")) {
						personaDTO.setPiso(-1);
					}else {
						personaDTO.setPiso(Integer.parseInt(tfPisoCliente.getText()));
					}
					if(tfDptoCliente.getText().isEmpty()) {
						personaDTO.setDpto("");
					}else{
						personaDTO.setDpto(tfDptoCliente.getText());
					}
					personaDTO.setSexo(cbSexoCliente.getSelectedIndex());
					personaDTO.setTipoDoc(cbTipoDocumentoCliente.getSelectedIndex());
					personaDTO.setGrupoSang(cbGrupoSanguineoConductor.getSelectedIndex());
					personaDTO.setEsDonante(esDonante());
					personaDTO.setFechaNacimiento(dcFechaNacim.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					personaDTO.setNombreUsuAdmin(admin.getNombre());
					personaDTO.setApellidoUsuAdmin(admin.getApellido());
				   
					GestorPersona.actualizarDatosConductor(personaDTO, dni);
					VentanaAdmin.mensajeExito("Datos actualizados correctamente", "ÉXITO");
					limpiarPantalla();
					deshabilitarCampos();
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		}
	});
	btnGuardarCambios.setBounds(801, 602, 138, 37);
	btnGuardarCambios.setEnabled(false);
	add(btnGuardarCambios);
	
	try {
		llenarCB();
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	
	}
	
	protected void deshabilitarCampos() {
		tfNombreCliente.setEnabled(false);
		tfApellidoCliente.setEnabled(false);
		cbTipoDocumentoCliente.setEnabled(false);
		tfNroDocumentoCliente.setText("");
		tfCalleCliente.setEnabled(false);
		tfNumDirCliente.setEnabled(false);
		tfPisoCliente.setEnabled(false);
		tfDptoCliente.setEnabled(false);
		cbGrupoSanguineoConductor.setEnabled(false);
		cbSexoCliente.setEnabled(false);
		dcFechaNacim.setEnabled(false);
		cbDonanteDeOrganos.setEnabled(false);
		btnGuardarCambios.setEnabled(false);
	}

	private Boolean esDonante() {
		if(cbDonanteDeOrganos.getSelectedIndex()==1) {
			return true;
		}else {
			return false;
		}
	}

	protected void habilitarCampos() {
		tfNombreCliente.setEnabled(true);
		tfApellidoCliente.setEnabled(true);
		cbTipoDocumentoCliente.setEnabled(true);
		tfNroDocumentoCliente.setText("");
		tfCalleCliente.setEnabled(true);
		tfNumDirCliente.setEnabled(true);
		tfPisoCliente.setEnabled(true);
		tfDptoCliente.setEnabled(true);
		cbGrupoSanguineoConductor.setEnabled(true);
		cbSexoCliente.setEnabled(true);
		dcFechaNacim.setEnabled(true);
		cbDonanteDeOrganos.setEnabled(true);
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
		dcFechaNacim.setDate(Date.valueOf(LocalDate.now()));
		cbDonanteDeOrganos.setSelectedIndex(0);
		lblTipoDoc.setText("");
		lblCalle.setText("");
		lblSexo.setText("");
		lblGrupoSang.setText("");
		lblDonante.setText("");
		lblNombre.setText("");
		lblApellido.setText("");
	}

	private void cargarDatosenCampos(Conductor conductor) throws ParseException {
		tfNombreCliente.setText(conductor.getNombre());
		tfApellidoCliente.setText(conductor.getApellido());
		cbTipoDocumentoCliente.setSelectedIndex(conductor.getTipoDoc());
		tfNroDocumentoCliente.setText(Integer.toString(conductor.getDni()));
		cbSexoCliente.setSelectedIndex(conductor.getCodSexo());
		tfFechaEmision.setText(LocalDate.now().toString());
		LocalDate fechaNac = conductor.getFechaNacimiento();
		dcFechaNacim.setDate(Date.from(fechaNac.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		tfCalleCliente.setText(conductor.getDireccion());
		tfNumDirCliente.setText(Integer.toString(conductor.getNumDir()));
		tfDptoCliente.setText(conductor.getDpto());
		cbGrupoSanguineoConductor.setSelectedIndex(conductor.getTipoGrupoSanguineo());
		cbDonanteDeOrganos.setSelectedIndex(conductor.getCodDonaOrganos());
		if(conductor.getPiso()!=-1) {
			tfPisoCliente.setText(Integer.toString(conductor.getPiso()));
		}else {
			tfPisoCliente.setText("");
		}
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

		//Llena el combo box de sexo
		cbSexoCliente.addItem("-Seleccione-");
		cbSexoCliente.addItem("M");
		cbSexoCliente.addItem("F");
		
		//Llena el combo box de donante
		cbDonanteDeOrganos.addItem("-Seleccione-");
		cbDonanteDeOrganos.addItem("SI");
		cbDonanteDeOrganos.addItem("NO");
	}

	private boolean esDniValido(String val) {
		int dni=0;
		if(val != null) {
			if(Integer.parseInt(val) > 0 ) {
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
		}else {
			return false;
		}
		
	}
	private boolean validarCampos() {
		
		limpiarErrores();
		
		if (tfNombreCliente.getText().isEmpty()) { 
			lblNombre.setText("Por favor, ingrese el nombre del titular" );
		}
		else if (tfApellidoCliente.getText().isEmpty()){
			lblApellido.setText("Por favor, ingrese el apellido del titular");
		}
		else if (cbTipoDocumentoCliente.getSelectedIndex() == 0 || tfNroDocumentoCliente.getText().isEmpty()) {
			lblTipoDoc.setText("Por favor, complete todos los datos del documento del titular");
		}
		else if (tfCalleCliente.getText().isEmpty() || tfNumDirCliente.getText().isEmpty()) {
			lblCalle.setText("Por favor, complete todos los datos de la direccion del titular");
		}
		else if (!validarNumerosCalle(tfNumDirCliente.getText().trim())) {
			lblCalle.setText("Por favor, Ingrese correctamente el número");
		}
		else if (cbGrupoSanguineoConductor.getSelectedIndex() == 0 ) {
			lblGrupoSang.setText("Por favor, ingrese el Grupo Sanguineo del titular");
		}
		else if (cbSexoCliente.getSelectedIndex() == 0) {
			lblSexo.setText("Por favor, ingrese el sexo del titular");
		}
		else if (cbDonanteDeOrganos.getSelectedIndex() == 0 ) {
			lblDonante.setText("Por favor, ingrese si el titular es donante");
		}else {
			return true;
		}
		
		return false;
	}
	
	private void limpiarErrores() {
		lblTipoDoc.setText("");
		lblCalle.setText("");
		lblSexo.setText("");
		lblGrupoSang.setText("");
		lblDonante.setText("");
		lblNombre.setText("");
		lblApellido.setText("");
		
	}

	public static boolean validarNumerosCalle (String datos) {
		return datos.matches("[0-9]{1,4}");
	}
}
