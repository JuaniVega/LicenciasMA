package mvc.view;

import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.TextArea;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	

public class PntDarAltaTitularUI extends JPanel{
             	                    
				private JTextField insertarNombreConductortxt;                                                                                                             
            	private JTextField textField;                                                                                                                              
             	private JTextField textField_1;                                                                                                                            
             	private JTextField textField_2;                                                                                                                            
             	private JTextField textFieldNombreTitular;
             	private JTextField textFieldApellidoTitular;
             	private JTextField textFieldNumDocTitular;
             	private JTextField textFieldCalleTitular;
             	private JTextField textFieldNumCalleTitular;
             	private JTextField textFieldPisoTitular;
             	private JTextField textFieldDptoTitular;
             	private JLabel labelErrorNom;
             	private JLabel labelErrorApellido;
             	private JLabel labelErrorDoc;
             	private JLabel labelErrorFechNac;
             	private JLabel labelErrorDireccion;
             	private JLabel labelErrorFactorRH;
             	private JLabel labelErrorGrupSanguineo;
             	private JComboBox cBoxTipoDoc;
             	private JDateChooser dateChooserFechaNacTitular;
             	private JComboBox comboBoxGrupoSanguineo;
             	private JComboBox comboBoxFactorRH;
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
             		
             		cBoxTipoDoc = new JComboBox();
             		cBoxTipoDoc.setBounds(189, 23, 117, 22);
             		PaneDocumento.add(cBoxTipoDoc);
             		cBoxTipoDoc.setBackground(UIManager.getColor("Button.disabledShadow"));
             		cBoxTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione-", "DNI", "LE", "LC"}));
             		
             		JLabel lblNewLabel_3 = new JLabel("Numero (*)");
             		lblNewLabel_3.setBounds(360, 27, 67, 14);
             		PaneDocumento.add(lblNewLabel_3);
             		
             		textFieldNumDocTitular = new JTextField();
             		textFieldNumDocTitular.setBounds(472, 24, 117, 20);
             		PaneDocumento.add(textFieldNumDocTitular);
             		textFieldNumDocTitular.setColumns(10);
             		
             		labelErrorDoc = new JLabel("");
             		labelErrorDoc.setForeground(Color.RED);
             		labelErrorDoc.setBounds(231, 47, 263, 14);
             		PaneDocumento.add(labelErrorDoc);
             		
