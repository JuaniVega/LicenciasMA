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

import mvc.controller.gestores.GestorLicencia;
import mvc.controller.gestores.GestorPersona;
import mvc.model.Licencia;
import mvc.model.Persona;
import mvc.model.TipoLicencia;

public class PntLicenciaExpirada extends JPanel{
	
	public static JTable table = new JTable();
	public static DefaultTableModel dm = new DefaultTableModel(){
		public boolean isCellEditable(int rowIndex, int columnIndex ) {
			return false;
		}
	};
	
	public PntLicenciaExpirada() {
	setLocation(-31, -63);
	setPreferredSize(new Dimension(980, 650));
	setLayout(null);
	
	actualizarVigenciasDesactualizadas();
	
	JButton btnAtras = new JButton("Atr\u00E1s");
	btnAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.pntmenuPrincipal, VentanaAdmin.n_pntmenuPrincipal);
			restaurarTabla();
		}
	});
	btnAtras.setBounds(41, 602, 118, 37);
	add(btnAtras);
	
	JButton btnObtenerLic = new JButton("Obtener licencias");
	btnObtenerLic.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				restaurarTabla();
				cargarLicenciasExpiradas();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	btnObtenerLic.setBounds(806, 602, 139, 37);
	add(btnObtenerLic);
	
	JTextPane txtpnEmitirLicencia = new JTextPane();
	txtpnEmitirLicencia.setText("LICENCIAS EXPIRADAS");
	txtpnEmitirLicencia.setFont(new Font("Tahoma", Font.BOLD, 21));
	txtpnEmitirLicencia.setEditable(false);
	txtpnEmitirLicencia.setBackground(SystemColor.menu);
	txtpnEmitirLicencia.setBounds(348, 11, 264, 37);
	add(txtpnEmitirLicencia);
	
	dm.addColumn("Nombre");
	dm.addColumn("Apellido");
	dm.addColumn("Fecha expiración");
	dm.addColumn("Clase");
	
	table.setModel(dm);
	
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setBounds(41, 59, 904, 499);
	add(scrollPane);
	
	}
	
	public static void actualizarVigenciasDesactualizadas() {
		GestorLicencia.actualizarVigenciasDesactualizadas();
	}
	
	public static void cargarLicenciasExpiradas() throws Exception {
		List<Licencia> licenExp = GestorLicencia.obtenerLicenciasExpiradas();
		List<TipoLicencia> tiposLic = GestorLicencia.obtenerTiposLicencias();
		List<Integer> listaDniLicencia = new ArrayList<Integer>();
		for(int i=0; i<licenExp.size();i++) {
			listaDniLicencia.add(licenExp.get(i).getIdPersona());
		}
		List<Persona> listaPersonas = GestorPersona.obtenerPersonasxListaDni(listaDniLicencia);
		String nombre= null;
		String apellido= null;
		String tipoLicencia = null;
		
		
		
		if(licenExp.size()==0) {
			VentanaAdmin.mensajeError("No se encontraron licencias expiradas", "ERROR");
		}else {
			for(int i=0; i<licenExp.size(); i++) {
				
				for(int j=0; j<tiposLic.size(); j++) {
					if(tiposLic.get(j).getId_tipo_licencia()==licenExp.get(i).getIdTipoLicencia()) {
						tipoLicencia=tiposLic.get(j).getClase();
					}
				}
				
				for(int j=0; j<listaPersonas.size(); j++) {
					if(listaPersonas.get(j).getDni().equals(licenExp.get(i).getIdPersona())) {
						nombre=listaPersonas.get(j).getNombre();
						apellido=listaPersonas.get(j).getApellido();
					}
				}
				
				Object[] rowData= {nombre, apellido, licenExp.get(i).getFechaVigencia().toString(), tipoLicencia}; 
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
