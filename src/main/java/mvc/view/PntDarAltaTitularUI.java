package mvc.view;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.TextArea;
import com.toedter.calendar.JDateChooser;

import mvc.controller.dto.CrearTitularDTO;
import mvc.controller.gestores.GestorPersona;
import mvc.model.TipoDocumento;
import mvc.model.TipoGrupoSanguineo;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;

	

public class PntDarAltaTitularUI extends JPanel{
                                                                                                                         
             	/**
				 * 
				 */
				private static final long serialVersionUID = -6048411653045236128L;
				
				private JTextField txtNombreTitular;
             	private JTextField txtApellidoTitular;
             	private JTextField txtNumDocTitular;
             	private JTextField txtCalleTitular;
             	private JTextField txtNumCalleTitular;
             	private JTextField txtPisoTitular;
             	private JTextField txtDptoTitular;
             	private JLabel labelErrorNom;
             	private JLabel labelErrorApellido;
             	private JLabel labelErrorDoc;
             	private JLabel labelErrorFechNac;
             	private JLabel labelErrorDireccion;
             	private JLabel labelErrorFactorRH;
             	private JLabel labelErrorGrupSanguineo;
             	private JLabel labelErrorPiso;
             	private JComboBox<String> cBoxTipoDoc;
             	private JDateChooser tfFechaNacTitular;
             	private JComboBox<String> cbGrupoSanguineo;
				private TextArea txtAreaOBS;

				private CrearTitularDTO crearTitularDTO = new CrearTitularDTO();
				
