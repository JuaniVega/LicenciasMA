package mvc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.util.ArrayList;

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
import mvc.controller.gestores.GestorLicencia;
import mvc.controller.gestores.GestorPersona;
import mvc.model.Licencia;
import mvc.model.TipoDocumento;
import mvc.model.TipoGrupoSanguineo;
import mvc.model.TipoLicencia;

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
	private JLabel tipoLicLbl2;
	private JLabel descLicLbl;
	private JLabel descLicLbl2;
	private JTextArea descripLicLbl;
	private JLabel donanteLbl;
	private JLabel grupoSangreLbl;
	private JLabel ObservacionesLbl;
	private JLabel documentoLbl;
	private JLabel gastoAdminLbl;
	private JLabel costoLicenciaLbl;
	private JLabel costoLicenciaLbl2;
	private JLabel totalLbl;
	private JLabel tipoDocumentoLbl;
	private JLabel tipoLicenciaDescLbl;
	private JLabel tipoLicenciaDescLbl2;
	private JLabel numEjemplarLbl;
	private JLabel lblNumCopia;
	
	private JButton btnImprimirLicencia;
	
	private Integer valorTotal=0;

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
		licDorsoPanel.setBounds(550, 10, 400, 300);
		licDorsoPanel.setBackground(new Color(230, 255, 255));
		licDorsoPanel.setBorder(new LineBorder(SystemColor.desktop));
		licDorsoPanel.setLayout(null);
		carnetConductorPanel.add(licDorsoPanel);
	
		JLabel lblTipoLic = new JLabel("Tipo de licencia / Type of license");
		lblTipoLic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoLic.setBounds(10, 55, 197, 14);
		licDorsoPanel.add(lblTipoLic);
		
		tipoLicLbl = new JLabel();
		tipoLicLbl.setHorizontalAlignment(SwingConstants.LEFT);
		tipoLicLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		tipoLicLbl.setBounds(20, 80, 50, 14);
		licDorsoPanel.add(tipoLicLbl);
		
		descLicLbl = new JLabel();
		descLicLbl.setHorizontalAlignment(SwingConstants.LEFT);
		descLicLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		descLicLbl.setBounds(74, 80, 316, 14);
		licDorsoPanel.add(descLicLbl);
		
		descripLicLbl = new JTextArea();
		descripLicLbl.setWrapStyleWord(true);
		descripLicLbl.setEditable(false);
		descripLicLbl.setBackground(new Color(230, 255, 255));
		descripLicLbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		descripLicLbl.setLineWrap(true);
		descripLicLbl.setBounds(20, 80, 370, 14);
		licDorsoPanel.add(descripLicLbl);
		
		JLabel lbldonante = new JLabel("Donante / Donor");
		lbldonante.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldonante.setBounds(10, 129, 108, 14);
		licDorsoPanel.add(lbldonante);
		
		JLabel lblGrupoYFactor = new JLabel("Grupo y factor / Blood type");
		lblGrupoYFactor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGrupoYFactor.setBounds(150, 129, 180, 14);
		licDorsoPanel.add(lblGrupoYFactor);
		
		donanteLbl = new JLabel();
		donanteLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		donanteLbl.setBounds(110, 129, 46, 14);
		licDorsoPanel.add(donanteLbl);
		
		grupoSangreLbl = new JLabel();
		grupoSangreLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		grupoSangreLbl.setBounds(308, 129, 82, 14);
		licDorsoPanel.add(grupoSangreLbl);
		
		JLabel lblDocumento = new JLabel("Documento / ID Card");
		lblDocumento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDocumento.setBounds(10, 149, 135, 14);
		licDorsoPanel.add(lblDocumento);
		
		documentoLbl = new JLabel();
		documentoLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		documentoLbl.setBounds(37, 169, 108, 14);
		licDorsoPanel.add(documentoLbl);
		
		tipoDocumentoLbl = new JLabel();
		tipoDocumentoLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		tipoDocumentoLbl.setBounds(10, 169, 46, 14);
		licDorsoPanel.add(tipoDocumentoLbl);

		JLabel lblObservaciones = new JLabel("Observaciones / Observations");
		lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObservaciones.setBounds(10, 189, 211, 14);
		licDorsoPanel.add(lblObservaciones);
		
		ObservacionesLbl = new JLabel();
		ObservacionesLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		ObservacionesLbl.setBounds(10, 209, 380, 40);
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
		
		tipoLicLbl2 = new JLabel();
		tipoLicLbl2.setHorizontalAlignment(SwingConstants.LEFT);
		tipoLicLbl2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		tipoLicLbl2.setBounds(20, 105, 50, 14);
		licDorsoPanel.add(tipoLicLbl2);
		
		descLicLbl2 = new JLabel();
		descLicLbl2.setHorizontalAlignment(SwingConstants.LEFT);
		descLicLbl2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		descLicLbl2.setBounds(74, 105, 316, 14);
		licDorsoPanel.add(descLicLbl2);
		
		lblNumCopia = new JLabel("Ejemplar  / Copy");
		lblNumCopia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumCopia.setBounds(150, 149, 120, 14);
		licDorsoPanel.add(lblNumCopia);
		
		numEjemplarLbl = new JLabel();
		numEjemplarLbl.setFont(new Font("Tahoma", Font.ITALIC, 11));
		numEjemplarLbl.setBounds(161, 169, 46, 14);
		licDorsoPanel.add(numEjemplarLbl);
		
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
		lblGastoAdmin.setBounds(10, 11, 154, 14);
		pagoPanel.add(lblGastoAdmin);
		
		JLabel lblCostoLicencia = new JLabel("Costo licencia ");
		lblCostoLicencia.setBounds(10, 36, 154, 14);
		pagoPanel.add(lblCostoLicencia);
		
		gastoAdminLbl = new JLabel("$8");
		gastoAdminLbl.setBounds(185, 11, 52, 14);
		pagoPanel.add(gastoAdminLbl);
		
		costoLicenciaLbl = new JLabel();
		costoLicenciaLbl.setBounds(185, 36, 52, 14);
		pagoPanel.add(costoLicenciaLbl);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(10, 97, 120, 14);
		pagoPanel.add(lblTotal);
		
		totalLbl = new JLabel();
		totalLbl.setBounds(185, 99, 52, 14);
		pagoPanel.add(totalLbl);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 84, 380, 2);
		pagoPanel.add(separator_2);
		
		costoLicenciaLbl2 = new JLabel();
		costoLicenciaLbl2.setBounds(185, 59, 52, 14);
		pagoPanel.add(costoLicenciaLbl2);
		
		tipoLicenciaDescLbl = new JLabel();
		tipoLicenciaDescLbl.setBounds(247, 36, 143, 14);
		pagoPanel.add(tipoLicenciaDescLbl);
		
		tipoLicenciaDescLbl2 = new JLabel();
		tipoLicenciaDescLbl2.setBounds(247, 59, 143, 14);
		pagoPanel.add(tipoLicenciaDescLbl2);
		
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
		btnImprimirLicencia.setBounds(768, 602, 160, 37);
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

			ArrayList<TipoLicencia> tipoLic = new ArrayList<TipoLicencia>(); 
			Licencia lic = null;
			TipoDocumento tipoDoc = null; 
			TipoGrupoSanguineo tipoGS = null;
			String esDonante;

			//Preparo algunos datos
			try {
				//lic = GestorLicencia.obtenerLicenciaxDni(datosDTO.getNumDoc()); 
				// Necesito id de la licencia o algun id de tramite 
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				for (Integer list : datosDTO.getIntLicenciasSeleccionadas()) {
					tipoLic.add(GestorLicencia.obtenerTipoLicencia(list));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				tipoDoc = GestorPersona.obtenerTipoDocumento(datosDTO.getTipoDoc());
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				tipoGS = GestorPersona.obtenerTipoGrupoSanguineo(datosDTO.getGrupoSang());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(datosDTO.getEsDonante() == true) {
				esDonante = "Si";
			}else {
				esDonante = "No";
			}

			//Licencia Frente
			this.apellidoLbl.setText(datosDTO.getApellidoCond());
			this.nombreLbl.setText(datosDTO.getNombreCond());
			this.domicilioLbl.setText(datosDTO.getCalle() + " " + datosDTO.getNumCalle() + " " + datosDTO.getPiso() + " " +  datosDTO.getDpto());
			this.fechaNacLbl.setText(datosDTO.getFechaNacimiento().toString());
			this.fechaVencimLbl.setText(datosDTO.getFechaVigencia().toString());

			//Licencia Dorso
			for(int i=0; i<tipoLic.size(); i++) {
				if(this.tipoLicLbl.getText().equals("")) {
					this.tipoLicLbl.setText(tipoLic.get(i).getClase());
					this.descLicLbl.setText(tipoLic.get(i).getDescripcion());
				}else {
					this.tipoLicLbl2.setText(tipoLic.get(i).getClase());
					this.descLicLbl2.setText(tipoLic.get(i).getDescripcion());
				}
			}
			this.donanteLbl.setText(esDonante);
			this.grupoSangreLbl.setText(tipoGS.getTipo_grupo_sanguineo());
			this.tipoDocumentoLbl.setText(tipoDoc.getTipo_doc());
			this.documentoLbl.setText(datosDTO.getNumDoc().toString());
			this.ObservacionesLbl.setText(datosDTO.getObservaciones());
			this.numEjemplarLbl.setText(datosDTO.getNumCopia().toString());

			//Seccion costos
			for(int i=0; i<datosDTO.getCosto().size(); i++) {
				if(this.costoLicenciaLbl.getText().equals("")) {
					this.costoLicenciaLbl.setText("$" + (Integer.toString(datosDTO.getCosto().get(i))));
					this.tipoLicenciaDescLbl.setText("Licencia "+tipoLic.get(i).getClase());
				}else {
					this.costoLicenciaLbl2.setText("$" + (Integer.toString(datosDTO.getCosto().get(i))));
					this.tipoLicenciaDescLbl2.setText("Licencia "+tipoLic.get(i).getClase());
				}
				valorTotal = valorTotal+ (datosDTO.getCosto().get(i));
			}
			this.totalLbl.setText("$" + (Integer.toString(valorTotal+8)));
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
