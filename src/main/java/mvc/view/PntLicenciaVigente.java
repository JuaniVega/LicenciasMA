package mvc.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import mvc.controller.dto.AdministradorDTO;
import mvc.controller.gestores.GestorLicencia;
import mvc.controller.gestores.GestorPersona;
import mvc.model.Licencia;
import mvc.model.Persona;
import mvc.model.TipoGrupoSanguineo;
import mvc.model.TipoLicencia;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class PntLicenciaVigente extends JPanel{
	
	public static JTable table = new JTable();
	public static DefaultTableModel dm = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex, int columnIndex ) {
			return false;
		}
	};
	private static JTextField tfFiltro;
	private Integer valorElegido;
	private JComboBox cbFiltro;
	private static JComboBox cbFiltro2;
	private JLabel lblNewLabel;
	private static JButton btnBuscar;
	private static JLabel lblErrorSeleccion;
	
	public PntLicenciaVigente() {
	}
	
	public PntLicenciaVigente(final AdministradorDTO admin) {
	setLocation(-31, -63);
	setPreferredSize(new Dimension(980, 650));
	setLayout(null);
	
	actualizarVigenciasDesactualizadas();
	
	JTextPane txtpnEmitirLicencia = new JTextPane();
	txtpnEmitirLicencia.setText("LICENCIAS VIGENTES");
	txtpnEmitirLicencia.setFont(new Font("Tahoma", Font.BOLD, 21));
	txtpnEmitirLicencia.setEditable(false);
	txtpnEmitirLicencia.setBackground(SystemColor.menu);
	txtpnEmitirLicencia.setBounds(368, 11, 264, 37);
	add(txtpnEmitirLicencia);
	
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setBounds(41, 124, 904, 434);
	add(scrollPane);
	
	lblNewLabel = new JLabel("Filtro");
	lblNewLabel.setBounds(319, 76, 39, 20);
	lblNewLabel.setVisible(false);
	add(lblNewLabel);
	
	tfFiltro = new JTextField();
	tfFiltro.setEnabled(false);
	tfFiltro.setBounds(368, 76, 218, 20);
	tfFiltro.setVisible(false);
	add(tfFiltro);
	tfFiltro.setColumns(10);
	
	JLabel lblTipoDeFiltro = new JLabel("Tipo de filtro");
	lblTipoDeFiltro.setBounds(41, 77, 81, 20);
	add(lblTipoDeFiltro);
	
	JButton btnAtras = new JButton("Atr\u00E1s");
	btnAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			MenuPrincipal menuPrincipal = new MenuPrincipal(admin);
			VentanaAdmin.cambiarPantalla(menuPrincipal, VentanaAdmin.n_pntmenuPrincipal);
			restaurarTabla();
			dm = new DefaultTableModel(){
				public boolean isCellEditable(int rowIndex, int columnIndex ) {
					return false;
				}
			};
		}
	});
	btnAtras.setBounds(41, 602, 118, 37);
	add(btnAtras);
	
	btnBuscar = new JButton("Buscar");
	btnBuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				restaurarTabla();
				cargarLicenciasVigentes(valorElegido);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	btnBuscar.setBounds(631, 68, 118, 28);
	btnBuscar.setEnabled(false);
	add(btnBuscar);
	
	cbFiltro = new JComboBox();
	cbFiltro.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione una opcion-", "Nombre", "Apellido", "Grupo sanguineo", "Es donante", "No es donante"}));
	cbFiltro.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tfFiltro.setText("");
			lblErrorSeleccion.setText("");
			tfFiltro.setEnabled(true);
			valorElegido=cbFiltro.getSelectedIndex();
			if(valorElegido==0) {
				cbFiltro2.setVisible(false);
				tfFiltro.setVisible(false);
				lblNewLabel.setVisible(false);
				btnBuscar.setEnabled(false);
			}else if(valorElegido==1 || valorElegido==2) {
				cbFiltro2.setVisible(false);
				tfFiltro.setVisible(true);
				lblNewLabel.setVisible(true);
				btnBuscar.setEnabled(true);
			}else if(valorElegido==3) {
				cbFiltro2.setVisible(true);
				tfFiltro.setVisible(false);
				lblNewLabel.setVisible(true);
				btnBuscar.setEnabled(true);
				cargarCb2();
			}else {
				cbFiltro2.setVisible(false);
				tfFiltro.setVisible(false);
				lblNewLabel.setVisible(false);
				btnBuscar.setEnabled(true);
			}
		}
	});
	cbFiltro.setBounds(132, 76, 177, 21);
	add(cbFiltro);
	
	dm.addColumn("Nombre");
	dm.addColumn("Apellido");
	dm.addColumn("Fecha expiración");
	dm.addColumn("Clase");
	
	table.setModel(dm);
	
	cbFiltro2 = new JComboBox();
	cbFiltro2.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione una opcion-"}));
	cbFiltro2.setBounds(354, 76, 177, 21);
	cbFiltro2.setVisible(false);
	add(cbFiltro2);
	
	lblErrorSeleccion = new JLabel("");
	lblErrorSeleccion.setForeground(Color.RED);
	lblErrorSeleccion.setBounds(354, 107, 232, 14);
	add(lblErrorSeleccion);
	
	}
	
	protected void cargarCb2() {
		try {
			List<TipoGrupoSanguineo> tiposGs= GestorPersona.obtenerTiposGrupoSanguineos();
			for(int i=0; i<tiposGs.size(); i++) {
				cbFiltro2.addItem(tiposGs.get(i).getTipo_grupo_sanguineo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void actualizarVigenciasDesactualizadas() {
		GestorLicencia.actualizarVigenciasDesactualizadas();
	}
	
	public static void cargarLicenciasVigentes(Integer val) throws Exception {
		
		List<Persona> personas = new ArrayList<Persona>();
		
		if (val==1) {
			if(tfFiltro.getText().equals("")) {
				lblErrorSeleccion.setText("Ingrese un nombre para filtrar");
			}else {
				personas = GestorPersona.obtenerPersonaxNombre(tfFiltro.getText().trim());
				lblErrorSeleccion.setText("");
				cargarTabla(personas);
			}
		}else if(val==2) {
			if(tfFiltro.getText().equals("")) {
				lblErrorSeleccion.setText("Ingrese un apellido para filtrar");
			}else {
				personas = GestorPersona.obtenerPersonaxApellido(tfFiltro.getText().trim());
				lblErrorSeleccion.setText("");
				cargarTabla(personas);
			}
		}else if(val==3) {
			if(cbFiltro2.getSelectedIndex()==0) {
				lblErrorSeleccion.setText("Seleccione una opcion para filtrar");
			}else {
				personas = GestorPersona.obtenerPersonaxGrupoSanguineo(cbFiltro2.getSelectedIndex());
				lblErrorSeleccion.setText("");
				cargarTabla(personas);
			}
		}else if(val==4) {
			personas = GestorPersona.obtenerPersonaxEsDonante(true);
			cargarTabla(personas);
		}else {
			personas = GestorPersona.obtenerPersonaxEsDonante(false);
			cargarTabla(personas);
		}
		
	}

	private static void cargarTabla(List<Persona> personas) throws Exception {
		List<Licencia> licenciasVigentes= GestorLicencia.obtenerLicenciaVigentexPersona(personas);
		
		List<TipoLicencia> tiposLic = GestorLicencia.obtenerTiposLicencias();
		String nombre= null;
		String apellido= null;
		String tipoLicencia = null;
		
		if(licenciasVigentes.size()==0) {
			VentanaAdmin.mensajeError("No se encontraron licencias vigentes", "AVISO");
		}else {
			for(int i=0; i<licenciasVigentes.size(); i++) {
				
				for(int j=0; j<tiposLic.size(); j++) {
					if(tiposLic.get(j).getId_tipo_licencia()==licenciasVigentes.get(i).getIdTipoLicencia()) {
						tipoLicencia=tiposLic.get(j).getClase();
					}
				}
				
				for(int j=0; j<personas.size(); j++) {
					if(personas.get(j).getDni().equals(licenciasVigentes.get(i).getIdPersona())) {
						nombre=personas.get(j).getNombre();
						apellido=personas.get(j).getApellido();
					}
				}
				
				Object[] rowData= {nombre, apellido, licenciasVigentes.get(i).getFechaVigencia().toString(), tipoLicencia}; 
				dm.addRow(rowData);
			}
		}
		
	}

	public static void restaurarTabla() {
		 for( int i = dm.getRowCount() - 1; i >= 0; i-- ) {
	          dm.removeRow(i);
	      }
		}
}