                //prueba                                                                                                                                                         
             	public PntDarAltaTitularUI() {
             		setBackground(UIManager.getColor("Button.background"));  
             		setPreferredSize(new Dimension(980, 650));
             		setLayout(null);
             		
             		JPanel PaneDocumento = new JPanel();
             		PaneDocumento.setToolTipText("Documento ");
             		PaneDocumento.setBorder(new TitledBorder(null, "Documento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
             		PaneDocumento.setBounds(138, 144, 750, 72);
             		add(PaneDocumento);
             		PaneDocumento.setLayout(null);
             		
             		JLabel lblNewLabel_2 = new JLabel("Tipo (*)");
             		lblNewLabel_2.setBounds(103, 27, 46, 14);
             		PaneDocumento.add(lblNewLabel_2);
             		
             		cBoxTipoDoc = new JComboBox<String>();
             		cBoxTipoDoc.setBounds(189, 23, 117, 22);
             		PaneDocumento.add(cBoxTipoDoc);
             		cBoxTipoDoc.setBackground(UIManager.getColor("Button.disabledShadow"));
             		
             		JLabel lblNewLabel_3 = new JLabel("Numero (*)");
             		lblNewLabel_3.setBounds(360, 27, 67, 14);
             		PaneDocumento.add(lblNewLabel_3);
             		
             		txtNumDocTitular = new JTextField();
             		txtNumDocTitular.setBounds(472, 24, 117, 20);
             		PaneDocumento.add(txtNumDocTitular);
             		txtNumDocTitular.setColumns(10);
             		
             		labelErrorDoc = new JLabel("");
             		labelErrorDoc.setForeground(Color.RED);
             		labelErrorDoc.setBounds(189, 47, 362, 14);
             		PaneDocumento.add(labelErrorDoc);
             		
             		JPanel panelDireccion = new JPanel();
             		panelDireccion.setBorder(new TitledBorder(null, "Direccion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
             		panelDireccion.setBounds(138, 242, 436, 107);
             		add(panelDireccion);
             		panelDireccion.setLayout(null);
             		
             		JLabel lblNewLabel_10 = new JLabel("Numero (*)");
             		lblNewLabel_10.setBounds(248, 21, 87, 14);
             		panelDireccion.add(lblNewLabel_10);
             		
             		txtNumCalleTitular = new JTextField();
             		txtNumCalleTitular.setBounds(319, 18, 87, 20);
             		panelDireccion.add(txtNumCalleTitular);
             		txtNumCalleTitular.setColumns(10);
             		
             		txtCalleTitular = new JTextField();
             		txtCalleTitular.setBounds(80, 18, 148, 20);
             		panelDireccion.add(txtCalleTitular);
             		txtCalleTitular.setColumns(10);
             		
             		JLabel lblNewLabel_9 = new JLabel("Calle (*)");
             		lblNewLabel_9.setBounds(22, 21, 46, 14);
             		panelDireccion.add(lblNewLabel_9);
             		
             		txtDptoTitular = new JTextField();
             		txtDptoTitular.setBounds(299, 61, 36, 20);
             		panelDireccion.add(txtDptoTitular);
             		txtDptoTitular.setColumns(10);
             		
             		JLabel lblNewLabel_12 = new JLabel("Departamento");
             		lblNewLabel_12.setBounds(203, 64, 86, 14);
             		panelDireccion.add(lblNewLabel_12);
             		
             		txtPisoTitular = new JTextField();
             		txtPisoTitular.setBounds(138, 61, 36, 20);
             		panelDireccion.add(txtPisoTitular);
             		txtPisoTitular.setColumns(10);
             		
             		JLabel lblNewLabel_11 = new JLabel("Piso");
             		lblNewLabel_11.setBounds(98, 64, 30, 14);
             		panelDireccion.add(lblNewLabel_11);
             		
             		labelErrorDireccion = new JLabel("");
             		labelErrorDireccion.setForeground(Color.RED);
             		labelErrorDireccion.setBounds(80, 39, 326, 14);
             		panelDireccion.add(labelErrorDireccion);
             		
             		labelErrorPiso = new JLabel("");
             		labelErrorPiso.setForeground(Color.RED);
             		labelErrorPiso.setBounds(69, 82, 326, 14);
             		panelDireccion.add(labelErrorPiso);
             		
             		JPanel panelGrupSanguineoFactorRH = new JPanel();
             		panelGrupSanguineoFactorRH.setBorder(new TitledBorder(null, "Grupo Sanguineo y Factor RH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
             		panelGrupSanguineoFactorRH.setBounds(138, 379, 410, 107);
             		add(panelGrupSanguineoFactorRH);
             		panelGrupSanguineoFactorRH.setLayout(null);
             		
             		cbGrupoSanguineo = new JComboBox<String>();
             		cbGrupoSanguineo.setBounds(198, 46, 117, 20);
             		panelGrupSanguineoFactorRH.add(cbGrupoSanguineo);
             		
             		JLabel lblNewLabel_7 = new JLabel("Grupo Sanguineo (*)");
             		lblNewLabel_7.setBounds(48, 49, 117, 14);
             		panelGrupSanguineoFactorRH.add(lblNewLabel_7);
             		
             		labelErrorGrupSanguineo = new JLabel("");
             		labelErrorGrupSanguineo.setForeground(Color.RED);
             		labelErrorGrupSanguineo.setBounds(48, 77, 345, 14);
             		panelGrupSanguineoFactorRH.add(labelErrorGrupSanguineo);
             		
             		labelErrorFactorRH = new JLabel("");
             		labelErrorFactorRH.setForeground(Color.RED);
             		labelErrorFactorRH.setBounds(63, 122, 291, 14);
             		panelGrupSanguineoFactorRH.add(labelErrorFactorRH);
             		
             		JTextPane txtpnAltaTitular = new JTextPane();
             		txtpnAltaTitular.setText("     ALTA  TITULAR");
             		txtpnAltaTitular.setBounds(451, 21, 165, 37);
             		txtpnAltaTitular.setFont(new Font("Tahoma", Font.BOLD, 21));
             		txtpnAltaTitular.setEditable(false);
             		txtpnAltaTitular.setBackground(SystemColor.menu);
             		txtpnAltaTitular.setBounds(393, 11, 219, 37);
             		add(txtpnAltaTitular);
             		
             		JPanel panelDireccion_1 = new JPanel();
             		panelDireccion_1.setLayout(null);
             		panelDireccion_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Titular", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
             		panelDireccion_1.setBounds(81, 69, 850, 481);
             		add(panelDireccion_1);
             		
             		tfFechaNacTitular = new JDateChooser();
             		tfFechaNacTitular.setDateFormatString("dd/mm/yyyy");
             		tfFechaNacTitular.setBounds(673, 195, 129, 20);
             		panelDireccion_1.add(tfFechaNacTitular);
             		
             		JLabel txtNombre = new JLabel("Nombre Completo (*)");
             		txtNombre.setBounds(93, 38, 142, 14);
             		panelDireccion_1.add(txtNombre);
             		
             		txtNombreTitular = new JTextField();
             		txtNombreTitular.setBounds(228, 35, 158, 20);
             		panelDireccion_1.add(txtNombreTitular);
             		txtNombreTitular.setColumns(10);
             		
             		JLabel lblNewLabel = new JLabel("Apellido(s) (*)");
             		lblNewLabel.setBounds(406, 38, 108, 14);
             		panelDireccion_1.add(lblNewLabel);
             		
             		JCheckBox chckbxDonadorOrganos = new JCheckBox("Donador de Organos");
             		chckbxDonadorOrganos.setBounds(577, 237, 148, 23);
             		panelDireccion_1.add(chckbxDonadorOrganos);
             		
             		txtApellidoTitular = new JTextField();
             		txtApellidoTitular.setBounds(505, 35, 158, 20);
             		panelDireccion_1.add(txtApellidoTitular);
             		txtApellidoTitular.setColumns(10);
             		
             		txtAreaOBS = new TextArea();
             		txtAreaOBS.setBounds(577, 316, 207, 125);
             		panelDireccion_1.add(txtAreaOBS);
             		
             		JLabel lblNewLabel_5 = new JLabel("Fecha de Nacimiento (*)");
             		lblNewLabel_5.setBounds(523, 195, 136, 14);
             		panelDireccion_1.add(lblNewLabel_5);
             		
             		labelErrorNom = new JLabel("");
             		labelErrorNom.setForeground(Color.RED);
             		labelErrorNom.setBounds(139, 63, 327, 14);
             		panelDireccion_1.add(labelErrorNom);
             		
             		labelErrorApellido = new JLabel("");
             		labelErrorApellido.setForeground(Color.RED);
             		labelErrorApellido.setBounds(406, 63, 257, 14);
             		panelDireccion_1.add(labelErrorApellido);
             		
             		labelErrorFechNac = new JLabel("");
             		labelErrorFechNac.setForeground(Color.RED);
             		labelErrorFechNac.setBounds(505, 220, 297, 14);
             		panelDireccion_1.add(labelErrorFechNac);
             		
             		JLabel lblNewLabel_13 = new JLabel("Observaciones ");
             		lblNewLabel_13.setBounds(478, 316, 101, 14);
             		panelDireccion_1.add(lblNewLabel_13);
             		
             		JButton btnNewButton = new JButton("Guardar");
             		btnNewButton.addActionListener(new ActionListener() {
             			public void actionPerformed(ActionEvent e) {
             				
             				limpiarCamposErrores();
             				// SI LOS CAMPOS DEL TITULAR ESTAN VACIOS
             				if (txtNombreTitular.getText().isEmpty()) { 
             					labelErrorNom.setText("Por favor, ingrese el nombre del titular" );
             				}
             				else if (txtApellidoTitular.getText().isEmpty()){
             					labelErrorApellido.setText("Por favor, ingrese el Apellido del titular");
             				}
             				else if (cBoxTipoDoc.getSelectedItem().equals("-Seleccione-") || txtNumDocTitular.getText().isEmpty()) {
             					labelErrorDoc.setText("Por favor, complete el Documento del titular");
             				}
             				else if (!validarNumerosDoc(txtNumDocTitular.getText().trim())) {
             					labelErrorDoc.setText("Ingrese correctamente el numero del Documento");
             				}
             				else if (txtCalleTitular.getText().isEmpty() || txtNumCalleTitular.getText().isEmpty()) {
             					labelErrorDireccion.setText("Por favor, complete la Direccion del titular");
             				}
             				else if (!validarNumerosCalle(txtNumCalleTitular.getText().trim())) {
             					labelErrorDireccion.setText("Por favor, Ingrese correctamente el Numero");
             				}
             				// else if (!(txtPisoTitular.getText().isEmpty())) {
             				// 	if (!validarNumerosCalle(txtPisoTitular.getText().trim())){
             				// 		labelErrorPiso.setText("Por favor, ingrese correctamente el piso");
             				// 	}
             				// }
             				else if(tfFechaNacTitular.getDate()==null) { 
             					labelErrorFechNac.setText("Por favor, ingrese la Fecha de Nacimiento del titular");
             				}
             				else if (cbGrupoSanguineo.getSelectedItem().equals("-Seleccione-") ) {
             					labelErrorGrupSanguineo.setText("Por favor, ingrese el Grupo Sanguineo del titular");
             				}
							else {
								try {
									emitirAltaTitular();
									System.out.println(crearTitularDTO);
									System.out.println("Cargo todo");
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
             				
             			}
             		});
             		btnNewButton.setBounds(838, 586, 117, 37);
             		add(btnNewButton);
             		
             		JButton btnCancelar = new JButton("Cancelar");
             		btnCancelar.setBounds(700, 586, 117, 37);
             		add(btnCancelar);

					try {
						llenarCB();
					} catch (Exception eCB) {
						eCB.printStackTrace();
					}                                                                                                                              
             	}

				public static boolean validarNumerosDoc (String datos) {
             		return datos.matches("[0-9]{8,10}");
             	}
				public static boolean validarNumerosCalle (String datos) {
             		return datos.matches("[0-9]{1,4}");
             	}

				protected void limpiarCamposErrores() {
					//definir todos los label de los errores 
					labelErrorNom.setText("");
					labelErrorApellido.setText("");
					labelErrorDoc.setText("");
					labelErrorDireccion.setText("");
					labelErrorFechNac.setText("");
					labelErrorGrupSanguineo.setText("");
					labelErrorPiso.setText("");
					//labelErrorFactorRH.setText("");
				} 
				
				protected void emitirAltaTitular() throws Exception {
					crearTitularDTO.setNombreCond(txtNombreTitular.getText());
					crearTitularDTO.setApellidoCond(txtApellidoTitular.getText());
					crearTitularDTO.setTipoDoc(null); //mirar
					crearTitularDTO.setNumDoc(Integer.parseInt(txtNumDocTitular.getText()));
					crearTitularDTO.setCalle(txtCalleTitular.getText());
					crearTitularDTO.setNumCalle(Integer.parseInt(txtNumCalleTitular.getText()));
					if(!txtPisoTitular.getText().isEmpty()) {
						crearTitularDTO.setPiso(Integer.parseInt(txtPisoTitular.getText()));
					}
					if(!txtDptoTitular.getText().isEmpty()) {
						crearTitularDTO.setDpto(txtDptoTitular.getText());
					}
					crearTitularDTO.setFechaNacimiento(LocalDate.parse(tfFechaNacTitular.getDateFormatString()));
					crearTitularDTO.setGrupoSang(null); //mirar
					if(!txtAreaOBS.getText().isEmpty()) {
						crearTitularDTO.setObservaciones(txtAreaOBS.getText());
					}
				}

				protected void llenarCB() throws Exception{

					//Llena el combo box de tipo de documento
					List<TipoDocumento> tipoDoc= GestorPersona.obtenerTiposDocumentos();
					cBoxTipoDoc.addItem("-Seleccione-");
					for(int i=0; i<tipoDoc.size(); i++) {
						cBoxTipoDoc.addItem(tipoDoc.get(i).getTipo_doc());
					}

					//Llena el combo box del tipo de sangre
					List<TipoGrupoSanguineo> grupSanguineo = GestorPersona.obtenerTiposGrupoSanguineos();
					cbGrupoSanguineo.addItem("-Seleccione-");
					for(int i=0; i<grupSanguineo.size(); i++) {
						cbGrupoSanguineo.addItem(grupSanguineo.get(i).getTipo_grupo_sanguineo());
					}
					
				}
}

