package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JTextPane;

public class PntCrearLicencia extends JPanel {
	
	public PntCrearLicencia() {
	setPreferredSize(new Dimension(980, 590));
	setLayout(null);
	
	JTextPane txtpnAltaParticipante = new JTextPane();
	txtpnAltaParticipante.setText("ALTA DE PARTICIPANTES");
	txtpnAltaParticipante.setFont(new Font("Tahoma", Font.PLAIN, 18));
	txtpnAltaParticipante.setEditable(false);
	txtpnAltaParticipante.setBackground(SystemColor.menu);
	txtpnAltaParticipante.setBounds(372, 47, 219, 37);
	add(txtpnAltaParticipante);
	
	}

}
