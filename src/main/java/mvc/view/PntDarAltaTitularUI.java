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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PntDarAltaTitularUI extends JPanel{
             	                    
				private JTextField insertarNombreConductortxt;                                                                                                             
            	private JTextField textField;                                                                                                                              
             	private JTextField textField_1;                                                                                                                            
             	private JTextField textField_2;                                                                                                                            
             	private JTextField tfNombre;
             	private JTextField tfNroDni;
             	private JTextField tfCalle;
             	private JTextField tfNroCalle;
             	private JTextField tfPiso;
             	private JTextField tfDepartamento;
             	private JTextField tfApellido;
             	
                                                                                                                                                                         
             	public PntDarAltaTitularUI() {
             		setBackground(UIManager.getColor("Button.background"));  
             		setPreferredSize(new Dimension(980, 650));
             		setLayout(null);
             		
             		JTextPane txtpnAltaTitular = new JTextPane();
             		txtpnAltaTitular.setText("     ALTA  TITULAR");
             		txtpnAltaTitular.setBounds(378, 11, 165, 37);
             		txtpnAltaTitular.setFont(new Font("Tahoma", Font.BOLD, 21));
             		txtpnAltaTitular.setEditable(false);
             		txtpnAltaTitular.setBackground(SystemColor.menu);
             		txtpnAltaTitular.setBounds(393, 11, 219, 37);
             		add(txtpnAltaTitular);
             		
             		JPanel panelDireccion_1 = new JPanel();
             		panelDireccion_1.setLayout(null);
             		panelDireccion_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Titular", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
             		panelDireccion_1.setBounds(45, 45, 896, 530);
             		add(panelDireccion_1);
             		
             		JDateChooser dcFechaNacimiento = new JDateChooser();
             		dcFechaNacimiento.setBounds(625, 291, 83, 20);
             		panelDireccion_1.add(dcFechaNacimiento);
             		
             		JLabel txtNombre = new JLabel("Nombre Completo (*)");
             		txtNombre.setBounds(69, 42, 117, 14);
             		panelDireccion_1.add(txtNombre);
             		
             		tfNombre = new JTextField();
             		tfNombre.setBounds(182, 39, 246, 20);
             		panelDireccion_1.add(tfNombre);
             		tfNombre.setColumns(10);
             		
             		JLabel lblNewLabel = new JLabel("Apellido(s) (*)");
             		lblNewLabel.setBounds(480, 42, 75, 14);
             		panelDireccion_1.add(lblNewLabel);
             		
             		tfApellido = new JTextField();
             		tfApellido.setColumns(10);
             		tfApellido.setBounds(565, 39, 246, 20);
             		panelDireccion_1.add(tfApellido);
             		
             		JPanel PaneDocumento = new JPanel();
             		PaneDocumento.setBounds(69, 100, 522, 72);
             		panelDireccion_1.add(PaneDocumento);
             		PaneDocumento.setToolTipText("Documento ");
             		PaneDocumento.setBorder(new TitledBorder(null, "Documento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
             		PaneDocumento.setLayout(null);
             		
             		JLabel lblNewLabel_2 = new JLabel("Tipo (*)");
             		lblNewLabel_2.setBounds(41, 27, 46, 14);
             		PaneDocumento.add(lblNewLabel_2);
             		
             		JComboBox cBoxTipoDoc = new JComboBox();
             		cBoxTipoDoc.setBounds(97, 23, 151, 22);
             		PaneDocumento.add(cBoxTipoDoc);
             		cBoxTipoDoc.setBackground(UIManager.getColor("Button.disabledShadow"));
             		cBoxTipoDoc.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione-", "DNI", "LE", "LC"}));
             		
             		JLabel lblNewLabel_3 = new JLabel("Numero (*)");
             		lblNewLabel_3.setBounds(298, 27, 67, 14);
             		PaneDocumento.add(lblNewLabel_3);
             		
             		tfNroDni = new JTextField();
             		tfNroDni.setBounds(367, 24, 117, 20);
             		PaneDocumento.add(tfNroDni);
             		tfNroDni.setColumns(10);
             		
             		JLabel lblNewLabel_5 = new JLabel("Fecha de Nacimiento (*)");
             		lblNewLabel_5.setBounds(481, 291, 117, 14);
             		panelDireccion_1.add(lblNewLabel_5);
             		
             		JPanel panelDireccion = new JPanel();
             		panelDireccion.setBounds(69, 198, 359, 107);
             		panelDireccion_1.add(panelDireccion);
             		panelDireccion.setBorder(new TitledBorder(null, "Direccion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
             		panelDireccion.setLayout(null);
             		
             		JLabel lblNewLabel_10 = new JLabel("Numero (*)");
             		lblNewLabel_10.setBounds(224, 21, 54, 14);
             		panelDireccion.add(lblNewLabel_10);
             		
             		tfNroCalle = new JTextField();
             		tfNroCalle.setBounds(288, 18, 61, 20);
             		panelDireccion.add(tfNroCalle);
             		tfNroCalle.setColumns(10);
             		
             		tfCalle = new JTextField();
             		tfCalle.setBounds(66, 18, 148, 20);
             		panelDireccion.add(tfCalle);
             		tfCalle.setColumns(10);
             		
             		JLabel lblNewLabel_9 = new JLabel("Calle (*)");
             		lblNewLabel_9.setBounds(22, 21, 46, 14);
             		panelDireccion.add(lblNewLabel_9);
             		
             		tfDepartamento = new JTextField();
             		tfDepartamento.setBounds(224, 58, 36, 20);
             		panelDireccion.add(tfDepartamento);
             		tfDepartamento.setColumns(10);
             		
             		JLabel lblNewLabel_12 = new JLabel("Departamento");
             		lblNewLabel_12.setBounds(146, 61, 86, 14);
             		panelDireccion.add(lblNewLabel_12);
             		
             		tfPiso = new JTextField();
             		tfPiso.setBounds(100, 58, 36, 20);
             		panelDireccion.add(tfPiso);
             		tfPiso.setColumns(10);
             		
             		JLabel lblNewLabel_11 = new JLabel("Piso");
             		lblNewLabel_11.setBounds(76, 61, 30, 14);
             		panelDireccion.add(lblNewLabel_11);
             		
             		JLabel lblNewLabel_6 = new JLabel("Donador de Organos (*)");
             		lblNewLabel_6.setBounds(480, 211, 117, 14);
             		panelDireccion_1.add(lblNewLabel_6);
             		
             		JComboBox cbDonadorDeOrganos = new JComboBox();
             		cbDonadorDeOrganos.setBounds(624, 207, 84, 22);
             		panelDireccion_1.add(cbDonadorDeOrganos);
             		cbDonadorDeOrganos.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione-", "Si", "No"}));
             		
             		JPanel panelGrupSanguineoFactorRH = new JPanel();
             		panelGrupSanguineoFactorRH.setBounds(69, 343, 359, 78);
             		panelDireccion_1.add(panelGrupSanguineoFactorRH);
             		panelGrupSanguineoFactorRH.setBorder(new TitledBorder(null, "Grupo Sanguineo y Factor RH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
             		panelGrupSanguineoFactorRH.setLayout(null);
             		
             		JComboBox cbGrupoSanguineo = new JComboBox();
             		cbGrupoSanguineo.setBounds(176, 31, 84, 20);
             		panelGrupSanguineoFactorRH.add(cbGrupoSanguineo);
             		cbGrupoSanguineo.setModel(new DefaultComboBoxModel(new String[] {"-Seleccione-", "A", "0", "AB", "B"}));
             		
             		JLabel lblNewLabel_7 = new JLabel("Grupo Sanguineo (*)");
             		lblNewLabel_7.setBounds(64, 34, 117, 14);
             		panelGrupSanguineoFactorRH.add(lblNewLabel_7);
             		
             		JLabel lblNewLabel_13 = new JLabel("Observaciones ");
             		lblNewLabel_13.setBounds(480, 343, 75, 14);
             		panelDireccion_1.add(lblNewLabel_13);
             		
             		JTextArea taObservaciones = new JTextArea();
             		taObservaciones.setBounds(565, 343, 246, 150);
             		panelDireccion_1.add(taObservaciones);
             		
             		JLabel lblNewLabel_6_1 = new JLabel("Sexo (*)");
             		lblNewLabel_6_1.setBounds(481, 254, 117, 14);
             		panelDireccion_1.add(lblNewLabel_6_1);
             		
             		JComboBox cbSexo = new JComboBox();
             		cbSexo.setBounds(624, 250, 84, 22);
             		panelDireccion_1.add(cbSexo);
             		
             		JButton btnGuardar = new JButton("Guardar");
             		btnGuardar.addActionListener(new ActionListener() {
             			public void actionPerformed(ActionEvent e) {
             			}
             		});
             		btnGuardar.setBounds(810, 602, 118, 37);
             		add(btnGuardar);
             		
             		JButton btnCancelar = new JButton("Cancelar");
             		btnCancelar.addActionListener(new ActionListener() {
             			public void actionPerformed(ActionEvent e) {
             				VentanaAdmin.cambiarPantalla(VentanaAdmin.pntCrearLicencia,VentanaAdmin.n_pntCrearLicencia);
             			}
             		});
             		btnCancelar.setBounds(41, 602, 118, 37);
             		add(btnCancelar);
             		
             		                                                                                                       
             		                                                                                                                                                        
             		                                                                                                                                                       
             	} 
}
