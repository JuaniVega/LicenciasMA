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

public class LoginAdmin extends JPanel{
	private JTextField tfUsuario;
	private JPasswordField tfCont;
	private AdministradorDTO administradorDTO = new AdministradorDTO();
	
	public LoginAdmin() {
		
	setLocation(-31, -63);
	setPreferredSize(new Dimension(980, 650));
	setLayout(null);
	
	JTextPane txtpnLogin = new JTextPane();
	txtpnLogin.setText("INICIAR SESI\u00D3N");
	txtpnLogin.setFont(new Font("Tahoma", Font.BOLD, 21));
	txtpnLogin.setEditable(false);
	txtpnLogin.setBackground(SystemColor.menu);
	txtpnLogin.setBounds(373, 118, 196, 37);
	add(txtpnLogin);
	
	JLabel lblUsuario = new JLabel("Usuario");
	lblUsuario.setBounds(255, 190, 73, 14);
	add(lblUsuario);
	
	JLabel lblContra = new JLabel("Contrase\u00F1a");
	lblContra.setBounds(255, 236, 73, 14);
	add(lblContra);
	
	tfUsuario = new JTextField();
	tfUsuario.setBounds(338, 190, 315, 20);
	add(tfUsuario);
	tfUsuario.setColumns(10);
	
	tfCont = new JPasswordField();
	tfCont.setColumns(10);
	tfCont.setBounds(338, 236, 315, 20);
	add(tfCont);
	
	JButton btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
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
	btnCancelar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(ABORT);
		}
	});
	btnCancelar.setBounds(422, 321, 147, 23);
	add(btnCancelar);
	
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
