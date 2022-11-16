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
             	private JComboBox cBoxTipoDoc;
             	private JDateChooser dateChooserFechaNacTitular;
             	private JComboBox comboBoxGrupoSanguineo;
             	private JComboBox comboBoxClaseLicencia;
             	private JComboBox comboBoxFactorRH;
                //prueba                                                                                                                                                         
             	public PntDarAltaTitularUI() {
             		setBackground(UIManager.getColor("Button.background"));  
             		setPreferredSize(new Dimension(980, 650));
             		setLayout(null);
             		
             		JLabel lblNewLabel_8 = new JLabel("Clase Licencia (*)");
             		lblNewLabel_8.setBounds(584, 399, 132, 14);
             		add(lblNewLabel_8);
             		
             		JLabel lblNewLabel_13 = new JLabel("Observaciones ");
             		lblNewLabel_13.setBounds(584, 448, 101, 14);
             		add(lblNewLabel_13);
             		
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
             		
             		JLabel lblNewLabel_1 = new JLabel("New label");
             		lblNewLabel_1.setBounds(189, 47, 46, 14);
             		PaneDocumento.add(lblNewLabel_1);
             		
             		JPanel panelDireccion = new JPanel();
             		panelDireccion.setBorder(new TitledBorder(null, "Direccion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
             		panelDireccion.setBounds(138, 242, 436, 107);
             		add(panelDireccion);
             		panelDireccion.setLayout(null);
             		
             		JLabel lblNewLabel_10 = new JLabel("Numero (*)");
             		lblNewLabel_10.setBounds(248, 21, 87, 14);
             		panelDireccion.add(lblNewLabel_10);
             		
             		textFieldNumCalleTitular = new JTextField();
             		textFieldNumCalleTitular.setBounds(345, 18, 61, 20);
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
             		textFieldDptoTitular.setBounds(266, 58, 36, 20);
             		panelDireccion.add(textFieldDptoTitular);
             		textFieldDptoTitular.setColumns(10);
             		
             		JLabel lblNewLabel_12 = new JLabel("Departamento");
             		lblNewLabel_12.setBounds(170, 61, 86, 14);
             		panelDireccion.add(lblNewLabel_12);
             		
             		textFieldPisoTitular = new JTextField();
             		textFieldPisoTitular.setBounds(124, 58, 36, 20);
             		panelDireccion.add(textFieldPisoTitular);
             		textFieldPisoTitular.setColumns(10);
             		
             		JLabel lblNewLabel_11 = new JLabel("Piso");
             		lblNewLabel_11.setBounds(76, 61, 30, 14);
             		panelDireccion.add(lblNewLabel_11);
             		
             		JPanel panelGrupSanguineoFactorRH = new JPanel();
             		panelGrupSanguineoFactorRH.setBorder(new TitledBorder(null, "Grupo Sanguineo y Factor RH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
             		panelGrupSanguineoFactorRH.setBounds(138, 379, 410, 135);
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
             		dateChooserFechaNacTitular.setBounds(671, 195, 83, 20);
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
             		txtAreaOBS.setBounds(638, 366, 165, 72);
             		panelDireccion_1.add(txtAreaOBS);
             		
             		comboBoxClaseLicencia = new JComboBox();
             		comboBoxClaseLicencia.setBounds(637, 327, 100, 22);
             		panelDireccion_1.add(comboBoxClaseLicencia);
             		comboBoxClaseLicencia.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione-", "A", "B", "C", "D", "E", "F", "G"}));
             		
             		JLabel lblNewLabel_5 = new JLabel("Fecha de Nacimiento (*)");
             		lblNewLabel_5.setBounds(523, 195, 136, 14);
             		panelDireccion_1.add(lblNewLabel_5);
             		
             		labelErrorNom = new JLabel("");
             		labelErrorNom.setForeground(Color.RED);
             		labelErrorNom.setBounds(139, 63, 247, 14);
             		panelDireccion_1.add(labelErrorNom);
             		
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
             					JOptionPane.showMessageDialog(null, "Por favor, ingrese el Apellido del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             				}
             				else if (cBoxTipoDoc.getSelectedItem().equals("-Seleccione-") || textFieldNumDocTitular.getText().isEmpty()) {
             					JOptionPane.showMessageDialog(null, "Por favor, complete el Documento del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             				}
             				else if (textFieldCalleTitular.getText().isEmpty() || textFieldNumCalleTitular.getText().isEmpty()) {
             					JOptionPane.showMessageDialog(null, "Por favor, complete la Direccion del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             				}
             				else if(dateChooserFechaNacTitular.getDate()==null) {
             					JOptionPane.showMessageDialog(null, "Por favor, ingrese la Fecha de Nacimiento del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             				}
             				else if (comboBoxGrupoSanguineo.getSelectedItem().equals("-Seleccione-")) {
             					JOptionPane.showMessageDialog(null, "Por favor, ingrese el Grupo Sanguineo del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             				}
             				else if (comboBoxFactorRH.getSelectedItem().equals("-Seleccione-") ) {
             					JOptionPane.showMessageDialog(null, "Por favor, ingrese el Factor RH del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             				}
             				else if (comboBoxClaseLicencia.getSelectedItem().equals("-Seleccione-")) {
             					JOptionPane.showMessageDialog(null, "Por favor, seleccione la Clase de la licencia del titular","ERROR",JOptionPane.WARNING_MESSAGE);
             				}
             				
             				
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
				} 
}