             		JPanel panelDireccion = new JPanel();
             		panelDireccion.setBorder(new TitledBorder(null, "Direccion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
             		panelDireccion.setBounds(138, 242, 436, 107);
             		add(panelDireccion);
             		panelDireccion.setLayout(null);
             		
             		JLabel lblNewLabel_10 = new JLabel("Numero (*)");
             		lblNewLabel_10.setBounds(248, 21, 87, 14);
             		panelDireccion.add(lblNewLabel_10);
             		
             		textFieldNumCalleTitular = new JTextField();
             		textFieldNumCalleTitular.setBounds(319, 18, 87, 20);
             		panelDireccion.add(textFieldNumCalleTitular);
             		textFieldNumCalleTitular.setColumns(10);
             		
             		textFieldCalleTitular = new JTextField();
             		textFieldCalleTitular.setBounds(80, 18, 148, 20);
             		panelDireccion.add(textFieldCalleTitular);
             		textFieldCalleTitular.setColumns(10);
             		
             		JLabel lblNewLabel_9 = new JLabel("Calle (*)");
             		lblNewLabel_9.setBounds(22, 21, 46, 14);
             		panelDireccion.add(lblNewLabel_9);
             		
             		textFieldDptoTitular = new JTextField();
             		textFieldDptoTitular.setBounds(299, 61, 36, 20);
             		panelDireccion.add(textFieldDptoTitular);
             		textFieldDptoTitular.setColumns(10);
             		
             		JLabel lblNewLabel_12 = new JLabel("Departamento");
             		lblNewLabel_12.setBounds(203, 64, 86, 14);
             		panelDireccion.add(lblNewLabel_12);
             		
             		textFieldPisoTitular = new JTextField();
             		textFieldPisoTitular.setBounds(138, 61, 36, 20);
             		panelDireccion.add(textFieldPisoTitular);
             		textFieldPisoTitular.setColumns(10);
             		
             		JLabel lblNewLabel_11 = new JLabel("Piso");
             		lblNewLabel_11.setBounds(98, 64, 30, 14);
             		panelDireccion.add(lblNewLabel_11);
             		
             		labelErrorDireccion = new JLabel("");
             		labelErrorDireccion.setForeground(Color.RED);
             		labelErrorDireccion.setBounds(80, 39, 326, 14);
             		panelDireccion.add(labelErrorDireccion);
             		
             		JPanel panelGrupSanguineoFactorRH = new JPanel();
             		panelGrupSanguineoFactorRH.setBorder(new TitledBorder(null, "Grupo Sanguineo y Factor RH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
             		panelGrupSanguineoFactorRH.setBounds(138, 379, 410, 147);
             		add(panelGrupSanguineoFactorRH);
             		panelGrupSanguineoFactorRH.setLayout(null);
             		
             		comboBoxGrupoSanguineo = new JComboBox();
             		comboBoxGrupoSanguineo.setBounds(215, 42, 117, 20);
             		panelGrupSanguineoFactorRH.add(comboBoxGrupoSanguineo);
             		comboBoxGrupoSanguineo.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione-", "A", "0", "AB", "B"}));
             		
             		JLabel lblNewLabel_7 = new JLabel("Grupo Sanguineo (*)");
             		lblNewLabel_7.setBounds(63, 45, 117, 14);
             		panelGrupSanguineoFactorRH.add(lblNewLabel_7);
             		
             		JLabel txtFactorRH = new JLabel("Factor RH (*)");
             		txtFactorRH.setBounds(63, 90, 81, 14);
             		panelGrupSanguineoFactorRH.add(txtFactorRH);
             		
             		comboBoxFactorRH = new JComboBox();
             		comboBoxFactorRH.setBounds(215, 86, 117, 22);
             		panelGrupSanguineoFactorRH.add(comboBoxFactorRH);
             		comboBoxFactorRH.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione-", "+", "-"}));
             		
             		labelErrorGrupSanguineo = new JLabel("");
             		labelErrorGrupSanguineo.setForeground(Color.RED);
             		labelErrorGrupSanguineo.setBounds(30, 65, 345, 14);
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
             		
             		dateChooserFechaNacTitular = new JDateChooser();
             		dateChooserFechaNacTitular.setBounds(673, 195, 129, 20);
             		panelDireccion_1.add(dateChooserFechaNacTitular);
             		
             		JLabel txtNombre = new JLabel("Nombre Completo (*)");
             		txtNombre.setBounds(93, 38, 142, 14);
             		panelDireccion_1.add(txtNombre);
             		
             		textFieldNombreTitular = new JTextField();
             		textFieldNombreTitular.setBounds(228, 35, 158, 20);
             		panelDireccion_1.add(textFieldNombreTitular);
             		textFieldNombreTitular.setColumns(10);
             		
             		JLabel lblNewLabel = new JLabel("Apellido(s) (*)");
             		lblNewLabel.setBounds(406, 38, 108, 14);
             		panelDireccion_1.add(lblNewLabel);
             		
             		JCheckBox chckbxDonadorOrganos = new JCheckBox("Donador de Organos");
             		chckbxDonadorOrganos.setBounds(577, 237, 148, 23);
             		panelDireccion_1.add(chckbxDonadorOrganos);
             		
             		textFieldApellidoTitular = new JTextField();
             		textFieldApellidoTitular.setBounds(505, 35, 158, 20);
             		panelDireccion_1.add(textFieldApellidoTitular);
             		textFieldApellidoTitular.setColumns(10);
             		
             		TextArea txtAreaOBS = new TextArea();
             		txtAreaOBS.setBounds(577, 316, 207, 125);
             		panelDireccion_1.add(txtAreaOBS);
             		
             		JLabel lblNewLabel_5 = new JLabel("Fecha de Nacimiento (*)");
             		lblNewLabel_5.setBounds(523, 195, 136, 14);
             		panelDireccion_1.add(lblNewLabel_5);
             		
             		labelErrorNom = new JLabel("");
             		labelErrorNom.setForeground(Color.RED);
             		labelErrorNom.setBounds(139, 63, 247, 14);
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
             				if (textFieldNombreTitular.getText().isEmpty()) { 
             					//JOptionPane.showMessageDialog(null, "Por favor, ingrese el Nombre del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             				labelErrorNom.setText("Por favor, ingrese el nombre del titular" );
             				}
             				else if (textFieldApellidoTitular.getText().isEmpty()){
             					//JOptionPane.showMessageDialog(null, "Por favor, ingrese el Apellido del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             				labelErrorApellido.setText("Por favor, ingrese el Apellido del titular");
             				}
             				else if (cBoxTipoDoc.getSelectedItem().equals("-Seleccione-") || textFieldNumDocTitular.getText().isEmpty()) {
             					//JOptionPane.showMessageDialog(null, "Por favor, complete el Documento del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             					labelErrorDoc.setText("Por favor, complete el Documento del titular");
             				}
             				else if (textFieldCalleTitular.getText().isEmpty() || textFieldNumCalleTitular.getText().isEmpty()) {
             					//JOptionPane.showMessageDialog(null, "Por favor, complete la Direccion del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             					labelErrorDireccion.setText("Por favor, complete la Direccion del titular");
             				}
             				else if(dateChooserFechaNacTitular.getDate()==null) {
             					//JOptionPane.showMessageDialog(null, "Por favor, ingrese la Fecha de Nacimiento del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             					labelErrorFechNac.setText("Por favor, ingrese la Fecha de Nacimiento del titular");
             				}
             				else if (comboBoxGrupoSanguineo.getSelectedItem().equals("-Seleccione-") ) {
             					//JOptionPane.showMessageDialog(null, "Por favor, ingrese el Grupo Sanguineo del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             					labelErrorGrupSanguineo.setText("Por favor, ingrese el Grupo Sanguineo del titular");
             				}
             				else if (comboBoxFactorRH.getSelectedItem().equals("-Seleccione-") ) {
             					//JOptionPane.showMessageDialog(null, "Por favor, ingrese el Factor RH del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             				labelErrorFactorRH.setText("Por favor, ingrese el Factor RH del titular");
             				}
             				/*else if (comboBoxClaseLicencia.getSelectedItem().equals("-Seleccione-")) {
             					JOptionPane.showMessageDialog(null, "Por favor, seleccione la Clase de la licencia del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             				}*/
             				
             				
             			}
             		});
             		btnNewButton.setBounds(838, 586, 117, 37);
             		add(btnNewButton);
             		
             		JButton btnCancelar = new JButton("Cancelar");
             		btnCancelar.setBounds(700, 586, 117, 37);
             		add(btnCancelar);
             		
             		                                                                                                 
             		                                                                                                                                                        
             		                                                                                                                                                       
             	}


				protected void limpiarCamposErrores() {
					//definir todos los label de los errores 
					labelErrorNom.setText("");
					labelErrorApellido.setText("");
					labelErrorDoc.setText("");
					labelErrorDireccion.setText("");
					labelErrorFechNac.setText("");
					labelErrorGrupSanguineo.setText("");
					labelErrorFactorRH.setText("");
				} 
}
