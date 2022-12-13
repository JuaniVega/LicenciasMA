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

import mvc.controller.dao.PersonaDao;
import mvc.controller.dto.EmitirLicenciaDTO;
import mvc.controller.dto.PersonaDTO;
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

public class PntModificarDatosConductor extends JPanel {
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
	private JLabel lblErrorLicencias;
	private JLabel lblErrorDonantes;
	private int dni;
	private JButton btnCrearTitular = new JButton("Crear titular");
	private JButton btnEmitirLicencia;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
	
	private boolean licenciasConCDE=false;
	
	public PntModificarDatosConductor() {
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
	txtNombreCliente.setBounds(44, 68, 125, 20);
	panelConductor.add(txtNombreCliente);
	
	tfNombreCliente = new JTextField();
	tfNombreCliente.setBounds(171, 68, 260, 20);
	panelConductor.add(tfNombreCliente);
	tfNombreCliente.setColumns(10);
	
	JTextPane txtApellidoCliente = new JTextPane();
	txtApellidoCliente.setText("Apellido(s) (*)");
	txtApellidoCliente.setEditable(false);
	txtApellidoCliente.setBackground(SystemColor.menu);
	txtApellidoCliente.setBounds(468, 68, 89, 20);
	panelConductor.add(txtApellidoCliente);
	
	tfApellidoCliente = new JTextField();
	tfApellidoCliente.setColumns(10);
	tfApellidoCliente.setBounds(567, 68, 293, 20);
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
	txtTipoDocumentoCliente.setBounds(21, 37, 58, 20);
	panelDocumento.add(txtTipoDocumentoCliente);
	
	tfNroDocumentoCliente = new JTextField();
	tfNroDocumentoCliente.setEditable(false);
	tfNroDocumentoCliente.setColumns(10);
	tfNroDocumentoCliente.setBounds(282, 37, 120, 20);
	panelDocumento.add(tfNroDocumentoCliente);
	
	JTextPane txtNroDocumentoCliente = new JTextPane();
	txtNroDocumentoCliente.setText("N\u00FAmero (*)");
	txtNroDocumentoCliente.setEditable(false);
	txtNroDocumentoCliente.setBackground(SystemColor.menu);
	txtNroDocumentoCliente.setBounds(201, 37, 71, 20);
	panelDocumento.add(txtNroDocumentoCliente);
	
	cbTipoDocumentoCliente = new JComboBox();
	cbTipoDocumentoCliente.setEnabled(false);
	cbTipoDocumentoCliente.setBounds(89, 37, 85, 22);
	panelDocumento.add(cbTipoDocumentoCliente);
	
	JTextPane txtFechaNacCliente = new JTextPane();
	txtFechaNacCliente.setText("Fecha de nacimiento (*)");
	txtFechaNacCliente.setEditable(false);
	txtFechaNacCliente.setBackground(SystemColor.menu);
	txtFechaNacCliente.setBounds(44, 231, 133, 20);
	panelConductor.add(txtFechaNacCliente);
	
	JTextPane txtpnSexoCliente = new JTextPane();
	txtpnSexoCliente.setText("Sexo (*)");
	txtpnSexoCliente.setEditable(false);
	txtpnSexoCliente.setBackground(SystemColor.menu);
	txtpnSexoCliente.setBounds(299, 231, 48, 20);
	panelConductor.add(txtpnSexoCliente);
	
	cbSexoCliente = new JComboBox();
	cbSexoCliente.setEditable(true);
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
	tfPisoCliente.setColumns(10);
	tfPisoCliente.setBounds(250, 86, 64, 20);
	panelDocumento_2.add(tfPisoCliente);
	
	tfFechaNacimConductor = new JTextField();
	tfFechaNacimConductor.setEditable(false);
	tfFechaNacimConductor.setColumns(10);
	tfFechaNacimConductor.setBounds(182, 231, 107, 20);
	panelConductor.add(tfFechaNacimConductor);
	
	JTextPane txtGrupoSanguineo = new JTextPane();
	txtGrupoSanguineo.setText("Grupo sangu\u00EDneo (*)");
	txtGrupoSanguineo.setEditable(false);
	txtGrupoSanguineo.setBackground(SystemColor.menu);
	txtGrupoSanguineo.setBounds(60, 286, 122, 33);
	panelConductor.add(txtGrupoSanguineo);
	
	cbGrupoSanguineoConductor = new JComboBox();
	cbGrupoSanguineoConductor.setEnabled(false);
	cbGrupoSanguineoConductor.setBounds(182, 286, 88, 22);
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
	panelAdmin.add(tfFechaEmision);
	
	JButton btnCancelar = new JButton("Atr\u00E1s");
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.pntmenuPrincipal, VentanaAdmin.n_pntmenuPrincipal);
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
				//List<Persona> persona;
				List<Conductor> conductor;
				try {
					//persona = GestorPersona.obtenerPersonaxDni(dni);
					conductor = GestorPersona.obtenerConductorxDni(dni);
					
					limpiarPantalla();
					if( conductor.size()==0) {
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
	btnBuscarTitular.setBounds(374, 602, 232, 37);
	add(btnBuscarTitular);
	
	JButton btnGuardarCambios = new JButton("Guardar Cambios");
	btnGuardarCambios.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			//agregar las modificaciones hechas 
			if(validarCampos()) {
				PersonaDTO personaDTO = new PersonaDTO();
				try {
					personaDTO.setNombre(tfNombreCliente.getText());
					personaDTO.setApellido(tfApellidoCliente.getText());
					personaDTO.setCalle(tfCalleCliente.getText());
					String callenum = tfNumDirCliente.getText();
					personaDTO.setNumcalle(Integer.parseInt(callenum));
					personaDTO.setDepto(tfDptoCliente.getText());
					String pisoPersona = tfPisoCliente.getText();
					personaDTO.setPiso(Integer.parseInt(pisoPersona));
					personaDTO.setSexo((String) cbSexoCliente.getSelectedItem());
				   
					GestorPersona.actualizarDatosConductor(personaDTO, dni);
					
					//VentanaAdmin.cambiarPantalla(pntImprimirLicencia,VentanaAdmin.n_pntImprimirLicencia);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		}
	});
	btnGuardarCambios.setBounds(810, 602, 118, 37);
	add(btnGuardarCambios);
	
	try {
		llenarCB();
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	
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
		lblErrorLicencias.setText("");
		lblErrorDonantes.setText("");
	}

	private void cargarDatosenCampos(Conductor conductor) throws ParseException {
		tfNombreCliente.setText(conductor.getNombre());
		tfApellidoCliente.setText(conductor.getApellido());
		cbTipoDocumentoCliente.setSelectedIndex(conductor.getTipoDoc());
		tfNroDocumentoCliente.setText(Integer.toString(conductor.getDni()));
		cbSexoCliente.setSelectedIndex(conductor.getCodSexo());
		tfFechaEmision.setText(LocalDate.now().toString());
		tfFechaNacimConductor.setText(String.valueOf(conductor.getFechaNacimiento().format(formatter)));
		tfCalleCliente.setText(conductor.getDireccion());
		tfNumDirCliente.setText(Integer.toString(conductor.getNumDir()));
		tfDptoCliente.setText(conductor.getDpto());
		cbGrupoSanguineoConductor.setSelectedIndex(conductor.getTipoGrupoSanguineo());
		tfPisoCliente.setText(Integer.toString(conductor.getPiso()));
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
	private boolean validarCampos() {
		
		if (tfNombreCliente.getText()== null || tfApellidoCliente.getText()== null) {
			return false;
		}
		else if (tfCalleCliente.getText()== null || tfNumDirCliente.getText()==null) {
			return false ;
		}
		else if (tfDptoCliente.getText()!= null) {
			if (tfPisoCliente.getText()== null) {
				return false;
			}
		}
		else if (tfPisoCliente.getText()!=null) {
			if (tfDptoCliente.getText()==null) {
				return false;
			}
		}
		else if (cbSexoCliente.getSelectedItem().equals("-Seleccione-")) {
			return false;
		}

		return true;
	}
}
