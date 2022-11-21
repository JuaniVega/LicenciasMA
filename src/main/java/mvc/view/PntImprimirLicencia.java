package mvc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.border.LineBorder;

import mvc.controller.dto.EmitirLicenciaDTO;
import mvc.controller.gestores.GestorPersona;
import mvc.model.TipoDocumento;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

public class PntImprimirLicencia extends JPanel implements Printable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5995874360565210693L;
	
	private JPanel carnetConductorPanel;
	private JPanel licFrentePanel;
	private JPanel licDorsoPanel;
	private JPanel pagoPanel;
	
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
	
	private JButton btnImprimirLicencia;

	/**
	 * Create the panel.
	 */
	public PntImprimirLicencia(final EmitirLicenciaDTO datosLicencia) {
		setPreferredSize(new Dimension(980, 650));
		setLayout(null);

		JLabel lblTituloImpresion = new JLabel("Previsualizaci\u00F3n de Licencia", SwingConstants.CENTER);
		lblTituloImpresion.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTituloImpresion.setBounds(0, 10, 980, 20);
		add(lblTituloImpresion);
		
		carnetConductorPanel = new JPanel();
		carnetConductorPanel.setBounds(0, 40, 980, 467);
		carnetConductorPanel.setLayout(null);
		add(carnetConductorPanel);
		
		licFrentePanel = new JPanel();
		licFrentePanel.setBounds(10, 10, 400, 300);
		licFrentePanel.setBackground(new Color(230, 255, 255));
		licFrentePanel.setBorder(new LineBorder(SystemColor.desktop));
		licFrentePanel.setLayout(null);
		carnetConductorPanel.add(licFrentePanel);
		
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
		numLicenciaLbl.setBounds(160, 80, 220, 14);
		licFrentePanel.add(numLicenciaLbl);

		JLabel lblApellido = new JLabel("Apellido / Last name");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(150, 100, 140, 14);
		licFrentePanel.add(lblApellido);
		
		apellidoLbl = new JLabel();
		apellidoLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		apellidoLbl.setBounds(160, 120, 210, 14);
		licFrentePanel.add(apellidoLbl);
		
		JLabel lblNombre = new JLabel("Nombre / First name");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(150, 140, 140, 14);
		licFrentePanel.add(lblNombre);
		
		nombreLbl = new JLabel();
		nombreLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		nombreLbl.setBounds(160, 160, 220, 14);
		licFrentePanel.add(nombreLbl);
		
		JLabel lblDomicilio = new JLabel("Domicilio / address");
		lblDomicilio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDomicilio.setBounds(150, 180, 140, 14);
		licFrentePanel.add(lblDomicilio);
		
		domicilioLbl = new JLabel();
		domicilioLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		domicilioLbl.setBounds(160, 200, 220, 14);
		licFrentePanel.add(domicilioLbl);
		
		JLabel lblFechaNac = new JLabel("Fecha de Nac. / Date of Birth");
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaNac.setBounds(150, 220, 190, 14);
		licFrentePanel.add(lblFechaNac);
		
		fechaNacLbl = new JLabel();
		fechaNacLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		fechaNacLbl.setBounds(160, 240, 220, 14);
		licFrentePanel.add(fechaNacLbl);
		
		JLabel lblfechaVencim = new JLabel("Vencimiento / Expires");
		lblfechaVencim.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblfechaVencim.setBounds(150, 260, 140, 14);
		licFrentePanel.add(lblfechaVencim);
		
		fechaVencimLbl = new JLabel();
		fechaVencimLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		fechaVencimLbl.setBounds(160, 280, 220, 14);
		licFrentePanel.add(fechaVencimLbl);
		
		
		licDorsoPanel = new JPanel();
		licDorsoPanel.setBounds(570, 10, 400, 300);
		licDorsoPanel.setBackground(new Color(230, 255, 255));
		licDorsoPanel.setBorder(new LineBorder(SystemColor.desktop));
		licDorsoPanel.setLayout(null);
		carnetConductorPanel.add(licDorsoPanel);
	
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
		descripLicLbl.setBounds(20, 80, 370, 32);
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
		donanteLbl.setBounds(110, 120, 46, 14);
		licDorsoPanel.add(donanteLbl);
		
		grupoSangreLbl = new JLabel();
		grupoSangreLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		grupoSangreLbl.setBounds(308, 120, 82, 14);
		licDorsoPanel.add(grupoSangreLbl);
		
		JLabel lblDocumento = new JLabel("Documento / ID Card");
		lblDocumento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDocumento.setBounds(10, 140, 135, 14);
		licDorsoPanel.add(lblDocumento);
		
		documentoLbl = new JLabel();
		documentoLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		documentoLbl.setBounds(37, 160, 108, 14);
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
		ObservacionesLbl.setBounds(10, 200, 380, 49);
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
		
		JTextPane txtDetallePago = new JTextPane();
		txtDetallePago.setText("Detalle de pago");
		txtDetallePago.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDetallePago.setEditable(false);
		txtDetallePago.setBackground(SystemColor.menu);
		txtDetallePago.setBounds(20, 330, 96, 22);
		carnetConductorPanel.add(txtDetallePago);
		
		pagoPanel = new JPanel();
		pagoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pagoPanel.setBounds(10, 340, 400, 122);
		carnetConductorPanel.add(pagoPanel);
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
		
		btnImprimirLicencia = new JButton("Imprimir licencia");
		btnImprimirLicencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				PrinterJob job = PrinterJob.getPrinterJob();
				PageFormat pf = job.defaultPage();
				pf.setOrientation(PageFormat.LANDSCAPE);
				job.setPrintable(new PntImprimirLicencia(datosLicencia), pf);
				if(job.printDialog()) {
					try {					
						job.print();
					} catch (PrinterException e) {
						e.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(carnetConductorPanel, "La impresion se cancelo", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnImprimirLicencia.setBounds(810, 602, 118, 37);
		add(btnImprimirLicencia);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAdmin.cambiarPantalla(VentanaAdmin.pntCrearLicencia,VentanaAdmin.n_pntCrearLicencia);
			}
		});
		btnAtras.setBounds(41, 602, 118, 37);
		add(btnAtras);
		
		cargarDatosenCampo(datosLicencia);
	}

	private void cargarDatosenCampo(EmitirLicenciaDTO datosDTO) {
		if(datosDTO != null) {

			TipoDocumento tipoDoc = null; 

			//Preparo algunos datos
			try {
				tipoDoc = GestorPersona.obtenerTipoDocumento(datosDTO.getTipoDoc());
			} catch (Exception e) {
				e.printStackTrace();
			}

			

			//Licencia Frente
			this.apellidoLbl.setText(datosDTO.getApellidoCond());
			this.nombreLbl.setText(datosDTO.getNombreCond());
			this.domicilioLbl.setText(datosDTO.getCalle() + " " + datosDTO.getNumCalle() + " " + datosDTO.getPiso() + " " +  datosDTO.getDpto());
			this.fechaNacLbl.setText(datosDTO.getFechaNacimiento().toString());
			this.fechaVencimLbl.setText(datosDTO.getFechaVigencia().toString());

			//Licencia Dorso
			// this.tipoLicLbl.setText(datosDTO.getLicenciasSeleccionadas().get(0).toString(ALLBITS));
			this.donanteLbl.setText(datosDTO.getEsDonante().toString());
			this.grupoSangreLbl.setText(datosDTO.getGrupoSang().toString());
			this.tipoDocumentoLbl.setText(tipoDoc.getTipo_doc());
			this.documentoLbl.setText(datosDTO.getNumDoc().toString());
			this.ObservacionesLbl.setText(datosDTO.getObservaciones());
		}
	}

	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if(pageIndex > 0) return NO_SUCH_PAGE;
	
		Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		g2d.scale(0.70,0.80);
		carnetConductorPanel.printAll(graphics);
		return PAGE_EXISTS;
		
	}

}
