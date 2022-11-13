package mvc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import mvc.model.Licencia;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

public class PntImprimirLicencia extends JPanel {

	private JLabel numLicenciaLbl;
	private JLabel apellidoLbl;
	private JLabel nombreLbl;
	private JLabel domicilioLbl;
	private JLabel fechaNacLbl;
	private JLabel fechaVencimLbl;
	private JLabel tipoLicLbl;
	private JTextArea descripLicLbl;
	private JLabel donanteLbl;
	private JLabel grupoSangreLbl;
	private JLabel ObservacionesLbl;
	private JLabel documentoLbl;
	private JLabel gastoAdminLbl;
	private JLabel costoLicenciaLbl;
	private JLabel totalLbl;
	private JLabel tipoDocumentoLbl;

	/**
	 * Create the panel.
	 */
	public PntImprimirLicencia() {
		setPreferredSize(new Dimension(980, 650));
		setLayout(null);
		
		JLabel lblTituloImpresion = new JLabel("Previsualizaci\u00F3n de Licencia", SwingConstants.CENTER);
		lblTituloImpresion.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTituloImpresion.setBounds(0, 10, 980, 20);
		add(lblTituloImpresion);
		
		JPanel licFrentePanel = new JPanel();
		licFrentePanel.setBounds(10, 50, 400, 300);
		licFrentePanel.setBackground(new Color(230, 255, 255));
		licFrentePanel.setBorder(new LineBorder(SystemColor.desktop));
		licFrentePanel.setLayout(null);
		add(licFrentePanel);
		
		JLabel lblTituloLicencia = new JLabel("Licencia Nacional de Conducir");
		lblTituloLicencia.setForeground(new Color(4, 130, 255));
		lblTituloLicencia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloLicencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLicencia.setBounds(0, 4, 400, 15);
		licFrentePanel.add(lblTituloLicencia);
		
		JLabel lblUbiLicencia = new JLabel("SANTA FE - SANTA FE");
		lblUbiLicencia.setForeground(new Color(4, 130, 255));
		lblUbiLicencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUbiLicencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbiLicencia.setBounds(0, 20, 400, 14);
		licFrentePanel.add(lblUbiLicencia);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.textHighlight);
		separator.setBounds(10, 40, 380, 10);
		licFrentePanel.add(separator);
		
		JLabel lblFotoPersona = new JLabel();
		lblFotoPersona.setHorizontalAlignment(SwingConstants.CENTER);
		File imagenPersona = new File("img/oso.jpg"); 
		lblFotoPersona.setIcon(new ImageIcon(imagenPersona.getPath()));
		lblFotoPersona.setBounds(10,60,130,200);
		licFrentePanel.add(lblFotoPersona);
		
		JLabel lblNumLicencia = new JLabel("N\u00B0 Licencia / License N\u00B0");
		lblNumLicencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumLicencia.setBounds(150, 60, 140, 14);
		licFrentePanel.add(lblNumLicencia);
		
		numLicenciaLbl = new JLabel();
		numLicenciaLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		numLicenciaLbl.setBounds(160, 80, 46, 14);
		licFrentePanel.add(numLicenciaLbl);

		JLabel lblApellido = new JLabel("Apellido / Last name");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(150, 100, 140, 14);
		licFrentePanel.add(lblApellido);
		
		apellidoLbl = new JLabel();
		apellidoLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		apellidoLbl.setBounds(160, 120, 46, 14);
		licFrentePanel.add(apellidoLbl);
		
		JLabel lblNombre = new JLabel("Nombre / First name");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(150, 140, 140, 14);
		licFrentePanel.add(lblNombre);
		
		nombreLbl = new JLabel();
		nombreLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		nombreLbl.setBounds(160, 160, 46, 14);
		licFrentePanel.add(nombreLbl);
		
		JLabel lblDomicilio = new JLabel("Domicilio / address");
		lblDomicilio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDomicilio.setBounds(150, 180, 140, 14);
		licFrentePanel.add(lblDomicilio);
		
		domicilioLbl = new JLabel();
		domicilioLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		domicilioLbl.setBounds(160, 200, 104, 14);
		licFrentePanel.add(domicilioLbl);
		
		JLabel lblFechaNac = new JLabel("Fecha de Nac. / Date of Birth");
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaNac.setBounds(150, 220, 190, 14);
		licFrentePanel.add(lblFechaNac);
		
		fechaNacLbl = new JLabel();
		fechaNacLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		fechaNacLbl.setBounds(160, 240, 104, 14);
		licFrentePanel.add(fechaNacLbl);
		
		JLabel lblfechaVencim = new JLabel("Vencimiento / Expires");
		lblfechaVencim.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblfechaVencim.setBounds(150, 260, 140, 14);
		licFrentePanel.add(lblfechaVencim);
		
		fechaVencimLbl = new JLabel();
		fechaVencimLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		fechaVencimLbl.setBounds(160, 280, 89, 14);
		licFrentePanel.add(fechaVencimLbl);
		
		
		JPanel licDorsoPanel = new JPanel();
		licDorsoPanel.setBounds(570, 50, 400, 300);
		licDorsoPanel.setBackground(new Color(230, 255, 255));
		licDorsoPanel.setBorder(new LineBorder(SystemColor.desktop));
		licDorsoPanel.setLayout(null);
		add(licDorsoPanel);
	
		JLabel lblTipoLic = new JLabel("Tipo de licencia / Type of license");
		lblTipoLic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoLic.setBounds(10, 60, 197, 14);
		licDorsoPanel.add(lblTipoLic);
		
