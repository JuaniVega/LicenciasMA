package mvc.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import mvc.controller.dto.AdministradorDTO;
import mvc.controller.gestores.GestorPersona;
import mvc.model.Persona;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class LoginAdmin extends JPanel{
	private JTextField tfUsuario;
	private JPasswordField tfCont;
	private AdministradorDTO administradorDTO = new AdministradorDTO();
	
	public LoginAdmin() {
		setBackground(SystemColor.controlShadow);
		
	setLocation(-31, -63);
	setPreferredSize(new Dimension(980, 650));
	setLayout(null);
	
	JLabel lblUsuario = new JLabel("Usuario");
	lblUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
	lblUsuario.setBounds(255, 190, 73, 14);
	add(lblUsuario);
	
	JLabel lblContra = new JLabel("Contrase\u00F1a");
	lblContra.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
	lblContra.setBounds(255, 236, 73, 14);
	add(lblContra);
	
	tfUsuario = new JTextField();
	tfUsuario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	tfUsuario.setBounds(338, 190, 315, 20);
	add(tfUsuario);
	tfUsuario.setColumns(10);
	
	tfCont = new JPasswordField();
	tfCont.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	tfCont.setColumns(10);
	tfCont.setBounds(338, 236, 315, 20);
	add(tfCont);
	
	JButton btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
	btnIniciarSesion.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnIniciarSesion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
	btnIniciarSesion.setBackground(UIManager.getColor("Button.background"));
	btnIniciarSesion.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				List<Persona> admin = GestorPersona.iniciarSesion(tfUsuario.getText().trim(), String.valueOf(tfCont.getPassword()));
				if(admin.size()>0) {
					cargarDTO(admin.get(0));
					MenuPrincipal menuPrincipal = new MenuPrincipal(administradorDTO);
					VentanaAdmin.cambiarPantalla(menuPrincipal, VentanaAdmin.n_pntmenuPrincipal);
					limpiarCampos();
				}else {
					VentanaAdmin.mensajeError("Usuario / contraseña incorrectos", "ERROR");
					limpiarCampos();
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	btnIniciarSesion.setBounds(338, 287, 315, 23);
	add(btnIniciarSesion);
	
	JButton btnCancelar = new JButton("Cancelar");
	btnCancelar.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnCancelar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
	btnCancelar.setBackground(UIManager.getColor("Button.background"));
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(ABORT);
		}
	});
	btnCancelar.setBounds(422, 321, 147, 23);
	add(btnCancelar);
	
	JPanel panel = new JPanel();
	panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	panel.setBackground(Color.LIGHT_GRAY);
	panel.setBounds(216, 85, 521, 331);
	add(panel);
	panel.setLayout(null);
	
	JTextPane txtpnLogin = new JTextPane();
	txtpnLogin.setBounds(175, 62, 198, 32);
	panel.add(txtpnLogin);
	txtpnLogin.setText("INICIAR SESI\u00D3N");
	txtpnLogin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 21));
	txtpnLogin.setEditable(false);
	txtpnLogin.setBackground(Color.LIGHT_GRAY);
	
	}

	protected void cargarDTO(Persona persona) {
		administradorDTO.setNombre(persona.getNombre());
		administradorDTO.setApellido(persona.getApellido());
	}
	
	private void limpiarCampos() {
		tfCont.setText("");
		tfUsuario.setText("");
	}
}
