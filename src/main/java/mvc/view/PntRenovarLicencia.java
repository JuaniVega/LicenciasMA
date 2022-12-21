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

import mvc.controller.dto.AdministradorDTO;
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

public class PntRenovarLicencia extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2439382630198569769L;
	
	private JTextField tfNombreCliente;
	private JTextField tfApellidoCliente;
	private JTextField tfNroDocumentoCliente;
	private JTextField tfCalleCliente;
	private JTextField tfNumDirCliente;
	private JTextField tfDptoCliente;
	private JTextField tfPisoCliente;
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
	
	private JButton btnEmitirRenovacion = new JButton("Emitir renovaci\u00F3n");
	private JButton btnImprimirLicencia;
	
	private ArrayList<String> licenciasSelec;
	private ArrayList<Integer> costosLicencias;
	private ArrayList<Licencia> licenciasObtenidas;
	private ArrayList<JCheckBox> licenciasObtenidasChBx;
	private ArrayList<JCheckBox> licenciasCheckBox = new ArrayList<JCheckBox>();
	private EmitirLicenciaDTO emitirLicenciaDTO = new EmitirLicenciaDTO();
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
	
	private JTextField tfCopiaNum;
	private JTextField tfVigencia;
	
	public PntRenovarLicencia() {
	}
	
	public PntRenovarLicencia(final AdministradorDTO admin) {
		setLocation(-31, -63);
	setPreferredSize(new Dimension(980, 650));
	setLayout(null);
	
	JTextPane txtDatosConductor = new JTextPane();
	txtDatosConductor.setFont(new Font("Tahoma", Font.BOLD, 13));
	txtDatosConductor.setBounds(44, 48, 115, 20);
	add(txtDatosConductor);
	txtDatosConductor.setBackground(SystemColor.menu);
	txtDatosConductor.setEditable(false);
	txtDatosConductor.setText("Datos conductor");
	
	JTextPane txtpnEmitirCopia = new JTextPane();
	txtpnEmitirCopia.setText("RENOVAR LICENCIA");
	txtpnEmitirCopia.setFont(new Font("Tahoma", Font.BOLD, 21));
	txtpnEmitirCopia.setEditable(false);
	txtpnEmitirCopia.setBackground(SystemColor.menu);
	txtpnEmitirCopia.setBounds(393, 11, 232, 37);
	add(txtpnEmitirCopia);
	
	JPanel panelConductor = new JPanel();
	panelConductor.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelConductor.setToolTipText("");
	panelConductor.setBounds(31, 59, 908, 493);
	add(panelConductor);
	panelConductor.setLayout(null);
	
	JTextPane txtpnClasesDeLicencias = new JTextPane();
	txtpnClasesDeLicencias.setText("Clases de licencias");
	txtpnClasesDeLicencias.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtpnClasesDeLicencias.setEditable(false);
	txtpnClasesDeLicencias.setBackground(SystemColor.menu);
	txtpnClasesDeLicencias.setBounds(41, 323, 114, 22);
	panelConductor.add(txtpnClasesDeLicencias);
	
	JTextPane txtpnDireccion = new JTextPane();
	txtpnDireccion.setText("Direcci\u00F3n");
	txtpnDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtpnDireccion.setEditable(false);
	txtpnDireccion.setBackground(SystemColor.menu);
	txtpnDireccion.setBounds(481, 94, 59, 22);
	panelConductor.add(txtpnDireccion);
	
	JTextPane txtDocumentoCliente = new JTextPane();
	txtDocumentoCliente.setText("Documento");
	txtDocumentoCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtDocumentoCliente.setEditable(false);
	txtDocumentoCliente.setBackground(SystemColor.menu);
	txtDocumentoCliente.setBounds(41, 94, 71, 22);
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
	panelDocumento.setBounds(28, 105, 388, 49);
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
	txtFechaNacCliente.setBounds(30, 206, 133, 20);
	panelConductor.add(txtFechaNacCliente);
	
	JTextPane txtpnDonadorDeOrganos = new JTextPane();
	txtpnDonadorDeOrganos.setText("Donante de organos (*)");
	txtpnDonadorDeOrganos.setEditable(false);
	txtpnDonadorDeOrganos.setBackground(SystemColor.menu);
	txtpnDonadorDeOrganos.setBounds(265, 278, 80, 34);
	panelConductor.add(txtpnDonadorDeOrganos);
	
	cbDonanteDeOrganos = new JComboBox();
	cbDonanteDeOrganos.setEnabled(false);
	cbDonanteDeOrganos.setBounds(345, 278, 71, 22);
	panelConductor.add(cbDonanteDeOrganos);
	
	txtpnObservaciones = new JTextPane();
	txtpnObservaciones.setText("Observaciones (*)");
	txtpnObservaciones.setEditable(false);
	txtpnObservaciones.setBackground(SystemColor.menu);
	txtpnObservaciones.setBounds(468, 221, 107, 22);
	panelConductor.add(txtpnObservaciones);
	
	taObservaciones = new JTextArea();
	taObservaciones.setEditable(false);
	taObservaciones.setEnabled(false);
	taObservaciones.setToolTipText("Observaciones");
	taObservaciones.setBounds(585, 221, 275, 175);
	panelConductor.add(taObservaciones);
	
	JTextPane txtpnSexoCliente = new JTextPane();
	txtpnSexoCliente.setText("Sexo (*)");
	txtpnSexoCliente.setEditable(false);
	txtpnSexoCliente.setBackground(SystemColor.menu);
	txtpnSexoCliente.setBounds(287, 206, 58, 20);
	panelConductor.add(txtpnSexoCliente);
	
	cbSexoCliente = new JComboBox();
	cbSexoCliente.setEnabled(false);
	cbSexoCliente.setBounds(352, 206, 64, 22);
	panelConductor.add(cbSexoCliente);
	
	JPanel panelDocumento_2 = new JPanel();
	panelDocumento_2.setLayout(null);
	panelDocumento_2.setToolTipText("");
	panelDocumento_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelDocumento_2.setBounds(468, 105, 392, 78);
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
	tfFechaNacimConductor.setBounds(169, 206, 107, 20);
	panelConductor.add(tfFechaNacimConductor);
	
	JTextPane txtGrupoSanguineo = new JTextPane();
	txtGrupoSanguineo.setText("Grupo sangu\u00EDneo (*)");
	txtGrupoSanguineo.setEditable(false);
	txtGrupoSanguineo.setBackground(SystemColor.menu);
	txtGrupoSanguineo.setBounds(28, 278, 122, 33);
	panelConductor.add(txtGrupoSanguineo);
	
	cbGrupoSanguineoConductor = new JComboBox();
	cbGrupoSanguineoConductor.setEnabled(false);
	cbGrupoSanguineoConductor.setBounds(156, 278, 88, 22);
	panelConductor.add(cbGrupoSanguineoConductor);
	
	JPanel panelClasesDeLicencias = new JPanel();
	panelClasesDeLicencias.setLayout(null);
	panelClasesDeLicencias.setToolTipText("");
	panelClasesDeLicencias.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelClasesDeLicencias.setBounds(28, 334, 388, 79);
	panelConductor.add(panelClasesDeLicencias);
	
	chbxTipoLicenciaA = new JCheckBox("A");
	chbxTipoLicenciaA.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaA);
	chbxTipoLicenciaA.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			agregarALista(chbxTipoLicenciaA,"1");
			validarRelacionesDeLicencias(chbxTipoLicenciaA);
		}
	});
	chbxTipoLicenciaA.setBounds(19, 7, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaA);
	
	chbxTipoLicenciaB = new JCheckBox("B");
	chbxTipoLicenciaB.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaB);
	chbxTipoLicenciaB.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			agregarALista(chbxTipoLicenciaB,"2");
			validarRelacionesDeLicencias(chbxTipoLicenciaB);
		}
	});
	chbxTipoLicenciaB.setBounds(19, 49, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaB);
	
	chbxTipoLicenciaC = new JCheckBox("C");
	chbxTipoLicenciaC.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaC);
	chbxTipoLicenciaC.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			agregarALista(chbxTipoLicenciaC,"3");
			validarRelacionesDeLicencias(chbxTipoLicenciaC);
		}
	});
	chbxTipoLicenciaC.setBounds(102, 7, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaC);
	
	chbxTipoLicenciaD = new JCheckBox("D");
	chbxTipoLicenciaD.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaD);
	chbxTipoLicenciaD.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			agregarALista(chbxTipoLicenciaD,"4");
			validarRelacionesDeLicencias(chbxTipoLicenciaD);
		}
	});
	chbxTipoLicenciaD.setBounds(102, 49, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaD);
	
	chbxTipoLicenciaE = new JCheckBox("E");
	chbxTipoLicenciaE.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaE);
	chbxTipoLicenciaE.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			agregarALista(chbxTipoLicenciaE,"5");
			validarRelacionesDeLicencias(chbxTipoLicenciaE);
		}
	});
	chbxTipoLicenciaE.setBounds(193, 7, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaE);
	
	chbxTipoLicenciaF = new JCheckBox("F");
	chbxTipoLicenciaF.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaF);
	chbxTipoLicenciaF.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			agregarALista(chbxTipoLicenciaF,"6");
			validarRelacionesDeLicencias(chbxTipoLicenciaF);
		}
	});
	chbxTipoLicenciaF.setBounds(193, 49, 68, 23);
	panelClasesDeLicencias.add(chbxTipoLicenciaF);
	
	chbxTipoLicenciaG = new JCheckBox("G");
	chbxTipoLicenciaG.setEnabled(false);
	licenciasCheckBox.add(chbxTipoLicenciaG);
	chbxTipoLicenciaG.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			agregarALista(chbxTipoLicenciaG,"7");
			validarRelacionesDeLicencias(chbxTipoLicenciaG);
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
	
	JTextPane txtNumCopia = new JTextPane();
	txtNumCopia.setText("Copia n\u00FAmero");
	txtNumCopia.setEditable(false);
	txtNumCopia.setBackground(SystemColor.menu);
	txtNumCopia.setBounds(28, 444, 80, 20);
	panelConductor.add(txtNumCopia);
	
	tfCopiaNum = new JTextField();
	tfCopiaNum.setEnabled(false);
	tfCopiaNum.setEditable(false);
	tfCopiaNum.setColumns(10);
	tfCopiaNum.setBounds(118, 444, 71, 20);
	panelConductor.add(tfCopiaNum);
	
	JTextPane txtVigenciaHasta = new JTextPane();
	txtVigenciaHasta.setText("Vigencia hasta");
	txtVigenciaHasta.setEditable(false);
	txtVigenciaHasta.setBackground(SystemColor.menu);
	txtVigenciaHasta.setBounds(210, 444, 89, 20);
	panelConductor.add(txtVigenciaHasta);
	
	tfVigencia = new JTextField();
	tfVigencia.setEnabled(false);
	tfVigencia.setEditable(false);
	tfVigencia.setColumns(10);
	tfVigencia.setBounds(309, 444, 107, 20);
	panelConductor.add(tfVigencia);
	
	JButton btnAtras = new JButton("Atr\u00E1s");
	btnAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			MenuPrincipal menuPrincipal = new MenuPrincipal(admin);
			VentanaAdmin.cambiarPantalla(menuPrincipal, VentanaAdmin.n_pntmenuPrincipal);
			limpiarPantalla();
		}
	});
	btnAtras.setBounds(41, 602, 118, 37);
	add(btnAtras);
	
	btnImprimirLicencia = new JButton("Imprimir licencia");
	btnImprimirLicencia.setEnabled(false);
	btnImprimirLicencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(validarSelecciones()) {
					PntImprimirLicencia pntImprimirLicencia= new PntImprimirLicencia(admin, emitirLicenciaDTO);
					VentanaAdmin.cambiarPantalla(pntImprimirLicencia,VentanaAdmin.n_pntImprimirLicencia);
					limpiarPantalla();
			}		
		}
	});
	btnImprimirLicencia.setBounds(786, 602, 142, 37);
	add(btnImprimirLicencia);
	
	btnEmitirRenovacion.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(validarSelecciones()) {
				try {
					if(validarTiempoRenov()) {
						cargarRenovacionLicenciaDTO();
						GestorPersona.actualizarConductorDonante(emitirLicenciaDTO);
						GestorLicencia.crearLicencia(emitirLicenciaDTO);
						deshabilitarCheckBox();
						VentanaAdmin.mensajeExito("Renovación generada correctamente", "Éxito");
						btnImprimirLicencia.setEnabled(true);
						btnEmitirRenovacion.setEnabled(false);
					}else {
						VentanaAdmin.mensajeError("No puede renovar su licencia aún.\nLa diferencia con su fecha de vencimiento\nes mayor a 2 meses.", "ERROR");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}
	});
	btnEmitirRenovacion.setEnabled(false);
	btnEmitirRenovacion.setBounds(499, 602, 232, 37);
	add(btnEmitirRenovacion);
	
	JButton btnBuscarTitular = new JButton("Buscar titular");
	btnBuscarTitular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String val = VentanaAdmin.mensajeBusqueda(null, "Ingrese DNI del titular");
			if(esDniValido(val)) {
				int dni = Integer.parseInt(val);
				List<Conductor> conductor;
				List<Licencia> licencia;
				try {
					
					conductor = GestorPersona.obtenerConductorxDni(dni);
					licencia = GestorLicencia.obtenerLicenciaVigentexDni(dni);
					
					limpiarPantalla();
					licenciasSelec = new ArrayList<String>();
					costosLicencias = new ArrayList<Integer>();
					licenciasObtenidas = new ArrayList<Licencia>();
					licenciasObtenidasChBx = new ArrayList<JCheckBox>();
					
					if(conductor.size()==0) {
						VentanaAdmin.mensajeError("Persona no encontrada", "ERROR");
					}else {	
						if(licencia.size()>0) {
							habilitarCampos();
							cargarDatosenCamposConductor(conductor.get(0));
							cargarCheckBoxLicencia(licencia);
						}else {
							VentanaAdmin.mensajeError("No existen licencias vigentes para este DNI", "ERROR");
						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	});
	btnBuscarTitular.setBounds(217, 602, 232, 37);
	add(btnBuscarTitular);
	
	try {
		llenarCB();
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	
	}
	

	protected boolean validarTiempoRenov() {
		for(int i =0; i<licenciasObtenidas.size(); i++) {
			if(licenciasObtenidas.get(i).getIdTipoLicencia()==Integer.parseInt(licenciasSelec.get(0))) {
				LocalDate f1 = licenciasObtenidas.get(i).getFechaVigencia();
				LocalDate f2 = LocalDate.now();
				Period period = Period.between(f2, f1);
				if(period.getMonths()<2) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}

	protected void habilitarCampos() {
		cbSexoCliente.setEnabled(true);
		tfCalleCliente.setEnabled(true);
		tfNumDirCliente.setEnabled(true);
		cbDonanteDeOrganos.setEnabled(true);
	}


	protected void cargarCheckBoxLicencia(List<Licencia> licencia) {
		for(int i=0; i<licencia.size(); i++) {
			int numLic = licencia.get(i).getIdTipoLicencia();
			licenciasCheckBox.get(numLic - 1).setEnabled(true);
			licenciasObtenidasChBx.add(licenciasCheckBox.get(numLic-1));
		}
		licenciasObtenidas=(ArrayList)licencia;
	}


	protected boolean validarSelecciones() {
		lblErrorLicencias.setText("Seleccione la licencia que desea emitir copia.");
		
		if(licenciasSelec.size()==0) {
			lblErrorLicencias.setText("Por favor seleccione un tipo de licencia.");
			return false;
		}
		return true;
		
	}
	
	private void validarRelacionesDeLicencias(JCheckBox licencia) {
		if(licencia.isSelected()) {
			for(int i=0; i<licenciasCheckBox.size();i++) {
				if(!licenciasCheckBox.get(i).equals(licencia)) {
					licenciasCheckBox.get(i).setEnabled(false);
				}
			}
			cargarDatosdeLicencia();
			btnEmitirRenovacion.setEnabled(true);
		}else {
				for(int i=0; i<licenciasObtenidasChBx.size();i++) {
					licenciasObtenidasChBx.get(i).setEnabled(true);
				}
			borrarDatosdeCampoLicencia();
			btnEmitirRenovacion.setEnabled(false);
			}
		
		}

	private void borrarDatosdeCampoLicencia() {
		taObservaciones.setText("");
		tfCopiaNum.setText("");
		tfVigencia.setText("");
	}


	private void cargarDatosdeLicencia() {
		for(int i =0; i<licenciasObtenidas.size(); i++) {
			if(licenciasObtenidas.get(i).getIdTipoLicencia()==Integer.parseInt(licenciasSelec.get(0))) {
				taObservaciones.setText(licenciasObtenidas.get(i).getObservaciones());
				tfCopiaNum.setText(licenciasObtenidas.get(i).getNumCopia().toString());
				tfVigencia.setText(licenciasObtenidas.get(i).getFechaVigencia().toString());
			}
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
		cbSexoCliente.setEnabled(false);
		cbDonanteDeOrganos.setSelectedIndex(0);
		cbDonanteDeOrganos.setEnabled(false);
		tfFechaNacimConductor.setText("");
		tfVigencia.setText("");
		tfCopiaNum.setText("");
		taObservaciones.setText("");
		taObservaciones.setEnabled(false);
		lblErrorLicencias.setText("");
		lblErrorDonantes.setText("");
		deshabilitarCheckBox();
		chbxTipoLicenciaA.setSelected(false);
		chbxTipoLicenciaB.setSelected(false);
		chbxTipoLicenciaC.setSelected(false);
		chbxTipoLicenciaD.setSelected(false);
		chbxTipoLicenciaE.setSelected(false);
		chbxTipoLicenciaF.setSelected(false);
		chbxTipoLicenciaG.setSelected(false);
	}

	private void deshabilitarCheckBox() {
		chbxTipoLicenciaA.setEnabled(false);
		chbxTipoLicenciaB.setEnabled(false);
		chbxTipoLicenciaC.setEnabled(false);
		chbxTipoLicenciaD.setEnabled(false);
		chbxTipoLicenciaE.setEnabled(false);
		chbxTipoLicenciaF.setEnabled(false);
		chbxTipoLicenciaG.setEnabled(false);
		
	}


	protected void agregarALista(JCheckBox chbxTipoLicencia, String i) {
		if(chbxTipoLicencia.isSelected()==true) {
			licenciasSelec.add(i);
		}else {
			licenciasSelec.remove(i);
		}
		
	}

	protected void cargarRenovacionLicenciaDTO() throws Exception {
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
		if(tfPisoCliente.getText().isEmpty() || tfPisoCliente.getText().equals("")) {
			emitirLicenciaDTO.setPiso(-1);
		}else {
			emitirLicenciaDTO.setPiso(Integer.parseInt(tfPisoCliente.getText()));
		}
		emitirLicenciaDTO.setDpto(tfDptoCliente.getText());
		emitirLicenciaDTO.setObservaciones(taObservaciones.getText());
		emitirLicenciaDTO.setLicenciasSeleccionadas(licenciasSelec);
		emitirLicenciaDTO.setFechaEmision(LocalDate.now());
		emitirLicenciaDTO.setFechaVigencia(GestorLicencia.calculoVigencia(emitirLicenciaDTO.getFechaNacimiento(), emitirLicenciaDTO.getNumDoc()));
		emitirLicenciaDTO.setEsCopia(false);
		emitirLicenciaDTO.setEstaVigente(true);
		emitirLicenciaDTO.setNumCopia(1);
		
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

	private void cargarDatosenCamposConductor(Conductor conductor) throws ParseException {
		int esDonante=1;
		tfNombreCliente.setText(conductor.getNombre());
		tfApellidoCliente.setText(conductor.getApellido());
		cbTipoDocumentoCliente.setSelectedIndex(conductor.getTipoDoc());
		tfNroDocumentoCliente.setText(Integer.toString(conductor.getDni()));
		tfCalleCliente.setText(conductor.getDireccion());
		tfNumDirCliente.setText(Integer.toString(conductor.getNumDir()));
		if(conductor.getPiso()!=-1) {
			tfPisoCliente.setText(Integer.toString(conductor.getPiso()));
		}else {
			tfPisoCliente.setText("");
		}
		tfDptoCliente.setText(conductor.getDpto());
		cbGrupoSanguineoConductor.setSelectedIndex(conductor.getTipoGrupoSanguineo());
		cbSexoCliente.setSelectedIndex(conductor.getCodSexo());
		tfFechaNacimConductor.setText(String.valueOf(conductor.getFechaNacimiento().format(formatter)));
		
		if(conductor.getDonaOrganos().equals(false)) {
			esDonante=2;
		}
		
		cbDonanteDeOrganos.setSelectedIndex(esDonante);
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
}