		tipoLicLbl = new JLabel();
		tipoLicLbl.setHorizontalAlignment(SwingConstants.LEFT);
		tipoLicLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		tipoLicLbl.setBounds(20, 80, 46, 14);
		licDorsoPanel.add(tipoLicLbl);
		
		descripLicLbl = new JTextArea();
		descripLicLbl.setWrapStyleWord(true);
		descripLicLbl.setEditable(false);
		descripLicLbl.setBackground(new Color(230, 255, 255));
		descripLicLbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		descripLicLbl.setLineWrap(true);
		descripLicLbl.setBounds(60, 80, 330, 32);
		licDorsoPanel.add(descripLicLbl);
		
		JLabel lbldonante = new JLabel("Donante / Donor");
		lbldonante.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldonante.setBounds(10, 120, 108, 14);
		licDorsoPanel.add(lbldonante);
		
		JLabel lblGrupoYFactor = new JLabel("Grupo y factor / Blood type");
		lblGrupoYFactor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGrupoYFactor.setBounds(150, 120, 180, 14);
		licDorsoPanel.add(lblGrupoYFactor);
		
		donanteLbl = new JLabel();
		donanteLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		donanteLbl.setBounds(120, 120, 46, 14);
		licDorsoPanel.add(donanteLbl);
		
		grupoSangreLbl = new JLabel();
		grupoSangreLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		grupoSangreLbl.setBounds(332, 120, 46, 14);
		licDorsoPanel.add(grupoSangreLbl);
		
		JLabel lblDocumento = new JLabel("Documento / ID Card");
		lblDocumento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDocumento.setBounds(10, 140, 135, 14);
		licDorsoPanel.add(lblDocumento);
		
		documentoLbl = new JLabel();
		documentoLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		documentoLbl.setBounds(60, 160, 85, 14);
		licDorsoPanel.add(documentoLbl);
		
		tipoDocumentoLbl = new JLabel();
		tipoDocumentoLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		tipoDocumentoLbl.setBounds(10, 160, 46, 14);
		licDorsoPanel.add(tipoDocumentoLbl);

		JLabel lblObservaciones = new JLabel("Observaciones / Observations");
		lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObservaciones.setBounds(10, 180, 211, 14);
		licDorsoPanel.add(lblObservaciones);
		
		ObservacionesLbl = new JLabel();
		ObservacionesLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		ObservacionesLbl.setBounds(10, 200, 330, 14);
		licDorsoPanel.add(ObservacionesLbl);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(10, 40, 380, 10);
		licDorsoPanel.add(separator_1);
		
		JLabel lblLnc = new JLabel("LNC");
		lblLnc.setHorizontalAlignment(SwingConstants.CENTER);
		lblLnc.setForeground(SystemColor.text);
		lblLnc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLnc.setBounds(10, 270, 70, 20);
		licDorsoPanel.add(lblLnc);
		
		JLabel lblMinisterioDeTransporte = new JLabel("Ministerio de Transporte");
		lblMinisterioDeTransporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinisterioDeTransporte.setForeground(SystemColor.text);
		lblMinisterioDeTransporte.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMinisterioDeTransporte.setBounds(163, 270, 227, 20);
		licDorsoPanel.add(lblMinisterioDeTransporte);
		
		JPanel panelAzul = new JPanel();
		panelAzul.setBackground(SystemColor.textHighlight);
		panelAzul.setBorder(new LineBorder(SystemColor.desktop));
		panelAzul.setBounds(0, 260, 400, 40);
		licDorsoPanel.add(panelAzul);
		
		JTextPane txtGrupoSangYFactRH = new JTextPane();
		txtGrupoSangYFactRH.setText("Detalle de pago");
		txtGrupoSangYFactRH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtGrupoSangYFactRH.setEditable(false);
		txtGrupoSangYFactRH.setBackground(SystemColor.menu);
		txtGrupoSangYFactRH.setBounds(20, 364, 103, 22);
		add(txtGrupoSangYFactRH);
		
		JPanel pagoPanel = new JPanel();
		pagoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pagoPanel.setBounds(10, 374, 400, 122);
		add(pagoPanel);
		pagoPanel.setLayout(null);
		
		JLabel lblGastoAdmin = new JLabel("Gastos administrativos");
		lblGastoAdmin.setBounds(10, 25, 154, 14);
		pagoPanel.add(lblGastoAdmin);
		
		JLabel lblCostoLicencia = new JLabel("Costo licencia ");
		lblCostoLicencia.setBounds(10, 50, 154, 14);
		pagoPanel.add(lblCostoLicencia);
		
		gastoAdminLbl = new JLabel("$8");
		gastoAdminLbl.setBounds(185, 25, 52, 14);
		pagoPanel.add(gastoAdminLbl);
		
		costoLicenciaLbl = new JLabel("$80");
		costoLicenciaLbl.setBounds(185, 50, 52, 14);
		pagoPanel.add(costoLicenciaLbl);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(10, 97, 120, 14);
		pagoPanel.add(lblTotal);
		
		totalLbl = new JLabel("$88");
		totalLbl.setBounds(185, 99, 52, 14);
		pagoPanel.add(totalLbl);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 84, 380, 2);
		pagoPanel.add(separator_2);
		
		JButton btnImprimirLicencia = new JButton("Imprimir licencia");
		btnImprimirLicencia.setBounds(852, 602, 118, 37);
		add(btnImprimirLicencia);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(724, 602, 118, 37);
		add(btnAtras);
		
		JButton btnImprimirComprobante = new JButton("Imprimir comprobante ");
		btnImprimirComprobante.setBounds(243, 507, 167, 20);
		add(btnImprimirComprobante);
		
		

	}
}
