package mvc.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JPanel{
	
	private JTextPane txtpnEmitirCopia;
	private JButton btnEmitirLicencia;
	private JButton btnDarDeAltaTitular;
	private JButton btnEmitirCopia;
 	private JButton btnLicenciasExpiradas;
	private JButton btnLicenciasVigentes;
	private JButton btnModificarTitular;
	private JButton btnRenovarLicencia;
	private JButton btnSalir;
	

	public MenuPrincipal() {
	setLocation(-31, -63);
	setPreferredSize(new Dimension(980, 650));
	setLayout(null);
	
	txtpnEmitirCopia = new JTextPane();
	txtpnEmitirCopia.setText("MEN�");
	txtpnEmitirCopia.setFont(new Font("Tahoma", Font.BOLD, 21));
	txtpnEmitirCopia.setEditable(false);
	txtpnEmitirCopia.setBackground(SystemColor.menu);
	txtpnEmitirCopia.setBounds(428, 30, 80, 37);
	add(txtpnEmitirCopia);
	
	btnEmitirLicencia = new JButton("Emitir licencia");
	btnEmitirLicencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.pntCrearLicencia, VentanaAdmin.n_pntCrearLicencia);
		}
	});
	btnEmitirLicencia.setBounds(238, 93, 184, 60);
	add(btnEmitirLicencia);
	
	btnDarDeAltaTitular = new JButton("Dar de alta titular");
	btnDarDeAltaTitular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.pntDarAltaTitularUI, VentanaAdmin.n_pntDarAltaTitularUI);
		}
	});
	btnDarDeAltaTitular.setBounds(384, 461, 184, 60);
	add(btnDarDeAltaTitular);
	
	btnEmitirCopia = new JButton("Emitir copia de licencia");
	btnEmitirCopia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.pntEmitirCopia, VentanaAdmin.n_pntEmitirCopia);
		}
	});
	btnEmitirCopia.setBounds(238, 214, 184, 60);
	add(btnEmitirCopia);
	
	btnLicenciasExpiradas = new JButton("Licencias expiradas");
	btnLicenciasExpiradas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.pntLicenciaExpirada, VentanaAdmin.n_pntLicenciaExpirada);
		}
	});
	btnLicenciasExpiradas.setBounds(519, 93, 184, 60);
	add(btnLicenciasExpiradas);
	
	btnLicenciasVigentes = new JButton("Licencias vigentes");
	btnLicenciasVigentes.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.pntLicenciaVigente, VentanaAdmin.n_pntLicenciaVigente);
		}
	});
	btnLicenciasVigentes.setBounds(519, 214, 184, 60);
	add(btnLicenciasVigentes);
	
	btnModificarTitular = new JButton("Modificar datos de titular");
	btnModificarTitular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.pntModificarDatosConductor, VentanaAdmin.n_pntModificarDatosConductor);
		}
	});
	btnModificarTitular.setBounds(519, 346, 184, 60);
	add(btnModificarTitular);
	
	btnRenovarLicencia = new JButton("Renovar licencia");
	btnRenovarLicencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.pntRenovarLicencia, VentanaAdmin.n_pntRenovarLicencia);
		}
	});
	btnRenovarLicencia.setBounds(238, 346, 184, 60);
	add(btnRenovarLicencia);
	
	btnSalir = new JButton("SALIR");
	btnSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(ABORT);
		}
	});
	btnSalir.setBounds(881, 604, 89, 23);
	add(btnSalir);
		
	}
}
