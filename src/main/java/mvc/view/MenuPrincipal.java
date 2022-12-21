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
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

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
	private JPanel panel;

	public MenuPrincipal() {
		
	}

	public MenuPrincipal(final AdministradorDTO admin) {
		setBackground(SystemColor.controlShadow);
	setLocation(-31, -63);
	setPreferredSize(new Dimension(980, 650));
	setLayout(null);
	
	btnEmitirLicencia = new JButton("Emitir licencia");
	btnEmitirLicencia.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnEmitirLicencia.setBackground(UIManager.getColor("Button.background"));
	btnEmitirLicencia.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnEmitirLicencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			PntCrearLicencia pntCrearLicencia = new PntCrearLicencia(admin);
			VentanaAdmin.cambiarPantalla(pntCrearLicencia, VentanaAdmin.n_pntCrearLicencia);
		}
	});
	btnEmitirLicencia.setBounds(238, 93, 184, 60);
	add(btnEmitirLicencia);
	
	btnDarDeAltaTitular = new JButton("Dar de alta titular");
	btnDarDeAltaTitular.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnDarDeAltaTitular.setBackground(UIManager.getColor("Button.background"));
	btnDarDeAltaTitular.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnDarDeAltaTitular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PntDarAltaTitularUI pntDarAltaTitularUI = new PntDarAltaTitularUI(admin);
			VentanaAdmin.cambiarPantalla(pntDarAltaTitularUI, VentanaAdmin.n_pntDarAltaTitularUI);
		}
	});
	btnDarDeAltaTitular.setBounds(519, 346, 184, 60);
	add(btnDarDeAltaTitular);
	
	btnEmitirCopia = new JButton("Emitir copia de licencia");
	btnEmitirCopia.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnEmitirCopia.setBackground(UIManager.getColor("Button.background"));
	btnEmitirCopia.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnEmitirCopia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PntEmitirCopia pntEmitirCopia = new PntEmitirCopia(admin);
			VentanaAdmin.cambiarPantalla(pntEmitirCopia, VentanaAdmin.n_pntEmitirCopia);
		}
	});
	btnEmitirCopia.setBounds(238, 214, 184, 60);
	add(btnEmitirCopia);
	
	btnLicenciasExpiradas = new JButton("Licencias expiradas");
	btnLicenciasExpiradas.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnLicenciasExpiradas.setBackground(UIManager.getColor("Button.background"));
	btnLicenciasExpiradas.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnLicenciasExpiradas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PntLicenciaExpirada pntLicenciaExpirada = new PntLicenciaExpirada(admin);
			VentanaAdmin.cambiarPantalla(pntLicenciaExpirada, VentanaAdmin.n_pntLicenciaExpirada);
		}
	});
	btnLicenciasExpiradas.setBounds(519, 93, 184, 60);
	add(btnLicenciasExpiradas);
	
	btnLicenciasVigentes = new JButton("Licencias vigentes");
	btnLicenciasVigentes.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnLicenciasVigentes.setBackground(UIManager.getColor("Button.background"));
	btnLicenciasVigentes.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnLicenciasVigentes.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PntLicenciaVigente pntLicenciaVigente = new PntLicenciaVigente(admin);
			VentanaAdmin.cambiarPantalla(pntLicenciaVigente, VentanaAdmin.n_pntLicenciaVigente);
		}
	});
	btnLicenciasVigentes.setBounds(519, 214, 184, 60);
	add(btnLicenciasVigentes);
	
	btnModificarTitular = new JButton("Modificar datos de titular");
	btnModificarTitular.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnModificarTitular.setBackground(UIManager.getColor("Button.background"));
	btnModificarTitular.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnModificarTitular.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PntModificarDatosConductor pntModificarDatosConductor = new PntModificarDatosConductor(admin);
			VentanaAdmin.cambiarPantalla(pntModificarDatosConductor, VentanaAdmin.n_pntModificarDatosConductor);
		}
	});
	btnModificarTitular.setBounds(359, 461, 229, 60);
	add(btnModificarTitular);
	
	btnRenovarLicencia = new JButton("Renovar licencia");
	btnRenovarLicencia.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnRenovarLicencia.setBackground(UIManager.getColor("Button.background"));
	btnRenovarLicencia.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnRenovarLicencia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PntRenovarLicencia pntRenovarLicencia = new PntRenovarLicencia(admin);
			VentanaAdmin.cambiarPantalla(pntRenovarLicencia, VentanaAdmin.n_pntRenovarLicencia);
		}
	});
	btnRenovarLicencia.setBounds(238, 346, 184, 60);
	add(btnRenovarLicencia);
	
	btnSalir = new JButton("Salir");
	btnSalir.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnSalir.setBackground(UIManager.getColor("Button.background"));
	btnSalir.setFont(new Font("Montserrat Light", Font.BOLD, 11));
	btnSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(ABORT);
		}
	});
	btnSalir.setBounds(881, 604, 89, 23);
	add(btnSalir);
	
	JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
	btnCerrarSesin.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnCerrarSesin.setBackground(UIManager.getColor("Button.background"));
	btnCerrarSesin.setFont(new Font("Montserrat Light", Font.BOLD, 11));
	btnCerrarSesin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			VentanaAdmin.cambiarPantalla(VentanaAdmin.loginAdmin, VentanaAdmin.n_loginAdmin);
		}
	});
	btnCerrarSesin.setBounds(732, 604, 139, 23);
	add(btnCerrarSesin);
	
	panel = new JPanel();
	panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panel.setBackground(Color.LIGHT_GRAY);
	panel.setBounds(214, 11, 515, 549);
	add(panel);
	panel.setLayout(null);
	
	txtpnEmitirCopia = new JTextPane();
	txtpnEmitirCopia.setBounds(218, 21, 79, 39);
	panel.add(txtpnEmitirCopia);
	txtpnEmitirCopia.setText("MENÚ");
	txtpnEmitirCopia.setFont(new Font("Tahoma", Font.PLAIN, 27));
	txtpnEmitirCopia.setEditable(false);
	txtpnEmitirCopia.setBackground(Color.LIGHT_GRAY);
		
	}
}
