package mvc.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import mvc.controller.dto.AdministradorDTO;

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
		
	}

	public MenuPrincipal(final AdministradorDTO admin) {
	setLocation(-31, -63);
	setPreferredSize(new Dimension(980, 650));
	setLayout(null);
	
	txtpnEmitirCopia = new JTextPane();
	txtpnEmitirCopia.setText("MENÚ");
	txtpnEmitirCopia.setFont(new Font("Montserrat Light", Font.BOLD, 21));
	txtpnEmitirCopia.setEditable(false);
	txtpnEmitirCopia.setBackground(SystemColor.menu);
	txtpnEmitirCopia.setBounds(428, 30, 80, 37);
	add(txtpnEmitirCopia);
	
	btnEmitirLicencia = new JButton("Emitir licencia");
	btnEmitirLicencia.setFont(new Font("Montserrat Light", Font.BOLD, 11));
	btnEmitirLicencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			PntCrearLicencia pntCrearLicencia = new PntCrearLicencia(admin);
			VentanaAdmin.cambiarPantalla(pntCrearLicencia, VentanaAdmin.n_pntCrearLicencia);
		}
	});
	btnEmitirLicencia.setBounds(238, 93, 184, 60);
	add(btnEmitirLicencia);
	
	btnDarDeAltaTitular = new JButton("Dar de alta titular");
	btnDarDeAltaTitular.setFont(new Font("Montserrat Light", Font.BOLD, 11));
	btnDarDeAltaTitular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PntDarAltaTitularUI pntDarAltaTitularUI = new PntDarAltaTitularUI(admin);
			VentanaAdmin.cambiarPantalla(pntDarAltaTitularUI, VentanaAdmin.n_pntDarAltaTitularUI);
		}
	});
	btnDarDeAltaTitular.setBounds(384, 461, 184, 60);
	add(btnDarDeAltaTitular);
	
	btnEmitirCopia = new JButton("Emitir copia de licencia");
	btnEmitirCopia.setFont(new Font("Montserrat Light", Font.BOLD, 11));
	btnEmitirCopia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PntEmitirCopia pntEmitirCopia = new PntEmitirCopia(admin);
			VentanaAdmin.cambiarPantalla(pntEmitirCopia, VentanaAdmin.n_pntEmitirCopia);
		}
	});
	btnEmitirCopia.setBounds(238, 214, 184, 60);
	add(btnEmitirCopia);
	
	btnLicenciasExpiradas = new JButton("Licencias expiradas");
	btnLicenciasExpiradas.setFont(new Font("Montserrat Light", Font.BOLD, 11));
	btnLicenciasExpiradas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PntLicenciaExpirada pntLicenciaExpirada = new PntLicenciaExpirada(admin);
			VentanaAdmin.cambiarPantalla(pntLicenciaExpirada, VentanaAdmin.n_pntLicenciaExpirada);
		}
	});
	btnLicenciasExpiradas.setBounds(519, 93, 184, 60);
	add(btnLicenciasExpiradas);
	
	btnLicenciasVigentes = new JButton("Licencias vigentes");
	btnLicenciasVigentes.setFont(new Font("Montserrat Light", Font.BOLD, 11));
	btnLicenciasVigentes.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PntLicenciaVigente pntLicenciaVigente = new PntLicenciaVigente(admin);
			VentanaAdmin.cambiarPantalla(pntLicenciaVigente, VentanaAdmin.n_pntLicenciaVigente);
		}
	});
	btnLicenciasVigentes.setBounds(519, 214, 184, 60);
	add(btnLicenciasVigentes);
	
	btnModificarTitular = new JButton("Modificar datos de titular");
	btnModificarTitular.setFont(new Font("Montserrat Light", Font.BOLD, 11));
	btnModificarTitular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PntModificarDatosConductor pntModificarDatosConductor = new PntModificarDatosConductor(admin);
			VentanaAdmin.cambiarPantalla(pntModificarDatosConductor, VentanaAdmin.n_pntModificarDatosConductor);
		}
	});
	btnModificarTitular.setBounds(519, 346, 184, 60);
	add(btnModificarTitular);
	
	btnRenovarLicencia = new JButton("Renovar licencia");
	btnRenovarLicencia.setFont(new Font("Montserrat Light", Font.BOLD, 11));
	btnRenovarLicencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PntRenovarLicencia pntRenovarLicencia = new PntRenovarLicencia(admin);
			VentanaAdmin.cambiarPantalla(pntRenovarLicencia, VentanaAdmin.n_pntRenovarLicencia);
		}
	});
	btnRenovarLicencia.setBounds(238, 346, 184, 60);
	add(btnRenovarLicencia);
	
	btnSalir = new JButton("Salir");
	btnSalir.setFont(new Font("Montserrat Light", Font.BOLD, 11));
	btnSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(ABORT);
		}
	});
	btnSalir.setBounds(881, 604, 89, 23);
	add(btnSalir);
	
	JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
	btnCerrarSesin.setFont(new Font("Montserrat Light", Font.BOLD, 11));
	btnCerrarSesin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.loginAdmin, VentanaAdmin.n_loginAdmin);
		}
	});
	btnCerrarSesin.setBounds(732, 604, 139, 23);
	add(btnCerrarSesin);
		
	}
}
