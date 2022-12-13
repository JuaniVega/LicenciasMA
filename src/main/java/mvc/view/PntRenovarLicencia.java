package mvc.view;

import javax.swing.JPanel;
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
import mvc.controller.dto.AdministradorDTO;
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
    
    //#region varibles

    private JTextField tfApellidoCliente = new JTextField();
	private JTextField tfNombreCliente = new JTextField();
	private JTextField tfDireccionCliente = new JTextField();
	private JTextField tfNroDocumentoCliente = new JTextField();
	private JComboBox cbTipoDocumentoCliente = new JComboBox();
	private JComboBox cbGrupoSanguineoConductor = new JComboBox();
	private JComboBox cbDonanteDeOrganos = new JComboBox();
	private JCheckBox chbxTipoLicenciaA;
	private JCheckBox chbxTipoLicenciaB;
	private JCheckBox chbxTipoLicenciaC;
	private JCheckBox chbxTipoLicenciaD;
	private JCheckBox chbxTipoLicenciaE;
	private JCheckBox chbxTipoLicenciaF;
	private JCheckBox chbxTipoLicenciaG;
	private JLabel lblErrorLicencias;
	private JComboBox cbSexoCliente;
	private JTextArea taObservaciones = new JTextArea();
		
	private JTextField tfNombreAdmin = new JTextField();
	private JTextField tfApellidoAdmin = new JTextField();
	
	private JButton btnBuscarTitular= new JButton("Buscar Titular");
	private JButton btnAtras = new JButton("Atr\u00E1s");
	private JButton btnRenovarLicencia = new JButton("Renovar Licencia");
	private ArrayList<JCheckBox> licenciasCheckBox = new ArrayList<JCheckBox>();
	private ArrayList<String> licenciasSelec = new ArrayList<String>();

	private boolean licenciasConCDE=false;
	JPanel panelClasesDeLicencias = new JPanel();
	boolean LicenciaRenovada = false;
	private JTextField tfFechaEmision;
    //#endregion

	public PntRenovarLicencia() {
		
	}

	//#region constructor pantalla
    public PntRenovarLicencia(final AdministradorDTO admin) {
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
	txtpnEmitirLicencia.setText("RENOVAR LICENCIA");
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

	JTextPane txtpnClasesDeLicencias = new JTextPane();
	txtpnClasesDeLicencias.setText("Clases de licencias");
	txtpnClasesDeLicencias.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtpnClasesDeLicencias.setEditable(false);
	txtpnClasesDeLicencias.setBackground(SystemColor.menu);
	txtpnClasesDeLicencias.setBounds(28, 241, 114, 22);
	panelConductor.add(txtpnClasesDeLicencias);
	
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
	
	
	tfNombreCliente.setBounds(141, 11, 275, 20);
	panelConductor.add(tfNombreCliente);
	tfNombreCliente.setColumns(10);

	JTextPane txtpnSexoCliente = new JTextPane();
	txtpnSexoCliente.setText("Sexo (*)");
	txtpnSexoCliente.setEditable(false);
	txtpnSexoCliente.setBackground(SystemColor.menu);
	txtpnSexoCliente.setBounds(263, 147, 58, 20);
	panelConductor.add(txtpnSexoCliente);
	
	JTextPane txtApellidoCliente = new JTextPane();
	txtApellidoCliente.setText("Apellido(s) (*)");
	txtApellidoCliente.setEditable(false);
	txtApellidoCliente.setBackground(SystemColor.menu);
	txtApellidoCliente.setBounds(486, 11, 89, 20);
	panelConductor.add(txtApellidoCliente);
	
	
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
	
	
	tfNroDocumentoCliente.setColumns(10);
	tfNroDocumentoCliente.setBounds(244, 11, 120, 20);
	panelDocumento.add(tfNroDocumentoCliente);
	
	JTextPane txtNroDocumentoCliente = new JTextPane();
	txtNroDocumentoCliente.setText("N\u00FAmero (*)");
	txtNroDocumentoCliente.setEditable(false);
	txtNroDocumentoCliente.setBackground(SystemColor.menu);
	txtNroDocumentoCliente.setBounds(173, 11, 71, 20);
	panelDocumento.add(txtNroDocumentoCliente);
	
	
	cbTipoDocumentoCliente.setBounds(78, 11, 85, 22);
	panelDocumento.add(cbTipoDocumentoCliente);
	
	JTextPane txtDireccionCliente = new JTextPane();
	txtDireccionCliente.setText("Direcci\u00F3n (*)");
	txtDireccionCliente.setEditable(false);
	txtDireccionCliente.setBackground(SystemColor.menu);
	txtDireccionCliente.setBounds(501, 82, 74, 20);
	panelConductor.add(txtDireccionCliente);
	
	
	tfDireccionCliente.setColumns(10);
	tfDireccionCliente.setBounds(585, 82, 275, 20);
	panelConductor.add(tfDireccionCliente);
	
	JTextPane txtFechaNacCliente = new JTextPane();
	txtFechaNacCliente.setText("Fecha de nacimiento (*)");
	txtFechaNacCliente.setEditable(false);
	txtFechaNacCliente.setBackground(SystemColor.menu);
	txtFechaNacCliente.setBounds(28, 147, 125, 20);
	panelConductor.add(txtFechaNacCliente);
	
	JTextPane txtpnDonadorDeOrganos = new JTextPane();
	txtpnDonadorDeOrganos.setText("Donador de organos (*)");
	txtpnDonadorDeOrganos.setEditable(false);
	txtpnDonadorDeOrganos.setBackground(SystemColor.menu);
	txtpnDonadorDeOrganos.setBounds(239, 178, 80, 34);
	panelConductor.add(txtpnDonadorDeOrganos);
	
	cbSexoCliente = new JComboBox();
	cbSexoCliente.setEnabled(false);
	cbSexoCliente.setBounds(340, 147, 64, 22);
	panelConductor.add(cbSexoCliente);

	cbDonanteDeOrganos.setBounds(327, 190, 89, 22);
	panelConductor.add(cbDonanteDeOrganos);
	
	
	panelClasesDeLicencias.setLayout(null);
	panelClasesDeLicencias.setToolTipText("");
	panelClasesDeLicencias.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panelClasesDeLicencias.setBounds(28, 254, 388, 79);
	panelConductor.add(panelClasesDeLicencias);
	

	//#region tipos de licencia
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

	//#endregion
	
	lblErrorLicencias = new JLabel("");
	lblErrorLicencias.setForeground(Color.RED);
	lblErrorLicencias.setBounds(28, 348, 388, 25);
	panelConductor.add(lblErrorLicencias);
	


	JTextPane txtpnClaseLicencia = new JTextPane();
	txtpnClaseLicencia.setText("Clase (*)");
	txtpnClaseLicencia.setEditable(false);
	txtpnClaseLicencia.setBackground(SystemColor.menu);
	txtpnClaseLicencia.setBounds(239, 275, 59, 20);
	panelConductor.add(txtpnClaseLicencia);

	
	JTextPane txtpnObservaciones = new JTextPane();
	txtpnObservaciones.setText("Observaciones (*)");
	txtpnObservaciones.setEditable(false);
	txtpnObservaciones.setBackground(SystemColor.menu);
	txtpnObservaciones.setBounds(468, 178, 107, 22);
	panelConductor.add(txtpnObservaciones);
		
	JTextField tfFechaNacimConductor ;
	tfFechaNacimConductor = new JTextField();
	tfFechaNacimConductor.setEditable(false);
	tfFechaNacimConductor.setColumns(10);
	tfFechaNacimConductor.setBounds(162, 147, 80, 20);
	panelConductor.add(tfFechaNacimConductor);

	taObservaciones = new JTextArea();
	taObservaciones.setEnabled(false);
	taObservaciones.setToolTipText("Observaciones");
	taObservaciones.setBounds(585, 178, 275, 147);
	panelConductor.add(taObservaciones);
	cbGrupoSanguineoConductor.setBounds(160, 190, 69, 22);
	panelConductor.add(cbGrupoSanguineoConductor);
	
	JTextPane txtGrupoSanguineo = new JTextPane();
	txtGrupoSanguineo.setBounds(28, 190, 107, 22);
	panelConductor.add(txtGrupoSanguineo);
	txtGrupoSanguineo.setText("Grupo sangu\u00EDneo (*)");
	txtGrupoSanguineo.setEditable(false);
	txtGrupoSanguineo.setBackground(SystemColor.menu);
	
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
	tfNombreAdmin.setEditable(false);
	
	
	tfNombreAdmin.setColumns(10);
	tfNombreAdmin.setBounds(147, 25, 275, 20);
	tfNombreAdmin.setText(admin.getNombre());
	panelAdmin.add(tfNombreAdmin);
	
	JTextPane txtApellidoAdmin = new JTextPane();
	txtApellidoAdmin.setText("Apellido(s) (*)");
	txtApellidoAdmin.setEditable(false);
	txtApellidoAdmin.setBackground(SystemColor.menu);
	txtApellidoAdmin.setBounds(491, 25, 85, 20);
	panelAdmin.add(txtApellidoAdmin);
	tfApellidoAdmin.setEditable(false);
	
	tfApellidoAdmin.setColumns(10);
	tfApellidoAdmin.setBounds(586, 25, 275, 20);
	tfApellidoAdmin.setText(admin.getApellido());
	panelAdmin.add(tfApellidoAdmin);
	
	JTextPane txtFechaEmision = new JTextPane();
	txtFechaEmision.setText("Fecha de emisi\u00F3n (*)");
	txtFechaEmision.setEditable(false);
	txtFechaEmision.setBackground(SystemColor.menu);
	txtFechaEmision.setBounds(10, 89, 131, 20);
	panelAdmin.add(txtFechaEmision);
	
	tfFechaEmision = new JTextField();
	tfFechaEmision.setText((String) null);
	tfFechaEmision.setEditable(false);
	tfFechaEmision.setColumns(10);
	tfFechaEmision.setBounds(147, 89, 275, 20);
	tfFechaEmision.setText(LocalDate.now().toString());
	panelAdmin.add(tfFechaEmision);

	//#endregion



	//#region Botones

	btnBuscarTitular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String val = VentanaAdmin.mensajeBusqueda(null, "Ingrese DNI del titular");
			
			if(esDniValido(val)) {
				int dni = Integer.parseInt(val);
				System.out.println("La dni es : " + dni);
				List<Conductor> conductor;
				try {
					
					conductor = GestorPersona.obtenerConductorxDni(dni);
					if(conductor==null || conductor.size() == 0){
						VentanaAdmin.mensajeError("Persona no encontrada", "ERROR");
						
						btnAtras.setEnabled(true);
					}else {
						// Verificar que la persona tenga licencia
						// Seleccionar la licencia a renovar
						
						List<Licencia> licenciasConductor = new ArrayList<Licencia>();
						licenciasConductor = GestorLicencia.obtenerLicenciaxDni(conductor.get(0).getId());
						//pedir seleccionar una licencia a renovar
						//habilitar los checkbox de las licencia que puede renovar
						//habilitarPanelLicencias(licencia)
						VentanaAdmin.mensajeError("Por favor seleccione la licencia a renovar y luego presione el boton 'Renovar Licencia' ", "AVISO");
						//obtener licencia seleccionada
						Licencia licenciaPorRenovar = new Licencia();
						licenciaPorRenovar = seleccionarLicenciaARenovar(licenciasConductor);
						GestorLicencia.renovarLicencia(conductor.get(0), licenciaPorRenovar);
						LicenciaRenovada = true;
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	});
	btnBuscarTitular.setBounds(379, 602, 181, 37);
	add(btnBuscarTitular);

	


	btnAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			MenuPrincipal menuPrincipal = new MenuPrincipal(admin);
			VentanaAdmin.cambiarPantalla(menuPrincipal, VentanaAdmin.n_pntmenuPrincipal);
		}
	});
	btnAtras.setBounds(41, 602, 142, 37);
	add(btnAtras);


	btnRenovarLicencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			

			if(LicenciaRenovada){
				//redirigir al impimir licencia
				
			}
			else{
				if(panelClasesDeLicencias().getSelectedIndex()!= -1){
					VentanaAdmin.mensajeError("No selecciono la licencia a Renovar", "ERROR");
				}else{
					VentanaAdmin.mensajeError("No se puede renovar su licencia", "ERROR");
				}
				
			}
			
		}
	});
	btnRenovarLicencia.setBounds(744, 602, 174, 37);
	add(btnRenovarLicencia);

	//#endregion



    }



	//#region metodos 
	private void habilitarCrearTitular(){
		inhabilitarCamposBusquedaTitular(false);
		
	}

	private Licencia seleccionarLicenciaARenovar(List<Licencia> licencia ){
		Licencia lic = new Licencia();
		Integer idCb = -1;
		idCb = this.panelClasesDeLicencias().getSelectedIndex();

		for(int i=0; i<licencia.size(); i++){
			if(licencia.get(i).getIdTipoLicencia()==idCb){
				lic = licencia.get(i);
			}
		}

		return lic;
	}

	private JComboBox panelClasesDeLicencias() {
		return null;
	}



	protected boolean validarLicenciaASeleccionar(LocalDate fechaNacimiento, int dni) throws Exception {
		
			
		LocalDate fechaActual=LocalDate.now();
		Period periodAniosCond = Period.between(fechaNacimiento, fechaActual);
		int aniosConductor= periodAniosCond.getYears();
		
		int aniosAntiguedad= calcularAntiguedadLicB(dni, fechaActual);
		int licenciasCDE= calcularCantLicCDE(dni);
		
		if(aniosConductor<17) {
			cbDonanteDeOrganos.setEnabled(false);
			
			lblErrorLicencias.setText("Menores de 17 a�os no pueden solicitar NINGUNA licencia.");
			return false;
		}else if(aniosConductor<21) {
			taObservaciones.setEnabled(true);
			cbDonanteDeOrganos.setEnabled(true);
			
			chbxTipoLicenciaA.setEnabled(true);
			chbxTipoLicenciaB.setEnabled(true);
			chbxTipoLicenciaF.setEnabled(true);
			chbxTipoLicenciaG.setEnabled(true);
			lblErrorLicencias.setText("Menores de 21 a�os no pueden solicitar licencias C, D o E.");
			return false;
		}else if((aniosConductor>=21 && aniosAntiguedad<1)) {
			taObservaciones.setEnabled(true);
			cbDonanteDeOrganos.setEnabled(true);
			
			chbxTipoLicenciaA.setEnabled(true);
			chbxTipoLicenciaB.setEnabled(true);
			chbxTipoLicenciaF.setEnabled(true);
			chbxTipoLicenciaG.setEnabled(true);
			lblErrorLicencias.setText("No posee 1 a�o o mas de antiguedad con licencia B.");
			return false;
		}else if(aniosConductor>65 && licenciasCDE==0) {
			taObservaciones.setEnabled(true);
			cbDonanteDeOrganos.setEnabled(true);
			
			chbxTipoLicenciaA.setEnabled(true);
			chbxTipoLicenciaB.setEnabled(true);
			chbxTipoLicenciaF.setEnabled(true);
			chbxTipoLicenciaG.setEnabled(true);
			lblErrorLicencias.setText("Mayores de 65 a�os no pueden solicitar licencias C, D o E por primera vez.");
			return false;
		}else if(aniosConductor>=21 && aniosAntiguedad>=1) {
			taObservaciones.setEnabled(true);
			cbDonanteDeOrganos.setEnabled(true);
			
			chbxTipoLicenciaA.setEnabled(true);
			chbxTipoLicenciaB.setEnabled(true);
			chbxTipoLicenciaC.setEnabled(true);
			chbxTipoLicenciaD.setEnabled(true);
			chbxTipoLicenciaE.setEnabled(true);
			chbxTipoLicenciaF.setEnabled(true);
			chbxTipoLicenciaG.setEnabled(true);
			licenciasConCDE=true;
			return true;
		}
		return false;
		
	}

	private int calcularAntiguedadLicB(int dni, LocalDate fechaActual) throws Exception {
		int aniosAntiguedad=0;
		List<Licencia> licencia= GestorLicencia.obtenerLicenciaxDnixTipo(dni, 2); 
		LocalDate fechaEmision=licencia.get(0).getFechaEmision();
		
		Period periodAniosEmision = Period.between(fechaEmision, fechaActual);
		aniosAntiguedad= periodAniosEmision.getYears();
		return aniosAntiguedad;
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


	//Metodo para inahilitar los campos cuando se busca un titular
	public void inhabilitarCamposBusquedaTitular(boolean a) {
		this.tfNombreCliente.setEditable(a);
		this.tfApellidoCliente.setEditable(a);
		this.tfDireccionCliente.setEditable(a);
		this.tfNroDocumentoCliente.setEditable(a);
		this.cbTipoDocumentoCliente.setEnabled(a);
		this.cbGrupoSanguineoConductor.setEnabled(a);
		//this.cbFactorRHConductor.setEnabled(a);
		this.cbDonanteDeOrganos.setEnabled(a);
		this.taObservaciones.setEditable(a);
		this.tfNombreAdmin.setEditable(a);
		this.tfApellidoAdmin.setEditable(a);
		
		this.btnRenovarLicencia.setEnabled(a);

		
	}
	//Metodo para inahilitar los campos cuando se quiere crear un titular
	public void inhabilitarCamposCrearTitular(boolean b) {
		this.tfNombreCliente.setEditable(b);
		this.tfApellidoCliente.setEditable(b);
		this.tfDireccionCliente.setEditable(b);
		this.tfNroDocumentoCliente.setEditable(b);
		this.cbTipoDocumentoCliente.setEnabled(b);
		this.cbGrupoSanguineoConductor.setEnabled(b);
		//this.cbFactorRHConductor.setEnabled(b);
		this.cbDonanteDeOrganos.setEnabled(b);
		this.taObservaciones.setEditable(b);
		this.tfNombreAdmin.setEditable(b);
		this.tfApellidoAdmin.setEditable(b);
		this.btnRenovarLicencia.setEnabled(b);
		this.btnBuscarTitular.setEnabled(b);

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
	
	protected void agregarALista(JCheckBox chbxTipoLicencia, String i) {
		if(chbxTipoLicencia.isSelected()==true) {
			licenciasSelec.add(i);
		}else {
			licenciasSelec.remove(i);
		}
		
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

	//#endregion

}
